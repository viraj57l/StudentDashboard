package com.vircode.StudentDasboard.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;
    private  String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_subjects", // Name of the table which i want to join
            joinColumns = @JoinColumn(name = "student_id"), // Name of the  column for student_id 
            inverseJoinColumns = @JoinColumn(name = "subjects_id") // Name of the column for subjects_id
    )
    private Set<Subject> subjects;
}
