package pt.iade.projectoeico2_db.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "inscricao")
    public class Inscriçao {

        @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
        @Column(name="inscricao_id") private int id;
        
        @JsonProperty("campoId")
        @ManyToOne @JoinColumn(name="campo_id")
            private Campo campo;

            @JsonProperty("PessoaId")
            @ManyToOne @JoinColumn(name="pessoa_id")
            private Pessoa pessoa;

            @JsonProperty("semana")
            @ManyToOne @JoinColumn(name="semana_id")
            private Semana semana;

            public int getId() {
                return id;
            }

            public Campo getCampo() {
                return campo;
            }

            public Pessoa getPessoa() {
                return pessoa;
            }

            public Semana getSemana() {
                return semana;
            }


    }