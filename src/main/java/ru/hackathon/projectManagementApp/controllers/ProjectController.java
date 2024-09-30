package ru.hackathon.projectManagementApp.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackathon.projectManagementApp.domain.models.Project;
import ru.hackathon.projectManagementApp.services.ProjectService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
@Tag(name = "Project Management")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<Project> projectInfo(@PathVariable Long id) {
        return ResponseEntity.ok().body(projectService.getById(id));
    }
}
