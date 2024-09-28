package ru.hackathon.projectManagementApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hackathon.projectManagementApp.domain.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
