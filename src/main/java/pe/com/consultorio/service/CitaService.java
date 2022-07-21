
package pe.com.consultorio.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import pe.com.consultorio.entity.Cita;

public interface CitaService {
    List<Cita> findAll();

    List<Cita> findAllCustom();
    
    List<Cita> findAllInactive();

    List<Cita> findbyDate(Date fecha);
    
    Optional<Cita> findById(Long id);

    Cita add(Cita c);

    Cita update(Cita c);

    Cita delete(Cita c);
}
