package org.sid.gestioncinema.entities;

import jakarta.persistence.Id;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "p1" ,types = projection.class)
public interface projectionProj {

   public Long getId();
   public double getprix();
   public Date getdateProjection();
   public salle getsalle();
   public film getfilm();
   public seance getseance();
   public Collection<ticket> gettickets();



}
