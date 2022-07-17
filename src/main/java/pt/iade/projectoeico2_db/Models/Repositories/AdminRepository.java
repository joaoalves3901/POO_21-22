package pt.iade.projectoeico2_db.Models.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import pt.iade.projectoeico2_db.Models.Admin;
import pt.iade.projectoeico2_db.Models.Campo_semana;

public interface AdminRepository extends CrudRepository <Admin, Integer> {

    String QueryFindAdmin = "select * from admin;";
    String QueryFindAdminId= "select * from admin where admin_id = :adminId";
    String QueryaceitarMonitor= "UPDATE monitor_insc SET cv = 1 WHERE pessoa_id = :monitorId";
    String QueryPedidosMonitor= "SELECT pessoa.pessoa_nome, pessoa.pessoa_id from pessoa INNER JOIN monitor_insc ON pessoa.pessoa_id = monitor_insc.pessoa_id AND monitor_insc.cv = 0";
    String QueryGerirMonitor= "INSERT INTO campo_semana (semana_id, monitor_id, campo_id) values (:semanaId,:monitorId,:campoId)";


    @Query(value = QueryFindAdmin, nativeQuery = true)
    Iterable<Admin> findAdmin();

    @Query(value = QueryFindAdminId, nativeQuery = true)
    Iterable<Admin> findAdminId (@Param("adminId") int adminId);

    // Iterable<Admin> findAnuncioByDestino (String destino);

    @Query(value = QueryaceitarMonitor, nativeQuery = true)
    Iterable<Admin> aceitarMonitor (@Param("monitorId") int monitorId);

    @Query(value = QueryPedidosMonitor, nativeQuery = true)
    Iterable<Admin> pedidosMonitor();    
    
    @Modifying
    @Query(value = QueryGerirMonitor, nativeQuery = true)
    List<Admin> gerirMonitor (@Param("semanaId") int semana, @Param ("monitorId") int monitor, @Param ("campoId") int campo);



   /* String QueryInsertAnuncio = "insert into anuncio (anuncio_cliente_id, anuncio_origem, anuncio_destino, anuncio_volume, anuncio_desc) values (:#{#anuncio.cliente.id}, "+
    ":#{#anuncio.origem},:#{#anuncio.destino},:#{#anuncio.volume},:#{#anuncio.descricao}";
    @Modifying
    @Transactional
    @Query(value=QueryInsertAnuncio, nativeQuery = true)
    void addAnuncio(@Param("Anuncio")int id);*/

}
