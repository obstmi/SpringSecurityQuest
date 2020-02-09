package com.wildcodeschool.myProjectWithSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author micha
 */
@Controller
public class AvengersController {
	
	@GetMapping("/")
	public String hello() {
		return "welcome";
	}
	
	@GetMapping("/avengers")
	public String shieldHero() {
		return "avengers";
	}
	
	@GetMapping("/bases")
	public String shieldDirector() {
		return "bases";
	}

}
