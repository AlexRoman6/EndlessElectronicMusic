package dad.endlessElectronicMusic.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo;
	
	private Date fecha;
	
	private String texto;
	
	@OneToMany
	private List<Comentario> comentarios = new ArrayList<>();
	
	protected Post() {
	}
	
	public Post(String titulo, Date fecha, String texto) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.texto = texto;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", texto=" + texto + "]";
	}
}
