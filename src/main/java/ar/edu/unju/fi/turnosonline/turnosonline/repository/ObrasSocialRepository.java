package ar.edu.unju.fi.turnosonline.turnosonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.turnosonline.turnosonline.entity.ObraSocial;

@Repository
public interface ObrasSocialRepository extends JpaRepository<ObraSocial, Integer>{

}
