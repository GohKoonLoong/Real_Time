package com.uum.demo.controller;

import com.uum.demo.model.Sales;
import com.uum.demo.response.ResponseHandler;
import com.uum.demo.service.SalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    //Read Specific Sales from DB
    @GetMapping("{invoiceNo}")
    public ResponseEntity<Object> getSaleDetails(@PathVariable("invoiceNo") String invoiceNo){
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

    @PutMapping
    public String updateSales(@RequestBody Sales sales){
        salesService.updateSales(sales);
        return "Sales updated successfully";
    }

    @DeleteMapping("{invoiceNo}")
    public String deleteSales(@PathVariable("invoiceNo") String invoiceNo){
        salesService.deleteSales(invoiceNo);
        return "Sales deleted successfully";
    }

}
