package com.inventory.management.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// Entity representing a Inventory in the database
@Entity // JPA entity class
@Table(name="inventory")  // Creating table of name 'inventory'
@AllArgsConstructor  // Using All argument constructor annotation for handling parameterized constructors
@NoArgsConstructor  // Using No argument constructor annotation for handling non - parameterized constructors
public class Inventory {
    @Id //Primary Key
    private Long id; // Manual ID provided by client

    @Column(nullable = false) // Name is required it should not be null or false.
    private String name;

    @Column(columnDefinition = "TEXT") // Description can be long
    private String description;

    @Column(nullable = false) // Stock quantity cannot be null
    private Integer stockQuantity;

    // Getter and Setter methods for all fields
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) {
        if (stockQuantity == null) stockQuantity = 0;
        this.stockQuantity = stockQuantity;
    }
}
