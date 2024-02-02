package org.sid.gestioncinema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class seance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Temporal(TemporalType.TIME)
    private Date heuredebut;


}
