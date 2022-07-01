package ar.edu.unju.fi.turnosonline.turnosonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Paciente;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;
 
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	@Query("select p from Paciente p where p.usuario = :value") 
	Paciente findByPacienteId(@Param("value") Usuario id);

	@Query("select p from Paciente p where p.eMail=:email")
	public Paciente findByEmail(@Param("email") String email);
	@Query("select p from Paciente p where p.dni=:dni")
	public Paciente findByDni(@Param("dni") String dni);

}
