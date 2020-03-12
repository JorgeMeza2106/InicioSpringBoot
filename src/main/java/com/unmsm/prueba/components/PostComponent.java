package com.unmsm.prueba.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.prueba.model.Post;

@Component("com.unmsm.prueba.components.PostComponent")
public class PostComponent {
	
	public List<Post> getPost(){
		ArrayList<Post> post = new ArrayList<>();
		post.add(new Post(1,"Titulo 1", "Esta es la descripcion 1 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		post.add(new Post(2,"Titulo 2", "Esta es la descripcion 2 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		post.add(new Post(3,"Titulo 3", "Esta es la descripcion 3 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		post.add(new Post(4,"Titulo 4", "Esta es la descripcion 4 de prueba para Springboot", "http://localhost/img/goku.jpg" ));
		return post;
	}
}
