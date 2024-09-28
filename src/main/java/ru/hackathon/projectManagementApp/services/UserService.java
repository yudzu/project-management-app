package ru.hackathon.projectManagementApp.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.hackathon.projectManagementApp.configurations.UserDetailsImpl;
import ru.hackathon.projectManagementApp.entities.User;
import ru.hackathon.projectManagementApp.repositories.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with email '%s' not found", email)
                )
        );
        return UserDetailsImpl.create(user);
    }
}
