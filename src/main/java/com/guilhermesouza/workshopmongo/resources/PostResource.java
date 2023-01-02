package com.guilhermesouza.workshopmongo.resources;

import com.guilhermesouza.workshopmongo.domain.Post;
import com.guilhermesouza.workshopmongo.resources.util.URL;
import com.guilhermesouza.workshopmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(
            @RequestParam(value = "search", defaultValue = "") String text
    ) {
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}

