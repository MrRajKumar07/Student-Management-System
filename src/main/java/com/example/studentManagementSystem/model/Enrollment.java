package com.example.studentManagementSystem.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "enrollments")
public class Enrollment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    private Long courseId;

    private LocalDate enrollmentDate;

    private String status;

    @PrePersist
    protected void onCreate() {
        this.enrollmentDate = LocalDate.now();
        this.status = "ACTIVE";
    }

}
