package com.unmsm.prueba.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unmsm.prueba.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	
	public List<Post> getPost(){
		ArrayList<Post> post = new ArrayList<>();
		post.add(new Post("Titulo 1", "Esta es la descripcion 1 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		post.add(new Post("Titulo 2", "Esta es la descripcion 1 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		return post;
	}
	
	@GetMapping(path= {"/post", "/"})
	public String saludar(Model model) {
		
		model.addAttribute("posts", getPost());
		return "index";
	}
}
