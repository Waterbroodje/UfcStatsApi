package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fighters")
public class FighterController {

    @Autowired private FighterService fighterService;

    @GetMapping
    public List<Fighter> getAllFighters() {
        return fighterService.getAllFighters();
    }

    @GetMapping("/{id}")
    public Fighter getFighterById(@PathVariable String id) {
        return fighterService.getFighterById(id).orElse(null);
    }
}