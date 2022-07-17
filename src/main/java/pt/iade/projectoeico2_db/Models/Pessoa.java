package pt.iade.projectoeico2_db.Models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Pessoa")
    public class Pessoa {
        @Id @GeneratedValue
            (strategy = GenerationType.IDENTITY)
			@Column(name="pessoa_id") private Integer pessoaId;
            @Column(name="pessoa_nome") private String nome;
            @Column(name="pessoa_morada") private String morada;
            @Column(name="pessoa_dtnasc") private Date dtnasc;
			@Column(name="pessoa_genero") private Character genero;
			@Column(name="pessoa_email") private String email;
            @Column(name="pessoa_pass") private String pass;
            @Column(name="pessoa_tlm") private Integer tlm;

			public Pessoa() {}

			
			public Integer getPessoaId() {
				return pessoaId;
			}
			
			public String getNome() {
				return nome;
			}

			public String getMorada() {
				return morada;
			}

			public Date getdtnasc() {
				return dtnasc;
			}

			public Character getGenero() {
				return genero;
			}

			public String getEmail() {
				return email;
			}

			public String getPass() {
				return pass;
			}

			public Integer getTlm() {
				return tlm;
			}


			public Pessoa(Integer pessoaId, String nome, String morada, Date dtnasc, Character genero, String email,
					String pass, Integer tlm) {
				this.pessoaId = pessoaId;
				this.nome = nome;
				this.morada = morada;
				this.dtnasc = dtnasc;
				this.genero = genero;
				this.email = email;
				this.pass = pass;
				this.tlm = tlm;
			}


			

    }