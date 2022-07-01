package ar.edu.unju.fi.turnosonline.turnosonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.ObraSocial;
import ar.edu.unju.fi.turnosonline.turnosonline.repository.ObrasSocialRepository;

@Service
public class ObraSocialService {
	@Autowired
	private  ObrasSocialRepository obrasSocialRepository;
	
	public List<ObraSocial> findAll(){
		return obrasSocialRepository.findAll();
	}
	
}
