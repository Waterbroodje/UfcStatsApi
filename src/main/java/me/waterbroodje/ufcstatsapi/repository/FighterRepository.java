package me.waterbroodje.ufcstatsapi.repository;


import me.waterbroodje.ufcstatsapi.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {
    List<Fighter> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
    Optional<Fighter> findFighterById(String firstName);
}