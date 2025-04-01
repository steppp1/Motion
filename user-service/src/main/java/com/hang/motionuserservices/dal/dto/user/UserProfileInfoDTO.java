package com.hang.motionuserservices.dal.dto.user;
import java.sql.Timestamp;
import java.util.Date;

import com.hang.motionuserservices.framework.enumeration.Gender;
import lombok.Data;

@Data
public class UserProfileInfoDTO {

    private int userId;
    private String profilePicture;
    private String bio;
    private Gender gender;
    private Date birthday;
    private String location;
    private Timestamp updatedAt;

}
