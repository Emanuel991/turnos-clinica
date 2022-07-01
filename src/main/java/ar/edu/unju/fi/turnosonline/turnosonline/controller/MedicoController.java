package ar.edu.unju.fi.turnosonline.turnosonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Medico;
import ar.edu.unju.fi.turnosonline.turnosonline.services.MedicoService;

@Controller
@RequestMapping("listaMedicos")
public class MedicoController {
	@Autowired
	private MedicoService medicoService;
	
	@RequestMapping("/")
	public String ListarMedicos(Model model) {
		List<Medico> medicos = medicoService.findAll();
		model.addAttribute("medicos", medicos);
		return "medicosList"; 
	}
}