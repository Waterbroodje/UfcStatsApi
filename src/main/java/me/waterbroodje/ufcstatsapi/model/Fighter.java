package me.waterbroodje.ufcstatsapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fighters")
public class Fighter {

    @Id
    @Column(name = "fighter_id")
    private String fighterId;

    private String name;
}