package com.example.studentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentManagementSystem.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
