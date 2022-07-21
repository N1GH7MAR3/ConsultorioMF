
package pe.com.consultorio.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consultorio.entity.Procedimiento;
import pe.com.consultorio.repository.ProcedimientoRepository;
import pe.com.consultorio.service.ProcedimientoService;

@Service
public class ProcedimientoServiceImpl implements ProcedimientoService{
    
    @Autowired
    private ProcedimientoRepository procedimientoRepository;

    @Override
    public List<Procedimiento> findAll() {
        return procedimientoRepository.findAll();
    }

    @Override
    public List<Procedimiento> findAllCustom() {
        return procedimientoRepository.findAllCustom();
    }

    @Override
    public List<Procedimiento> findAllInactive() {
        return procedimientoRepository.findAllInactive();
    }

    @Override
    public List<Procedimiento> findbyName(String nombre) {
        return procedimientoRepository.findByName(nombre);
    }

    @Override
    public Optional<Procedimiento> findById(Long id) {
        return procedimientoRepository.findById(id);
    }

    @Override
    public Procedimiento add(Procedimiento t) {
        return procedimientoRepository.save(t);
    }

    @Override
    public Procedimiento update(Procedimiento t) {
        Procedimiento objProcedimiento = procedimientoRepository.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objProcedimiento);
        return procedimientoRepository.save(objProcedimiento);
    }

    @Override
    public Procedimiento delete(Procedimiento t) {
        Procedimiento objTratamiento = procedimientoRepository.getById(t.getCodigo());
        objTratamiento.setEstado(false);
        return procedimientoRepository.save(objTratamiento);
    }
    
}
