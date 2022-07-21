package pe.com.consultorio.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.consultorio.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query(value="select * from Paciente p where p.estado_paciente='1'",nativeQuery = true)
    List<Paciente> findAllCustom();
    
    @Query(value="select * from Paciente p where p.dni_paciente=(:dni) and p.estado_paciente='1'",nativeQuery = true)
    Optional<Paciente> findByDni(@Param("dni") int dni);
    
    @Query(value="select * from Paciente p where upper(p.nombre_paciente) like upper(:nombre) and p.estado_paciente='1'",nativeQuery = true)
    List<Paciente> findByName(@Param("nombre") String nombre);
    
    @Query(value="select * from Paciente p where upper(p.apellido_paciente) like upper(:apellido) and p.estado_paciente='1'",nativeQuery = true)
    List<Paciente> findBySurname(@Param("apellido") String apellido);
    
    @Query(value="select * from Paciente p where p.estado_paciente='0'",nativeQuery = true)
    List<Paciente> findAllInactive();
    
}
