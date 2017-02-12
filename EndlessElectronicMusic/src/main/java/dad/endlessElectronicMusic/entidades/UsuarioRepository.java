package dad.endlessElectronicMusic.entidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Modifying
	@Query("UPDATE Usuario u SET u.contraseña = ?1 where u.id = ?2")
	void setPassUserByID(String pass, long id);
}
