package com.hang.motionuserservices.dal.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterDTO implements Serializable {
    private String username;
    private String password;
    private String email;
    private String phone;
}
