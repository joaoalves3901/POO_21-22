package pt.iade.projectoeico2_db.Models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.projectoeico2_db.Models.Campo;

public interface CampoRepository extends CrudRepository <Campo, Integer> {

    String QueryFindCampos = "select * from campo;";
    String QueryFindCamposId= "select * from campo where campo_id =  :campoId";
    String QueryfindCampoAtiv = "SELECT ativ.ativ_nome, ativ.ativ_disc FROM ativ INNER JOIN ativ_campo ON ativ.ativ_id = ativ_campo.ativ_id AND ativ_campo.campo_id = :campoId";
    // String QueryCampoReserva = "SELECT * from inscricao WHERE campo_id = :campoId and pessoa_id = :pessoaId and semana_id = :semanaId";


    @Query(value = QueryFindCampos, nativeQuery = true)
    Iterable<Campo> findCampo ();

    @Query(value = QueryFindCamposId, nativeQuery = true)
    Iterable<Campo> findCampoId (@Param("campoId") int campoId);

    @Query(value = QueryFindCamposId, nativeQuery = true)
    Iterable<Campo> findCampoAtiv (@Param("campoId") int campoId);

    // @Query(value = QueryCampoReserva, nativeQuery = true)
    // Iterable<Campo> CampoReserva (@Param("campoId") int campoId, 
    //             @Param("pessoaId") int pessoaId, @Param("semanaId") int semanaId );
    



    // Iterable<Admin> findAnuncioByDestino (String destino);

    // @Query(value = QueryaceitarMonitor, nativeQuery = true)
    // Iterable<Admin> aceitarMonitor (@Param("monitorId") int monitorId);

    // @Query(value = QueryPedidosMonitor, nativeQuery = true)
    // Iterable<Admin> pedidosMonitor (@Param("adminId") int adminId);


}
