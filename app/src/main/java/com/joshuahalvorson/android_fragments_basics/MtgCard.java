package com.joshuahalvorson.android_fragments_basics;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MtgCard implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("manaCost")
    @Expose
    private String manaCost;
    @SerializedName("cmc")
    @Expose
    private int cmc;
    @SerializedName("colors")
    @Expose
    private List<String> colors = null;
    @SerializedName("colorIdentity")
    @Expose
    private List<String> colorIdentity = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("supertypes")
    @Expose
    private List<Object> supertypes = null;
    @SerializedName("types")
    @Expose
    private List<String> types = null;
    @SerializedName("subtypes")
    @Expose
    private List<Object> subtypes = null;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("set")
    @Expose
    private String set;
    @SerializedName("setName")
    @Expose
    private String setName;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("multiverseid")
    @Expose
    private int multiverseid;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("starter")
    @Expose
    private boolean starter;
    @SerializedName("foreignNames")
    @Expose
    private List<Object> foreignNames = null;
    @SerializedName("printings")
    @Expose
    private List<String> printings = null;
    @SerializedName("originalText")
    @Expose
    private String originalText;
    @SerializedName("originalType")
    @Expose
    private String originalType;
    @SerializedName("id")
    @Expose
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(List<String> colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getSupertypes() {
        return supertypes;
    }

    public void setSupertypes(List<Object> supertypes) {
        this.supertypes = supertypes;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Object> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<Object> subtypes) {
        this.subtypes = subtypes;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public int getMultiverseid() {
        return multiverseid;
    }

    public void setMultiverseid(int multiverseid) {
        this.multiverseid = multiverseid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isStarter() {
        return starter;
    }

    public void setStarter(boolean starter) {
        this.starter = starter;
    }

    public List<Object> getForeignNames() {
        return foreignNames;
    }

    public void setForeignNames(List<Object> foreignNames) {
        this.foreignNames = foreignNames;
    }

    public List<String> getPrintings() {
        return printings;
    }

    public void setPrintings(List<String> printings) {
        this.printings = printings;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
