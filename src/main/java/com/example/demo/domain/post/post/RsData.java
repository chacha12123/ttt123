package com.example.demo.domain.post.post;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RsData<T> {

    private String resultCode;
    private String message;
    private T data;
}
