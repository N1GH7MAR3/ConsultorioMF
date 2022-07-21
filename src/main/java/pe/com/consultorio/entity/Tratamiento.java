
package pe.com.consultorio.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data 

@Entity(name="Tratamiento")
@Table(name="Tratamiento")
public class Tratamiento implements Serializable {
    private static final long serialVersion=1L;
     
    @Id
    @Column(name = "id_tratamiento")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre_tratamiento")
    private String nombre;
    @Column(name = "descripcion_tratamiento")
    private String descripcion;
    @Column(name = "sesiones_tratamiento")
    private Integer sesiones;
    @Column(name = "costo_tratamiento")
    private Double costo;
    @Column(name = "estado_tratamiento")
    private boolean estado;
    
}
