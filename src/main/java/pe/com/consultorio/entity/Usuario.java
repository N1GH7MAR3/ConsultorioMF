
package pe.com.consultorio.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor 
@AllArgsConstructor 
@Data 

@Entity(name="Usuario")

@Table(name="Usuario")
public class Usuario implements Serializable {
     private static final long serialVersion = 1L;

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre_usuario")
    private String nombre;
    @Column(name = "apellido_usuario")
    private String apellido;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "clave")
    private String clave;
    @Column(name = "estado_usuario")
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
}
