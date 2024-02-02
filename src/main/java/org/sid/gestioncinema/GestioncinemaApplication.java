package org.sid.gestioncinema;

import org.sid.gestioncinema.Service.IcinemaInitialService;
import org.sid.gestioncinema.dao.CategorieRepository;
import org.sid.gestioncinema.entities.film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class GestioncinemaApplication implements CommandLineRunner {

    @Autowired
    private IcinemaInitialService icinemaInitialService;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(GestioncinemaApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {

        restConfiguration.exposeIdsFor(film.class);

        icinemaInitialService.initvilles();
        icinemaInitialService.initcinemas();
        icinemaInitialService.initsalles();
        icinemaInitialService.initplaces();
        icinemaInitialService.initsceances();
        icinemaInitialService.initcategories();
        icinemaInitialService.initfilms();
        icinemaInitialService.initProjections();
        icinemaInitialService.inittickets();

    }
}
