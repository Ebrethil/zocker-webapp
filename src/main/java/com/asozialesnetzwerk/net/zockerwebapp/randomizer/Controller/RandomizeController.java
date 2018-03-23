package com.asozialesnetzwerk.net.zockerwebapp.randomizer.Controller;

import com.asozialesnetzwerk.net.zockerwebapp.randomizer.TeamRandomizer;
import com.asozialesnetzwerk.net.zockerwebapp.randomizer.model.Item;
import com.asozialesnetzwerk.net.zockerwebapp.randomizer.model.RandomizableRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.LinkedList;

@RestController()
public class RandomizeController {
    private final TeamRandomizer teamRandomizer;

    public RandomizeController(TeamRandomizer teamRandomiser) {
        this.teamRandomizer = teamRandomiser;
    }

    @PostMapping(value = "/randomize")
    @Produces(value = "application/json")
    public ResponseEntity<LinkedList<LinkedList<String>>> randomizeTeams(
            @RequestBody RandomizableRequest randomizableRequest) {

        LinkedList<LinkedList<String>> randomizedCollection = teamRandomizer.randomize(
                randomizableRequest.getItems(),
                randomizableRequest.getTeamCount()
        );

        logTeams(randomizedCollection);

        return ResponseEntity.ok(randomizedCollection);
    }
























    private void logTeams(LinkedList<LinkedList<String>> randomizedCollection) {
        for (LinkedList<String> team : randomizedCollection) {
            System.out.println("Team [ " + Arrays.toString(team.toArray()) + " ]");
        }
        System.out.println("- - - - - - - - - - - - - - - -");
    }


    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HttpEntity postTest(@RequestBody Item item) {
        return ResponseEntity.ok(item.getName());
    }

    @GetMapping(value = "/test")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("bla");
    }
}
