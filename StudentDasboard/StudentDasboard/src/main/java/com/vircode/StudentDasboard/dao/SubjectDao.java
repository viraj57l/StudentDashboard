package com.vircode.StudentDasboard.dao;

import com.vircode.StudentDasboard.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository<Subject,Integer> {
}
