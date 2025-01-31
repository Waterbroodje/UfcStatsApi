package me.waterbroodje.ufcstatsapi.repository;

import me.waterbroodje.ufcstatsapi.model.Fight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FightRepository extends JpaRepository<Fight, Long> {
    Optional<Fight> getFightByFightId(String id);
    Page<Fight> findAll(Pageable pageable); // Added pagination support
}