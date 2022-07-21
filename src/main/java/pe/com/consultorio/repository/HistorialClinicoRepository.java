
package pe.com.consultorio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.consultorio.entity.HistorialClinico;

public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Long>{
    @Query(value="select * from Historial_Clinico h where h.estado_historial='1'",nativeQuery = true)
    List<HistorialClinico> findAllCustom();   
    
    @Query(value="select * from Historial_Clinico h where h.estado_historial='0'",nativeQuery = true)
    List<HistorialClinico> findAllInactive();
}
