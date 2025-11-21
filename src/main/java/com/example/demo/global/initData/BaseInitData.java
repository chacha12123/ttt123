package com.example.demo.global.initData;

import com.example.demo.domain.post.post.Post;
import com.example.demo.domain.post.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostRepository postRepository;

    @Bean
    public ApplicationRunner test() {

        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {

                if(postRepository.count() > 0) return;

                Post p1 = new Post();
                p1.setTitle("첫번째 게시글");
                p1.setContent("첫번째 게시글 내용입니다.");

                Post p2 = new Post();
                p2.setTitle("두번째 게시글");
                p2.setContent("두번째 게시글 내용입니다.");

                Post p3 = new Post();
                p3.setTitle("세번째 게시글");
                p3.setContent("세번째 게시글 내용입니다.");

                postRepository.save(p1);
                postRepository.save(p2);
                postRepository.save(p3);
            }
        };

    }

}
