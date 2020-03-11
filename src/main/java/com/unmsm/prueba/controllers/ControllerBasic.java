package com.unmsm.prueba.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unmsm.prueba.configurations.Pages;
import com.unmsm.prueba.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	
	public List<Post> getPost(){
		ArrayList<Post> post = new ArrayList<>();
		post.add(new Post(1,"Titulo 1", "Esta es la descripcion 1 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		post.add(new Post(2,"Titulo 2", "Esta es la descripcion 2 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		post.add(new Post(3,"Titulo 3", "Esta es la descripcion 3 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		post.add(new Post(4,"Titulo 4", "Esta es la descripcion 4 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		return post;
	}
	
	@GetMapping(path= {"/inicio", "/"})
	public String saludar(Model model) {
		model.addAttribute("posts", getPost());
		return "index";
	}
	
	@GetMapping(path= {"/post"})
	public ModelAndView getPostModelAndView(
			@RequestParam( defaultValue = "1", name = "id", required = false) int id
			) {
		ModelAndView post = new ModelAndView(Pages.POST);
		
		List<Post> postFiltrado = this.getPost().stream().filter( (p) -> {
			return p.getId() == id;
		}).collect(Collectors.toList());
		
		post.addObject("posts", postFiltrado.get(0));
		return post;
	}
	
	@GetMapping(path = {"/form1"})
	public ModelAndView getForm() {
		ModelAndView post = new ModelAndView(Pages.FORM1);
		post.addObject("post", new Post());
		return post;
	}
	
	@PostMapping("/form1/newPost")
	public String addNewPost(Post post, Model model) {
		List<Post> posts = this.getPost();
		posts.add(post);
		model.addAttribute("posts", posts);
		return Pages.HOME;
	}
}
