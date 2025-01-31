package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Fight;
import me.waterbroodje.ufcstatsapi.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fights")
public class FightController {

    @Autowired
    private FightService fightService;

    @GetMapping
    public List<Fight> getAllFights() {
        return fightService.getAllFights();
    }

    @GetMapping("/{id}")
    public Fight getFightById(@PathVariable String id) {
        return fightService.getFightById(id);
    }
}