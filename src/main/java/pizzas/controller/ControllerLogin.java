package pizzas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pizzas.modelo.entidades.Permiso;
import pizzas.modelo.entidades.Usuario;
import pizzas.modelo.repositorio.PermisoRepositorio;
import pizzas.modelo.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping("/login")
public class ControllerLogin {
@Autowired private UsuarioRepositorio usrep;
@Autowired private PermisoRepositorio prep;
	
	@RequestMapping(method = RequestMethod.GET)
	public String contacto(Model model) {
		
		Usuario user = new Usuario();
		user.setUsername("user");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode("user"));
		
		Permiso per = prep.getOneByNombre("ADMIN");
		
		user.addPermiso(per);
		
		usrep.save(user);
		System.out.println(user.getPassword());
		
		
		return "pages/login";
	}
}
