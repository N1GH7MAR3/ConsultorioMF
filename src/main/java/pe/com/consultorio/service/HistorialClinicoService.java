
package pe.com.consultorio.service;

import java.util.List;
import java.util.Optional;
import pe.com.consultorio.entity.HistorialClinico;

public interface HistorialClinicoService {
    List<HistorialClinico> findAll();

    List<HistorialClinico> findAllCustom();
    
    List<HistorialClinico> findAllInactive();

    Optional<HistorialClinico> findById(Long id);

    HistorialClinico add(HistorialClinico h);

    HistorialClinico update(HistorialClinico h);

    HistorialClinico delete(HistorialClinico h);
}
