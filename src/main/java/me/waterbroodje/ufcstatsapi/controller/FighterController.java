package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fighters")
public class FighterController {

    @Autowired private FighterService fighterService;

    @GetMapping
    public Page<Fighter> getAllFighters(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return fighterService.getAllFighters(page, size);
    }

    @GetMapping("/{id}")
    public Fighter getFighterById(@PathVariable String id) {
        return fighterService.getFighterById(id).orElse(null);
    }
}