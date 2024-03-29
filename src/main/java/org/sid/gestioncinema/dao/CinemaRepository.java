package org.sid.gestioncinema.dao;

import org.sid.gestioncinema.entities.cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource

@CrossOrigin("*")

public interface CinemaRepository extends JpaRepository<cinema,Long> {

}
