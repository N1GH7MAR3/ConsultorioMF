package pe.com.consultorio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
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
import org.springframework.format.annotation.DateTimeFormat;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "Cita")
@Table(name = "Cita")
public class Cita implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @Column(name = "id_cita")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "fecha_cita")   
    private Date fecha;
    @Column(name = "hora_cita")
    private Time hora;
    @Column(name = "descripcion_cita")
    private String descripcion;
    @Column(name = "estado_cita")
    private boolean estado; 
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_procedimiento", nullable = false)
    private Procedimiento procedimiento;

}
