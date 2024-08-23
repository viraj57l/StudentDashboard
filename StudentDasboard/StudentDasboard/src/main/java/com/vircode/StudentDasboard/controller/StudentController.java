package com.vircode.StudentDasboard.controller;

import com.vircode.StudentDasboard.entity.Student;
import com.vircode.StudentDasboard.entity.StudentData;
import com.vircode.StudentDasboard.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("allStudents")
    public ResponseEntity<List<StudentData>> getAllStudents(){
        return studentService.getAllStudents();
    }



    @PostMapping("addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
       return studentService.addStudent(student);
    }

    @PostMapping("/{studentId}/assignSubjects")
    public ResponseEntity<String> assignSubjectsToStudent(
            @PathVariable Integer studentId,
            @RequestBody Set<Integer> subjectIds){
      return   studentService.assignSubjectsToStudent(studentId,subjectIds);
    }

}
