package dad.endlessElectronicMusic.web;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String nombre;
    private String nacionalidad;
    private String estilo;
    
    public Artista (){};
    
    public Artista(long id, String nombre, String nacionalidad, String estilo) {
		this.id = id;
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

    
 
}
