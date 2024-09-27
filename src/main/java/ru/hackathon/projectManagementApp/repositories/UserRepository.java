package ru.hackathon.projectManagementApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackathon.projectManagementApp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
