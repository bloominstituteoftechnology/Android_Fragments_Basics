package com.lambdaschool.congressfragmentsproject.api

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.HandlerThread

import javax.net.ssl.HttpsURLConnection
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL

object NetworkAdapter {

    private val TIMEOUT = 3000
    private val API_KEY = "glCbNQgEiisCdhTwucffBYZfvBXiHCiZ18S2pEFL"

    fun httpGetRequest(urlString: String): String {
        val result = arrayOfNulls<String>(1)
        val downloadThread = object : HandlerThread("UIHandler") {
            override fun run() {
                var stream: InputStream? = null
                var connection: HttpsURLConnection? = null
                try {
                    val url = URL(urlString)
                    connection = url.openConnection() as HttpsURLConnection
                    connection.setRequestProperty("x-api-key", API_KEY)
                    connection.readTimeout = TIMEOUT
                    connection.connectTimeout = TIMEOUT
                    connection.requestMethod = "GET"
                    connection.doInput = true
                    connection.connect()
                    val responseCode = connection.responseCode
                    if (responseCode != HttpsURLConnection.HTTP_OK) {
                        result[0] = Integer.toString(responseCode)
                        throw IOException("HTTP error code: $responseCode")
                    }

                    stream = connection.inputStream
                    if (stream != null) {

                        val reader = BufferedReader(InputStreamReader(stream))
                        val sb = StringBuilder()

                        var line: String? = reader.readLine()
                        while (line != null) {
                            sb.append(line).append('\n')
                            line = reader.readLine()
                        }
                        result[0] = sb.toString()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                } finally {
                    // Close Stream and disconnect HTTPS connection.
                    if (stream != null) {
                        try {
                            stream.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                    }
                    connection?.disconnect()
                }
            }
        }
        downloadThread.start()

        try {
            downloadThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return result[0]?: ""
    }

    fun getBitmapFromURL(urlString: String): Bitmap? {
        val result = arrayOfNulls<Bitmap>(1)
        val downloadThread = object : HandlerThread("UIHandler") {
            override fun run() {
                var connection: HttpsURLConnection? = null
                try {

                    val url = java.net.URL(urlString)
                    connection = url
                        .openConnection() as HttpsURLConnection
                    connection.doInput = true
                    connection.connect()
                    val input = connection.inputStream
                    result[0] = BitmapFactory.decodeStream(input)
                } catch (e: IOException) {
                    e.printStackTrace()
                } finally {
                    connection?.disconnect()
                }
            }
        }
        downloadThread.start()

        try {
            downloadThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return result[0]
    }
}
