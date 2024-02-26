package com.MicroService.inventoryservice.controller;

import com.MicroService.inventoryservice.dto.InventoryResponse;
import com.MicroService.inventoryservice.repositiry.InventoryRepository;
import com.MicroService.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    //Default format
    //**http://localhost:8082/api/inventory/iPhone_13,iPhone_13_red.....

//    @GetMapping("/{sku-code}")
//    @ResponseStatus(HttpStatus.OK)
//    public boolean isInStock(@PathVariable("sku-code") String skuCode){
//
//        return inventoryService.isInStock(skuCode);
//    }

    //Readable format
    //**http://localhost:8082/api/inventory?sku-code=iPhone_13&sku-code=iPhone_13_red.....
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }

}
