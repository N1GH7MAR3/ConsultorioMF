
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
import pe.com.consultorio.entity.Procedimiento;
import pe.com.consultorio.service.ProcedimientoService;

@RestController
@RequestMapping("/procedimiento")
public class ProcedimientoController {
    
    @Autowired
    private ProcedimientoService procedimientoService;
    
    @GetMapping
    public List<Procedimiento> findAll(){
        return procedimientoService.findAll();
    }
    @GetMapping("/custom")
    public List<Procedimiento> findAllCustom(){
        return procedimientoService.findAllCustom();
    }
    @GetMapping("/inactive")
    public List<Procedimiento> findAllInactive(){
        return procedimientoService.findAllInactive();
    }
    @GetMapping("/name/{name}")
    public List<Procedimiento> findByName(@PathVariable String name){
        return procedimientoService.findbyName(name);
    }
    @GetMapping("/{id}")
    public Optional<Procedimiento> findById(@PathVariable long id){
        return procedimientoService.findById(id);
    }
    @PostMapping
    public Procedimiento add(@RequestBody Procedimiento t){
        return procedimientoService.add(t);
    }
    @PutMapping("/{id}")
    public Procedimiento update(@PathVariable Long id, @RequestBody Procedimiento t){
        t.setCodigo(id);
        return procedimientoService.update(t);
    }
    @DeleteMapping("/{id}")
    public Procedimiento delete(@PathVariable Long id){
        Procedimiento objTratamiento = new Procedimiento();
        objTratamiento.setCodigo(id);
        return procedimientoService.delete(Procedimiento.builder().codigo(id).build());
    }
}
