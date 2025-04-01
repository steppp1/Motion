package com.hang.motionuserservices.controller.user.profile;

import com.hang.motionuserservices.dal.dto.user.UserProfileInfoDTO;
import com.hang.motionuserservices.framework.result.Result;
import com.hang.motionuserservices.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user/profile")
@Slf4j
@Tag(name = "用户个人信息相关接口")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/update")
    @Operation(summary = "用户个人信息更新")
    public Result UpdateProfile(@RequestBody UserProfileInfoDTO userProfileInfoDTO) {
        log.info("用户个人信息更新：{}", userProfileInfoDTO);
        Boolean revise = userProfileService.updateUserProfileInfo(userProfileInfoDTO);
        return revise ? Result.success() : Result.error("没有任何个人信息被修改");
    }


}
