package com.lambdaschool.congressfragmentsproject.model

import com.lambdaschool.congressfragmentsproject.`object`.CongressDao
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

class Role {

    // SerializedName("congress")
    var congress: String? = null
        private set
    // SerializedName("chamber")
    var chamber: String? = null
        private set
    // SerializedName("title")
    var title: String? = null
        private set
    // SerializedName("short_title")
    var shortTitle: String? = null
        private set
    // SerializedName("state")
    var state: String? = null
        private set
    // SerializedName("party")
    var party: String? = null
        private set
    // SerializedName("leadership_role")
    var leadershipRole: String? = null
        private set
    // SerializedName("fec_candidate_id")
    var fecCandidateId: String? = null
        private set
    // SerializedName("seniority")
    var seniority: String? = null
        private set
    // SerializedName("district")
    var district: String? = null
        private set
    // SerializedName("at_large")
    var isAtLarge: Boolean = false
        private set
    // SerializedName("ocd_id")
    var ocdId: String? = null
        private set
    // SerializedName("start_date")
    var startDate: String? = null
        private set
    // SerializedName("end_date")
    var endDate: String? = null
        private set
    // SerializedName("office")
    var office: String? = null
        private set
    // SerializedName("phone")
    var phone: String? = null
        private set
    // SerializedName("fax")
    var fax: String? = null
        private set
    // SerializedName("contact_form")
    var contactForm: String? = null
        private set
    // SerializedName("bills_sponsored")
    var billsSponsored: Int = 0
        private set
    // SerializedName("bills_cosponsored")
    var billsCosponsored: Int = 0
        private set
    // SerializedName("missed_votes_pct")
    var missedVotesPct: Double = 0.toDouble()
        private set
    // SerializedName("votes_with_party_pct")
    var votesWithPartyPct: Double = 0.toDouble()
        private set
    // SerializedName("committees")
    var committees: List<Committee>? = null
        private set
    // SerializedName("subcommittees")
    var subcommittees: List<Subcommittee>? = null
        private set

    constructor(
        congress: String,
        chamber: String,
        title: String,
        shortTitle: String,
        state: String,
        party: String,
        leadershipRole: String,
        fecCandidateId: String,
        seniority: String,
        district: String,
        atLarge: Boolean,
        ocdId: String,
        startDate: String,
        endDate: String,
        office: String,
        phone: String,
        fax: String,
        contactForm: String,
        billsSponsored: Int,
        billsCosponsored: Int,
        missedVotesPct: Double,
        votesWithPartyPct: Double,
        committees: List<Committee>,
        subcommittees: List<Subcommittee>
    ) {
        this.congress = congress
        this.chamber = chamber
        this.title = title
        this.shortTitle = shortTitle
        this.state = state
        this.party = party
        this.leadershipRole = leadershipRole
        this.fecCandidateId = fecCandidateId
        this.seniority = seniority
        this.district = district
        this.isAtLarge = atLarge
        this.ocdId = ocdId
        this.startDate = startDate
        this.endDate = endDate
        this.office = office
        this.phone = phone
        this.fax = fax
        this.contactForm = contactForm
        this.billsSponsored = billsSponsored
        this.billsCosponsored = billsCosponsored
        this.missedVotesPct = missedVotesPct
        this.votesWithPartyPct = votesWithPartyPct
        this.committees = committees
        this.subcommittees = subcommittees
    }

    constructor(jsonObject: JSONObject) {
        this.congress =
            CongressDao.getStringFromJson(jsonObject, "congress")
        this.chamber =
            CongressDao.getStringFromJson(jsonObject, "chamber")
        this.title = CongressDao.getStringFromJson(jsonObject, "title")
        this.shortTitle =
            CongressDao.getStringFromJson(jsonObject, "short_title")
        this.state = CongressDao.getStringFromJson(jsonObject, "state")
        this.party = CongressDao.getStringFromJson(jsonObject, "party")
        this.leadershipRole =
            CongressDao.getStringFromJson(jsonObject, "leadership_role")
        this.fecCandidateId =
            CongressDao.getStringFromJson(jsonObject, "fec_candidate_id")
        this.seniority =
            CongressDao.getStringFromJson(jsonObject, "seniority")
        this.district =
            CongressDao.getStringFromJson(jsonObject, "district")
        this.isAtLarge =
            CongressDao.getBooleanFromJson(jsonObject, "at_large")
        this.ocdId = CongressDao.getStringFromJson(jsonObject, "ocd_id")
        this.startDate =
            CongressDao.getStringFromJson(jsonObject, "start_date")
        this.endDate =
            CongressDao.getStringFromJson(jsonObject, "end_date")
        this.office = CongressDao.getStringFromJson(jsonObject, "office")
        this.phone = CongressDao.getStringFromJson(jsonObject, "phone")
        this.fax = CongressDao.getStringFromJson(jsonObject, "fax")
        this.contactForm =
            CongressDao.getStringFromJson(jsonObject, "contact_form")
        this.billsSponsored =
            CongressDao.getIntFromJson(jsonObject, "bills_sponsored")
        this.billsCosponsored =
            CongressDao.getIntFromJson(jsonObject, "bills_cosponsored")
        this.missedVotesPct =
            CongressDao.getDoubleFromJson(jsonObject, "missed_votes_pct")
        this.votesWithPartyPct = CongressDao.getDoubleFromJson(
            jsonObject,
            "votes_with_party_pct"
        )
        this.committees = Committee.getCommitteesFromJSON(
            CongressDao.getJSONArrayFromJson(
                jsonObject,
                "committees"
            )!!
        )
        this.subcommittees =
            Subcommittee.getSubCommitteesFromJSON(
                CongressDao.getJSONArrayFromJson(
                    jsonObject,
                    "subcommittees"
                )!!
            )
    }

    companion object {

        internal fun getRolesFromJSON(jsonArray: JSONArray): ArrayList<Role> {
            val roles = ArrayList<Role>()
            for (i in 0 until jsonArray.length()) {
                try {
                    roles.add(Role(jsonArray.getJSONObject(i)))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }
            return roles
        }
    }
}
