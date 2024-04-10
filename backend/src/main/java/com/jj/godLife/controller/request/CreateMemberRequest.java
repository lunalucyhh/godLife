package com.jj.godLife.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CreateMemberRequest {

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("login_type")
    private Long loginType;    

    @JsonProperty("password")
    private String password;

    @JsonProperty("gather_agree")
    private Long gatherAgree;

    @JsonProperty("cell_phone")
    private String cellPhone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("sex")
    private Long sex;

    @JsonProperty("board_no")
    private String boardNo;
}
