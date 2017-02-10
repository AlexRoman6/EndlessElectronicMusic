package dad.endlessElectronicMusic.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String nombre;
    private String nacionalidad;
    private String estilo;
    
    @OneToMany (mappedBy="artista")
    private List<Cancion> canciones = new ArrayList<>();
    
    protected Artista (){};
    
    public Artista(String nombre, String nacionalidad, String estilo) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.estilo = estilo;
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
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String getEstilo() {
		return estilo;
	}
	
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", estilo=" + estilo
				+ ", canciones=" + canciones + "]";
	}

    
 
}
