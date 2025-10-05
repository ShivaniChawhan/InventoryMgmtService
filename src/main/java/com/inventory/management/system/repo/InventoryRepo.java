// Interface to handle DB operations using Spring Data JPA
package com.inventory.management.system.repo;

import com.inventory.management.system.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Mark this interface as a Spring Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long> { // Inherits default CRUD operations from JpaRepository
}
