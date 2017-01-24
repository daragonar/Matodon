package pizzas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pizzas.modelo.entidades.Ingredientes;
import pizzas.modelo.enumeraciones.IngredienteCategoria;
import pizzas.modelo.repositorio.IngredienteRepositorio;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {
	@Autowired
	private IngredienteRepositorio repo;

	@RequestMapping(method = RequestMethod.GET)
	public String contacto(Model model) {
		Iterable<Ingredientes> lista= repo.findAll();
		model.addAttribute("categorias", IngredienteCategoria.values());
		model.addAttribute("ingredientes", lista);
		return "pages/listadoIng";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addIngre(Model model,@Valid @ModelAttribute Ingredientes ingrediente, BindingResult binres )
	{
		repo.save(ingrediente);
		Iterable<Ingredientes> lista= repo.findAll();
		model.addAttribute("categorias", IngredienteCategoria.values());
		model.addAttribute("ingredientes", lista);
		return "pages/listadoIng";
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> borrar(Model model,@PathVariable Long id){
		try {
			repo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Ingredientes buscarIngrediente(@PathVariable Long id){
		Ingredientes ingrediente = repo.findOne(id);
		return ingrediente;
	}
	
}
