package com.jb.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jb.dojoninjas.models.Dojo;
import com.jb.dojoninjas.models.Ninja;
import com.jb.dojoninjas.services.DNService;

@Controller
public class DNController {
	private final DNService dNService;
	public DNController(DNService dNService) {
		this.dNService = dNService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		List<Dojo> dojos = dNService.allDojos();
		model.addAttribute("dojos", dojos);
		return "home.jsp";
	}
	
	@RequestMapping("/dojo/new")
	public String newDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "newDojo.jsp";
	}
	
	@RequestMapping("/ninja/new")
	public String newNinja(Model model) {
		List<Dojo> dojos = dNService.allDojos();
		model.addAttribute("dojoList", dojos);
		model.addAttribute("ninja", new Ninja());
		return "newNinja.jsp";
	}
	
	@RequestMapping(value="/dojo/new", method=RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo.jsp";
        }
        else {
            dNService.createDojo(dojo);
            return "redirect:/home";
        }
    }
	
	@RequestMapping(value="/ninja/new", method=RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "newNinja.jsp";
        }
        else {
            dNService.createNinja(ninja);
            return "redirect:/home";
        }
    }
	
	@RequestMapping("/dojo/{id}")
	public String showDojo(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dNService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojo.jsp";
	}
}
