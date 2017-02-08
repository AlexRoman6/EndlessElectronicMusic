package dad.endlessElectronicMusic.web;
import java.awt.Image;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;
	private String artista;
	private String genero;
	private int año;
	private Date fechaDeInclusion;
	private int valoracion;
	private Image imagen;
	private String url;
	
	public Cancion(){}

	public Cancion(long id, String nombre, String artista, String genero, int año, Date fechaDeInclusion,
			int valoracion, Image imagen, String url) {
		
		this.id = id;
		this.nombre = nombre;
		this.artista = artista;
		this.genero = genero;
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

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
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
		return "Cancion [id=" + id + ", nombre=" + nombre + ", artista=" + artista + ", genero=" + genero + ", año="
				+ año + ", fechaDeInclusion=" + fechaDeInclusion + ", valoracion=" + valoracion + ", imagen=" + imagen
				+ ", url=" + url + "]";
	};
	
	
}
