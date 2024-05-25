package com.jj.godLife.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CreateMemberRequest {
    
    private Long userNo;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("login_type")
    private Integer loginType;    

    @JsonProperty("password")
    private String password;

    @JsonProperty("gather_agree")
    private Integer gatherAgree;

    @JsonProperty("cell_phone")
    private String cellPhone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("sex")
    private Integer sex;

    @JsonProperty("board_no")
    private Long boardNo;
}
