package pt.iade.projectoeico2_db.Models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.projectoeico2_db.Models.Monitor;

public interface MonitorRepository extends CrudRepository <Monitor, Integer> {

    String QueryFindMonitor = "select * from monitor_insc;";
   
    @Query(value = QueryFindMonitor, nativeQuery = true)
    Iterable<Monitor> findMonitor();

}
