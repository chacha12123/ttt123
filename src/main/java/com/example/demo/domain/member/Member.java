package com.example.demo.domain.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 회원번호

    @Column(unique = true)
    private String username; // 아이디
    private String password; // 비밀번호
    private String nickname; // 별명
    private String apiKey; // API 키
}
