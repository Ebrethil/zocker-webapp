package com.asozialesnetzwerk.net.zockerwebapp.randomizer;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TeamRandomizer implements Randomizer {
    @Override
    public LinkedList<LinkedList<String>> randomize(List<String> names, int teamCount) {
        LinkedList<LinkedList<String>> randomizedTeams = new LinkedList<>();
        createTeams(randomizedTeams, teamCount);

        Collections.shuffle(names);

        distributeTeams(names, teamCount, randomizedTeams);

        return randomizedTeams;
    }

    private void distributeTeams(List<String> names,
                                 int teamCount,
                                 LinkedList<LinkedList<String>> randomizedTeams) {
        int currentTeamIndex = 0;
        for (String name : names) {
            randomizedTeams.get(currentTeamIndex).add(name);

            if (currentTeamIndex < teamCount - 1) {
                currentTeamIndex ++;
            } else {
                currentTeamIndex = 0;
            }
        }
    }

    private void createTeams(LinkedList<LinkedList<String>> randomizedTeams, Integer teamCount) {
        for (int i = 1; i <= teamCount; i ++) {
            randomizedTeams.add(new LinkedList<>());
        }
    }
}
