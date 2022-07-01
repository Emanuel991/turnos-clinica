package ar.edu.unju.fi.turnosonline.turnosonline.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Medico;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Paciente;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;
import ar.edu.unju.fi.turnosonline.turnosonline.services.MedicoService;
import ar.edu.unju.fi.turnosonline.turnosonline.services.PacienteService;
import ar.edu.unju.fi.turnosonline.turnosonline.services.SecurityService;
import ar.edu.unju.fi.turnosonline.turnosonline.services.UsuarioService;


@Controller
public class LoginController {
    
	@Autowired
	private SecurityService securityService;
	@Autowired
	private UsuarioService userService;
	@Autowired
	PacienteService pacienteService;
	@Autowired
	MedicoService medicoService;

	@RequestMapping("/") 
    public String init(Authentication auth, HttpSession session){
    	String username = auth.getName();
    	if(session.getAttribute(username)==null) {
    		Usuario usuario = userService.findUserByUsername(username);
    		Paciente paciente = pacienteService.buscar(usuario);
    		Medico medico = medicoService.buscar(usuario);
    		usuario.setPassword(null);
    		if(paciente==null) {
    			session.setAttribute("medico",medico);
    		}else {
    			session.setAttribute("paciente",paciente);
    		}
    	}
        return "index.html";
    }
	
	@GetMapping("/login")
    public String login(Model model, String error) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }
        if (error != null)
            model.addAttribute("error", "El Usuario o Password son Incorrectos");
        return "login";
    }
	
    /*
     * @RequestMapping(value="/nuevoUsuario", method = RequestMethod.GET)
    public String nuevoUsuario(Model model){
        Usuario user = new Usuario();
        model.addAttribute("user", user);
        return "registroUsuario";
    }
    
	@PostMapping(value = "/guardarUsuario")
	public String guardarUsuario(@ModelAttribute("user")Usuario user, BindingResult result, Model model) {
		userService.save(user);
		model.addAttribute("message", "El Usuario se Agrego Correctamente");
        return "registroUsuario";
	}
     */
}
