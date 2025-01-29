package me.waterbroodje.ufcstatsapi.service;

import me.waterbroodje.ufcstatsapi.model.Referee;
import me.waterbroodje.ufcstatsapi.repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeService {

    @Autowired public RefereeRepository refereeRepository;

    public Optional<Referee> getReferee(Long id) {
        return refereeRepository.findById(id);
    }

    public List<Referee> getAll() {
        return refereeRepository.findAll();
    }

    public Referee save(Referee referee) {
        return refereeRepository.save(referee);
    }

    public void delete(Long id) {
        refereeRepository.deleteById(id);
    }
}