package me.waterbroodje.ufcstatsapi.controller;

import me.waterbroodje.ufcstatsapi.model.Referee;
import me.waterbroodje.ufcstatsapi.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/referees")
public class RefereeController {
    @Autowired
    private RefereeService refereeService;

    @GetMapping
    public ResponseEntity<List<Referee>> getAllReferees() {
        List<Referee> referees = refereeService.getAll();
        return ResponseEntity.ok(referees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Referee> getRefereeById(@PathVariable Long id) {
        Optional<Referee> referee = refereeService.getReferee(id);
        return referee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Referee> createReferee(@RequestBody Referee referee) {
        Referee savedReferee = refereeService.save(referee);
        return ResponseEntity.ok(savedReferee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Referee> updateReferee(@PathVariable Long id, @RequestBody Referee referee) {
        if (!refereeService.getReferee(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        referee.setRefereeId(id);
        Referee updatedReferee = refereeService.save(referee);
        return ResponseEntity.ok(updatedReferee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReferee(@PathVariable Long id) {
        if (!refereeService.getReferee(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        refereeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
  