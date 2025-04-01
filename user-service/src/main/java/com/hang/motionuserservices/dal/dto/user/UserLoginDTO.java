package com.hang.motionuserservices.dal.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginDTO implements Serializable {
    private String email;
    private String password;
}
