package com.hang.motionuserservices.dal.entity.user;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserBasicInfo implements Serializable {
    private Long userId;
    private String username;
    private String passwordHash;
    private String email;
    private String phone;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
