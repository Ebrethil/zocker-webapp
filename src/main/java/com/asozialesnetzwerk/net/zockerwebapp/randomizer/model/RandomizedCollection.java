package com.asozialesnetzwerk.net.zockerwebapp.randomizer.model;

import java.util.List;

public class RandomizedCollection<T> {
    private List<T> randomizedTeams;

    public List<T> getRandomizedTeams() {
        return randomizedTeams;
    }

    public void setRandomizedTeams(List<T> randomizedTeams) {
        this.randomizedTeams = randomizedTeams;
    }
}
