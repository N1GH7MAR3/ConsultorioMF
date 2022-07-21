
package pe.com.consultorio.service;

import java.util.List;
import java.util.Optional;
import pe.com.consultorio.entity.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();

    List<Usuario> findAllCustom();
    
    List<Usuario> findAllInactive();

    List<Usuario> findbyName(String nombre);
    
    List<Usuario> findbySurname(String apellido);

    Optional<Usuario> findById(Long id);

    Usuario add(Usuario u);

    Usuario update(Usuario u);

    Usuario delete(Usuario u);
}
