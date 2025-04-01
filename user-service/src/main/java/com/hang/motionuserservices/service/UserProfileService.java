package com.hang.motionuserservices.service;


import com.hang.motionuserservices.dal.dto.user.UserProfileInfoDTO;

public interface UserProfileService {
    Boolean updateUserProfileInfo(UserProfileInfoDTO userProfileInfoDTO);
}
