package me.waterbroodje.ufcstatsapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity klasse die een UFC vechter representeert
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fighters")
public class Fighter {

    // Unieke identifier voor de vechter
    @Id
    @Column(name = "fighter_id")
    private String fighterId;

    // Naam van de vechter
    private String name;
}