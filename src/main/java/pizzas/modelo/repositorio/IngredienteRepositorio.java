package pizzas.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pizzas.modelo.entidades.Ingredientes;

@Repository
public interface IngredienteRepositorio extends CrudRepository<Ingredientes, Long> {
	//aqui puedo añadir mis metodos personalizados
public default void mostrarAlgo()
{
	System.out.print("Hola");
}
public default void mostrarEste()
{
	System.out.print("Este");
}
}
