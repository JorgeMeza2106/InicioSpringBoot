package com.unmsm.prueba.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.prueba.components.PostComponent;
import com.unmsm.prueba.model.Post;
import com.unmsm.prueba.services.interf.PostService;

@Service("postService1")
public class PostServiceImpl implements PostService {

	@Override
	public List<Post> validationId(List<Post> posts) {
		for(Post post : posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("No se puede tener post con id 0");
			}
		}
		return posts;
	}

}
