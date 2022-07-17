package pt.iade.projectoeico2_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Console;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.iade.projectoeico2_db.Models.Admin;
import pt.iade.projectoeico2_db.Models.Campo_semana;
import pt.iade.projectoeico2_db.Models.Repositories.AdminRepository;

@RestController
@RequestMapping(path="/api/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<pt.iade.projectoeico2_db.Models.Admin> getAdmin() {
        logger.info("Sending all admins");
        return adminRepository.findAdmin();
    }
    
    @GetMapping(path = "/{adminId}/pedidosMonitor", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Admin> pedidosMonitor(@PathVariable("adminId") Integer adminId) {
        logger.info("Sending all pedidos for admin" + adminId);
        return adminRepository.pedidosMonitor();
    }    
    
    @PostMapping(path = "/gerirMonitor", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Admin> gerirMonitor(@RequestBody Campo_semana campo_semana) {
        logger.info("Monitor Updated by admin");
        return adminRepository.gerirMonitor(campo_semana.getSemana().getId(), campo_semana.getMonitor().getId(), campo_semana.getCampo().getCampoId());
    }

    @GetMapping(path = "/{adminId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Admin> getAdminId(@PathVariable Integer adminId) {
        logger.info("Sending profile for admin" + adminId);
        return adminRepository.findAdminId(adminId);
    }


    // @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    // public Admin saveAnuncio(@RequestBody Admin newAnuncio) {
    //     logger.info("Saving Anuncio:"+ newAnuncio.getDescricao());
    //     Admin anuncio = adminRepository.save(newAnuncio);
    //     return anuncio;
    // }

    @PutMapping(path = "/aceitarMonitor", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<pt.iade.projectoeico2_db.Models.Admin> aceitarMonitor(@RequestBody int id) {
        logger.info("Sending all advertisements with id" + id);
        return adminRepository.aceitarMonitor(id);
    }

}