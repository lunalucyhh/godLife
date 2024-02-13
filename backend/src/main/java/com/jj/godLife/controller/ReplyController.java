package com.jj.godLife.controller;

import com.jj.godLife.controller.request.CreateReplyRequest;
import com.jj.godLife.controller.response.ReplyResponse;
import com.jj.godLife.domain.Reply;
import com.jj.godLife.service.ReplyService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post/{post_no}/reply")
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping
    public ResponseEntity<List<ReplyResponse>> readReply(
                                            @PathVariable("post_no") Long postNo,
                                            @RequestParam(name = "limit", required = false) Integer limit,
                                            @RequestParam(name = "page", required = false) Integer page,
                                            @RequestParam(name = "sort", required = false) String sort){
        
        List<ReplyResponse> readReply = replyService.readReply(postNo, page, limit, sort);
        return ResponseEntity.ok().body(readReply);
    } 

    @PostMapping
    public ResponseEntity<Reply> create(@RequestBody CreateReplyRequest request){
        System.out.println("request = " + request);
        Reply createReply = replyService.create(request);
        return ResponseEntity.ok().body(createReply);

    }

    @DeleteMapping("/{reply_no}")
    public ResponseEntity<Void> delete(@PathVariable("reply_no") Long replyNo){
        System.out.println("replyNo = " + replyNo);
        replyService.delete(replyNo);
        return ResponseEntity.noContent().build();
    }


}