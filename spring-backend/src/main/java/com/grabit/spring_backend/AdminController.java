package com.grabit.spring_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SystemAdmin loginRequest) {
        boolean success = adminService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (success) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody SystemAdmin admin) {
        SystemAdmin created = adminService.createAdmin(admin);
        return ResponseEntity.ok(created);
    }
}
