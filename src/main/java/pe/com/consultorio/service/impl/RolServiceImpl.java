
package pe.com.consultorio.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consultorio.entity.Rol;
import pe.com.consultorio.repository.RolRepository;
import pe.com.consultorio.service.RolService;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public List<Rol> findAllCustom() {
        return rolRepository.findAllCustom();
    }

    @Override
    public List<Rol> findAllInactive() {
        return rolRepository.findAllInactive();
    }

    @Override
    public List<Rol> findbyName(String nombre) {
        return rolRepository.findByName(nombre);
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol add(Rol r) {
        return rolRepository.save(r);
    }

    @Override
    public Rol update(Rol r) {
        Rol objRol = rolRepository.getById(r.getCodigo());
        BeanUtils.copyProperties(r, objRol);
        return rolRepository.save(objRol);
    }

    @Override
    public Rol delete(Rol r) {
        Rol objRol = rolRepository.getById(r.getCodigo());
        objRol.setEstado(false);
        return rolRepository.save(objRol);
    }
    
}
