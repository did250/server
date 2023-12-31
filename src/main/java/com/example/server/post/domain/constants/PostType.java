package com.example.server.post.domain.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostType {

    NOTICE("NOTICE", "공지사항"),
    INQUIRY("INQUIRY", "문의사항");

    private final String postType;
    private final String name;
}
