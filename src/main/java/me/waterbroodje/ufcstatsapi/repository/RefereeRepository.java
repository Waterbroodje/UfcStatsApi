package me.waterbroodje.ufcstatsapi.repository;

import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.model.Referee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefereeRepository extends JpaRepository<Referee, Long> {
    Optional<Referee> findByName(String name);

    Optional<Referee> getRefereeByRefereeId(Long id);
    Page<Referee> findAll(Pageable pageable);
}