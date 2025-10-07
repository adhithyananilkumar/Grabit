package com.grabit.spring_backend.restaurant;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.validation.constraints.NotNull
    @Column(nullable = false)
    private String name;

    @jakarta.validation.constraints.NotNull
    @Column(nullable = false)
    private String location;

    @jakarta.validation.constraints.NotNull
    @Column(nullable = false)
    private String type;  // e.g., "Multi-cuisine", "Fast Food"

    // Constructors
    public Restaurant() {}
    
    public Restaurant(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", type=" + type + "]";
    }
}
