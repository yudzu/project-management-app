package ru.hackathon.projectManagementApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hackathon.projectManagementApp.domain.models.Project;
import ru.hackathon.projectManagementApp.repositories.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    public Project getById(Long id){
        return projectRepository.findById(id).orElse(null);
    }
}
