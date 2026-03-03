package com.example.studentManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.studentManagementSystem.config.JwtUtil;
import com.example.studentManagementSystem.dto.LoginDTO;
import com.example.studentManagementSystem.dto.RegisterDTO;
import com.example.studentManagementSystem.mapper.AuthMapper;
import com.example.studentManagementSystem.model.User;
import com.example.studentManagementSystem.repository.RoleRepository;
import com.example.studentManagementSystem.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
    @Autowired 
    private UserRepository userRepository;
    
    @Autowired 
    private RoleRepository roleRepository;
    
    @Autowired 
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired 
    private JwtUtil jwtUtil;
    
    @Autowired 
    private AuthMapper authMapper;

    @Override
    public String registerUser(RegisterDTO registerDTO) {
    	
    	//user save( username,password,email,roleName)
        User user = authMapper.toEntity(registerDTO);
        
        //Raj@1234 - qbhtsrdecg$fr%@bjlijfbjilvfil
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        if(passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        return "Invalid credentials";
    }
}