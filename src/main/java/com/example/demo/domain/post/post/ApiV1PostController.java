package com.example.demo.domain.post.post;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberService;
import com.example.demo.global.exception.ServiceException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ApiV1PostController {

    private final PostService postService;
    private final MemberService memberService;

    @Getter
    @NoArgsConstructor
    static class WriteReqBody {
        private String title;
        private String content;
        private String username;
        private String password;
    }


    @PostMapping("/api/v1/posts")
    @ResponseBody
    public RsData write(@RequestBody WriteReqBody writeReqBody) {

        // 우리 회원이 맞는지 체크
        Optional<Member> opMember = memberService.findByUsername(writeReqBody.username);

        if (opMember.isEmpty()) {
            throw new ServiceException("401", "없는 회원입니다.");
        }

        Member member = opMember.get();

        if (!member.getPassword().equals(writeReqBody.password)) {
            throw new ServiceException("401", "비밀번호를 틀렸습니다.");
        }

        postService.write(writeReqBody.title, writeReqBody.content);

        RsData rsData = new RsData();
        rsData.setResultCode("200");
        rsData.setMessage(writeReqBody.username + "님의 글 작성이 완료되었습니다.");

        return rsData;
    }

    @GetMapping("/api/v1/posts")
    @ResponseBody
    public List<Post> list() {
        List<Post> postList = postService.list();

        return postList;
    }

    @DeleteMapping("/api/v1/posts/{id}")
    @ResponseBody
    public String remove(@PathVariable Long id) {

        postService.delete(id);

        return "글 삭제가 완료되었습니다.";
    }
}
