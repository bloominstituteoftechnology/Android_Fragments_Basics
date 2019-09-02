package com.lambdaschool.congressfragmentsproject.data

import android.graphics.Bitmap
import com.lambdaschool.congressfragmentsproject.api.NetworkAdapter
import com.lambdaschool.congressfragmentsproject.model.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.model.CongresspersonOverview
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

object CongressDao {
    private val BASE_URL = "https://api.propublica.org/congress/v1/"

    private val URL_MEMBERS_HOUSE_CALIFORNIA = BASE_URL + "members/house/CA/current.json"
    val CONGRESS_NUMBER = "115"
    private val URL_MEMBERS_HOUSE_ALL = "$BASE_URL$CONGRESS_NUMBER/house/members.json"
    private val URL_MEMBERS_SENATE_CALIFORNIA = BASE_URL + "members/senate/CA/current.json"
    private val URL_MEMBERS_SENATE_ALL = "$BASE_URL$CONGRESS_NUMBER/senate/members.json"

    private val MEMBER_DETAILS = BASE_URL + "members/"

    private val IMAGE_URL = "https://theunitedstates.io/images/congress/450x550/"

    private val JPG = ".jpg"
    private val JSON = ".json"

    val allMembers: ArrayList<CongresspersonOverview>
        get() {
            val data = ArrayList<CongresspersonOverview>()

            try {
                val result =
                    NetworkAdapter.httpGetRequest(URL_MEMBERS_HOUSE_ALL)
                if (result != null) {
                    val dataObject = JSONObject(result)
                    val dataJsonArray = dataObject.getJSONArray("results").getJSONObject(0).getJSONArray("members")

                    for (i in 0 until dataJsonArray.length()) {
                        val officialOverview = CongresspersonOverview(
                            dataJsonArray.getJSONObject(i)
                        )
                        data.add(officialOverview)
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return data
        }

    interface OverviewListCallback {
        fun requestFinished(success: Boolean, list: ArrayList<CongresspersonOverview>)
    }

    interface MemberDetailsCallback {
        fun requestFinished(success: Boolean, list: ArrayList<CongresspersonOverview>)
    }

    fun getMemberDetails(memberId: String): CongresspersonDetails {
        var congressPersonProfile: CongresspersonDetails
        try {
            val result =
                NetworkAdapter.httpGetRequest(MEMBER_DETAILS + memberId + JSON)
            val dataObject = JSONObject(result)
            val dataJsonObject = dataObject.getJSONArray("results").getJSONObject(0)

            congressPersonProfile =
                CongresspersonDetails(dataJsonObject)

        } catch (e: JSONException) {
            e.printStackTrace()
            congressPersonProfile = CongresspersonDetails()
        }

        return congressPersonProfile
    }

    fun getImage(id: String): Bitmap? {
        return NetworkAdapter.getBitmapFromURL(IMAGE_URL + id + JPG)
    }

    fun getIntFromJson(jsonObject: JSONObject, id: String): Int {
        var value = 0
        try {
            value = jsonObject.getInt(id)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return value

    }

    fun getDoubleFromJson(jsonObject: JSONObject, id: String): Double {
        var value = 0.0
        try {
            value = jsonObject.getDouble(id)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return value
    }

    fun getBooleanFromJson(jsonObject: JSONObject, id: String): Boolean {
        var value = false
        try {
            value = jsonObject.getBoolean(id)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return value
    }

    fun getStringFromJson(jsonObject: JSONObject, id: String): String {
        var value = ""
        try {
            value = jsonObject.getString(id)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return value
    }

    fun getJSONObjectFromJson(jsonObject: JSONObject, id: String): JSONObject? {
        var value: JSONObject? = null
        try {
            value = jsonObject.getJSONObject(id)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return value
    }

    fun getJSONArrayFromJson(jsonObject: JSONObject, id: String): JSONArray? {
        var value: JSONArray? = null
        try {
            value = jsonObject.getJSONArray(id)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return value
    }
}
