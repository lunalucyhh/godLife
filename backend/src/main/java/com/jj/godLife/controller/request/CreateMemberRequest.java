package com.jj.godLife.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CreateMemberRequest {

    @JsonProperty("user_no")
    private Long userNo;


}
