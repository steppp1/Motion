package com.hang.motionuserservices.service.impl;

import com.hang.motionuserservices.dal.entity.note.Note;
import com.hang.motionuserservices.dal.mysql.note.NoteMapper;
import com.hang.motionuserservices.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;


@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<Note> listAll() {

        List<Note> noteList = noteMapper.selectList(null);
        return noteList;

    }


}
