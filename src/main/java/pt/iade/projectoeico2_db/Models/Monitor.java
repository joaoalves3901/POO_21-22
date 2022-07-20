package pt.iade.projectoeico2_db.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "monitor")
    public class Monitor {
        @Id @GeneratedValue
            (strategy = GenerationType.IDENTITY)
            @Column(name="monitor_id") private int monitorId;
            @Column(name = "cv") private boolean cv;

            @OneToOne @JoinColumn(name="pessoa_id")
            private Pessoa pessoa;

            public Monitor() {}

            public int getId() {
                return monitorId;
            }

            public boolean isCv() {
                return cv;
            }

            public Pessoa getPessoa() {
                return pessoa;
            }

            public Monitor(int monitorId, boolean cv, Pessoa pessoa) {
                this.monitorId = monitorId;
                this.cv = cv;
                this.pessoa = pessoa;
            }

    }