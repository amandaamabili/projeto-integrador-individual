package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.service.IinboundOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

/**
 * This class holds all endpoints related to inbound orders
 * @author Monica, Yago, Marina, Amanda
 * @version 1.0.1
 * @see <a href="https://br-playground.digitalhouse.com/course/86ba8e00-da33-420a-a62a-02d4a77c55e8/unit/f1c410da-fa91-44a9-b216-b6b93b85246c/lesson/39480008-71db-4c4a-af64-12766a2245a7/topic/21261b7d-ee61-46cc-b8e3-ab7dffec542f"> Requirement 1 User Story Contracts</a>
 */


@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InBoundOrderController {
    @Autowired
    private IinboundOrderService service;

    /**
     * Route used to insert into the datavase a new inbound order
     * @param newOrder A list containing: orderId (Long); Date(dateTime); Sector(String) and batchStockList(List)
     * @return  HTML Response 201: Created
     * @throws Exception ElementAlreadyExistException 
     */

    @PostMapping("/insert")
    public ResponseEntity<Object> create(@RequestBody InboundOrderRequestDTO newOrder) throws Exception {
        InBoundOrder response = service.saveInBoundOrder(newOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(new InBoundOrderResponseDTO(response));

    }
    
    /**
     * Route used to update inbound orders that already exists in the database
     * @param updateOrder A list containing: orderId (Long); Date(dateTime); Sector(String) and batchStockList(List)
     * @return HTML Response 204: Updated
     * @throws Exception ElementNotFoundException
     */
    @PutMapping("/update")
    public ResponseEntity<Object> updateInBoundOrder(@RequestBody InboundOrderRequestDTO updateOrder) throws Exception {
        InBoundOrder updatedResponse = service.updateInBoundOrder(updateOrder);

        return new ResponseEntity<>(new InBoundOrderResponseDTO(updatedResponse), HttpStatus.CREATED);

    }
}


