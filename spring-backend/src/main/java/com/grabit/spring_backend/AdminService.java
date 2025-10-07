package com.grabit.spring_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private SystemAdminRepository adminRepository;

    public boolean login(String username, String password) {
        SystemAdmin admin = adminRepository.findByUsername(username);
        return admin != null && admin.getPassword().equals(password);
    }

    public SystemAdmin createAdmin(SystemAdmin admin) {
        return adminRepository.save(admin);
    }
}
