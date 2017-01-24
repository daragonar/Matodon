package pizzas.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pizzas.modelo.entidades.Pizza;

@Repository
public interface PizzaRepositorio extends CrudRepository<Pizza, Long> {

}
