package ar.edu.unju.fi.turnosonline.turnosonline.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)    
	private Integer id;

    @Column(length = 200)
    private String nombre;
    
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="especialidad_id") 
    private Especialidad especialidad;
    
    @OneToMany(
        mappedBy = "medico",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ObraSocialMedico> obrasSociales = new ArrayList<>();

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="usuario_id")  
    private Usuario usuario;

    public void addObraSocial(ObraSocialMedico obraSocialMedico) {
        obrasSociales.add(obraSocialMedico);
        obraSocialMedico.setMedico(this);
    }
 
    public void removeObraSocial(ObraSocialMedico obraSocialMedico) {
        obrasSociales.remove(obraSocialMedico);
        obraSocialMedico.setMedico(null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ObraSocialMedico> getObrasSociales() {
        return obrasSociales;
    }

    public void setObrasSociales(List<ObraSocialMedico> obrasSociales) {
        this.obrasSociales = obrasSociales;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
