
package pe.com.consultorio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.consultorio.entity.Procedimiento;

public interface ProcedimientoRepository extends JpaRepository<Procedimiento, Long>{
    @Query(value="select * from Procedimiento t where t.estado_procedimiento='1'",nativeQuery = true)
    List<Procedimiento> findAllCustom();
    
    @Query(value="select * from Procedimiento t where upper(t.nombre_procedimiento) like upper(:nombre) and t.estado_procedimiento='1'",nativeQuery = true)
    List<Procedimiento> findByName(@Param("nombre") String nombre);
 
    @Query(value="select * from Procedimiento t where t.estado_procedimiento='0'",nativeQuery = true)
    List<Procedimiento> findAllInactive();
}
