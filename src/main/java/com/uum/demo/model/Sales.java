package com.uum.demo.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="sales")

public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceNo;

    private String stockCode;
    private String description;
    private int quantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "invoice_date", updatable = false, insertable = false)
    private Date invoiceDate; // This field is managed by the database

    private double unitPrice;
    private String customerID;
    private String country;

    public Sales(){
    }

    public Sales(Long invoiceNo, String stockCode, String description, int quantity, Date invoiceDate, double unitPrice, String customerID, String country){
        this.invoiceNo = invoiceNo;
        this.stockCode = stockCode;
        this.description = description;
        this.quantity = quantity;
        this.invoiceDate = invoiceDate;
        this.unitPrice = unitPrice;
        this.customerID = customerID;
        this.country = country;
    }

    public Long getInvoiceNo() {
        return invoiceNo;
    }

//    public void setInvoiceNo(String invoiceNo) {
//        this.invoiceNo = invoiceNo;
//    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

//    public void setInvoiceDate(String invoiceDate) {
//        this.invoiceDate = invoiceDate;
//    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
