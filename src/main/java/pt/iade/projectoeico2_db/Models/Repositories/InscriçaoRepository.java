package pt.iade.projectoeico2_db.Models.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import antlr.collections.List;
import pt.iade.projectoeico2_db.Models.Inscriçao;

public interface InscriçaoRepository extends CrudRepository <Inscriçao, Integer> {

    String QueryCampoReserva = "INSERT INTO inscricao (campo_id, pessoa_id, semana_id) values (:campoId,:PessoaId,:semana);";


    @Query(value = QueryCampoReserva, nativeQuery = true)
    Iterable<Inscriçao> CampoReserva (@Param("campoId") int campoId, 
                @Param("PessoaId") int pessoaId, @Param("semana") int semanaId );
    

}
