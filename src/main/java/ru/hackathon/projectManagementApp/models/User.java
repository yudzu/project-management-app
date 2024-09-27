package ru.hackathon.projectManagementApp.models;

import jakarta.persistence.*;
import lombok.Data;
import ru.hackathon.projectManagementApp.models.enums.Role;


@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name = "password", length = 1000)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public boolean isManager(){
        return role != null && role.equals(Role.ROLE_MANAGER);
    }
}
