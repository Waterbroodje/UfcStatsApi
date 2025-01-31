package me.waterbroodje.ufcstatsapi.service;

import jakarta.transaction.Transactional;
import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    public Optional<Fighter> getFighterById(String id) {
        return fighterRepository.getFighterByFighterId(id);
    }

    @Transactional
    public void saveFighter(Fighter fighter) {
        fighterRepository.save(fighter);
    }

    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }
}