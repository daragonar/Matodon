package pizzas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pizzas.modelo.entidades.Ingredientes;
import pizzas.modelo.entidades.Pizza;
import pizzas.modelo.enumeraciones.CategoriaDePizza;
import pizzas.modelo.repositorio.IngredienteRepositorio;
import pizzas.modelo.repositorio.PizzaRepositorio;
import pizzas.propertyeditors.IngredientePropertyEditor;

@Controller
@RequestMapping("/pizza")
public class ControllerPizza {
	@Autowired
	private PizzaRepositorio repo;
	@Autowired
	private IngredienteRepositorio repoIng;
	@Autowired
	private IngredientePropertyEditor ingrePropeEdit;

	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		Iterable<Pizza> lista = repo.findAll();
		model.addAttribute("categorias", CategoriaDePizza.values());
		model.addAttribute("pizzas", lista);
		model.addAttribute("ingredientes", repoIng.findAll());
		return "pages/listadoPi";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String addPizza(Model model, @Valid @ModelAttribute Pizza pizza,BindingResult bindingResult)
	{
		repo.save(pizza);
		Iterable<Pizza> lista = repo.findAll();
		model.addAttribute("categorias", CategoriaDePizza.values());
		model.addAttribute("pizzas", lista);
		model.addAttribute("ingredientes", repoIng.findAll());
		return "pages/listadoPi";
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> borrar(Model model, @PathVariable Long id)
	{
		try {
			repo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Pizza buscarPizza(@PathVariable Long id)
	{
		Pizza piz=repo.findOne(id);
		return piz;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Ingredientes.class, ingrePropeEdit);
	}

}
