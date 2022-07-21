
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

@Entity(name="Procedimiento")
@Table(name="Procedimiento")
public class Procedimiento implements Serializable {
    private static final long serialVersion=1L;
     
    @Id
    @Column(name = "id_procedimiento")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre_procedimiento")
    private String nombre;
    @Column(name = "descripcion_procedimiento")
    private String descripcion;
    @Column(name = "sesiones_procedimiento")
    private Integer sesiones;
    @Column(name = "costo_procedimiento")
    private Double costo;
    @Column(name = "estado_procedimiento")
    private boolean estado;
    
}
