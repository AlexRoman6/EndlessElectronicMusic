package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import dad.endlessElectronicMusic.entidades.Artista;
import dad.endlessElectronicMusic.entidades.ArtistaRepository;
import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.ComentarioEventoRepository;
import dad.endlessElectronicMusic.entidades.ComentarioPostRepository;
import dad.endlessElectronicMusic.entidades.Evento;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Imagen;
import dad.endlessElectronicMusic.entidades.ImagenRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;

import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.Usuario;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerAdmin {

	@Autowired
	private CancionRepository songRepo;

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private EventoRepository eventRepo;

	@Autowired
	private ArtistaRepository artistRepo;

	@Autowired
	private ComentarioEventoRepository comenEvenRepo;

	@Autowired
	private ComentarioPostRepository comenPostRepo;

	@Autowired
	private ImagenRepository imageRepo;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping("/admin")
	public String adminIndex(Model model) {
		return "redirect:/admin/tables.html";

	}

	@RequestMapping("/admin/tables")
	public ModelAndView printAdminTables(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		List<Usuario> totalusuarios = usuarioRepository.findAll();
		result.addObject("usuarios", totalusuarios);

		List<Cancion> totalcanciones = songRepo.findAll();
		result.addObject("canciones", totalcanciones);

		List<Artista> totalartistas = artistRepo.findAll();
		result.addObject("artistas", totalartistas);

		List<Evento> totaleventos = eventRepo.findAll();
		result.addObject("eventos", totaleventos);

		List<Post> totalposts = postRepo.findAll();
		result.addObject("posts", totalposts);

		return result;

	}

	@RequestMapping("/admin/addUserSong")
	public ModelAndView printAdminAddUserSong(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		List<Artista> ls = artistRepo.findAll();
		result.addObject("artistas", ls);

		return result;

	}

	@RequestMapping("/admin/gallery")
	public ModelAndView printAdminGallery(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		List<Imagen> imagenes;
		imagenes = imageRepo.findAll();

		result.addObject("imagen", imagenes);

		return result;

	}

	@RequestMapping("/admin/addPost")
	public ModelAndView printAdminAddPost(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		return result;

	}

	@PostMapping("/admin/procesarFormulario")
	public ModelAndView printProcesarForm(HttpServletRequest request, @RequestParam String type,
			@RequestParam("fileUpload") MultipartFile file) {

		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		String uploadPath = "resources/core/css/img/";
		// String uploadPath = "D:\\";

		if (type.equals("addArtista")) {
			Artista a = new Artista(request.getParameter("nomArtista"), request.getParameter("nomNacionalidad"),
					request.getParameter("nomEstilo"));
			artistRepo.save(a);
		}

		if (type.equals("addSong")) {

			System.out.println(uploadPath);

			try {

				byte[] bytes = file.getBytes();
				Path path = Paths.get(uploadPath + file.getOriginalFilename());
				Files.write(path, bytes);

			} catch (IOException e) {
				e.printStackTrace();
			}

			Imagen imagen1 = new Imagen("fotoDef.png");
			imageRepo.save(imagen1);

			Artista a = artistRepo.findOne(Long.parseLong(request.getParameter("idSong")));

			String name = request.getParameter("nomSong");
			String url = request.getParameter("url");
			String estilo = request.getParameter("estiloSong");
			int anio = Integer.parseInt(request.getParameter("anioSong"));

			Cancion c = new Cancion(name, a, a.getNombre(), estilo, anio, new Date(), 0, imagen1, url);

			songRepo.save(c);

		}

		return result;

	}
	
	@RequestMapping("/admin/eliminarContenido")
	public ModelAndView printDelContent(HttpServletRequest request, @RequestParam String type, @RequestParam Long id) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		if(type.equals("img")){
			imageRepo.delete(id);
		}

		return result;

	}


}
