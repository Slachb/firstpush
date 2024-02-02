package org.sid.gestioncinema.dao;

import org.sid.gestioncinema.entities.film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface FilmRepository extends JpaRepository<film,Long> {
}
