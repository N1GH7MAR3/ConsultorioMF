
package pe.com.consultorio.service;

import java.util.List;
import java.util.Optional;
import pe.com.consultorio.entity.Rol;

public interface RolService {
    List<Rol> findAll();

    List<Rol> findAllCustom();
    
    List<Rol> findAllInactive();

    List<Rol> findbyName(String nombre);

    Optional<Rol> findById(Long id);

    Rol add(Rol r);

    Rol update(Rol r);

    Rol delete(Rol r);
}
