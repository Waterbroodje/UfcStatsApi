package me.waterbroodje.ufcstatsapi.service;

import me.waterbroodje.ufcstatsapi.model.Fight;
import me.waterbroodje.ufcstatsapi.repository.FightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FightService {

    @Autowired public FightRepository fightRepository;

    public Optional<Fight> getFight(String id) {
        return fightRepository.getFightByFightId(id);
    }

    public List<Fight> getAll() {
        return fightRepository.findAll();
    }

    @Transactional
    public void save(Fight fight) {
        fightRepository.save(fight);
    }
}
