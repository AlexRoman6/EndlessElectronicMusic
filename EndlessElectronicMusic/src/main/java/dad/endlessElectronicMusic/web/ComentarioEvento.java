package dad.endlessElectronicMusic.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ComentarioEvento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Usuario usuario;

	private String texto;
	
	@ManyToOne
	private Evento evento;

	public ComentarioEvento() {
	};

	public ComentarioEvento(long id, Usuario usuario, String texto, Evento evento) {
		this.id = id;
		this.usuario = usuario;
		this.texto = texto;
		this.evento = evento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Evento getevento() {
		return evento;
	}

	public void setevento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", usuario=" + usuario + ", texto=" + texto + ", evento=" + evento + "]";
	}

}
