package dad.endlessElectronicMusic.entidades;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {

	List<Cancion> findAllByNombreAutor(String nombre);
	List<Cancion> findAllByGenero(String genero);
	
	
			
}
