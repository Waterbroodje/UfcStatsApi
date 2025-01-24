package me.waterbroodje.ufcstatsapi.repository;


import me.waterbroodje.ufcstatsapi.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {
}