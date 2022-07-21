
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
import org.springframework.web.bind.annotation.RestController;
import pe.com.consultorio.entity.Tratamiento;
import pe.com.consultorio.service.TratamientoService;

@RestController
@RequestMapping("/tratamiento")
public class TratamientoController {
    
    @Autowired
    private TratamientoService tratamientoService;
    
    @GetMapping
    public List<Tratamiento> findAll(){
        return tratamientoService.findAll();
    }
    @GetMapping("/custom")
    public List<Tratamiento> findAllCustom(){
        return tratamientoService.findAllCustom();
    }
    @GetMapping("/inactive")
    public List<Tratamiento> findAllInactive(){
        return tratamientoService.findAllInactive();
    }
    @GetMapping("/name/{name}")
    public List<Tratamiento> findByName(@PathVariable String name){
        return tratamientoService.findbyName(name);
    }
    @GetMapping("/{id}")
    public Optional<Tratamiento> findById(@PathVariable long id){
        return tratamientoService.findById(id);
    }
    @PostMapping
    public Tratamiento add(@RequestBody Tratamiento t){
        return tratamientoService.add(t);
    }
    @PutMapping("/{id}")
    public Tratamiento update(@PathVariable Long id, @RequestBody Tratamiento t){
        t.setCodigo(id);
        return tratamientoService.update(t);
    }
    @DeleteMapping("/{id}")
    public Tratamiento delete(@PathVariable Long id){
        Tratamiento objTratamiento = new Tratamiento();
        objTratamiento.setCodigo(id);
        return tratamientoService.delete(Tratamiento.builder().codigo(id).build());
    }
}
