import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SalesService } from '../sales.service';
import { response } from 'express';
import { ApiResponse, Sales } from '../sales';

@Component({
  selector: 'app-sales-details',
  standalone: true,
  imports: [],
  templateUrl: './sales-details.component.html',
  styleUrl: './sales-details.component.css',
})
export class SalesDetailsComponent implements OnInit {
  invoiceNo: number = 0;
  sales: Sales = new Sales();

  constructor(
    private route: ActivatedRoute,
    private salesService: SalesService
  ) {}

  ngOnInit(): void {
    this.invoiceNo = this.route.snapshot.params['invoiceNo'];
    this.sales = new Sales();

    this.salesService
      .getSalesByInvoiceNo(this.invoiceNo)
      .subscribe((response: ApiResponse) => {
        this.sales = response.data;
      });
  }
}
