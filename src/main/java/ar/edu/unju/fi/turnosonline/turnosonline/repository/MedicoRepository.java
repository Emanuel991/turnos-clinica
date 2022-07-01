package ar.edu.unju.fi.turnosonline.turnosonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Especialidad;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Medico;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{

	@Query("from Medico m where m.especialidad=?1")
	public List<Medico> findByEsp(Especialidad especialidad);
	
	@Query("from Medico t where t.usuario = :medico")
	public Medico findByMedico(@Param("medico") Usuario id);
}
