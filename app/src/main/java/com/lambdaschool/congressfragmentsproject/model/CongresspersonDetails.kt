package com.lambdaschool.congressfragmentsproject.model

import com.lambdaschool.congressfragmentsproject.data.CongressDao
import org.json.JSONObject

import java.util.ArrayList

class CongresspersonDetails {

    // SerializedName("member_id")
    var memberId: String? = null
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
    // SerializedName("url")
    var url: String? = null
        private set
    // SerializedName("times_topics_url")
    var timesTopicsUrl: String? = null
        private set
    // SerializedName("times_tag")
    var timesTag: String? = null
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
    // SerializedName("twitter_account")
    var twitterAccount: String? = null
        private set
    // SerializedName("facebook_account")
    var facebookAccount: String? = null
        private set
    // SerializedName("youtube_account")
    var youtubeAccount: String? = null
        private set
    // SerializedName("crp_id")
    var crpId: String? = null
        private set
    // SerializedName("google_entity_id")
    var googleEntityId: String? = null
        private set
    // SerializedName("rss_url")
    var rssUrl: String? = null
        private set
    // SerializedName("in_office")
    var isInOffice: Boolean = false
        private set
    // SerializedName("current_party")
    var currentParty: String? = null
        private set
    // SerializedName("most_recent_vote")
    var mostRecentVote: String? = null
        private set
    // SerializedName("last_updated")
    var lastUpdated: String? = null
        private set
    // SerializedName("roles")
    var roles: List<Role>? = null
        private set

    constructor(
        memberId: String,
        firstName: String,
        middleName: String,
        lastName: String,
        suffix: String,
        dateOfBirth: String,
        gender: String,
        url: String,
        timesTopicsUrl: String,
        timesTag: String,
        govtrackId: String,
        cspanId: String,
        votesmartId: String,
        icpsrId: String,
        twitterAccount: String,
        facebookAccount: String,
        youtubeAccount: String,
        crpId: String,
        googleEntityId: String,
        rssUrl: String,
        inOffice: Boolean,
        currentParty: String,
        mostRecentVote: String,
        lastUpdated: String,
        roles: List<Role>
    ) {
        this.memberId = memberId
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.suffix = suffix
        this.dateOfBirth = dateOfBirth
        this.gender = gender
        this.url = url
        this.timesTopicsUrl = timesTopicsUrl
        this.timesTag = timesTag
        this.govtrackId = govtrackId
        this.cspanId = cspanId
        this.votesmartId = votesmartId
        this.icpsrId = icpsrId
        this.twitterAccount = twitterAccount
        this.facebookAccount = facebookAccount
        this.youtubeAccount = youtubeAccount
        this.crpId = crpId
        this.googleEntityId = googleEntityId
        this.rssUrl = rssUrl
        this.isInOffice = inOffice
        this.currentParty = currentParty
        this.mostRecentVote = mostRecentVote
        this.lastUpdated = lastUpdated
        this.roles = roles
    }

    constructor() {
        this.memberId = "member_id"
        this.firstName = "first_name"
        this.middleName = "middle_name"
        this.lastName = "last_name"
        this.suffix = "suffix"
        this.dateOfBirth = "date_of_birth"
        this.gender = "gender"
        this.url = "url"
        this.timesTopicsUrl = "times_topics_url"
        this.timesTag = "times_tag"
        this.govtrackId = "govtrack_id"
        this.cspanId = "cspan_id"
        this.votesmartId = "votesmart_id"
        this.icpsrId = "icpsr_id"
        this.twitterAccount = "twitter_account"
        this.facebookAccount = "facebook_account"
        this.youtubeAccount = "youtube_account"
        this.crpId = "crp_id"
        this.googleEntityId = "google_entity_id"
        this.rssUrl = "rss_url"
        this.isInOffice = false
        this.currentParty = "current_party"
        this.mostRecentVote = "most_recent_vote"
        this.lastUpdated = "last_updated"
        this.roles = ArrayList()
    }

    constructor(jsonObject: JSONObject) {
        this.memberId =
            CongressDao.getStringFromJson(jsonObject, "member_id")
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
        this.url = CongressDao.getStringFromJson(jsonObject, "url")
        this.timesTopicsUrl =
            CongressDao.getStringFromJson(jsonObject, "times_topics_url")
        this.timesTag =
            CongressDao.getStringFromJson(jsonObject, "times_tag")
        this.govtrackId =
            CongressDao.getStringFromJson(jsonObject, "govtrack_id")
        this.cspanId =
            CongressDao.getStringFromJson(jsonObject, "cspan_id")
        this.votesmartId =
            CongressDao.getStringFromJson(jsonObject, "votesmart_id")
        this.icpsrId =
            CongressDao.getStringFromJson(jsonObject, "icpsr_id")
        this.twitterAccount =
            CongressDao.getStringFromJson(jsonObject, "twitter_account")
        this.facebookAccount =
            CongressDao.getStringFromJson(jsonObject, "facebook_account")
        this.youtubeAccount =
            CongressDao.getStringFromJson(jsonObject, "youtube_account")
        this.crpId = CongressDao.getStringFromJson(jsonObject, "crp_id")
        this.googleEntityId =
            CongressDao.getStringFromJson(jsonObject, "google_entity_id")
        this.rssUrl = CongressDao.getStringFromJson(jsonObject, "rss_url")
        this.isInOffice =
            CongressDao.getBooleanFromJson(jsonObject, "in_office")
        this.currentParty =
            CongressDao.getStringFromJson(jsonObject, "current_party")
        this.mostRecentVote =
            CongressDao.getStringFromJson(jsonObject, "most_recent_vote")
        this.lastUpdated =
            CongressDao.getStringFromJson(jsonObject, "last_updated")
        this.roles = Role.getRolesFromJSON(
            CongressDao.getJSONArrayFromJson(
                jsonObject,
                "roles"
            )!!
        )
    }
}
