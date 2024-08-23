package com.vircode.StudentDasboard.service;

import com.vircode.StudentDasboard.dao.StudentDao;
import com.vircode.StudentDasboard.dao.SubjectDao;
import com.vircode.StudentDasboard.entity.Student;
import com.vircode.StudentDasboard.entity.StudentData;
import com.vircode.StudentDasboard.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    SubjectDao subjectDao;


    public ResponseEntity<List<StudentData>> getAllStudents() {
        try{
            List<Student> students =studentDao.findAll();
            List <StudentData> studentDataList = students.stream()
                    .map(s -> new StudentData(s.getStudentName(),s.getAddress()))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(studentDataList);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity <String>  addStudent(Student student) {
        studentDao.save(student);
        String successMessage = "Successfully added student " + student.getStudentName();
        return new ResponseEntity<>(successMessage,HttpStatus.CREATED) ;
    }

    public ResponseEntity<String> assignSubjectsToStudent(Integer studentId, Set<Integer> subjectIds) {
        Optional<Student> studentOptional =studentDao.findById(studentId);
        if(studentOptional.isPresent()){
            Student student =studentOptional.get();
            Set<Subject> subjects =subjectIds.stream()
                    .map(subjectId -> subjectDao.findById(subjectId).orElse(null))
                    .filter(subject -> subject!=null)
                    .collect(Collectors.toSet());
            student.setSubjects(subjects);                 
            studentDao.save(student);
        }
        return new ResponseEntity<>("Successfully added subjects",HttpStatus.CREATED);
    }


}
