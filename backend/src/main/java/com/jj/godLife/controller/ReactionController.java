package com.jj.godLife.controller;

import com.jj.godLife.controller.response.ReactionTypeResponse;
import com.jj.godLife.domain.Reaction;
import com.jj.godLife.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ReactionController {

    private final ReactionService reactionService;


    @GetMapping("/reactions")
    public ResponseEntity<List<ReactionTypeResponse>> readReactions() {

        List<ReactionTypeResponse> readReactions = reactionService.findReactions();

        return ResponseEntity.ok().body(readReactions);
    }

/*

    @GetMapping
    public ResponseEntity<ReactionResponse> readReaction(@PathVariable("post_no") Long PostNo,
                                                            @RequestBody
                                                         ){

    }
    @PostMapping("/{reaction_no}")
    public ResponseEntity<Reaction> create(@PathVariable("post_no"),
                                            @PathVariable("reaction_no")
                                           ){
        Reaction createReaction = reactionService.create();
        return ResponseEntity.ok().body();
    }

    @DeleteMapping("/{reaction_no")
    public ResponseEntity<Reaction> delete(@PathVariable("post_no"),
                                            @PathVariable("reaction_no"),

                                           )}
*/

}

