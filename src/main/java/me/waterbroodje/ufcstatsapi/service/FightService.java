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

@Service
public class FightService {

    @Autowired public FightRepository fightRepository;
    @Autowired private FighterRepository fighterRepository;
    @Autowired private RefereeRepository refereeRepository;

    public Optional<Fight> getFight(String id) {
        return fightRepository.getFightByFightId(id);
    }

    @Transactional
    public void save(Fight fight) {
        fightRepository.save(fight);
    }

    public Page<Fight> getAllFights(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return fightRepository.findAll(pageable);
    }

    public Fight getFightById(String id) {
        return fightRepository.getFightByFightId(id).orElse(null);
    }

    public Page<Fight> getFightsByReferee(Long refereeId, int page, int size) {
        Optional<Referee> referee = refereeRepository.findById(refereeId);
        Pageable pageable = PageRequest.of(page, size);
        return referee.map(r -> fightRepository.findByReferee(r, pageable)).orElse(Page.empty());
    }

    public Page<Fight> getFightsByFighter(String fighterId, int page, int size) {
        Optional<Fighter> fighter = fighterRepository.getFighterByFighterId(fighterId);
        Pageable pageable = PageRequest.of(page, size);
        return fighter.map(f -> fightRepository.findByFirstFighterOrSecondFighter(f, f, pageable)).orElse(Page.empty());
    }
}
