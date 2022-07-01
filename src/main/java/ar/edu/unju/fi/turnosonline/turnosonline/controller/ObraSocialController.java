package ar.edu.unju.fi.turnosonline.turnosonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.ObraSocial;
import ar.edu.unju.fi.turnosonline.turnosonline.services.ObraSocialService;

@Controller
@RequestMapping("obrasSociales")
public class ObraSocialController {
	@Autowired
	private ObraSocialService obraSocialService;
	
	@RequestMapping("/")
	public String ListarObrasSociales(Model model) {
		List<ObraSocial> obrasSociales = obraSocialService.findAll();
		model.addAttribute("obrasSociales", obrasSociales);
		return "obrasSocialesList";
	}
}
