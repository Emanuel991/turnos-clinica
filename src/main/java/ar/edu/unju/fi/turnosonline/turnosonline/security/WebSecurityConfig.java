package ar.edu.unju.fi.turnosonline.turnosonline.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import ar.edu.unju.fi.turnosonline.turnosonline.services.UsuarioDetailsServiceImpl;
import ar.edu.unju.fi.turnosonline.turnosonline.services.UsuarioService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UsuarioDetailsServiceImpl();
	}
	
	@Bean
	public UsuarioService userService() {
		return new UsuarioService();
	}
	
	@Bean
	public String username() {
		return new String();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**", "/js/**").permitAll()
		.antMatchers("/nuevoUsuario").permitAll()
        .antMatchers("/guardarUsuario").permitAll()
        .antMatchers("/turnos_medicos").hasRole("MEDICO")
        .antMatchers("/turnos_reservados").hasRole("PACIENTE")
        .antMatchers("/nuevo_turno").hasRole("PACIENTE")
        .antMatchers("/guardar_turno").hasRole("PACIENTE")
        .antMatchers("/obrasSociales/").hasRole("ADMIN")
        .antMatchers("/listaMedicos/").hasRole("ADMIN")
        .antMatchers("/listaEspecialidades/").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")           	
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/403");
   		http.headers().frameOptions().sameOrigin();;
	}

}
