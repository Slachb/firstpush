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

public class film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String titre;
    private String realisateur;
    private String description;
    private Date datesortie;
    private double duree;
    private  String photo;

    @OneToMany(mappedBy = "film")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<projection>projections;
@ManyToOne
    private categorie categorie;
}
