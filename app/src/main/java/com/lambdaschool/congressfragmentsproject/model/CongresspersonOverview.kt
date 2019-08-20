package com.lambdaschool.congressfragmentsproject.model

import com.lambdaschool.congressfragmentsproject.data.CongressDao
import org.json.JSONObject

class CongresspersonOverview {

    // SerializedName("id")
    var id: String? = null
        private set
    // SerializedName("title")
    var title: String? = null
        private set
    // SerializedName("short_title")
    var shortTitle: String? = null
        private set
    // SerializedName("api_uri")
    var apiUri: String? = null
        private set
    // SerializedName("first_name")
    var firstName: String? = null
        private set
    // SerializedName("middle_name")
    var middleName: String? = null
        private set
    // SerializedName("last_name")
    var lastName: String? = null
        private set
    // SerializedName("suffix")
    var suffix: String? = null
        private set
    // SerializedName("date_of_birth")
    var dateOfBirth: String? = null
        private set
    // SerializedName("gender")
    var gender: String? = null
        private set
    // SerializedName("party")
    var party: String? = null
        private set
    // SerializedName("leadership_role")
    var leadershipRole: String? = null
        private set
    // SerializedName("twitter_account")
    var twitterAccount: String? = null
        private set
    // SerializedName("facebook_account")
    var facebookAccount: String? = null
        private set
    // SerializedName("youtube_account")
    var youtubeAccount: String? = null
        private set
    // SerializedName("govtrack_id")
    var govtrackId: String? = null
        private set
    // SerializedName("cspan_id")
    var cspanId: String? = null
        private set
    // SerializedName("votesmart_id")
    var votesmartId: String? = null
        private set
    // SerializedName("icpsr_id")
    var icpsrId: String? = null
        private set
    // SerializedName("crp_id")
    var crpId: String? = null
        private set
    // SerializedName("google_entity_id")
    var googleEntityId: String? = null
        private set
    // SerializedName("fec_candidate_id")
    var fecCandidateId: String? = null
        private set
    // SerializedName("url")
    var url: String? = null
        private set
    // SerializedName("rss_url")
    var rssUrl: String? = null
        private set
    // SerializedName("contact_form")
    var contactForm: String? = null
        private set
    // SerializedName("in_office")
    var isInOffice: Boolean = false
        private set
    // SerializedName("dw_nominate")
    var dwNominate: Double = 0.toDouble()
        private set
    // SerializedName("ideal_point")
    var idealPoint: String? = null
        private set
    // SerializedName("seniority")
    var seniority: String? = null
        private set
    // SerializedName("next_election")
    var nextElection: String? = null
        private set
    // SerializedName("total_votes")
    var totalVotes: Int = 0
        private set
    // SerializedName("missed_votes")
    var missedVotes: Int = 0
        private set
    // SerializedName("total_present")
    var totalPresent: Int = 0
        private set
    // SerializedName("last_updated")
    var lastUpdated: String? = null
        private set
    // SerializedName("ocd_id")
    var ocdId: String? = null
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
    // SerializedName("state")
    var state: String? = null
        private set
    // SerializedName("senate_class")
    var senateClass: String? = null
        private set
    // SerializedName("state_rank")
    var stateRank: String? = null
        private set
    // SerializedName("lis_id")
    var lisId: String? = null
        private set
    // SerializedName("missed_votes_pct")
    var missedVotesPct: Double = 0.toDouble()
        private set
    // SerializedName("votes_with_party_pct")
    var votesWithPartyPct: Double = 0.toDouble()
        private set

    constructor(
        id: String,
        title: String,
        shortTitle: String,
        apiUri: String,
        firstName: String,
        middleName: String,
        lastName: String,
        suffix: String,
        dateOfBirth: String,
        gender: String,
        party: String,
        leadershipRole: String,
        twitterAccount: String,
        facebookAccount: String,
        youtubeAccount: String,
        govtrackId: String,
        cspanId: String,
        votesmartId: String,
        icpsrId: String,
        crpId: String,
        googleEntityId: String,
        fecCandidateId: String,
        url: String,
        rssUrl: String,
        contactForm: String,
        inOffice: Boolean,
        dwNominate: Double,
        idealPoint: String,
        seniority: String,
        nextElection: String,
        totalVotes: Int,
        missedVotes: Int,
        totalPresent: Int,
        lastUpdated: String,
        ocdId: String,
        office: String,
        phone: String,
        fax: String,
        state: String,
        senateClass: String,
        stateRank: String,
        lisId: String,
        missedVotesPct: Double,
        votesWithPartyPct: Double
    ) {
        this.id = id
        this.title = title
        this.shortTitle = shortTitle
        this.apiUri = apiUri
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.suffix = suffix
        this.dateOfBirth = dateOfBirth
        this.gender = gender
        this.party = party
        this.leadershipRole = leadershipRole
        this.twitterAccount = twitterAccount
        this.facebookAccount = facebookAccount
        this.youtubeAccount = youtubeAccount
        this.govtrackId = govtrackId
        this.cspanId = cspanId
        this.votesmartId = votesmartId
        this.icpsrId = icpsrId
        this.crpId = crpId
        this.googleEntityId = googleEntityId
        this.fecCandidateId = fecCandidateId
        this.url = url
        this.rssUrl = rssUrl
        this.contactForm = contactForm
        this.isInOffice = inOffice
        this.dwNominate = dwNominate
        this.idealPoint = idealPoint
        this.seniority = seniority
        this.nextElection = nextElection
        this.totalVotes = totalVotes
        this.missedVotes = missedVotes
        this.totalPresent = totalPresent
        this.lastUpdated = lastUpdated
        this.ocdId = ocdId
        this.office = office
        this.phone = phone
        this.fax = fax
        this.state = state
        this.senateClass = senateClass
        this.stateRank = stateRank
        this.lisId = lisId
        this.missedVotesPct = missedVotesPct
        this.votesWithPartyPct = votesWithPartyPct
    }

    constructor(jsonObject: JSONObject) {
        this.id = CongressDao.getStringFromJson(jsonObject, "id")
        this.title = CongressDao.getStringFromJson(jsonObject, "title")
        this.shortTitle =
            CongressDao.getStringFromJson(jsonObject, "short_title")
        this.apiUri = CongressDao.getStringFromJson(jsonObject, "api_uri")
        this.firstName =
            CongressDao.getStringFromJson(jsonObject, "first_name")
        this.middleName =
            CongressDao.getStringFromJson(jsonObject, "middle_name")
        this.lastName =
            CongressDao.getStringFromJson(jsonObject, "last_name")
        this.suffix = CongressDao.getStringFromJson(jsonObject, "suffix")
        this.dateOfBirth =
            CongressDao.getStringFromJson(jsonObject, "date_of_birth")
        this.gender = CongressDao.getStringFromJson(jsonObject, "gender")
        this.party = CongressDao.getStringFromJson(jsonObject, "party")
        this.leadershipRole =
            CongressDao.getStringFromJson(jsonObject, "leadership_role")
        this.twitterAccount =
            CongressDao.getStringFromJson(jsonObject, "twitter_account")
        this.facebookAccount =
            CongressDao.getStringFromJson(jsonObject, "facebook_account")
        this.youtubeAccount =
            CongressDao.getStringFromJson(jsonObject, "youtube_account")
        this.govtrackId =
            CongressDao.getStringFromJson(jsonObject, "govtrack_id")
        this.cspanId =
            CongressDao.getStringFromJson(jsonObject, "cspan_id")
        this.votesmartId =
            CongressDao.getStringFromJson(jsonObject, "votesmart_id")
        this.icpsrId =
            CongressDao.getStringFromJson(jsonObject, "icpsr_id")
        this.crpId = CongressDao.getStringFromJson(jsonObject, "crp_id")
        this.googleEntityId =
            CongressDao.getStringFromJson(jsonObject, "google_entity_id")
        this.fecCandidateId =
            CongressDao.getStringFromJson(jsonObject, "fec_candidate_id")
        this.url = CongressDao.getStringFromJson(jsonObject, "url")
        this.rssUrl = CongressDao.getStringFromJson(jsonObject, "rss_url")
        this.contactForm =
            CongressDao.getStringFromJson(jsonObject, "contact_form")
        this.isInOffice =
            CongressDao.getBooleanFromJson(jsonObject, "in_office")
        this.dwNominate =
            CongressDao.getDoubleFromJson(jsonObject, "dw_nominate")
        this.idealPoint =
            CongressDao.getStringFromJson(jsonObject, "ideal_point")
        this.seniority =
            CongressDao.getStringFromJson(jsonObject, "seniority")
        this.nextElection =
            CongressDao.getStringFromJson(jsonObject, "next_election")
        this.totalVotes =
            CongressDao.getIntFromJson(jsonObject, "total_votes")
        this.missedVotes =
            CongressDao.getIntFromJson(jsonObject, "missed_votes")
        this.totalPresent =
            CongressDao.getIntFromJson(jsonObject, "total_present")
        this.lastUpdated =
            CongressDao.getStringFromJson(jsonObject, "last_updated")
        this.ocdId = CongressDao.getStringFromJson(jsonObject, "ocd_id")
        this.office = CongressDao.getStringFromJson(jsonObject, "office")
        this.phone = CongressDao.getStringFromJson(jsonObject, "phone")
        this.fax = CongressDao.getStringFromJson(jsonObject, "fax")
        this.state = CongressDao.getStringFromJson(jsonObject, "state")
        this.senateClass =
            CongressDao.getStringFromJson(jsonObject, "senate_class")
        this.stateRank =
            CongressDao.getStringFromJson(jsonObject, "state_rank")
        this.lisId = CongressDao.getStringFromJson(jsonObject, "lis_id")
        this.missedVotesPct =
            CongressDao.getDoubleFromJson(jsonObject, "missed_votes_pct")
        this.votesWithPartyPct = CongressDao.getDoubleFromJson(
            jsonObject,
            "votes_with_party_pct"
        )
    }
}
