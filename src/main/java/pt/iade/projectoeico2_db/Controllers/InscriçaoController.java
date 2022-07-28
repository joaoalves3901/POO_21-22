package pt.iade.projectoeico2_db.Controllers;

import pt.iade.projectoeico2_db.Models.Inscriçao;
import pt.iade.projectoeico2_db.Models.Repositories.InscriçaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/inscricoes")

public class InscriçaoController {
    private Logger logger = LoggerFactory.getLogger(CentroController.class);
    @Autowired
    private InscriçaoRepository inscriçaoRepository;

    @PostMapping(path = "/reservas", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Inscriçao> CampoReserva(@RequestBody int campoId, int PessoaId, int semana ) {
        logger.info("Campo: "+ campoId + "Reservado pela pessoa: " + PessoaId);
        return inscriçaoRepository.CampoReserva(campoId, PessoaId, semana);
    };
}
