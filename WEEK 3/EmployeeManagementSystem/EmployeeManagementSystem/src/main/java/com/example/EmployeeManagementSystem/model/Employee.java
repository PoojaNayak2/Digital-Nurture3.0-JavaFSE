package com.example.EmployeeManagementSystem.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the current auditor's name (e.g., from the SecurityContext or hard-coded for simplicity)
        return Optional.of("Admin"); // Replace "Admin" with logic to retrieve the actual current user
    }
}
