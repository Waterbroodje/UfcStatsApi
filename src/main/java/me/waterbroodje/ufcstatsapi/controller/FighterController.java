package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.service.FightService;
import me.waterbroodje.ufcstatsapi.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FighterController {

    @Autowired private FighterService fighterService;
}
