import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Sales } from '../sales';
import { SalesService } from '../sales.service';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from 'console';
import { CommonModule } from '@angular/common';
import { ApiResponse } from '../sales';

@Component({
  selector: 'app-update-sales',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './update-sales.component.html',
  styleUrl: './update-sales.component.css',
})
export class UpdateSalesComponent implements OnInit {
  invoiceNo: number = 0;
  sales: Sales = new Sales();
  constructor(
    private salesService: SalesService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.invoiceNo = this.route.snapshot.params['invoiceNo'];

    this.salesService.getSalesByInvoiceNo(this.invoiceNo).subscribe({
      next: (response: ApiResponse) => {
        this.sales = response.data;
        console.log(this.sales);
      },
      error: (error) => {
        console.log(error);
      },
      complete: () => {
        console.log('Show sales completed');
      },
    });
  }

  goToSalesList() {
    this.router.navigate(['/sales']);
  }

  onSubmit() {
    this.salesService.updateSales(this.invoiceNo, this.sales).subscribe({
      next: (data) => {
        console.log(data);
        this.goToSalesList();
      },
      error: (error) => {
        console.log(error);
      },
      complete: () => {
        console.log('Update sales successfully');
      },
    });
  }
}
