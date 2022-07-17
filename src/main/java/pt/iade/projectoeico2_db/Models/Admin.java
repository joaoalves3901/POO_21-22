package pt.iade.projectoeico2_db.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "admin")
    public class Admin {
        @Id @GeneratedValue
            (strategy = GenerationType.IDENTITY)
            @Column(name="admin_id") private int id;
            

            @OneToOne @JoinColumn(name="pessoa_id")
            @JsonIgnoreProperties({"admin"})
            private Pessoa pessoa;

            public Admin() {}

            public int getId() {
                return id;
            }
     
            public Pessoa getPessoa() {
                return pessoa;
            }

    }