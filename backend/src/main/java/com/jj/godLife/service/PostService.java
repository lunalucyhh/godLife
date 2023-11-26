package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreatePostRequest;
import com.jj.godLife.controller.request.UpdatePostRequest;
import com.jj.godLife.domain.Post;
import com.jj.godLife.repository.PostRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post readDetail(Long postNo, Long boardNo){
        Post readDetail = postRepository.findById(postNo).get();
        System.out.println(readDetail);
        return readDetail;
    }

    public Post readTitle() {
        return new Post();
    }

    
    public Post create(CreatePostRequest request){
        Post newContents = new Post();
        newContents.setBoardNo(request.getBoardNo());
        newContents.setPostTitle(request.getTitle());
        newContents.setPostContents(request.getContents());
        newContents.setPostWriter(request.getWriter());
        newContents.setInsTimestamp(ZonedDateTime.now());
        newContents.setInsUser(request.getWriter());

        postRepository.save(newContents);

        return newContents;
    }

    @Transactional
    public Post update(Long postNo, UpdatePostRequest request){
        Post updateContents = postRepository.findById(postNo).get();

        updateContents.setPostTitle(request.getTitle());
        updateContents.setPostContents(request.getContents());
        updateContents.setPostWriter(request.getWriter());
        updateContents.setUpdTimestamp(ZonedDateTime.now());
        updateContents.setUpdUser(request.getWriter());

      
        return updateContents;
    }

    @Transactional
    public void delete(Long postNo){
        Post deleteContents = postRepository.findById(postNo).get();

        deleteContents.setDelTimestamp(ZonedDateTime.now());   

    }

        

}
