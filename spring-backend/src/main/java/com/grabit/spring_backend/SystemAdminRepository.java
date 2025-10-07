package com.grabit.spring_backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemAdminRepository extends JpaRepository<SystemAdmin, Long> {
    SystemAdmin findByUsername(String username);
}
