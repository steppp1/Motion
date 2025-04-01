package com.hang.motionuserservices.controller.user.basic;

import com.hang.motionuserservices.dal.dto.user.UserRegisterDTO;
import com.hang.motionuserservices.framework.result.Result;
import com.hang.motionuserservices.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/user/register")
@Slf4j
@Tag(name = "用户注册相关接口")
public class UserRegisterController {
    @Autowired
    private UserService userService;
    @PostMapping
    @Operation(summary = "用户注册")
    public Result Register(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("一个用户尝试注册：{}", userRegisterDTO);
        userService.userRegister(userRegisterDTO);

        log.info("一个用户注册成功：{}", userRegisterDTO);
        return Result.success();
    }
}
