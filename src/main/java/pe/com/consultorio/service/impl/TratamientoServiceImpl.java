
package pe.com.consultorio.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consultorio.entity.Tratamiento;
import pe.com.consultorio.repository.TratamientoRepository;
import pe.com.consultorio.service.TratamientoService;

@Service
public class TratamientoServiceImpl implements TratamientoService{
    
    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public List<Tratamiento> findAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public List<Tratamiento> findAllCustom() {
        return tratamientoRepository.findAllCustom();
    }

    @Override
    public List<Tratamiento> findAllInactive() {
        return tratamientoRepository.findAllInactive();
    }

    @Override
    public List<Tratamiento> findbyName(String nombre) {
        return tratamientoRepository.findByName(nombre);
    }

    @Override
    public Optional<Tratamiento> findById(Long id) {
        return tratamientoRepository.findById(id);
    }

    @Override
    public Tratamiento add(Tratamiento t) {
        return tratamientoRepository.save(t);
    }

    @Override
    public Tratamiento update(Tratamiento t) {
        Tratamiento objTratamiento = tratamientoRepository.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objTratamiento);
        return tratamientoRepository.save(objTratamiento);
    }

    @Override
    public Tratamiento delete(Tratamiento t) {
        Tratamiento objTratamiento = tratamientoRepository.getById(t.getCodigo());
        objTratamiento.setEstado(false);
        return tratamientoRepository.save(objTratamiento);
    }
    
}
