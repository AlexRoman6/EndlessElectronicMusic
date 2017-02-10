package dad.endlessElectronicMusic.web;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;
	@ManyToOne
	private Artista artista;
	private String estilo;
	private int año;
	private Date fechaDeInclusion;
	private int valoracion;
	private String imagen;
	private String url;
	
	protected Cancion(){}

	public Cancion(String nombre, Artista artista, String estilo, int año, Date fechaDeInclusion,
			int valoracion, String imagen, String url) {
		
		
		this.nombre = nombre;
		this.artista = artista;
		this.estilo = estilo;
		this.año = año;
		this.fechaDeInclusion = fechaDeInclusion;
		this.valoracion = valoracion;
		this.imagen = imagen;
		this.url = url;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public Date getFechaDeInclusion() {
		return fechaDeInclusion;
	}

	public void setFechaDeInclusion(Date fechaDeInclusion) {
		this.fechaDeInclusion = fechaDeInclusion;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", nombre=" + nombre + ", artista=" + artista + ", estilo=" + estilo + ", año="
				+ año + ", fechaDeInclusion=" + fechaDeInclusion + ", valoracion=" + valoracion + ", imagen=" + imagen
				+ ", url=" + url + "]";
	};
	
	
}
