package ar.edu.unju.fi.turnosonline.turnosonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Especialidad;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Medico;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Paciente;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;
import ar.edu.unju.fi.turnosonline.turnosonline.repository.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private  MedicoRepository medicoRepository;
	
	public List<Medico> findAll(){
		return medicoRepository.findAll(); 
	}
	
	public Medico buscar(Usuario id) {
		return medicoRepository.findByMedico(id);
	}

	/*@Override
	public List<StateEntity> findByCountry(int id) {
		return stateRepository.findByCountry(id);
	}*/

	public List<Medico> findByEspecialidad(Especialidad especialidad2) {
		// TODO Auto-generated method stub
		return medicoRepository.findByEsp(especialidad2);
	}

	public JsonElement findAllbyEspecialidad(int especialidadId2) {
		// TODO Auto-generated method stub
		return null;
	}

}