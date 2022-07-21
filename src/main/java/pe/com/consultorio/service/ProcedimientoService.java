
package pe.com.consultorio.service;

import java.util.List;
import java.util.Optional;
import pe.com.consultorio.entity.Procedimiento;

public interface ProcedimientoService {
    List<Procedimiento> findAll();

    List<Procedimiento> findAllCustom();
    
    List<Procedimiento> findAllInactive();

    List<Procedimiento> findbyName(String nombre);

    Optional<Procedimiento> findById(Long id);

    Procedimiento add(Procedimiento t);

    Procedimiento update(Procedimiento t);

    Procedimiento delete(Procedimiento t);
}
