package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Fight;
import me.waterbroodje.ufcstatsapi.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fights")
public class FightController {

    @Autowired private FightService fightService;

    @GetMapping
    public Page<Fight> getAllFights(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return fightService.getAllFights(page, size);
    }

    @GetMapping("/{id}")
    public Fight getFightById(@PathVariable String id) {
        return fightService.getFightById(id);
    }

    @GetMapping("/by-referee/{refereeId}")
    public Page<Fight> getFightsByReferee(
            @PathVariable Long refereeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return fightService.getFightsByReferee(refereeId, page, size);
    }

    @GetMapping("/by-fighter/{fighterId}")
    public Page<Fight> getFightsByFighter(
            @PathVariable String fighterId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return fightService.getFightsByFighter(fighterId, page, size);
    }
}