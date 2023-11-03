package com.example.server.common;

import com.example.server.friend.Friend;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {

    private String resultCode;

    private String resultMessage;

    private Map<String, Object> data;

}