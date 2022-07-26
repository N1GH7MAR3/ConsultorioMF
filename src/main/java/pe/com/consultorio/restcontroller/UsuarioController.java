
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
import pe.com.consultorio.entity.Usuario;
import pe.com.consultorio.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }
    @GetMapping("/custom")
    public List<Usuario> findAllCustom(){
        return usuarioService.findAllCustom();
    }
    @GetMapping("/inactive")
    public List<Usuario> findAllInactive(){
        return usuarioService.findAllInactive();
    }
    @GetMapping("/name/{name}")
    public List<Usuario> findByName(@PathVariable String name){
        return usuarioService.findbyName(name);
    }
    @GetMapping("/surname/{surname}")
    public List<Usuario> findBySurname(@PathVariable String surname){
        return usuarioService.findbySurname(surname);
    }
    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable long id){
        return usuarioService.findById(id);
    }
    @GetMapping("/user/{usuario}")
    public Optional<Usuario> findByUsuario(@PathVariable String usuario){
        return usuarioService.findByUsuario(usuario);
    }
    @PostMapping
    public Usuario add(@RequestBody Usuario u){
        try {
            usuarioService.add(u);
        } catch (Exception e) {
            System.out.println("Error al registrar Usuario : "+e.getMessage());
        }
        return u;
    }
    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario u){
        u.setCodigo(id);
        return usuarioService.update(u);
    }
    @DeleteMapping("/{id}")
    public Usuario delete(@PathVariable Long id){
        Usuario objUsuario = new Usuario();
        objUsuario.setCodigo(id);
        return usuarioService.delete(Usuario.builder().codigo(id).build());
    }
    
  
}
