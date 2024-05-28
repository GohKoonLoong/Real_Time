import { Component, OnInit } from '@angular/core';
import { Sales } from '../sales';
import { CommonModule } from '@angular/common';
import { SalesService } from '../sales.service';
import { NgxPaginationModule } from 'ngx-pagination';
import { Router } from '@angular/router';
import { response } from 'express';

@Component({
  selector: 'app-sales-list',
  standalone: true,
  imports: [CommonModule, NgxPaginationModule],
  templateUrl: './sales-list.component.html',
  styleUrl: './sales-list.component.css',
})
export class SalesListComponent implements OnInit {
  sales: Sales[] = [];
  p: number = 1;

  constructor(private salesService: SalesService, private router: Router) {}

  ngOnInit(): void {
    this.getSales();
    console.log(this.sales);
  }

  private getSales() {
    this.salesService.getSalesList().subscribe((response) => {
      this.sales = response;
    });
  }

  salesDetails(invoiceNo: number) {
    this.router.navigate(['sales-details', invoiceNo]);
  }

  updateSales(invoiceNo: number) {
    this.router.navigate(['update-sales', invoiceNo]);
  }

  deleteSales(invoiceNo: number) {
    this.salesService.deleteSales(invoiceNo).subscribe((response) => {
      console.log(response);
      this.getSales();
    });
  }
}
