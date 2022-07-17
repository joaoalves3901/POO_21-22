package pt.iade.projectoeico2_db.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Semana")
    public class Semana {
        @Id @GeneratedValue
            (strategy = GenerationType.IDENTITY)
			@Column(name="semana_id") private int semanaId;
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@Column(name="semana_start") private Date start;
			
			public Semana() {}


			public int getId() {
				return semanaId;
			}

			public Date getStart() {
				return start;
			}

			
			public Semana(int semanaId, Date start) {
				this.semanaId = semanaId;
				this.start = start;
			}


    }