package me.waterbroodje.ufcstatsapi.service;

import me.waterbroodje.ufcstatsapi.model.Fight;
import me.waterbroodje.ufcstatsapi.repository.FightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FightService {

    @Autowired public FightRepository fightRepository;

    public Optional<Fight> getFight(Long id) {
        return fightRepository.findById(id);
    }

    public List<Fight> getAll() {
        return fightRepository.findAll();
    }
}
