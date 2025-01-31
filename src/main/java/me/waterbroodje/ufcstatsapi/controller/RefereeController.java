package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Referee;
import me.waterbroodje.ufcstatsapi.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/referees")
public class RefereeController {

    @Autowired private RefereeService refereeService;

    @GetMapping
    public List<Referee> getAllReferees() {
        return refereeService.getAll();
    }

    @GetMapping("/{id}")
    public Referee getRefereeById(@PathVariable Long id) {
        return refereeService.getRefereeById(id).orElse(null);
    }
}
  