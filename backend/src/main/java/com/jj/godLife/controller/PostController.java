package com.jj.godLife.controller;

import com.jj.godLife.controller.request.CreatePostRequest;
import com.jj.godLife.controller.request.UpdatePostRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @GetMapping("/{post_no}")
    public ResponseEntity<String> get(@PathVariable("post_no") Long postNo, @RequestParam(name = "board_no", required = false) Long boardNo)
    {
        System.out.println("postNo = " + postNo);
        System.out.println("boardNo = " + boardNo);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/title")
    public ResponseEntity<String> getTitle(@RequestParam(name = "board_no", required = false) Long boardNo,
                                           @RequestParam(name = "limit", required = false) Integer limit,
                                           @RequestParam(name = "offset", required = false) Integer offset,
                                           @RequestParam(name = "sort", required = false) String sort){

        System.out.println("boardNo = " + boardNo);
        System.out.println("limit = " + limit);
        System.out.println("offset = " + offset);
        System.out.println("sort = " + sort);
        return ResponseEntity.ok("title");
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreatePostRequest request){
        System.out.println("request = " + request);

        return ResponseEntity.ok("create");
    }

    @PutMapping("/{post_no}")
    public ResponseEntity<String> update(@PathVariable("post_no") Long postNo,
                                         @RequestBody UpdatePostRequest request){
        System.out.println("request = " + request);

        return ResponseEntity.ok("update");
    }

    @DeleteMapping("/{post_no}")
    public ResponseEntity<String> delete(@PathVariable("post_no") Long postNo){
        System.out.println("postNo = " + postNo);

        return ResponseEntity.ok(":delete");
    }
}
