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
    @Column(name = "fight_id")
    private String fightId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "first_fighter_id", referencedColumnName = "fighter_id") // Correct column name
    private Fighter firstFighter;

    @Column(name = "first_fighter_result")
    private String firstFighterResult;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "second_fighter_id", referencedColumnName = "fighter_id") // Correct column name
    private Fighter secondFighter;

    @Column(name = "second_fighter_result")
    private String secondFighterResult;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "referee_id", referencedColumnName = "referee_id") // Correct column name
    private Referee referee;

    @Column(name = "head")
    private String head;

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
}