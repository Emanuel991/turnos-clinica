package ar.edu.unju.fi.turnosonline.turnosonline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;
import ar.edu.unju.fi.turnosonline.turnosonline.security.MyUserDetails;



public class UsuarioDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioService  userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userService.findUserByUsername(username);		
		if (user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		MyUserDetails myUserDetails = new MyUserDetails();
		myUserDetails.setUser(user);
		return	myUserDetails;
	}

}
