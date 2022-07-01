package ar.edu.unju.fi.turnosonline.turnosonline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)    
	private Integer id;

    @Column(length = 20) 
	private String username;

    @Column(length = 100)
	private String password;
    
    @Transient
    private String confirmPassword;

    @Column(length = 20)
	private String role;

	private boolean enabled;	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	} 

	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		//this.enabled = true;
		//this.role = "ROLE_PACIENTE";
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
    
    
}
