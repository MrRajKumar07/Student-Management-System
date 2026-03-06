package com.example.studentManagementSystem.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.studentManagementSystem.config.JwtUtil;
import com.example.studentManagementSystem.dto.LoginDTO;
import com.example.studentManagementSystem.dto.RegisterDTO;
import com.example.studentManagementSystem.exception.ResourceNotFoundException;
import com.example.studentManagementSystem.exception.UnauthorizedException;
import com.example.studentManagementSystem.mapper.AuthMapper;
import com.example.studentManagementSystem.model.Role;
import com.example.studentManagementSystem.model.User;
import com.example.studentManagementSystem.repository.RoleRepository;
import com.example.studentManagementSystem.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthMapper authMapper;

    @Override
    public String registerUser(RegisterDTO registerDTO) {
        // Convert DTO to Entity using your manual mapper
        User user = authMapper.toEntity(registerDTO);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        
        // 2. Fetch the Role entity based on the String in DTO
        Role role = roleRepository.findByRoleName(registerDTO.getRoleName())
                .orElseThrow(() -> new ResourceNotFoundException("Role: " + registerDTO.getRoleName() + " does not exist"));
        user.setRole(role);
        
        userRepository.save(user);
        return "User registered successfully with role " + registerDTO.getRoleName();
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid username"));
        
        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new UnauthorizedException("Invalid password credentials");
    }
}