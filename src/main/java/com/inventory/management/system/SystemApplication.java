/* Project: Inventory Management System API (Spring Boot, Java, MySQL)
This project provides CRUD operations and stock management for warehouse products. */
package com.inventory.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Main entry point of the Spring Boot application
@SpringBootApplication  // Enables auto-configuration and component scanning
public class SystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

}
