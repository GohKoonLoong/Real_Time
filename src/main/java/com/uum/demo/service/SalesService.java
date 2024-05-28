package com.uum.demo.service;

import com.uum.demo.model.Sales;
import java.util.List;

public interface SalesService {
    public String createSales(Sales sales);
    public String updateSales(Sales sales);
    public String deleteSales(Long invoiceNo);
    public Sales getSales(Long invoiceNo);
    public List<Sales> getAllSales();
}
