package ru.hackathon.projectManagementApp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hackathon.projectManagementApp.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/secured")
@Tag(name = "User Management")
public class UserController {
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Available only to authorized users")
    public String hello(){
        return "Hello, World!";
    }

    @GetMapping("/admin")
    @Operation(summary = "Available only to authorized users with ADMIN role")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloAdmin() {
        return "Hello, admin!";
    }

    @GetMapping("/get-admin")
    @Operation(summary = "Get ADMIN role(demonstration)")
    public void getAdmin() {
        userService.makeAdmin();
    }
}
