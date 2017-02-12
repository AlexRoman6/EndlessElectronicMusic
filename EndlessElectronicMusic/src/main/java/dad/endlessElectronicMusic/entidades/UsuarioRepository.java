package dad.endlessElectronicMusic.entidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Modifying
	@Transactional
    @Query("UPDATE Usuario u SET u.contraseña = :pass WHERE u.id = :id")
    int updatePass(@Param("pass") String pass, @Param("id") Long ip);
}
