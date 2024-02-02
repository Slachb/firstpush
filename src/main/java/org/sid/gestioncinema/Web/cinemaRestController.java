package org.sid.gestioncinema.Web;


import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.sid.gestioncinema.dao.FilmRepository;
import org.sid.gestioncinema.dao.TicketRepository;
import org.sid.gestioncinema.entities.film;
import org.sid.gestioncinema.entities.ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.json.JacksonMappingAwareSortTranslator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@RestController
@CrossOrigin("*")
public class cinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;

  @GetMapping(value = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte [] image (@PathVariable (name = "id") Long id){

         film f=filmRepository.findById(id).get();
         String photoName=f.getPhoto();

      File file =new File(System.getProperty("user.home")+"/cinema/images/"+photoName+".jpg");
      Path path = Paths.get(file.toURI());
      try {
          return Files.readAllBytes(path);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }

  }
    @PostMapping("/payerTickets")
    @Transactional
  public List<ticket>  payerTickets(@RequestBody TicketFrom ticketFrom){
      List<ticket> ListTickets=new ArrayList<>();
     ticketFrom.getTickets().forEach(idTicket->{

      // System.out.println(idTicket);

           ticket ticket=ticketRepository.findById(idTicket).get();
           ticket.setNomclient(ticketFrom.getNomClient());
           ticket.setReservee(true);
           ticketRepository.save(ticket);
        ListTickets.add(ticket);


     });
    return ListTickets;


    }
}
@Data
 class  TicketFrom{
    private String nomClient;
   private  int codepayement;
    private  List<Long> tickets=new ArrayList<>();
 }