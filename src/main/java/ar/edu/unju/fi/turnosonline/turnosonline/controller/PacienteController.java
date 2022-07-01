package ar.edu.unju.fi.turnosonline.turnosonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.ObraSocial;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Paciente;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;
import ar.edu.unju.fi.turnosonline.turnosonline.services.ObraSocialService;
import ar.edu.unju.fi.turnosonline.turnosonline.services.PacienteService;
 
@Controller
public class PacienteController {
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private ObraSocialService obraSocialService; 
	
	@RequestMapping(value="/nuevoUsuario", method = RequestMethod.GET)
    public String nuevoUsuario(Model model){
        Paciente paciente = new Paciente();
        List<ObraSocial> obraSocial = obraSocialService.findAll();
        model.addAttribute("paciente", paciente);
        model.addAttribute("obraSocial", obraSocial);
        return "AltaPaciente";
    }
	
	@PostMapping(value = "/guardarUsuario")
	public String guardarUsuario(@ModelAttribute("paciente")Paciente paciente, BindingResult result, Model model, RedirectAttributes message) {
		String mensaje = "";
		if(validarPassword(paciente) && validarUsername(paciente) && validarDni(paciente)) {
			pacienteService.save(paciente);
			message.addFlashAttribute("success", "Se agregó al paciente");
		}else {
			message.addFlashAttribute("success", "No se pudo agregar al paciente, ingrese correctamente los datos");
		}
		
        return "redirect:/nuevoUsuario";
	}
	
	/*
	 * Este metodo valida si el usuario existe en la bd
	 */
	public Boolean validarPassword(Paciente paciente) {
		String confirmPass = paciente.getUsuario().getConfirmPassword();
		String pass = paciente.getUsuario().getPassword();
		if(confirmPass.equals(pass)) {
			return true;
		}
		return false;
	}
	
	public Boolean validarUsername(Paciente paciente) {
		Paciente pacienteMail = pacienteService.buscarPorEmail(paciente.geteMail());
		Usuario usuario = pacienteService.findUserByUsername(paciente.getUsuario().getUsername());
		if(pacienteMail==null && usuario==null) {
			return true;
		}
		return false;
	}
	
	public Boolean validarDni(Paciente paciente) {
		Paciente pacienteDni = pacienteService.buscarPorDni(paciente.getDni());
		if(pacienteDni==null) {
			return true;
		}
		return false;
	}

}
