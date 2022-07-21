
package pe.com.consultorio.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.consultorio.entity.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long>{
        
    @Query(value="select * from Cita c where c.estado_cita='1'",nativeQuery = true)
    List<Cita> findAllCustom();
    
    @Query(value="select * from Cita c where c.fecha_cita like :fecha and c.estado_cita='1'",nativeQuery = true)
    List<Cita> findByDate(@Param("fecha") Date fecha);
    
    @Query(value="select * from Cita c where c.estado_cita='0'",nativeQuery = true)
    List<Cita> findAllInactive();
}
