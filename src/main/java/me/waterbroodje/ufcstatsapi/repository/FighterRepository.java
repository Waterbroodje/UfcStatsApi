package me.waterbroodje.ufcstatsapi.repository;


import me.waterbroodje.ufcstatsapi.model.Fighter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {
    Optional<Fighter> getFighterByFighterId(String id);
    Page<Fighter> findAll(Pageable pageable); // Pagination support
}