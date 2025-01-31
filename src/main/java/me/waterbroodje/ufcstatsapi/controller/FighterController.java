package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fighters")
public class FighterController {

    @Autowired
    private FighterService fighterService;

    @GetMapping
    public List<Fighter> getAllFighters() {
        return fighterService.getAllFighters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fighter> getFighterById(@PathVariable Long id) {
        return fighterService.getFighterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Fighter> searchFighters(@RequestParam String name) {
        return fighterService.searchFightersByName(name);
    }

    @PostMapping
    public Fighter createFighter(@RequestBody Fighter fighter) {
        return fighterService.saveFighter(fighter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fighter> updateFighter(@PathVariable Long id, @RequestBody Fighter fighter) {
        return fighterService.getFighterById(id)
                .map(existingFighter -> {
                    fighter.setId(id);
                    return ResponseEntity.ok(fighterService.saveFighter(fighter));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}