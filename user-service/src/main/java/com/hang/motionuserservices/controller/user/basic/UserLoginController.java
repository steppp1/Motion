package com.hang.motionuserservices.controller.user.basic;

import com.hang.motionuserservices.dal.dto.user.UserLoginDTO;
import com.hang.motionuserservices.dal.entity.user.UserBasicInfo;
import com.hang.motionuserservices.dal.vo.UserLoginVO;
import com.hang.motionuserservices.framework.result.Result;
import com.hang.motionuserservices.framework.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.hang.motionuserservices.framework.constant.JwtClaimsConstant.USER_ID;

@RestController
@RequestMapping("/api/user/login")
@Slf4j
@Tag(name = "用户登陆相关接口")
public class UserLoginController {

    @Autowired
    private com.hang.motionuserservices.service.UserService userService;
    @Autowired
    private com.hang.motionuserservices.framework.jwt.JwtProperties jwtProperties;
    @Operation(summary = "登陆")
    @PostMapping
    public Result login(UserLoginDTO userLoginDTO){

        log.info("员工登录：{}", userLoginDTO.toString().replace(userLoginDTO.getPassword(), "******"));

        UserBasicInfo userBasicInfo = userService.login(userLoginDTO);

        // 登录成功后，生成jwt令牌
        Map<String, Object> claims = Collections.synchronizedMap(new HashMap<>());
        claims.put(USER_ID, userBasicInfo.getUserId());

        // 校验JWT密钥和过期时间
        if (jwtProperties.getUserSecretKey() == null || jwtProperties.getUserTtl() <= 0) {
            throw new IllegalArgumentException("JWT配置无效.");
        }

        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(userBasicInfo.getUserId())
                .userName(userBasicInfo.getUsername())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }
}
