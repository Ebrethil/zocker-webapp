package com.asozialesnetzwerk.net.zockerwebapp.randomizer.model;

import java.util.List;

public class RandomizableRequest {
    private List<String> items;
    private String type;
    private int teamCount;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(int teamCount) {
        this.teamCount = teamCount;
    }
}
