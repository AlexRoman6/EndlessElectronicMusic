package dad.endlessElectronicMusic.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo;
	
	private String lugar;
	
	private Date fecha;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private Imagen imagen;
	
	private String texto;
	
	@OneToMany (mappedBy="evento", cascade=CascadeType.REMOVE)
	private List<ComentarioEvento> comentarios = new ArrayList<>();
	
	protected Evento() {
	}
	
	public Evento(String titulo, String lugar, Date fecha, Imagen imagen, String texto) {
		super();
		this.titulo = titulo;
		this.lugar = lugar;
		this.fecha = fecha;
		this.imagen = imagen;
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
	
	public String getLugar() {
		return titulo;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
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
	
	public List<ComentarioEvento> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioEvento> comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public String toString() {
		return "Evento [id=" + id + ", titulo=" + titulo + ", lugar=" + lugar + ", fecha=" + fecha + ", texto=" + texto + ", comentarios=" + comentarios + "]";
	}
}
