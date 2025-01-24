package me.waterbroodje.ufcstatsapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fights")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fight_id")
    private Long fightId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "first_fighter_id", referencedColumnName = "fighter_id")
    private Fighter firstFighter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "second_fighter_id", referencedColumnName = "fighter_id")
    private Fighter secondFighter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "referee_id", referencedColumnName = "referee_id")
    private Referee referee;

    @Column(name = "method")
    private String method;

    @Column(name = "round")
    private String round;

    @Column(name = "time")
    private String time;

    @Column(name = "time_format")
    private String timeFormat;

    @Column(name = "details")
    private String details;

    @Column(name = "result")
    private String result;
}