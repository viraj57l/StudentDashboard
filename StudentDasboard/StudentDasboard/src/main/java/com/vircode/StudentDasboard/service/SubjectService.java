package com.vircode.StudentDasboard.service;

import com.vircode.StudentDasboard.dao.SubjectDao;
import com.vircode.StudentDasboard.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectDao subjectDao;

    public ResponseEntity<List<Subject>> getAllSubjects() {
        try{
            return new ResponseEntity<>(subjectDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addSubject(Subject subject) {

        subjectDao.save(subject);
        String successMessage = "Successfully added subject " + subject.getSubjectName();
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}
