
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
import pe.com.consultorio.entity.Rol;
import pe.com.consultorio.service.RolService;


@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;
    
    @GetMapping
    public List<Rol> findAll(){
        return rolService.findAll();
    }
    @GetMapping("/custom")
    public List<Rol> findAllCustom(){
        return rolService.findAllCustom();
    }
    @GetMapping("/inactive")
    public List<Rol> findAllInactive(){
        return rolService.findAllInactive();
    }
    @GetMapping("/name/{name}")
    public List<Rol> findByName(@PathVariable String name){
        return rolService.findbyName(name);
    }
    @GetMapping("/{id}")
    public Optional<Rol> findById(@PathVariable long id){
        return rolService.findById(id);
    }
    @PostMapping
    public Rol add(@RequestBody Rol r){
        return rolService.add(r);
    }
    @PutMapping("/{id}")
    public Rol update(@PathVariable Long id, @RequestBody Rol r){
        r.setCodigo(id);
        return rolService.update(r);
    }
    @DeleteMapping("/{id}")
    public Rol delete(@PathVariable Long id){
        Rol objRol = new Rol();
        objRol.setCodigo(id);
        return rolService.delete(Rol.builder().codigo(id).build());
    }
}
