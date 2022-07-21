
package pe.com.consultorio.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.com.consultorio.entity.Paciente;
import pe.com.consultorio.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    
    @Autowired
    private PacienteService pacienteService;
    
    
    @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }
    
    @GetMapping("/custom")
    public List<Paciente> findAllCustom(){
        return pacienteService.findAllCustom();
    }
    
    @GetMapping("/inactive")
    public List<Paciente> findAllInactive(){
        return pacienteService.findAllInactive();
    }
    
    @GetMapping("/dni/{dni}")
    public Optional<Paciente> findByDni(@PathVariable int dni){
        return pacienteService.findbyDni(dni);
    }
    
    @GetMapping("/name/{name}")
    public List<Paciente> findByName(@PathVariable String name){
        return pacienteService.findbyName(name);
    }
    
    @GetMapping("/surname/{surname}")
    public List<Paciente> findBySurname(@PathVariable String surname){
        return pacienteService.findbySurname(surname);
    }
    
    @GetMapping("/{id}")
    public Optional<Paciente> findById(@PathVariable long id){
        return pacienteService.findById(id);
    }
    
    @PostMapping
    public Paciente add(@RequestBody Paciente p){
        try {
            pacienteService.add(p);
        } catch (Exception e) {
            System.out.println("Error al registrar Paciente : "+e.getMessage());
        }
        return p;
    }
    
    @PutMapping("/{id}")
    public Paciente update(@PathVariable Long id, @RequestBody Paciente p){
        p.setCodigo(id);
        return pacienteService.update(p);
    }
    
    @DeleteMapping("/{id}")
    public Paciente delete(@PathVariable Long id){
        Paciente objPaciente = new Paciente();
        objPaciente.setCodigo(id);
        return pacienteService.delete(Paciente.builder().codigo(id).build());
    }

    
}
