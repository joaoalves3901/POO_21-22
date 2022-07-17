package pt.iade.projectoeico2_db.Models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.projectoeico2_db.Models.Centro;

public interface CentroRepository extends CrudRepository <Centro, Integer> {

    String QueryFindCentros = "select * from centro_saude;";


    @Query(value = QueryFindCentros, nativeQuery = true)
    Iterable<Centro> findCentro();



    // Iterable<Admin> findAnuncioByDestino (String destino);

    // @Query(value = QueryaceitarMonitor, nativeQuery = true)
    // Iterable<Admin> aceitarMonitor (@Param("monitorId") int monitorId);

    // @Query(value = QueryPedidosMonitor, nativeQuery = true)
    // Iterable<Admin> pedidosMonitor (@Param("adminId") int adminId);


}
