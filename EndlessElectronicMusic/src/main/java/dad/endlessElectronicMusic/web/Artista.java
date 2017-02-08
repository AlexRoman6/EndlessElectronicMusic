package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String nombre;
    private String nacionalidad;
    private String estilo;
    
    @OneToMany
    private List<Cancion> cancion;
    
    public Artista (){};
    
    public Artista(long id, String nombre, String nacionalidad, String estilo,List<Cancion>cancion) {
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.estilo = estilo;
		this.cancion=cancion;
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

	public List<Cancion> getCancion() {
		return cancion;
	}

	public void setCancion(List<Cancion> cancion) {
		this.cancion = cancion;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", estilo=" + estilo
				+ ", cancion=" + cancion + "]";
	}

    
 
}
