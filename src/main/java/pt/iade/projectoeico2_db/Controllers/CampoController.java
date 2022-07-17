package pt.iade.projectoeico2_db.Controllers;

import pt.iade.projectoeico2_db.Models.Campo;
import pt.iade.projectoeico2_db.Models.Repositories.CampoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/campos")

public class CampoController {
    private Logger logger = LoggerFactory.getLogger(CampoController.class);
    @Autowired
    private CampoRepository campoRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Campo> getCampos() {
        logger.info("Sending all drivers");
        // System.out.println(campoRepository.findCampo());
        return campoRepository.findCampo();
    }

    @GetMapping(path = "/{campoId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Campo> getCampoId(@PathVariable int campoId) {
        logger.info("Sending user with id:"+ campoId);
        System.out.println(campoId);
        return campoRepository.findCampoId(campoId);
    }

    @GetMapping(path = "/{campoId}/ativ", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Campo> getCampoAtiv(@PathVariable int campoId) {
        logger.info("Sending user with id:"+ campoId);
        System.out.println(campoId);
        return campoRepository.findCampoAtiv(campoId);
    }

}
