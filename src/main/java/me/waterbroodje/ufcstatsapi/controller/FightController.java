package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FightController {

    @Autowired private FightService fightService;


}