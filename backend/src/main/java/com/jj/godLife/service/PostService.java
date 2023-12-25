package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreatePostRequest;
import com.jj.godLife.controller.request.UpdatePostRequest;
import com.jj.godLife.controller.response.PostTitleResponse;
import com.jj.godLife.domain.Post;
import com.jj.godLife.repository.PostRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post readDetail(Long postNo, Long boardNo){
        Post readDetail = postRepository.findById(postNo).get();
        System.out.println(readDetail);
        return readDetail;
    }

    
    public List<PostTitleResponse> readTitle(Long boardNo, Integer page, Integer limit, String sort) {
        int offset = (page - 1) * limit;
        String[] array = sort.split("_");
        String dir = array[2].toUpperCase();
        String orderBy = String.format("%s%s", array[0], array[1]
                                        .substring(0, 1).toUpperCase() 
                                        + array[1].substring(1)); // insTimestamp
    
        PageRequest paging = PageRequest.of(offset, limit, Sort.by(Sort.Direction.valueOf(dir), orderBy));
        List<Post> readTitle = postRepository.findAllByBoardNo(boardNo,paging);
        List<PostTitleResponse> postTitleResponse = new ArrayList();
        
        for (Post post : readTitle) {
            PostTitleResponse title = new PostTitleResponse();
            title.setPostNo(post.getPostNo());
            title.setPostTitle(post.getPostTitle());
            title.setInsTimestamp(post.getInsTimestamp());
            postTitleResponse.add(title);
        }
        return postTitleResponse;
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
