package dad.endlessElectronicMusic.entidades;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;
	
	@ManyToOne
	private Artista autor;
	private String nombreAutor;
	private String genero;
	private int anio;
	private Date addSong;
	private int valoracion;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private Imagen imagen;
	
	private String url;
	
	protected Cancion(){}

	public Cancion(String nombre, Artista artista,String nombreAutor, String estilo, int año, Date fechaDeInclusion,
			int valoracion, Imagen imagen, String url) {
		
		
		this.nombre = nombre;
		this.autor = artista;
		this.nombreAutor= nombreAutor;
		this.genero = estilo;
		this.anio = año;
		this.addSong = fechaDeInclusion;
		this.valoracion = valoracion;
		this.imagen = imagen;
		this.url = url;
	}
	

	public Artista getAutor() {
		return autor;
	}

	public void setAutor(Artista autor) {
		this.autor = autor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Date getAddSong() {
		return addSong;
	}

	public void setAddSong(Date addSong) {
		this.addSong = addSong;
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
		return autor;
	}

	public void setArtista(Artista artista) {
		this.autor = artista;
	}

	public String getEstilo() {
		return genero;
	}

	public void setEstilo(String estilo) {
		this.genero = estilo;
	}

	public int getAño() {
		return anio;
	}

	public void setAño(int año) {
		this.anio = año;
	}

	public Date getFechaDeInclusion() {
		return addSong;
	}

	public void setFechaDeInclusion(Date fechaDeInclusion) {
		this.addSong = fechaDeInclusion;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
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
		return "Cancion [id=" + id + ", nombre=" + nombre + ", artista=" + autor + ", estilo=" + genero + ", año="
				+ anio + ", fechaDeInclusion=" + addSong + ", valoracion=" + valoracion + ", imagen=" + imagen
				+ ", url=" + url + "]";
	};
	
	
}
