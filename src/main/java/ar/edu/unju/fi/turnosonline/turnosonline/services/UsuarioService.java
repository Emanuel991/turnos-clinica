package ar.edu.unju.fi.turnosonline.turnosonline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;
import ar.edu.unju.fi.turnosonline.turnosonline.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Usuario findUserByUsername(String username) {
	    return userRepository.findByUsername(username);
    }

    public void save(Usuario user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);

    }
}
