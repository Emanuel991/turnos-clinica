package ar.edu.unju.fi.turnosonline.turnosonline.controller;
/*import com.google.gson.Gson;*/

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;



import com.google.gson.Gson;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Especialidad;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Medico;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Paciente;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Turno;
import ar.edu.unju.fi.turnosonline.turnosonline.services.EspecialidadService;
import ar.edu.unju.fi.turnosonline.turnosonline.services.MailService;
import ar.edu.unju.fi.turnosonline.turnosonline.services.MedicoService;
import ar.edu.unju.fi.turnosonline.turnosonline.services.PacienteService;
import ar.edu.unju.fi.turnosonline.turnosonline.services.TurnoService;

@Controller
@RequestMapping(value = { "", "turno" })
public class TurnoController {
	@Autowired
	MedicoService medicoService;
	@Autowired
	TurnoService turnoService;
	@Autowired
	private MailService mailService;
	@Autowired
	private EspecialidadService especialidadService;
	
	@ResponseBody
	@RequestMapping(value = "loadMedicosByEspecialidad/{especialidad}", method = RequestMethod.GET)
	public String loadMedicosByEspecialidad(@PathVariable("especialidad") int especialidad) {

	Especialidad especialidad2 = new Especialidad();
	especialidad2=especialidadService.getBy(especialidad);
		
	Gson gson = new Gson();
	System.out.println(especialidad);
	
	   List<Medico> medico = medicoService.findByEspecialidad(especialidad2);
	   List<Medico> listMedico = new ArrayList<>();
	   for (Medico medico2 : medico) {
	    	System.out.println(medico2.getNombre());
	    	Medico m=new Medico();
	    	m.setId(medico2.getId());
	    	m.setNombre(medico2.getNombre());
	    	listMedico.add(m);

	    }
		 return gson.toJson(listMedico);
		
	}
	
	@GetMapping("/nuevo_turno")
	public String reservarTurno(Model model) {
		Turno turno = new Turno();
		List<Medico> medico = medicoService.findAll();
		List<Especialidad> especialidad =especialidadService.findAll();
		//Paciente paciente;
		model.addAttribute("turno",turno);
	    model.addAttribute("medico",medico);
		model.addAttribute("especialidad",especialidad);
		return "reservaTurno";
	}
	
	public Boolean validarTurno(Turno turno) {
		List<Turno> turnoList = turnoService.traerTurno();
		Date fecha = turno.getFecha();
		int year = fecha.getYear();
		int mes = fecha.getMonth();
		int dia = fecha.getDay();
		for(Turno t : turnoList) {
			if((t.getFecha().getYear()==year) && (t.getFecha().getMonth()==mes) && (t.getFecha().getDay()==dia)) {
				if(Time.valueOf(turno.getHoraTexto()).equals(t.getHora())) {
					if(turno.getMedico().equals(t.getMedico())) {
						//System.out.println("arranca");
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@RequestMapping("/reserva_turno")
	public String guardar(Model model, @ModelAttribute("turno") Turno turno ) {
		if(validarTurno(turno)) {
			turnoService.save(turno);
			model.addAttribute("mensaje", "El turno de Registro Correctamente");
			String correo=turno.getPaciente().geteMail();
			mailService.sendMail(correo, "Turno confirmado", turno.toString());
		}
		return "redirect:/nuevo_turno";
	}
	
	@RequestMapping("/estado/{id}")
	public String cambiarEstado(@PathVariable int id, Model model) {
		Optional<Turno> turno = turnoService.traerPorId(id);
		model.addAttribute("turno", turno);
		return "turnoEstado";
	}
	
	@RequestMapping("/guardar_estado")
	public String guardarEstado(@ModelAttribute("turno") Turno turno, Model model) {
		System.out.println("turno id y estado " + turno.getId() + " " + turno.getEnabled());
		turnoService.guardarEstado(turno.getId(), turno.getEnabled());
		model.addAttribute("mensaje", "El turno de modifico Correctamente");
		return "turnoEstado";
	}
	
	@RequestMapping("/turnos_reservados")
	public String mostrar(Model model,  @SessionAttribute("paciente") Paciente paciente) {
		List<Turno> turnos = turnoService.traerTurnosPaciente(paciente);
		model.addAttribute("turnos", turnos);
		return "turnoList";
	}
	
	@RequestMapping("/turnos_medicos")
	public String mostrarTurnosMedicos(Model model,  @SessionAttribute("medico") Medico medico) {
		List<Turno> turnos = turnoService.traerTurnosMedioc(medico);
		model.addAttribute("turnos", turnos);
		return "turnosListMedico";
	}
	
	
	@InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }

}
