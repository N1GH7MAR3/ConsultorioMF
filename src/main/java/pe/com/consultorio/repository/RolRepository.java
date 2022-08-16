
package pe.com.consultorio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.consultorio.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{
    @Query(value="select * from Rol r where r.estado_rol='1'",nativeQuery = true)
    List<Rol> findAllCustom();
    
    @Query(value="select * from Rol r where upper(r.nombre_rol)like upper(CONCAT('%',:nombre,'%')) and r.estado_rol='1'",nativeQuery = true)
    List<Rol> findByName(@Param("nombre") String nombre);
    
    @Query(value="select * from Rol r where r.estado_rol='0'",nativeQuery = true)
    List<Rol> findAllInactive();
}
