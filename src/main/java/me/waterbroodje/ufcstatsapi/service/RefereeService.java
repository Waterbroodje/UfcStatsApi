package me.waterbroodje.ufcstatsapi.service;

import me.waterbroodje.ufcstatsapi.model.Referee;
import me.waterbroodje.ufcstatsapi.repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeService {

    @Autowired public RefereeRepository refereeRepository;

    public Optional<Referee> getRefereeByName(String name) {
        return refereeRepository.findByName(name);
    }

    public List<Referee> getAll() {
        return refereeRepository.findAll();
    }

    @Transactional
    public void save(Referee referee) {
        refereeRepository.save(referee);
    }
}