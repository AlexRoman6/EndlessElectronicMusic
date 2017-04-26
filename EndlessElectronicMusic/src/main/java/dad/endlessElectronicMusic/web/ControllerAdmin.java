package dad.endlessElectronicMusic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import dad.endlessElectronicMusic.entidades.Artista;
import dad.endlessElectronicMusic.entidades.ArtistaRepository;
import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.Evento;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Imagen;
import dad.endlessElectronicMusic.entidades.ImagenRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;

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
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());   	
		
		result.addObject("userName", ControllerIndex.renderUsuarios(request, result));
		if(ControllerIndex.temp){
			ControllerIndex.executeCommand("tar -xf /home/azureuser/webapp.tar -C /" + request.getServletContext().getRealPath("/"));
		}
		
		return result;

	}

	@RequestMapping("/admin/addUserSong")
	public ModelAndView printAdminAddUserSong(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		List<Artista> ls = artistRepo.findAll();
		result.addObject("artistas", ls);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());
		
		result.addObject("userName", ControllerIndex.renderUsuarios(request, result));
		if(ControllerIndex.temp){
			ControllerIndex.executeCommand("tar -xf /home/azureuser/webapp.tar -C /" + request.getServletContext().getRealPath("/"));
		}
		
		return result;

	}

	@RequestMapping("/admin/gallery")
	public ModelAndView printAdminGallery(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		result.addObject("upload", request.getContextPath() + "/upload");

		List<Imagen> imagenes;
		imagenes = imageRepo.findAll();

		result.addObject("imagen", imagenes);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());
		
		result.addObject("userName", ControllerIndex.renderUsuarios(request, result));
		if(ControllerIndex.temp){
			ControllerIndex.executeCommand("tar -xf /home/azureuser/webapp.tar -C /" + request.getServletContext().getRealPath("/"));
		}

		return result;

	}

	@RequestMapping("/admin/addPost")
	public ModelAndView printAdminAddPost(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); 
		result.addObject("token", token.getToken());
		
		result.addObject("userName", ControllerIndex.renderUsuarios(request, result));
		if(ControllerIndex.temp){
			ControllerIndex.executeCommand("tar -xf /home/azureuser/webapp.tar -C /" + request.getServletContext().getRealPath("/"));
		}

		return result;

	}

	@PostMapping("/admin/procesarFormulario")
	public ModelAndView printProcesarForm(HttpServletRequest request, @RequestParam String type,
			@RequestParam("fileUpload") MultipartFile file) {

		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");
		result.addObject("upload", request.getContextPath() + "/upload");

		String realPathtoUploads = request.getServletContext().getRealPath("/upload/");
		
		if (!new File(realPathtoUploads).exists()) {
			new File(realPathtoUploads).mkdir();
		}

		if (type.equals("addArtista")) {
			Artista a = new Artista(request.getParameter("nomArtista"), request.getParameter("nomNacionalidad"),
					request.getParameter("nomEstilo"));
			artistRepo.save(a);
		}

		if (type.equals("addSong")) {

			String orgName = file.getOriginalFilename();

			try {

				String filePath = realPathtoUploads + orgName;
				File dest = new File(filePath);
				file.transferTo(dest);

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Imagen imagen1 = new Imagen(orgName);
			imageRepo.save(imagen1);

			Artista a = artistRepo.findOne(Long.parseLong(request.getParameter("idSong")));

			String name = request.getParameter("nomSong");
			String url = request.getParameter("url");
			String estilo = request.getParameter("estiloSong");
			int anio = Integer.parseInt(request.getParameter("anioSong"));

			Cancion c = new Cancion(name, a, a.getNombre(), estilo, anio, new Date(), 0, imagen1, url);

			songRepo.save(c);

		}
		
		if (type.equals("addPost")) {

			String orgName = file.getOriginalFilename();

			try {

				String filePath = realPathtoUploads + orgName;
				File dest = new File(filePath);
				file.transferTo(dest);

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Imagen imagen1 = new Imagen(orgName);
			imageRepo.save(imagen1);

			String titulo = request.getParameter("titulo");
			Date date = new Date();
			String texto = request.getParameter("texto");
			
			Post p = new Post(titulo, date, imagen1, texto);

			postRepo.save(p);

		}
		
		if (type.equals("addEvento")) {

			String orgName = file.getOriginalFilename();

			try {

				String filePath = realPathtoUploads + orgName;
				File dest = new File(filePath);
				file.transferTo(dest);

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Imagen imagen1 = new Imagen(orgName);
			imageRepo.save(imagen1);

			String titulo = request.getParameter("titulo");
			String lugar = request.getParameter("lugar");
			Date date = new Date();
			String texto = request.getParameter("texto");
			
			Evento e = new Evento(titulo, lugar, date, imagen1, texto);
			
			eventRepo.save(e);
		}
		
		

		return result;

	}

	@RequestMapping("/admin/eliminarContenido")
	public ModelAndView printDelContent(HttpServletRequest request, @RequestParam String type, @RequestParam Long id) {
		ModelAndView result = new ModelAndView();
		result.addObject("resources", request.getContextPath() + "/resources");

		if (type.equals("img")) {
			
			eliminarContenidoFisico(imageRepo.findOne(id).getUrl(), request);
			
			imageRepo.updateImg("NoImg.jpg", id);

		}
		if (type.equals("usuario")) {
			usuarioRepository.delete(id);
		}
		if (type.equals("cancion")) {
			songRepo.delete(id);
		}
		if (type.equals("artista")) {
			artistRepo.delete(id);
		}
		if (type.equals("evento")) {
			eventRepo.delete(id);
		}
		if (type.equals("post")) {
			postRepo.delete(id);
		}
		return result;

	}

	public static void eliminarContenidoFisico(String name, HttpServletRequest request) {

		String realPathtoUploads = request.getServletContext().getRealPath("/upload/");
		String filePath = realPathtoUploads + name;

		new File(filePath).delete();

	}

}
