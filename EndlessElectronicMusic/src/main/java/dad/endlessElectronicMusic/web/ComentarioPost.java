package dad.endlessElectronicMusic.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ComentarioPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Usuario usuario;

	private String texto;

	@ManyToOne
	private Post post;

	public ComentarioPost() {
	};

	public ComentarioPost(long id, Usuario usuario, String texto, Post post) {
		this.id = id;
		this.usuario = usuario;
		this.texto = texto;
		this.post = post;
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
	
	public Post getpost() {
		return post;
	}

	public void setpost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", usuario=" + usuario + ", texto=" + texto + ", post=" + post + "]";
	}

}

