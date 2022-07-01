package ar.edu.unju.fi.turnosonline.turnosonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Usuario findByUsername(String userName);  

}
