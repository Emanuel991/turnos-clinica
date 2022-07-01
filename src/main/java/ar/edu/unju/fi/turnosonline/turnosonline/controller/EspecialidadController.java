package ar.edu.unju.fi.turnosonline.turnosonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Especialidad;
import ar.edu.unju.fi.turnosonline.turnosonline.services.EspecialidadService;

@Controller
@RequestMapping("listaEspecialidades")
public class EspecialidadController {
	
	@Autowired
	EspecialidadService especialidadService;
	
	@RequestMapping("/")
	public String ListarMedicos(Model model) {
		List<Especialidad> especialidad = especialidadService.findAll();
		model.addAttribute("especialidad", especialidad);
		return "listaEspecialidades"; 
	}
}
