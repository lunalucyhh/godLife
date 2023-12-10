package com.jj.godLife.controller;

import com.jj.godLife.controller.request.CreatePostRequest;
import com.jj.godLife.controller.request.UpdatePostRequest;
import com.jj.godLife.domain.Post;
import com.jj.godLife.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/{post_no}")
    public ResponseEntity<Post> getDetail(@PathVariable("post_no") Long postNo, @RequestParam(name = "board_no", required = false) Long boardNo)
    {   
        System.out.println("postNo = " + postNo);
        System.out.println("boardNo = " + boardNo);
        Post readDetail = postService.readDetail(postNo, boardNo);
        return ResponseEntity.ok().body(readDetail);
    }

    @GetMapping("/title")
    public ResponseEntity<Post> getTitle(@RequestParam(name = "board_no", required = false) Long boardNo,
                                           @RequestParam(name = "limit", required = false) Integer limit,
                                           @RequestParam(name = "offset", required = false) Integer offset,
                                           @RequestParam(name = "sort", required = false) String sort){

        System.out.println("boardNo = " + boardNo);
        System.out.println("limit = " + limit);
        System.out.println("offset = " + offset);
        System.out.println("sort = " + sort);
        Post readTitle = postService.readTitle(boardNo, limit, offset, sort);
        return ResponseEntity.ok().body(readTitle);
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody CreatePostRequest request){
        System.out.println("request = " + request);
        Post createPost = postService.create(request);        
        return ResponseEntity.ok().body(createPost);
    }

    @PutMapping("/{post_no}")
    public ResponseEntity<Post> update(@PathVariable("post_no") Long postNo,
                                         @RequestBody UpdatePostRequest request){
        System.out.println("request = " + request);
        Post updatePost = postService.update(postNo, request);
        return ResponseEntity.ok().body(updatePost);
    }

    @DeleteMapping("/{post_no}")
    public ResponseEntity<Void> delete(@PathVariable("post_no") Long postNo){
        System.out.println("postNo = " + postNo);
        postService.delete(postNo);
        return ResponseEntity.noContent().build();
    }
}
