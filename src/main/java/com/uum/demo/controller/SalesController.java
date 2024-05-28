package com.uum.demo.controller;

import com.uum.demo.model.Sales;
import com.uum.demo.response.ResponseHandler;
import com.uum.demo.service.SalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "http://localhost:4200")
public class SalesController {

    SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    //Read Specific Sales from DB
    @GetMapping("{invoiceNo}")
    public ResponseEntity<Object> getSaleDetails(@PathVariable("invoiceNo") Long invoiceNo){
        return ResponseHandler.responseBuilder("Requested Sales Details are given here",
                HttpStatus.OK,salesService.getSales(invoiceNo));
    }

    //Read All Sales from DB
    @GetMapping()
    public ResponseEntity<Object> getAllSaleDetails(){
        return ResponseHandler.responseBuilder("Requested Sales Details are given here",
                HttpStatus.OK,salesService.getAllSales());
    }

    @PostMapping
    public String createSales(@RequestBody Sales sales){
        salesService.createSales(sales);
        return "Sales created successfully";
    }

    @PutMapping("{invoiceNo}")
    public String updateSales(@RequestBody Sales sales){
        return salesService.updateSales(sales);
    }

    @DeleteMapping("{invoiceNo}")
    public String deleteSales(@PathVariable("invoiceNo") Long invoiceNo){
        return salesService.deleteSales(invoiceNo);
    }

}
