package com.jj.godLife.controller;

import com.jj.godLife.controller.request.CreateReplyRequest;
import com.jj.godLife.domain.Post;
import com.jj.godLife.domain.Reply;
import com.jj.godLife.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post/{post_no}/reply")
public class ReplyController {

    private final ReplyService replyService;

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