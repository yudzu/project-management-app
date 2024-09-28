package ru.hackathon.projectManagementApp.controllers;

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
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/project/{id}")
    public ResponseEntity<Project> projectInfo(@PathVariable Long id){
        return ResponseEntity.ok().body(projectService.getById(id));
    }
}
