package ar.edu.unju.fi.turnosonline.turnosonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Paciente;
import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;
import ar.edu.unju.fi.turnosonline.turnosonline.repository.PacienteRepository;
import ar.edu.unju.fi.turnosonline.turnosonline.repository.UsuarioRepository;

@Service 
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private UsuarioRepository usuarioRepo; 
	@Autowired  
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Usuario findUserByUsername(String username) {
	    return usuarioRepo.findByUsername(username);
    }
	
	/*
	 * Este metodo obtiene el user y password ingresados en el formulario y los almacena en 
	 * un onjeto Usuario, luego guarda tanto el Paciente como el Usuario  
	 */
	public void save(Paciente paciente) {
		String password = paciente.getUsuario().getPassword();
		String username = paciente.getUsuario().getUsername();
		Usuario user = new Usuario(username,bCryptPasswordEncoder.encode(password));
		user.setEnabled(true);
		user.setRole("ROLE_PACIENTE");
		paciente.setEnabled(true);
		paciente.setUsuario(user);
		usuarioRepo.save(user);
        pacienteRepository.save(paciente);
    }
	 
	public Paciente buscar(Usuario id) {
		return pacienteRepository.findByPacienteId(id);
	}
	
	public Paciente buscarPorEmail(String email){
		return pacienteRepository.findByEmail(email);
	}
	
	public Paciente buscarPorDni(String dni) {
		return pacienteRepository.findByDni(dni);
	}

}
