package org.sid.gestioncinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ticket implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double prix;
    private String nomclient;

    @Column(unique = false,nullable = true)
    private  Integer codepayment;
    private boolean reservee;

    @ManyToOne
    private place place;

    @ManyToOne

    private projection projection;
}
