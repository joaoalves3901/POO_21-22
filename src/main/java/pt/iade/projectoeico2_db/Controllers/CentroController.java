package pt.iade.projectoeico2_db.Controllers;

import pt.iade.projectoeico2_db.Models.Centro;
import pt.iade.projectoeico2_db.Models.Repositories.CentroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/centros")

public class CentroController {
    private Logger logger = LoggerFactory.getLogger(CentroController.class);
    @Autowired
    private CentroRepository centroRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Centro> getCentros() {
        logger.info("Sending all centros");
        return centroRepository.findCentro();
    }
}
