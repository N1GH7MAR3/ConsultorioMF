
package pe.com.consultorio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.consultorio.entity.Tratamiento;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long>{
    @Query(value="select * from Tratamiento t where t.estado_tratamiento='1'",nativeQuery = true)
    List<Tratamiento> findAllCustom();
    
    @Query(value="select * from Tratamiento t where upper(t.nombre_tratamiento) like upper(:nombre) and t.estado_tratamiento='1'",nativeQuery = true)
    List<Tratamiento> findByName(@Param("nombre") String nombre);
 
    @Query(value="select * from Tratamiento t where t.estado_tratamiento='0'",nativeQuery = true)
    List<Tratamiento> findAllInactive();
}
