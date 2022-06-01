package br.com.alura.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hellowWorld")
public class HellowWorldController {

	@GetMapping
	public String main() {
		return "Hellow World";
	}

	
}
