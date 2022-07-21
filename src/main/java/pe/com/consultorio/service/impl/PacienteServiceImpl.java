
package pe.com.consultorio.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.consultorio.entity.Paciente;
import pe.com.consultorio.repository.PacienteRepository;
import pe.com.consultorio.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public List<Paciente> findAllCustom() {
        return pacienteRepository.findAllCustom();
    }
    
    @Override
    public List<Paciente> findAllInactive() {
        return pacienteRepository.findAllInactive();
    }
    
    @Override
    public List<Paciente> findbyName(String nombre) {
        return pacienteRepository.findByName(nombre);
    }
    
    @Override
    public List<Paciente> findbySurname(String apellido) {
        return pacienteRepository.findBySurname(apellido);
    }
    
    @Override
    public Optional<Paciente> findbyDni(int dni) {
        return pacienteRepository.findByDni(dni);
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente add(Paciente p) {
        return pacienteRepository.save(p);
    }

    @Override
    public Paciente update(Paciente p) {
        Paciente objPaciente = pacienteRepository.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objPaciente);
        return pacienteRepository.save(objPaciente);
    }

    @Override
    public Paciente delete(Paciente p) {
        Paciente objPaciente = pacienteRepository.getById(p.getCodigo());
        objPaciente.setEstado(false);
        return pacienteRepository.save(objPaciente);
    }

    
    
}
