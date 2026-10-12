package controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import repos.Ingredient;
import repos.Ingredient.Type;
import repos.Taco;
import repos.TacoOrder;
import repos.clientInfoRepo;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
					new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
					new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
					new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
					new Ingredient("CARN", "Carnitas", Type.PROTEIN),
					new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
					new Ingredient("LETC", "Lettuce", Type.VEGGIES),
					new Ingredient("CHED", "Cheddar", Type.CHEESE),
					new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
					new Ingredient("SLSA", "Salsa", Type.SAUCE),
					new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
				);
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
				model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
		}
	 }

	/*
	@ModelAttribute
	public void fillData(Model model) {
		List<clientInfoRepo> aastclients = Arrays.asList(
				new clientInfoRepo("Ahmed M. ElSayed","compiler@aast.edu","Iqbla, loran"),
				new clientInfoRepo("Khalid Ahmed ElSayed","khalid.elsayed@student.aast.edu","Iqbla, loran"),
				new clientInfoRepo("Shahd Ahmed ElSayed","shahd.ahmed@aast.edu","AlBostan, 6 oct"),
				new clientInfoRepo("Nihad Nagy ElHadidy","nihad@aast.edu","Iqbla, loran"),
				new clientInfoRepo("Mohamed Ayman AbdElAal","m.ayman.abdelaal@aast.edu","AlBostan, 6 oct")			
				);			
		 
		model.addAttribute("aastClients",aastclients);
	}
	*/
	
	 @ModelAttribute(name = "tacoOrder")
	 public TacoOrder order() {
		 return new TacoOrder();
	 }

	 @ModelAttribute(name = "taco")
	 public Taco taco() {
		 return new Taco();
	 }
	 
	 
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	@PostMapping
	public String processTaco()
	
	
	private Iterable<Ingredient> filterByType(
			 List<Ingredient> ingredients, Type type) {
			 return ingredients
			 .stream()
			 .filter(x -> x.getType().equals(type))
			 .collect(Collectors.toList());
			 }
	
	
}

