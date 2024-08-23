package com.vircode.StudentDasboard.dao;

import com.vircode.StudentDasboard.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {

}
