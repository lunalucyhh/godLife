package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreatePostRequest;
import com.jj.godLife.domain.Post;
import com.jj.godLife.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post create(CreatePostRequest request){
        Post newContents = new Post();
        newContents.setBoardNo(request.getBoardNo());
        newContents.setPostTitle(request.getTitle());
        newContents.setPostContents(request.getContents());
        newContents.setPostWriter(request.getWriter());
        newContents.setInsTimestamp(ZonedDateTime.now());
        newContents.setInsUser(request.getWriter());

        postRepository.save(newContents);

        return new Post();
    }


}
