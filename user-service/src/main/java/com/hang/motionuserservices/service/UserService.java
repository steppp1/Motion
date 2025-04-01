package com.hang.motionuserservices.service;


import com.hang.motionuserservices.dal.dto.user.UserLoginDTO;
import com.hang.motionuserservices.dal.dto.user.UserRegisterDTO;
import com.hang.motionuserservices.dal.entity.user.UserBasicInfo;

public interface UserService {

    void userRegister(UserRegisterDTO userRegisterDTO);

    UserBasicInfo login(UserLoginDTO userLoginDTO);

}
