package pt.iade.projectoeico2_db.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "campo")
    public class Campo {
        @Id @GeneratedValue
            (strategy = GenerationType.IDENTITY)
            @Column(name="campo_id") 
            private int campoId;
            @JsonIgnoreProperties({"campo"})


            @Column(name="campo_nome") private String nome;
            @Column(name="campo_disc") private String disc;
            @Column(name="campo_lat") private double lat;
            @Column(name="campo_long") private double lng;
            @Column(name="campo_cap") private int cap;


            public int getCap() {
                return cap;
            }

            public Campo() {
            }


            public String getNome() {
                return nome;
            }



            public String getDisc() {
                return disc;
            }



            public double getLat() {
                return lat;
            }

            
            public double getLong() {
                return lng;
            }

            public int getCampoId() {
                return campoId;
            }



    }