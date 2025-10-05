package com.inventory.management.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="inventory")
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer stockQuantity;

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
