package dad.endlessElectronicMusic.entidades;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CancionRepository extends JpaRepository<Cancion, Long> {

	List<Cancion> findAllByNombreAutor(String nombre);
	List<Cancion> findAllByGenero(String genero);
	
	@Modifying
	@Transactional
    @Query("UPDATE Cancion c SET c.valoracion = :vote WHERE c.id = :id")
    int updateVote(@Param("vote") int vote, @Param("id") Long id);
	
			
}
