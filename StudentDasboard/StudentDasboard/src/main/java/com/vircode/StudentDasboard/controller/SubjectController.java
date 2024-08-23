package com.vircode.StudentDasboard.controller;

import com.vircode.StudentDasboard.entity.Subject;
import com.vircode.StudentDasboard.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping("allSubjects")
    public ResponseEntity<List<Subject>> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping("addSubject")
    public ResponseEntity<String> addSubject (@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }
}
