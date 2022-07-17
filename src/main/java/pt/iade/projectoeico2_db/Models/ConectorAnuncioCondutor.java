// package pt.iade.projectoeico2_db.Models;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @Entity
// @Table(name = "condutor_has_anuncio")
//     public class ConectorAnuncioCondutor {
        
//         @Id @Column(name ="cond_anuncio_id")
//         private int anuncioId;
    
//             @ManyToOne @JoinColumn(name="cond_id")
//             @JsonIgnoreProperties({"campos"})
//             private Campo campo;

//             @Column(name="estado") private String estado;

//             public ConectorAnuncioCondutor() {}

//             public String getEstado() {
//                 return estado;
//             }


//             public Campo getCondutor() {
//                 return campo;
//             }

//             public int getAnuncioId() {
//                 return anuncioId;
//             }
//     }