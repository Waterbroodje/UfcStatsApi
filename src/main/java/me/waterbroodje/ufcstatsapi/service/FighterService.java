package me.waterbroodje.ufcstatsapi.service;

import jakarta.transaction.Transactional;
import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service klasse voor het beheren van vechters
@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    // Haalt een vechter op basis van ID
    public Optional<Fighter> getFighterById(String id) {
        return fighterRepository.getFighterByFighterId(id);
    }

    // Slaat een vechter op in de database
    @Transactional
    public void saveFighter(Fighter fighter) {
        fighterRepository.save(fighter);
    }

    // Haalt alle vechters op met paginering
    public Page<Fighter> getAllFighters(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return fighterRepository.findAll(pageable);
    }
}