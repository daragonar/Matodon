package pizzas.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzas.modelo.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Usuario findOneByUsername(String username);

}
