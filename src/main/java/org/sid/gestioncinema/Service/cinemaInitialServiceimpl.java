package org.sid.gestioncinema.Service;

import jakarta.transaction.Transactional;
import org.sid.gestioncinema.dao.*;
import org.sid.gestioncinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class cinemaInitialServiceimpl implements IcinemaInitialService{
    @Autowired
    public VilleRepository villeRepository;
    @Autowired
    public CinemaRepository cinemaRepository;
   @Autowired
    public TicketRepository ticketRepository;
   @Autowired
   public SalleRepository salleRepository;
   @Autowired
   public PlaceRepository placeRepository;
   @Autowired
   public SeanceRepository seanceRepository;
   @Autowired
   public ProjectionRepository projectionRepository;
   @Autowired
   public FilmRepository filmRepository;
   @Autowired
   public CategorieRepository categorieRepository;
    @Override
    public void initvilles() {

     Stream.of("marrakech","casablanca","meknes","rabat").forEach(nameville -> {
      ville ville = new ville();
      ville.setName(nameville);
      villeRepository.save(ville);

     });

    }

    @Override
    public void initcinemas() {
     villeRepository.findAll().forEach(v->{
      Stream.of("megarama","IMAX","founoun","chahrazad").forEach(nameCinema ->{
       cinema cinema=new cinema();
       cinema.setName(nameCinema);
       cinema.setNombresalles(4+(int) Math.random()*15);
       cinema.setVille(v);
       cinemaRepository.save(cinema);
      });

             }

             );

    }

    @Override
    public void initsalles() {
     cinemaRepository.findAll().forEach( cinema->{
      for (int i=0;i<cinema.getNombresalles();i++){

       salle salle =new salle();
       salle.setName("salle"+(i+1));
       salle.setCinema(cinema);
       salle.setNombreplaces(15+(int) (Math.random()*30 ));
       salleRepository.save(salle);

      }
     } );

    }

    @Override
    public void initsceances() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("12:00","18:30","20:00","16:00").forEach(s -> {

            seance seance =new seance();
            try {
                seance.setHeuredebut(dateFormat.parse(s));
                seanceRepository.save(seance);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }


        });


    }

    @Override
    public void initplaces() {
     salleRepository.findAll().forEach(salle -> {
         for (int i=0;i<salle.getNombreplaces();i++) {

             place place = new place();
             place.setNumero(i+1);
             place.setSalle(salle);
             placeRepository.save(place);
         }
     });


    }

    @Override
    public void initcategories() {

            Stream.of("action","drama","comedie","romantic").forEach(cat ->{
             categorie categorie=new categorie();
             categorie.setName(cat);
             categorieRepository.save(categorie);

            });

    }

    @Override
    public void initfilms() {
      double [] durees =new double[]{1.5,2,3,1};
        List<categorie> categories =categorieRepository.findAll();
        Stream.of("game of thrones","vikings","lost","prison breack").forEach(titrefilm ->{

          film film =new film();
          film.setTitre(titrefilm);
            film.setDuree(durees[new Random().nextInt(durees.length)]);
            film.setPhoto(titrefilm.replaceAll("\\s+", ""));
            film.setCategorie(categories.get(new Random().nextInt(categories.size())));
            filmRepository.save(film);
        });

    }

    @Override
    public void initProjections() {
          double []prix = new double[]{20,50,60,70,80,90,100};

          List<film> films=filmRepository.findAll();
        villeRepository.findAll().forEach(ville -> {
          ville.getCinemas().forEach(cinema -> {
              cinema.getSalles().forEach(salle -> {
              int index =new Random().nextInt(films.size());

            film film=films.get(index);

                   seanceRepository.findAll().forEach(sceance ->{

                       projection projection=new projection();
                       projection.setDateProjection(new Date());
                       projection.setFilm(film);
                       projection.setPrix(prix [new Random().nextInt(prix.length)]);
                       projection.setSalle(salle);
                       projection.setSeance(sceance);
                       projectionRepository.save(projection);



                   });


              });
          });

        });

    }

    @Override
    public void inittickets() {
        projectionRepository.findAll().forEach(projection -> {
           projection.getSalle().getPlaces().forEach(places -> {

               ticket Ticket=new ticket();

                      Ticket.setPlace(places);
                       Ticket.setPrix(projection.getPrix());
                       Ticket.setProjection(projection);
                       Ticket.setReservee(false);
                       ticketRepository.save(Ticket);

           }
           );

        });

    }
}
