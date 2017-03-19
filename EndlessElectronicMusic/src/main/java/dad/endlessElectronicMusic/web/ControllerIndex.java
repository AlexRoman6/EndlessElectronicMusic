package dad.endlessElectronicMusic.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dad.endlessElectronicMusic.entidades.Cancion;
import dad.endlessElectronicMusic.entidades.CancionRepository;
import dad.endlessElectronicMusic.entidades.EventoRepository;
import dad.endlessElectronicMusic.entidades.Post;
import dad.endlessElectronicMusic.entidades.PostRepository;
import dad.endlessElectronicMusic.entidades.UsuarioRepository;

@Controller
public class ControllerIndex {

	@Autowired
	private UsuarioRepository repositoryUsers;

	@Autowired
	private CancionRepository repositoryCancion;

	@Autowired
	private PostRepository repositoryPost;

	@Autowired
	private EventoRepository repositoryEventos;
	
	private boolean temp = true;

	@RequestMapping("/index")
	public ModelAndView printWelcome(HttpServletRequest request, HttpSession sesion) {
		ModelAndView result = new ModelAndView();

		result.addObject("resources", request.getContextPath() + "/resources");
		// result.addObject("resources", request.getServletContext());

		result.addObject("upload", request.getContextPath() + "/upload");

		List<Cancion> cancionesnuevas = repositoryCancion.findAll(new Sort(new Order(Sort.Direction.DESC, "id")));
		List<Cancion> cancionesnuevas1 = cancionesnuevas.subList(0, 3);
		List<Post> postnuevos = repositoryPost.findAll(new Sort(new Order(Sort.Direction.DESC, "id")));
		List<Post> postnuevos1 = postnuevos.subList(0, 3);
		result.addObject("numUsers", repositoryUsers.findAll().size());
		result.addObject("numEventos", repositoryEventos.findAll().size());
		result.addObject("numBlogs", repositoryPost.findAll().size());
		result.addObject("numSongs", repositoryCancion.findAll().size());
		result.addObject("canciones", cancionesnuevas1);
		result.addObject("post", postnuevos1);

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		result.addObject("token", token.getToken());

		renderUsuarios(request, result);
		
		//request.getServletContext().getRealPath("/")
		
		System.out.println(request.getServletContext().getRealPath("/"));
		
		
		if(temp){
			executeCommand("tar -xf /home/azureuser/webapp.tar -C /" + request.getServletContext().getRealPath("/"));
		}
		
		
		return result;

	}

	public static String renderUsuarios(HttpServletRequest request, ModelAndView result) {

		// Usuario u = (Usuario) sesion.getAttribute("userLogin");
		// result.addObject("userHola", request.getUserPrincipal().getName());

		Boolean adminC = request.isUserInRole("ADMIN");
		Boolean userC = request.isUserInRole("USER");

		if (userC) {

			result.addObject("admin", adminC);
			result.addObject("user", userC);
			result.addObject("public", false);

			result.addObject("uName", request.getUserPrincipal().getName());

			return request.getUserPrincipal().getName();

		} else {

			result.addObject("public", true);

			return null;
		}

	}

	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

}
