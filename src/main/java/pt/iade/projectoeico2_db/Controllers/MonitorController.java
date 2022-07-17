package pt.iade.projectoeico2_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.iade.projectoeico2_db.Models.Monitor;
import pt.iade.projectoeico2_db.Models.Repositories.MonitorRepository;

@RestController
@RequestMapping(path="/api/monitor")
public class MonitorController {
    private Logger logger = LoggerFactory.getLogger(MonitorController.class);
    @Autowired
    private MonitorRepository monitorRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Monitor> getMonitor() {
        logger.info("Sending all monitors");
        return monitorRepository.findMonitor();
    }

}