/**
 * 
 */
package com.wildcodeschool.myProjectWithSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author micha
 *
 */
@RestController
public class HelloWorldController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello World!!!";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Hallo Admin!!!";
	}

}
