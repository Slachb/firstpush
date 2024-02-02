package org.sid.gestioncinema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cinema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private  double longitude,latitude,altitude;
    private int nombresalles;
    @ManyToOne
    private ville ville;
    @OneToMany(mappedBy = "cinema")
    private Collection <salle>salles;

}
