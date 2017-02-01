package pizzas.modelo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pizzas.modelo.repositorio.UsuarioRepositorio;

@Service
public class ServicioAutenticacacion implements UserDetailsService {

	@Autowired private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepositorio.findOneByUsername(username);
	}

	
	
}
