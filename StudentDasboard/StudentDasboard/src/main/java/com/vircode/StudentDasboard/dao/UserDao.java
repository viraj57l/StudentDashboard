package com.vircode.StudentDasboard.dao;

import com.vircode.StudentDasboard.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
