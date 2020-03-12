package com.unmsm.prueba.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unmsm.prueba.components.PostComponent;
import com.unmsm.prueba.configurations.Pages;
import com.unmsm.prueba.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	
	@Autowired
	private PostComponent _postComponent;
	
	@GetMapping(path= {"/inicio", "/"})
	public String saludar(Model model) {
		model.addAttribute("posts", _postComponent.getPost());
		return "index";
	}
	
	@GetMapping(path= {"/post"})
	public ModelAndView getPostModelAndView(
			@RequestParam( defaultValue = "1", name = "id", required = false) int id
			) {
		ModelAndView post = new ModelAndView(Pages.POST);
		
		List<Post> postFiltrado = _postComponent.getPost().stream().filter( (p) -> {
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
		List<Post> posts = _postComponent.getPost();
		posts.add(post);
		model.addAttribute("posts", posts);
		return Pages.HOME;
	}
}
