package com.loyalblue.ecommerce.inventory.controller;

import com.loyalblue.ecommerce.inventory.controller.model.InventoryItem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;




// @RestController indicates that this class will handle HTTP requests and return data in JSON or XML format.
@RestController
// @RequestMapping sets the base path for the controller. All routes defined in this class will start with "/inventory".
@RequestMapping("/inventory")
public class InventoryController {

    // @GetMapping is used to handle GET requests to the "/inventory" endpoint.
    // This method will be triggered when an HTTP GET request is made to "/inventory".
    @GetMapping
    public List<InventoryItem> getAllItems() {
        // This method returns a list of InventoryItem objects.
        // For now, it returns a static list of items for demonstration purposes.
        // In a real application, you would likely fetch this data from a database or another service.
        return List.of(
                new InventoryItem(1, "Item 1", 100), // Item with id 1, name "Item 1", and price 100
                new InventoryItem(2, "Item 2", 200)  // Item with id 2, name "Item 2", and price 200
        );
    }
}
