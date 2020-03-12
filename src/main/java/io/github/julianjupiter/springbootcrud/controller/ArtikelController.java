package io.github.julianjupiter.springbootcrud.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.julianjupiter.springbootcrud.domain.Artikel;
import io.github.julianjupiter.springbootcrud.service.ArtikelService;


@Controller
@RequestMapping("/artikels")
public class ArtikelController {
	
	private ArtikelService artikelService;
	
	@Autowired
	public void setArtikelService(ArtikelService artikelService) {
		this.artikelService = artikelService;
	}
	
	@RequestMapping(value = { "", "/" })
	public String index(Model model) {
		model.addAttribute("activePage","artikels");
		model.addAttribute("artikels",this.artikelService.getAllArtikel());
		return "artikels/index";
	}
	
	
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String addArtikelForm(Artikel artikel,Model model) {
		model.addAttribute("activePage","artikels");
		return "artikels/add";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String addArtikel(@Valid Artikel artikel,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("activePage","artikels");
			return "artikels/add";
		}
		this.artikelService.saveArtikel(artikel);
		return "redirect:/artikels";
		
	}
	
	@RequestMapping(value = "/view{id}")
	public String viewArtikel(@PathVariable Integer id, Model model) {
		model.addAttribute("artikels",this.artikelService.getArtikelById(id));
		model.addAttribute("activePage","artikels");
		return "artikels/view";
	}
	
	@RequestMapping(value ="/edit{id}")
	public String editArtikel(@PathVariable Integer id,Model model) {
		model.addAttribute("artikels",this.artikelService.getArtikelById(id));
		model.addAttribute("activePage","artikels");
		return "artikels/edit";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateArtikel(Artikel artikel) {
		System.out.println("Artikel ID :" + artikel.getId());
		this.artikelService.saveArtikel(artikel);
		return "redirect:/artikels/view/" + artikel.getId();
	}
	
	@RequestMapping(value ="/delete{id}",method = RequestMethod.GET)
	public String deleteArtikel(@PathVariable Integer id) {
		this.artikelService.deleteArtikel(id);
		return "redirect:/artikels";
	}

}
