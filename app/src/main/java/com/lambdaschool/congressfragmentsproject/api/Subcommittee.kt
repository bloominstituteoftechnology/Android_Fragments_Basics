package com.lambdaschool.congressfragmentsproject.api

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

class Subcommittee
/*public Subcommittee(String name, String code, String parentCommitteeId, String apiUri, String side, String title, int rankInParty, String beginDate, String endDate) {
        this.name = name;
        this.code = code;
        this.parentCommitteeId = parentCommitteeId;
        this.apiUri = apiUri;
        this.side = side;
        this.title = title;
        this.rankInParty = rankInParty;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }*/
private constructor(jsonObject: JSONObject) {

    // SerializedName("name")
    val name: String
    // SerializedName("code")
    val code: String
    // SerializedName("parent_committee_id")
    val parentCommitteeId: String
    // SerializedName("api_uri")
    val apiUri: String
    // SerializedName("side")
    val side: String
    // SerializedName("title")
    val title: String
    // SerializedName("rank_in_party")
    val rankInParty: Int
    // SerializedName("begin_date")
    val beginDate: String
    // SerializedName("end_date")
    val endDate: String

    init {
        this.name = CongressDao.getStringFromJson(jsonObject, "name")
        this.code = CongressDao.getStringFromJson(jsonObject, "code")
        this.parentCommitteeId = CongressDao.getStringFromJson(jsonObject, "parent_committee_id")
        this.apiUri = CongressDao.getStringFromJson(jsonObject, "api_uri")
        this.side = CongressDao.getStringFromJson(jsonObject, "side")
        this.title = CongressDao.getStringFromJson(jsonObject, "title")
        this.rankInParty = CongressDao.getIntFromJson(jsonObject, "rank_in_party")
        this.beginDate = CongressDao.getStringFromJson(jsonObject, "begin_date")
        this.endDate = CongressDao.getStringFromJson(jsonObject, "end_date")
    }

    companion object {

        internal fun getSubCommitteesFromJSON(jsonArray: JSONArray): ArrayList<Subcommittee> {
            val subcommittees = ArrayList<Subcommittee>()
            for (i in 0 until jsonArray.length()) {
                try {
                    subcommittees.add(Subcommittee(jsonArray.getJSONObject(i)))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }
            return subcommittees
        }
    }
}
