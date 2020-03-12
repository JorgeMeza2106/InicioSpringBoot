package com.unmsm.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unmsm.prueba.components.PostComponent;
import com.unmsm.prueba.services.interf.PostService;

@SpringBootApplication
public class PruebaSpringBootApplication implements CommandLineRunner{

	@Autowired
	@Qualifier("com.unmsm.prueba.components.PostComponent")
	private PostComponent postComponent;
	
	@Autowired
	@Qualifier("postService1")
	private PostService postService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postService.validationId(postComponent.getPost()).forEach(p -> {
			System.out.println(p.getTitulo());
		});;
	}

}
