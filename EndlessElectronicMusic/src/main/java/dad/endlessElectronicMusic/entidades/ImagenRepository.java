package dad.endlessElectronicMusic.entidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Imagen c SET c.url = :url WHERE c.id = :id")
    int updateImg(@Param("url") String url, @Param("id") Long id);

}
