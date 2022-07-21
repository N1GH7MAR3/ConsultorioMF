
package pe.com.consultorio.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consultorio.entity.Usuario;
import pe.com.consultorio.repository.UsuarioRepository;
import pe.com.consultorio.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAllCustom() {
        return usuarioRepository.findAllCustom();
    }

    @Override
    public List<Usuario> findAllInactive() {
        return usuarioRepository.findAllInactive();
    }

    @Override
    public List<Usuario> findbyName(String nombre) {
        return usuarioRepository.findByName(nombre);
    }

    @Override
    public List<Usuario> findbySurname(String apellido) {
        return usuarioRepository.findBySurname(apellido);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario add(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public Usuario update(Usuario u) {
        Usuario objUsuario = usuarioRepository.getById(u.getCodigo());
        BeanUtils.copyProperties(u, objUsuario);
        return usuarioRepository.save(objUsuario);
    }

    @Override
    public Usuario delete(Usuario u) {
        Usuario objUsuario = usuarioRepository.getById(u.getCodigo());
        objUsuario.setEstado(false);
        return usuarioRepository.save(objUsuario);
    }
    
}
