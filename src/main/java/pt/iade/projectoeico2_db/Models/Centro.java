package pt.iade.projectoeico2_db.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table(name = "centro_saude")
    public class Centro {


        @Id @GeneratedValue
            (strategy = GenerationType.IDENTITY)
            @Column(name="centro_id") 
            private int centroId;
            @JsonIgnoreProperties({"centro"})


            @Column(name="nome") private String nome;
            @Column(name="centro_tlm") private int tlm;
            @Column(name="centro_morada") private String morada;
            @Column(name = "centro_lat") private double lat;
            @Column(name = "centro_long") private double lng;
        

            public Centro() {
            }

            public int getCentroId() {
                return centroId;
            }

            public double getLat() {
                return lat;
            }

            
            public double getLong() {
                return lng;
            }

            public String getNome() {
                return nome;
            }

            public int getTlm() {
                return tlm;
            }

            public String getMorada() {
                return morada;
            }

            

    }