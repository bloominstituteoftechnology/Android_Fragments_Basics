package com.jakeesveld.android_fragments_basics;

public class AppListing {

    private int id;
    private String appName, appVersion, domainName, contactEmail, imageURL;

    public AppListing(String id, String appName, String appVersion, String domainName, String contactEmail, String imageURL) {
        this.id = Integer.parseInt(id);
        this.appName = appName;
        this.appVersion = appVersion;
        this.domainName = domainName;
        this.contactEmail = contactEmail;
        this.imageURL = imageURL;
    }

    public AppListing() {
    }

    public int getId() {
        return id;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

