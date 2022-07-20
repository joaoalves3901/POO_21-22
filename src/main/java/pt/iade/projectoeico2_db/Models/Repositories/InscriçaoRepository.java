package pt.iade.projectoeico2_db.Models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.projectoeico2_db.Models.Inscriçao;

public interface InscriçaoRepository extends CrudRepository <Inscriçao, Integer> {

    String QueryCampoReserva = "SELECT * from inscricao WHERE campo_id = :campoId and pessoa_id = :PessoaId and semana_id = :semana";


    @Query(value = QueryCampoReserva, nativeQuery = true)
    int CampoReserva (@Param("campoId") int campoId, 
                @Param("PessoaId") int pessoaId, @Param("semana") int semanaId );
    

}
