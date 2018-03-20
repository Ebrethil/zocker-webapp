package com.asozialesnetzwerk.net.zockerwebapp.randomizer;

import java.util.LinkedList;
import java.util.List;

public interface Randomizer {
    LinkedList<LinkedList<String>> randomize(List<String> items, int teamCount);
}
