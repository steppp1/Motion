package com.hang.motionuserservices.dal.mysql.user;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hang.motionuserservices.dal.dto.user.UserRegisterDTO;
import com.hang.motionuserservices.dal.entity.user.UserBasicInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;




import java.util.List;

@Mapper
public interface UserBasicInfoMapper extends BaseMapper<UserBasicInfo> {

    List<UserBasicInfo> registerCheck(UserRegisterDTO userRegisterDTO);

    @Insert("insert into user_basic_info (username, email, password_hash, phone) values (#{username}, #{email}, #{password}, #{phone})")
    int insert(UserBasicInfo UserBasicInfo);

    @Select("select * from user_basic_info where email = #{email}")
    UserBasicInfo getByEmail(String email);
}
