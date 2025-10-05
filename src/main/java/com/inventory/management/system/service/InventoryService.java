// Contains business logic for Inventory operations
package com.inventory.management.system.service;

import com.inventory.management.system.exception.BadRequestException;
import com.inventory.management.system.exception.NotFoundException;
import com.inventory.management.system.model.Inventory;
import com.inventory.management.system.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service // Mark this class as a Spring service bean
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;

    // Create a new inventory
    public Inventory addInventory(Inventory inventory) {
        if(inventory.getStockQuantity() < 0) {  // Stock cannot be negative
            throw new BadRequestException("Stock Quantity cannot be Empty");
        }
        return inventoryRepo.save(inventory);
    }

    // Get inventory by ID or throw Not Found Exception
    public Inventory getInventoryById(Long id) {
        return inventoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Inventory Not Found for Id :- "+id));
    }

    //Get All inventories
    public List<Inventory> getAllInventory() {
        return inventoryRepo.findAll();
    }

    // Update inventory fields by fetching it by ID (only for provided fields)
    public Inventory updateInventory(Long id, Inventory inventory) {
        Inventory existingInventory = getInventoryById(id);
        if(inventory.getName() != null) {
            existingInventory.setName(inventory.getName());
        }
        if(inventory.getDescription() != null) {
            existingInventory.setDescription(inventory.getDescription());
        }
        if(inventory.getStockQuantity() != null) {
           if(inventory.getStockQuantity() < 0) {
               throw new BadRequestException("Inventory Stock Quantity should not be less than 0");
           }
           existingInventory.setStockQuantity(inventory.getStockQuantity());
        }
        return inventoryRepo.save(existingInventory);
    }

    // Delete a inventory for provided ID.
    public void deleteInventory(Long id) {
        Inventory existingInventory = getInventoryById(id);
        inventoryRepo.delete(existingInventory);
    }

    // Increase Stock quantity
    public Inventory addStockQuantity(Long id, int quantity) {
        if(quantity < 0) {
            throw new BadRequestException("Quantity should be positive");
        }
        Inventory existingInventory = getInventoryById(id);
        int updatedQuantity = existingInventory.getStockQuantity() + quantity;
        existingInventory.setStockQuantity(updatedQuantity);
        return inventoryRepo.save(existingInventory);
    }

    // Decrease stock quantity with validation
    public Inventory decreaseStockQuantity(Long id, int quantity) {
        if(quantity < 0) {
            throw new BadRequestException("Quantity should be positive");
        }
        Inventory existingInventory = getInventoryById(id);
        if(existingInventory.getStockQuantity() < quantity) {
            throw new BadRequestException("Invalid Stock Quantity");
        }
        int updatedQuantity = existingInventory.getStockQuantity() - quantity;
        existingInventory.setStockQuantity(updatedQuantity);
        return inventoryRepo.save(existingInventory);
    }
}
