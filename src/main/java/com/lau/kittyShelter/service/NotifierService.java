package com.lau.kittyShelter.service;

import com.lau.kittyShelter.service.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifierService {
    @Autowired
    ShelterService shelterService;

    @Autowired
    MailService mailService;

    public void checkForNewKitty (){
        if(shelterService.isThereNewKittiesYet()){
            mailService.sendMail("l.haaitsma@gmail.com", "New Kitty!", "Hoi er is een nieuwe kitty yo!");
        }
    }
}
