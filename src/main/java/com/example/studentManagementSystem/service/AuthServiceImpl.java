package com.example.studentManagementSystem.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.studentManagementSystem.config.JwtUtil;
import com.example.studentManagementSystem.dto.LoginDTO;
import com.example.studentManagementSystem.dto.RegisterDTO;
import com.example.studentManagementSystem.exception.ApiException;
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
    public String registerUser(RegisterDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new ApiException("Username '" + dto.getUsername() + "' is already taken.");
        }

        Role role = roleRepository.findByRoleName(dto.getRoleName())
                .orElseThrow(() -> new ResourceNotFoundException("Role: " + dto.getRoleName() + " does not exist"));

        User user = authMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(role);

        userRepository.save(user);
        return "User registered successfully with role " + dto.getRoleName();
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid username"));
        
        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            // Updated to pass the role name to the token generator
            return jwtUtil.generateToken(user.getUsername(), user.getRole().getRoleName());
        }
        throw new UnauthorizedException("Invalid password credentials");
    }
}