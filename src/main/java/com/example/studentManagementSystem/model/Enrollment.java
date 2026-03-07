package com.example.studentManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "enrollments")
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private LocalDate enrollmentDate;

    private String status; // "ACTIVE", "COMPLETED", "DROPPED"

    @PrePersist
    protected void onCreate() {
        this.enrollmentDate = LocalDate.now();
        this.status = "ACTIVE";
    }

}
