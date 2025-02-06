package me.waterbroodje.ufcstatsapi.service;

import me.waterbroodje.ufcstatsapi.model.Fight;
import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.model.Referee;
import me.waterbroodje.ufcstatsapi.repository.FightRepository;
import me.waterbroodje.ufcstatsapi.repository.FighterRepository;
import me.waterbroodje.ufcstatsapi.repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Service klasse voor het beheren van gevechten
@Service
public class FightService {

    @Autowired public FightRepository fightRepository;
    @Autowired private FighterRepository fighterRepository;
    @Autowired private RefereeRepository refereeRepository;

    // Haalt een gevecht op basis van ID
    public Optional<Fight> getFight(String id) {
        return fightRepository.getFightByFightId(id);
    }

    // Slaat een gevecht op in de database
    @Transactional
    public void save(Fight fight) {
        fightRepository.save(fight);
    }

    // Haalt alle gevechten op met paginering
    public Page<Fight> getAllFights(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return fightRepository.findAll(pageable);
    }

    public Fight getFightById(String id) {
        return fightRepository.getFightByFightId(id).orElse(null);
    }

    // Haalt alle gevechten op van een specifieke scheidsrechter
    public Page<Fight> getFightsByReferee(Long refereeId, int page, int size) {
        Optional<Referee> referee = refereeRepository.findById(refereeId);
        Pageable pageable = PageRequest.of(page, size);
        return referee.map(r -> fightRepository.findByReferee(r, pageable)).orElse(Page.empty());
    }

    // Haalt alle gevechten op van een specifieke vechter
    public Page<Fight> getFightsByFighter(String fighterId, int page, int size) {
        Optional<Fighter> fighter = fighterRepository.getFighterByFighterId(fighterId);
        Pageable pageable = PageRequest.of(page, size);
        return fighter.map(f -> fightRepository.findByFirstFighterOrSecondFighter(f, f, pageable)).orElse(Page.empty());
    }
}
