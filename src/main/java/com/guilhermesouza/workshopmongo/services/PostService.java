package com.guilhermesouza.workshopmongo.services;

import com.guilhermesouza.workshopmongo.domain.Post;
import com.guilhermesouza.workshopmongo.domain.User;
import com.guilhermesouza.workshopmongo.repository.PostRepository;
import com.guilhermesouza.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        Optional<Post> OptionalPost = postRepository.findById(id);
        return OptionalPost.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
