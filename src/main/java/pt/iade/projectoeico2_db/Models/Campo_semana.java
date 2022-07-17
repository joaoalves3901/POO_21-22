package pt.iade.projectoeico2_db.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "campo_semana")
public class Campo_semana {

            @Id @GeneratedValue
            (strategy = GenerationType.IDENTITY)
            @Column(name="inscricao_id") private int id;

            @ManyToOne @JoinColumn(name="monitor_id")
            @JsonIgnoreProperties({"campo_semana"})
            @JsonProperty("monitor")
            private Monitor monitor;


            public Monitor getMonitor() {
                return monitor;
            }


            @ManyToOne @JoinColumn(name="campo_id")
            @JsonIgnoreProperties({"campo_semana"})
            @JsonProperty("campo")
            private Campo campo;


            public Campo getCampo() {
                return campo;
            }


            @ManyToOne @JoinColumn(name="semana_id")
            @JsonIgnoreProperties({"campo_semana"})
            private Semana semana;


            public Semana getSemana() {
                return semana;
            }

            public Campo_semana(int id, Monitor monitor, Campo campo, Semana semana) {
                this.id = id;
                this.monitor = monitor;
                this.campo = campo;
                this.semana = semana;
            }


}
