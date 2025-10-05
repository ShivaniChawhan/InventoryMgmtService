package com.inventory.management.system.controller;

import com.inventory.management.system.model.Inventory;
import com.inventory.management.system.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping()
    public ResponseEntity<List<Inventory>> getAllData(){
        return new ResponseEntity<>(inventoryService.getAllInventory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getDataById(@PathVariable Long id) {
        return new ResponseEntity<>(inventoryService.getInventoryById(id), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<Inventory> addData(@RequestBody Inventory inventory) {
        return new ResponseEntity<>(inventoryService.addInventory(inventory), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateData(@PathVariable Long id, @RequestBody Inventory inventory) {
        return new ResponseEntity<>(inventoryService.updateInventory(id, inventory), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
    }

    // Increase stock: accept a simple JSON { "quantity": 2 }
    @PostMapping("/{id}/increase")
    public Inventory increaseStock(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        Integer quantity = body.getOrDefault("quantity", 0);
        return inventoryService.addStockQuantity(id, quantity);
    }


    // Decrease stock: accept a simple JSON { "quantity": 1 }
    @PostMapping("/{id}/decrease")
    public Inventory decreaseStock(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        Integer quantity = body.getOrDefault("quantity", 0);
        return inventoryService.decreaseStockQuantity(id, quantity);
    }

}
