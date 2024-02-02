package org.sid.gestioncinema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ville implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double longitude,altitude,latitude;

     @OneToMany(mappedBy = "ville")
     private Collection<cinema>cinemas;

}
