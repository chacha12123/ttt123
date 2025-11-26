package com.example.demo.domain.post.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ApiV1PostController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public String write(String title, String content) {
        postService.write(title, content);

        return "글 작성이 완료되었습니다.";
    }

}
