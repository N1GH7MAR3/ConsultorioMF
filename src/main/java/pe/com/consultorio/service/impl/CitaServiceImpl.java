
package pe.com.consultorio.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consultorio.entity.Cita;
import pe.com.consultorio.repository.CitaRepository;
import pe.com.consultorio.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService{
    
    @Autowired
    private CitaRepository citaRepository;
    
    @Override
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public List<Cita> findAllCustom() {
        return citaRepository.findAllCustom();
    }

    @Override
    public List<Cita> findAllInactive() {
        return citaRepository.findAllInactive();
    }

    @Override
    public List<Cita> findbyDate(Date fecha) {
        return citaRepository.findByDate(fecha);
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public Cita add(Cita c) {
        return citaRepository.save(c);
    }

    @Override
    public Cita update(Cita c) {
        Cita objCita = citaRepository.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objCita);
        return citaRepository.save(objCita);
    }

    @Override
    public Cita delete(Cita c) {
        Cita objCita = citaRepository.getById(c.getCodigo());
        objCita.setEstado(false);
        return citaRepository.save(objCita);
    }
    
}
