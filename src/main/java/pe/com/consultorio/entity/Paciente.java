
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

@Entity(name="Paciente")
@Table(name="Paciente")
public class Paciente implements Serializable {
    
    private static final long serialVersion=1L;
     
    @Id
    @Column(name = "id_paciente")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre_paciente")
    private String nombre;
    @Column(name = "apellido_paciente")
    private String apellido;
    @Column(name = "dni_paciente")
    private Integer dni;
    @Column(name = "edad_paciente")
    private Integer edad;
    @Column(name = "direccion_paciente")
    private String direccion;
    @Column(name = "celular_paciente")
    private Integer celular;
    @Column(name = "estado_paciente")
    private boolean estado;
    
}
