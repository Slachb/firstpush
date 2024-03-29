package org.sid.gestioncinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class place implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  int numero;
    private double longitude,latitude,altitude;

    @ManyToOne
    private salle salle;

    @OneToMany(mappedBy = "place")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ticket>tickets;

}
