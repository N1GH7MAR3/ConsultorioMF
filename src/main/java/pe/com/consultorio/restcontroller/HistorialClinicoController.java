
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
import pe.com.consultorio.entity.HistorialClinico;
import pe.com.consultorio.service.HistorialClinicoService;

@RestController
@RequestMapping("/historial")
public class HistorialClinicoController {
    
    @Autowired
    private HistorialClinicoService historialService;
    
    @GetMapping
    public List<HistorialClinico> findAll(){
        return historialService.findAll();
    }
    @GetMapping("/custom")
    public List<HistorialClinico> findAllCustom(){
        return historialService.findAllCustom();
    }
    @GetMapping("/inactive")
    public List<HistorialClinico> findAllInactive(){
        return historialService.findAllInactive();
    }    
    @GetMapping("/{id}")
    public Optional<HistorialClinico> findById(@PathVariable long id){
        return historialService.findById(id);
    }
    @PostMapping
    public HistorialClinico add(@RequestBody HistorialClinico h){
        return historialService.add(h);
    }
    @PutMapping("/{id}")
    public HistorialClinico update(@PathVariable Long id, @RequestBody HistorialClinico h){
        h.setCodigo(id);
        return historialService.update(h);
    }
    @DeleteMapping("/{id}")
    public HistorialClinico delete(@PathVariable Long id){
        HistorialClinico objHistorial = new HistorialClinico();
        objHistorial.setCodigo(id);
        return historialService.delete(HistorialClinico.builder().codigo(id).build());
    }
    
}
