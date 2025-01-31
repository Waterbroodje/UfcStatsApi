package me.waterbroodje.ufcstatsapi.repository;

import me.waterbroodje.ufcstatsapi.model.Fight;
import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.model.Referee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FightRepository extends JpaRepository<Fight, Long> {
    Optional<Fight> getFightByFightId(String id);
    Page<Fight> findAll(Pageable pageable);
    Page<Fight> findByReferee(Referee referee, Pageable pageable);
    Page<Fight> findByFirstFighterOrSecondFighter(Fighter firstFighter, Fighter secondFighter, Pageable pageable);
}