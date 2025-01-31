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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referee_id")
    private Long refereeId;

    private String name;
}