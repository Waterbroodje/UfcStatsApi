package me.waterbroodje.ufcstatsapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity klasse die een UFC scheidsrechter representeert
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "referees")
public class Referee {

    // Automatisch gegenereerde ID voor de scheidsrechter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referee_id")
    private Long refereeId;

    // Naam van de scheidsrechter
    private String name;
}