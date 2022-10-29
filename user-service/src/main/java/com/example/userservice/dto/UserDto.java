package com.example.userservice.dto;

import com.example.userservice.vo.ResponseOrder;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createAt;

    private String encryptedPwd;

    private List<ResponseOrder> orders;

}
