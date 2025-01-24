package me.waterbroodje.ufcstatsapi.service;

import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    @Autowired public FighterRepository fighterRepository;

    public Optional<Fighter> getFighter(Long id) {
        return fighterRepository.findById(id);
    }

    public List<Fighter> getAll() {
        return fighterRepository.findAll();
    }
}