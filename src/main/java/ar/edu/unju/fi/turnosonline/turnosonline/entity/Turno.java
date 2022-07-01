package ar.edu.unju.fi.turnosonline.turnosonline.entity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Turno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)    
	private Integer id;   

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false)
    private Date fecha;     
    
    private Time hora;
    
    @Transient
    private String horaTexto;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="paciente_id") 
    private Paciente paciente;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="medico_id") 
    private Medico medico;

    private String enabled;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false)    
    private Date fechaCreacion;

    @Column(length = 20)
    private String usuarioCreacion;
    
    
    public String getFechaFormat1() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
		return sdf.format(fecha);
	}
    public String getFechaFormat2() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
		return sdf.format(fechaCreacion);
	}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

	public String getHoraTexto() {
		return horaTexto;
	}

	public void setHoraTexto(String horaTexto) {
		this.horaTexto = horaTexto;
	}

	@Override
	public String toString() {
		return "Clinica San Pedro \n"
				+ "Turno solicitado para el dia: " + this.getFechaFormat1() + ", a hs:" + hora + "\n Paciente: "
				+ paciente.getNombre() + "\n Medico: " + medico.getNombre() +", especialista en " + medico.getEspecialidad().getNombre()+ "\n Usted registro el turno el dia: " + this.getFechaFormat2()
				+ ", con el nombre de usuario: " + usuarioCreacion + ".";
	}
	
    
    
}
