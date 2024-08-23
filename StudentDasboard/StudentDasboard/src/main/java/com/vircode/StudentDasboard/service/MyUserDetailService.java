package com.vircode.StudentDasboard.service;

import com.vircode.StudentDasboard.dao.UserDao;
import com.vircode.StudentDasboard.entity.UserPrincipal;
import com.vircode.StudentDasboard.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao  repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users  user =repo.findByUsername(username);
        if(user == null){
            System.out.println("User not Found");
            throw new UsernameNotFoundException("User not Found");
        }
        return new UserPrincipal(user);
    }
}
