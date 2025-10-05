package com.inventory.management.system.service;

import com.inventory.management.system.exception.BadRequestException;
import com.inventory.management.system.exception.NotFoundException;
import com.inventory.management.system.model.Inventory;
import com.inventory.management.system.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;

    public Inventory addInventory(Inventory inventory) {
        if(inventory.getStockQuantity() < 0) {
            throw new BadRequestException("Stock Quantity cannot be Empty");
        }
        return inventoryRepo.save(inventory);
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Inventory Not Found for Id :- "+id));
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepo.findAll();
    }

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

    public void deleteInventory(Long id) {
        Inventory existingInventory = getInventoryById(id);
        inventoryRepo.delete(existingInventory);
    }

    public Inventory addStockQuantity(Long id, int quantity) {
        if(quantity < 0) {
            throw new BadRequestException("Quantity should be positive");
        }
        Inventory existingInventory = getInventoryById(id);
        int updatedQuantity = existingInventory.getStockQuantity() + quantity;
        existingInventory.setStockQuantity(updatedQuantity);
        return inventoryRepo.save(existingInventory);
    }

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
