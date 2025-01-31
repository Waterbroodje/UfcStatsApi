package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Referee;
import me.waterbroodje.ufcstatsapi.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/referees")
public class RefereeController {

    @Autowired private RefereeService refereeService;

    @GetMapping
    public Page<Referee> getAllReferees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return refereeService.getAllReferees(page, size);
    }

    @GetMapping("/{id}")
    public Referee getRefereeById(@PathVariable Long id) {
        return refereeService.getRefereeById(id).orElse(null);
    }
}
  