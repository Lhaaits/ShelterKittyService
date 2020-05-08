package com.lau.kittyShelter.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Getter
public class ShelterService {

    private List<String> kitties = new ArrayList<>();

    public boolean isThereNewKittiesYet() {
        List<String> updatedKitties;
        boolean isThereNewKitties;
        final String URI = "https://asieldierenonline.nl//katten?shelter=13";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(URI, String.class);
//        String countPattern = "<html.*?>(.*?\\n)*?.*<span id=\"count\">(\\d)+(.*?\\n)*?.*<h2>.*\\n.*?(\\w+)";
        String kittyNamesPattern = "<section.*\\n(.*\\n)*?.*?<h2>\\n.*?(\\w+)";

        Pattern p = Pattern.compile(kittyNamesPattern);
        assert response != null;
//        Matcher m = p.matcher(response);

        updatedKitties = Pattern.compile("<section.*\\n(.*\\n)*?.*?<h2>\\n.*?(\\w+)")
                .matcher(response)
                .results()
                .map(m -> m.group(2))
                .sorted()
                .collect(Collectors.toList());

//        int count = 0;
//        String name = "";
        // if we find a match, get the group
//        while (m.find()) {
//            updatedKitties.add(m.group(2));
//            // get the matching group
////            String countGroup = m.group(2);
////            count = Integer.parseInt(countGroup);
////            name = m.group(4);
//        }
        System.out.println(updatedKitties);
        isThereNewKitties = updatedKitties.size() > kitties.size() || !kitties.containsAll(updatedKitties);
        kitties = updatedKitties;
        return isThereNewKitties;
    }
}
