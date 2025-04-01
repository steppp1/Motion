package com.hang.motionuserservices.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.hang.motionuserservices.dal.dto.user.UserProfileInfoDTO;
import com.hang.motionuserservices.dal.mysql.user.UserProfileMapper;
import com.hang.motionuserservices.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileMapper userProfileMapper;
    @Override
    public Boolean updateUserProfileInfo(UserProfileInfoDTO userProfileInfoDTO) {
        if (userProfileInfoDTO == null || userProfileInfoDTO.getUserId() <= 0) {
            throw new IllegalArgumentException("User ID is required and must be greater than 0.");
        }
        // 使用LambdaUpdateWrapper动态生成SQL
        LambdaUpdateWrapper<UserProfileInfoDTO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserProfileInfoDTO::getUserId, userProfileInfoDTO.getUserId()); // 条件：userId匹配

        // 动态添加更新字段
        if (userProfileInfoDTO.getProfilePicture() != null) {
            updateWrapper.set(UserProfileInfoDTO::getProfilePicture, userProfileInfoDTO.getProfilePicture());
        }
        if (userProfileInfoDTO.getBio() != null) {
            updateWrapper.set(UserProfileInfoDTO::getBio, userProfileInfoDTO.getBio());
        }
        if (userProfileInfoDTO.getGender() != null) {
            updateWrapper.set(UserProfileInfoDTO::getGender, userProfileInfoDTO.getGender().name()); // 存储枚举名
        }
        if (userProfileInfoDTO.getBirthday() != null) {
            updateWrapper.set(UserProfileInfoDTO::getBirthday, userProfileInfoDTO.getBirthday());
        }
        if (userProfileInfoDTO.getLocation() != null) {
            updateWrapper.set(UserProfileInfoDTO::getLocation, userProfileInfoDTO.getLocation());
        }
        if (userProfileInfoDTO.getUpdatedAt() != null) {
            updateWrapper.set(UserProfileInfoDTO::getUpdatedAt, userProfileInfoDTO.getUpdatedAt());
        }

        int back = userProfileMapper.update(userProfileInfoDTO, updateWrapper);

        return back > 0;


    }
}
