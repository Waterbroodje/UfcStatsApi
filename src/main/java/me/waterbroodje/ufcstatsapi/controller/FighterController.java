package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fighters")
public class FighterController {

    @Autowired
    private FighterService fighterService;

    // Get fighter by ID
    @GetMapping("/{id}")
    public ResponseEntity<Fighter> getFighterById(@PathVariable Long id) {
        Optional<Fighter> fighter = fighterService.getFighterById(id);
        if (fighter.isPresent()) {
            return ResponseEntity.ok(fighter.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Search fighters by name
    @GetMapping("/search")
    public ResponseEntity<List<Fighter>> searchFighters(@RequestParam String name) {
        List<Fighter> fighters = fighterService.searchFightersByName(name);
        if (!fighters.isEmpty()) {
            return ResponseEntity.ok(fighters);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Endpoint to get all fighters
    @GetMapping
    public ResponseEntity<List<Fighter>> getAllFighters() {
        List<Fighter> fighters = fighterService.getAllFighters();
        return ResponseEntity.ok(fighters);
    }
}