package pt.iade.projectoeico2_db.Models.Repositories;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.projectoeico2_db.Models.Pessoa;

public interface PessoaRepository extends CrudRepository <Pessoa, Integer> {

    String QueryFindPessoaId= "select * from pessoa where pessoa_id = :pessoaId";
    String QueryPedirMonitor= "INSERT INTO monitor_insc (pessoa_id, cv) values (:pessoaId,0)";
    String QueryPedidosMonitor= "SELECT * from pessoa INNER JOIN monitor_insc ON pessoa.pessoa_id = monitor_insc.pessoa_id AND monitor_insc.cv = 0";


    @Query(value = QueryPedidosMonitor, nativeQuery = true)
    Iterable<Pessoa> pedidosMonitor();   

    @Query(value = QueryFindPessoaId, nativeQuery = true)
    Iterable<Pessoa> findPessoaId (@Param("pessoaId") int pessoaId);

    @Transactional
    @Modifying
    @Query(value = QueryPedirMonitor, nativeQuery = true)
    int pedirMonitor (@Param("pessoaId") int pessoaId);
    

    // @Query()

    
    // @Query(value = QueryRegsiter, nativeQuery = true)
    // Iterable<Pessoa> Register(@PathVariable Pessoa newPessoa);

}
