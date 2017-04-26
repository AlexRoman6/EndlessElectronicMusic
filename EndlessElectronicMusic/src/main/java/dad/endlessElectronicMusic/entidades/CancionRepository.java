package dad.endlessElectronicMusic.entidades;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@CacheConfig(cacheNames="index")
public interface CancionRepository extends JpaRepository<Cancion, Long> {

	@CacheEvict(allEntries=true)
	Cancion save(Cancion cancion);
	
	@Cacheable
	List<Cancion> findAllByNombreAutor(String nombre);
	
	@Cacheable
	List<Cancion> findAllByGenero(String genero);
	
	@Modifying
	@Transactional
    @Query("UPDATE Cancion c SET c.valoracion = :vote WHERE c.id = :id")
    int updateVote(@Param("vote") int vote, @Param("id") Long id);
	
			
}
