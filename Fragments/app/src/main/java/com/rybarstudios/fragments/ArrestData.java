package com.rybarstudios.fragments;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class ArrestData implements Serializable {
    private String name, team, teamName, teamCity, position, arrestCount;

    public ArrestData(JSONObject jsonObject) {
        try {
            this.name = jsonObject.getString("Name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.team = jsonObject.getString("Team");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.teamName = jsonObject.getString("Team_name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.teamCity = jsonObject.getString("Team_city");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.position = jsonObject.getString("Position");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.arrestCount = jsonObject.getString("arrest_count");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public String getPosition() {
        return position;
    }

    public String getArrestCount() {
        return arrestCount;
    }
}
