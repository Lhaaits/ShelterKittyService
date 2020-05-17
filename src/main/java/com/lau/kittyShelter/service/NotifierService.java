package com.lau.kittyShelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NotifierService {
    @Autowired
    ShelterService shelterService;

    public void checkForNewKitty (){
        if(shelterService.isThereNewKittiesYet()){
            System.out.println("sending Notification at "+ LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        }
    }
}
