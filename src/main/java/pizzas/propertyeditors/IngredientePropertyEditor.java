package pizzas.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pizzas.modelo.entidades.Ingredientes;
import pizzas.modelo.repositorio.IngredienteRepositorio;

@Component
public class IngredientePropertyEditor extends PropertyEditorSupport{

	@Autowired
	private IngredienteRepositorio repo;
	
	@Override
	public void setAsText(String text) 
	{
		long idIngrediente = Long.parseLong(text);
		Ingredientes ingrediente = repo.findOne(idIngrediente);
		setValue(ingrediente);
	}
}
