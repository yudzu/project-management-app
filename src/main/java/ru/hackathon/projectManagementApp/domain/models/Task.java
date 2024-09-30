package ru.hackathon.projectManagementApp.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private Project project;
    @Column(name = "name")
    private String name;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "due_date")
    private LocalDateTime due_date;
    @Column(name = "priority")
    private String priority;
    @ManyToMany(mappedBy = "tasks")
    private Set<User> users = new HashSet<>();
}
