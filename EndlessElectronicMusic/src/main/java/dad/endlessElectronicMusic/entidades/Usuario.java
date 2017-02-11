package dad.endlessElectronicMusic.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String usuario;
	private String email;
	private String contraseña;
	private String autentificacion;
	private boolean prioridad;
	//false prioridad baja y true prioridad alta
	
	@OneToMany(mappedBy="usuario")
	private List<ComentarioEvento> comentariosEvento = new ArrayList<>();
	
	@OneToMany(mappedBy="usuario")
	private List<ComentarioPost> comentariosPost = new ArrayList<>();
	
	protected Usuario(){};
	
	public Usuario(String usuario, String email, String contraseña, String autentificacion, boolean prioridad) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.contraseña = contraseña;
		this.autentificacion = autentificacion;
		this.prioridad = prioridad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getAutentificacion() {
		return autentificacion;
	}

	public void setAutentificacion(String autentificacion) {
		this.autentificacion = autentificacion;
	}

	public boolean isPrioridad() {
		return prioridad;
	}

	public void setPrioridad(boolean prioridad) {
		this.prioridad = prioridad;
	}

	public List<ComentarioEvento> getComentariosEvento() {
		return comentariosEvento;
	}

	public void setComentariosEvento(List<ComentarioEvento> comentariosEvento) {
		this.comentariosEvento = comentariosEvento;
	}

	public List<ComentarioPost> getComentariosPost() {
		return comentariosPost;
	}

	public void setComentariosPost(List<ComentarioPost> comentariosPost) {
		this.comentariosPost = comentariosPost;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", email=" + email + ", contraseña=" + contraseña
				+ ", autentificacion=" + autentificacion + ", prioridad=" + prioridad + ", comentarios=" + 
				comentariosEvento + ", comentarios=" + comentariosPost + "]";
	}
	
	
}
