package pt.iade.projectoeico2_db.Controllers;

import pt.iade.projectoeico2_db.Models.Pessoa;
import pt.iade.projectoeico2_db.Models.Semana;
import pt.iade.projectoeico2_db.Models.Repositories.SemanaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.Optional; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/semana")

public class SemanaController {
    private Logger logger = LoggerFactory.getLogger(PessoaController.class);
    @Autowired
    private SemanaRepository semanaRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Semana> getSemanas() {
        logger.info("Sending all drivers");
        // System.out.println(campoRepository.findCampo());
        return semanaRepository.findAll();
    }

}
