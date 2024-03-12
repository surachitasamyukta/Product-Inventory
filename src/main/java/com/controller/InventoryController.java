package com.controller;

import com.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {


    @Autowired
    InventoryService inventoryService;
    @GetMapping("/getCount/productName")
    public Integer getInventoryForProduct(String name) {
        return inventoryService.getInventoryForProduct(name);
    }

    @PostMapping("/updateInventory/{name}/{count}")
    public String updateInventoryForProduct(String name, Integer count) {
        return inventoryService.updateInventoryForProduct(name, count);
    }
}
