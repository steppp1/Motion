package com.hang.motionuserservices.dal.mysql.note;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hang.motionuserservices.dal.entity.note.Note;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface NoteMapper extends BaseMapper<Note> {

}
