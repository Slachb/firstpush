package org.sid.gestioncinema.dao;

import org.sid.gestioncinema.entities.film;
import org.sid.gestioncinema.entities.salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface SalleRepository extends JpaRepository<salle,Long> {
}
