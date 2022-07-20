package pt.iade.projectoeico2_db.Models.Repositories;

import java.util.List;

// import javax.management.monitor.Monitor;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.projectoeico2_db.Models.Admin;


public interface AdminRepository extends CrudRepository <Admin, Integer> {

    String QueryFindAdmin = "select * from admin;";
    String QueryFindAdminId= "select * from admin where admin_id = :adminId";
    String QueryaceitarMonitor= "UPDATE monitor_insc SET cv = 1 WHERE pessoa_id = :monitorId";
    String QueryGerirMonitor= "INSERT INTO campo_semana (semana_id, monitor_id, campo_id) values (:semanaId,:monitorId,:campoId)";


    @Query(value = QueryFindAdmin, nativeQuery = true)
    Iterable<Admin> findAdmin();

    @Query(value = QueryFindAdminId, nativeQuery = true)
    Iterable<Admin> findAdminId (@Param("adminId") int adminId);

    @Transactional
    @Modifying
    @Query(value = QueryaceitarMonitor, nativeQuery = true)
    int aceitarMonitor (@Param("monitorId") int id);   
    
    @Transactional
    @Modifying
    @Query(value = QueryGerirMonitor, nativeQuery = true)
    List<Admin> gerirMonitor (@Param("semanaId") int semanaId, @Param ("monitorId") int monitorId, @Param ("campoId") int campoId);

}
