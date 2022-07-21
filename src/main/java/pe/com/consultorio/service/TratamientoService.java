
package pe.com.consultorio.service;

import java.util.List;
import java.util.Optional;
import pe.com.consultorio.entity.Tratamiento;

public interface TratamientoService {
    List<Tratamiento> findAll();

    List<Tratamiento> findAllCustom();
    
    List<Tratamiento> findAllInactive();

    List<Tratamiento> findbyName(String nombre);

    Optional<Tratamiento> findById(Long id);

    Tratamiento add(Tratamiento t);

    Tratamiento update(Tratamiento t);

    Tratamiento delete(Tratamiento t);
}
