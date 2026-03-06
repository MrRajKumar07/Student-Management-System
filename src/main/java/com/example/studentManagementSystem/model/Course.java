package com.example.studentManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;
    private Integer credits;
    private String duration;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Access By Only Admin
    @OneToMany(mappedBy="course",cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;
    
}

