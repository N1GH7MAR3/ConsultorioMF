
package pe.com.consultorio.service;

import java.util.List;
import java.util.Optional;
import pe.com.consultorio.entity.Paciente;


public interface PacienteService {
    
    List<Paciente> findAll();

    List<Paciente> findAllCustom();
    
    List<Paciente> findAllInactive();

    List<Paciente> findbyName(String nombre);
    
    List<Paciente> findbySurname(String apellido);
    
    Optional<Paciente> findbyDni(int dni);

    Optional<Paciente> findById(Long id);

    Paciente add(Paciente p);

    Paciente update(Paciente p);

    Paciente delete(Paciente p);
    
}
