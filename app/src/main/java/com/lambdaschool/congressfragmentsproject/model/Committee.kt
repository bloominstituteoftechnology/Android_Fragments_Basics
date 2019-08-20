package com.lambdaschool.congressfragmentsproject.model

import com.lambdaschool.congressfragmentsproject.data.CongressDao
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

class Committee {

    // SerializedName("name")
    var name: String? = null
        private set
    // SerializedName("code")
    var code: String? = null
        private set
    // SerializedName("api_uri")
    var apiUri: String? = null
        private set
    // SerializedName("side")
    var side: String? = null
        private set
    // SerializedName("title")
    var title: String? = null
        private set
    // SerializedName("rank_in_party")
    var rankInParty: Int = 0
        private set
    // SerializedName("begin_date")
    var beginDate: String? = null
        private set
    // SerializedName("end_date")
    var endDate: String? = null
        private set

    constructor(
        name: String,
        code: String,
        apiUri: String,
        side: String,
        title: String,
        rankInParty: Int,
        beginDate: String,
        endDate: String
    ) {
        this.name = name
        this.code = code
        this.apiUri = apiUri
        this.side = side
        this.title = title
        this.rankInParty = rankInParty
        this.beginDate = beginDate
        this.endDate = endDate
    }

    constructor(jsonObject: JSONObject) {
        this.name = CongressDao.getStringFromJson(jsonObject, "name")
        this.code = CongressDao.getStringFromJson(jsonObject, "code")
        this.apiUri = CongressDao.getStringFromJson(jsonObject, "api_uri")
        this.side = CongressDao.getStringFromJson(jsonObject, "side")
        this.title = CongressDao.getStringFromJson(jsonObject, "title")
        this.rankInParty =
            CongressDao.getIntFromJson(jsonObject, "rank_in_party")
        this.beginDate =
            CongressDao.getStringFromJson(jsonObject, "begin_date")
        this.endDate =
            CongressDao.getStringFromJson(jsonObject, "end_date")
    }

    companion object {

        internal fun getCommitteesFromJSON(jsonArray: JSONArray): ArrayList<Committee> {
            val committees = ArrayList<Committee>()
            for (i in 0 until jsonArray.length()) {
                try {
                    committees.add(Committee(jsonArray.getJSONObject(i)))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }
            return committees
        }
    }
}
