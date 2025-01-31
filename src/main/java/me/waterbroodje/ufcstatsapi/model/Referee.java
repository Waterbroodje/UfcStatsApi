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
@Table(name = "referees")
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private String id;

    private String name;
}