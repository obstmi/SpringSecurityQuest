package com.wildcodeschool.myProjectWithSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author micha
 */
@Controller
public class AvengersController {
	
	@GetMapping("/")
	public String hello(Model model) {
		model.addAttribute("");
		return "welcome";
	}
	
	@GetMapping("/avengers/assemble")
	public String shieldHero() {
		return "avengers";
	}
	
	@GetMapping("/secret-bases")
	public String shieldDirector() {
		return "bases";
	}

}
