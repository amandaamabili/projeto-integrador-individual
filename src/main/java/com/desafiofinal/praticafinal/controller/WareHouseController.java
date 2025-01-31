package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.SellerDTO;
import com.desafiofinal.praticafinal.dto.WareHouseDTO;
import com.desafiofinal.praticafinal.service.ISellerService;
import com.desafiofinal.praticafinal.service.IWareHouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fresh-products/warehouse")

public class WareHouseController {

    private final IWareHouseService service;
    public WareHouseController(IWareHouseService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Object> insertWareHouse(@RequestBody WareHouseDTO wareHouseDTO){
        try {
            var  response = service.saveWarehouse(wareHouseDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
