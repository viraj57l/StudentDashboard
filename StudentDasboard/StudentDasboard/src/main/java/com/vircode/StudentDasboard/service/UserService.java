package com.vircode.StudentDasboard.service;

import com.vircode.StudentDasboard.dao.UserDao;
import com.vircode.StudentDasboard.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private  JWTService jwtService;

    private BCryptPasswordEncoder  encoder =new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
       return  userDao.save(user);
    }

    public String verify(Users user) {
        Authentication authentication
                =authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())) ;
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }
}
