package pt.iade.projectoeico2_db.Models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "campo_semana")
public class Campo_semana {

            @ManyToOne @JoinColumn(name="monitor_id")
            @JsonIgnoreProperties({"campo_semana"})
            private Monitor monitor;


            public Monitor getMonitor() {
                return monitor;
            }


            @ManyToOne @JoinColumn(name="campo_id")
            @JsonIgnoreProperties({"campo_semana"})
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

            public Campo_semana(Monitor monitor, Campo campo, Semana semana) {
                this.monitor = monitor;
                this.campo = campo;
                this.semana = semana;
            }


}
