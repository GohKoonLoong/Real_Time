package com.uum.demo.service.impl;

import com.uum.demo.exception.SalesNotFoundException;
import com.uum.demo.model.Sales;
import com.uum.demo.repository.SalesRepository;
import com.uum.demo.service.SalesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    SalesRepository salesRepository;

    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public String createSales(Sales sales) {
        try {
            salesRepository.save(sales);
            return "Success";
        } catch (Exception e) {
            throw new SalesNotFoundException("Failed to create sales: " + e.getMessage());
        }
    }

    @Override
    public String updateSales(Sales sales) {
        try {
            salesRepository.save(sales);
            return "";
        } catch (Exception e) {
            throw new SalesNotFoundException("Failed to update sales: " + e.getMessage());
        }
    }

    @Override
    public String deleteSales(Long invoiceNo) {
        try {
            salesRepository.deleteById(invoiceNo);
            return "";
        } catch (Exception e) {
            throw new SalesNotFoundException("Sales with Invoice No: " + invoiceNo + " not found");
        }
    }

    @Override
    public Sales getSales(Long invoiceNo) {
        if(salesRepository.findById(invoiceNo).isEmpty())
            throw new SalesNotFoundException("Requested Sales does not exist");
        return salesRepository.findById(invoiceNo).get();
    }

    @Override
    public List<Sales> getAllSales() {
        if(salesRepository.findAll().isEmpty())
            throw new SalesNotFoundException("List not found");
        return salesRepository.findAll();
    }
}
