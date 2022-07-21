
package pe.com.consultorio.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consultorio.entity.HistorialClinico;
import pe.com.consultorio.repository.HistorialClinicoRepository;
import pe.com.consultorio.service.HistorialClinicoService;

@Service
public class HistorialClinicoServiceImpl implements HistorialClinicoService{

    
    @Autowired
    private HistorialClinicoRepository historialRepository;
    
    @Override
    public List<HistorialClinico> findAll() {
        return historialRepository.findAll();
    }

    @Override
    public List<HistorialClinico> findAllCustom() {
        return historialRepository.findAllCustom();
    }

    @Override
    public List<HistorialClinico> findAllInactive() {
        return historialRepository.findAllInactive();
    }

    @Override
    public Optional<HistorialClinico> findById(Long id) {
        return historialRepository.findById(id);
    }

    @Override
    public HistorialClinico add(HistorialClinico h) {
        return historialRepository.save(h);
    }

    @Override
    public HistorialClinico update(HistorialClinico h) {
        HistorialClinico objHistorial = historialRepository.getById(h.getCodigo());
        BeanUtils.copyProperties(h, objHistorial);
        return historialRepository.save(objHistorial);
    }

    @Override
    public HistorialClinico delete(HistorialClinico h) {
        HistorialClinico objHistorial = historialRepository.getById(h.getCodigo());
        objHistorial.setEstado(false);
        return historialRepository.save(objHistorial);
    }
    
}
