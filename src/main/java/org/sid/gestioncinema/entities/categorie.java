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
public class categorie implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(length = 57)
    private String name;

    @OneToMany(mappedBy = "categorie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<film>films;
}
