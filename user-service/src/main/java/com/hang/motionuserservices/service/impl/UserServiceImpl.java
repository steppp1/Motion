package com.hang.motionuserservices.service.impl;

import com.hang.motionuserservices.dal.dto.user.UserLoginDTO;
import com.hang.motionuserservices.dal.dto.user.UserRegisterDTO;
import com.hang.motionuserservices.dal.entity.user.UserBasicInfo;
import com.hang.motionuserservices.dal.mysql.user.UserBasicInfoMapper;
import com.hang.motionuserservices.framework.constant.MessageConstant;
import com.hang.motionuserservices.framework.exception.PasswordErrorException;
import com.hang.motionuserservices.framework.exception.UserRegisterException;
import com.hang.motionuserservices.framework.exception.AccountNotFoundException;
import com.hang.motionuserservices.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;




import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBasicInfoMapper userBasicInfoMapper;

    /**
     * 实现用户注册
     */
    @Override
    public void userRegister(UserRegisterDTO userRegisterDTO) {
        //首先判断注册的这个用户的邮箱、用户名、手机号是否存在重复
        //存在重复，返回异常信息
        List<UserBasicInfo> list = userBasicInfoMapper.registerCheck(userRegisterDTO);
        if (list.size() >= 1) {
            throw new UserRegisterException(MessageConstant.User_ALREADY_EXISTS);
        }
        //将用户注册到用户表
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        BeanUtils.copyProperties(userRegisterDTO, userBasicInfo);
        userBasicInfo.setPasswordHash(DigestUtils.md5DigestAsHex(userBasicInfo.getPasswordHash().getBytes()));
        userBasicInfoMapper.insert(userBasicInfo);
    }
    @Override
    public UserBasicInfo login(UserLoginDTO userLoginDTO) {
        String email = userLoginDTO.getEmail();
        String password = userLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        UserBasicInfo userBasicInfo = userBasicInfoMapper.getByEmail(email);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (userBasicInfo == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.PASSWORD_ERROR);
        }

        //对明文密码进行md5比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(userBasicInfo.getPasswordHash())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        //3、返回实体对象
        return userBasicInfo;
    }
}
