package ar.edu.unju.fi.turnosonline.turnosonline.services;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Medico;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Paciente;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Turno;
import ar.edu.unju.fi.turnosonline.turnosonline.repository.TurnoRepository;

@Service
public class TurnoService {
	@Autowired 
	TurnoRepository turnoRepository;
	
	public List<Turno> traerTurno() { 
		return turnoRepository.findAll();
	}
	
	public List<Turno> traerTurnosPaciente(Paciente paciente){
		return turnoRepository.traerTurnosPaciente(paciente);
	}
	
	public List<Turno> traerTurnosMedioc(Medico medico){
		return turnoRepository.traerTurnosMedico(medico);
	}
	
	public Optional<Turno> traerPorId(int id){
		return turnoRepository.findById(id);
	}
	
	public void save(Turno turno) {
		//HttpSession session = null;
		Paciente paciente = turno.getPaciente();
		//turno.setFecha(new Date());
		turno.setHora(Time.valueOf(turno.getHoraTexto()));
		turno.setEnabled("INICIADO");
		turno.setPaciente(paciente);
		turno.setFechaCreacion(new Date());
		turno.setUsuarioCreacion(paciente.getUsuario().getUsername());
		turnoRepository.save(turno);
	}
	
	public void guardarEstado(int id, String estado) {
		turnoRepository.modificarEstado(id, estado);
	}

}
