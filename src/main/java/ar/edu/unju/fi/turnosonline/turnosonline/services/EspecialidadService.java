package ar.edu.unju.fi.turnosonline.turnosonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Especialidad;
import ar.edu.unju.fi.turnosonline.turnosonline.repository.EspecialidadRepository;
@Service
public class EspecialidadService {

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	public List<Especialidad> findAll(){
		return especialidadRepository.findAll(); 
	}

	public Especialidad getBy(int especialidadId) {
		// TODO Auto-generated method stub
		return especialidadRepository.getById(especialidadId);
	}
}
