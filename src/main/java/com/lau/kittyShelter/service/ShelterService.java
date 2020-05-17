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

        String kittyNamesPattern = "<section.*\\n(.*\\n)*?.*?<h2>\\n.*?(\\w+)";

        assert response != null;
        updatedKitties = Pattern.compile(kittyNamesPattern)
                .matcher(response)
                .results()
                .map(m -> m.group(2))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(updatedKitties);
        isThereNewKitties = updatedKitties.size() > kitties.size() || !kitties.containsAll(updatedKitties);
        kitties = updatedKitties;
        return isThereNewKitties;
    }
}
