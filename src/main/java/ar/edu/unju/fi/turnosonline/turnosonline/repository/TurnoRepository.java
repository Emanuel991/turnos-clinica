package ar.edu.unju.fi.turnosonline.turnosonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Medico;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Paciente;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Integer>{
	@Query("from Turno t where t.paciente=:paciente")
	public List<Turno> traerTurnosPaciente(@Param("paciente")Paciente paciente);
	
	@Query("from Turno t where t.medico=:medico")
	public List<Turno> traerTurnosMedico(@Param("medico")Medico medico);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Turno t set t.enabled = :estado where t.id = :id")
	public void modificarEstado(@Param("id") int id, @Param("estado") String estado);

}
