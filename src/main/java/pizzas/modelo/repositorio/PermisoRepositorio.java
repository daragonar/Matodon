package pizzas.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzas.modelo.entidades.Permiso;

public interface PermisoRepositorio extends JpaRepository<Permiso, Long> {

	Permiso getOneByNombre(String string);

}
