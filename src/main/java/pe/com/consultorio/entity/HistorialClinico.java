
package pe.com.consultorio.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "Historial_Clinico")
@Table(name = "Historial_Clinico")
public class HistorialClinico implements Serializable{
    private static final long serialVersion = 1L;

    @Id
    @Column(name = "id_historial")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "estado_historial")
    private boolean estado; 
    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
      
}
