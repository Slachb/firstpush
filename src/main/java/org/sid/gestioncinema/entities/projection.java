package org.sid.gestioncinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class projection implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProjection;
    private double prix;
    @ManyToOne
    private film film;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private salle salle;

    @OneToMany(mappedBy = "projection")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ticket>tickets;

    @ManyToOne

    private seance seance;
}
