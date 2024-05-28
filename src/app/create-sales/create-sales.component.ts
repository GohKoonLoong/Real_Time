import { Component, OnInit } from '@angular/core';
import { Sales } from '../sales';
import { FormsModule } from '@angular/forms';
import { SalesService } from '../sales.service';
import { error } from 'console';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-sales',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './create-sales.component.html',
  styleUrl: './create-sales.component.css',
})
export class CreateSalesComponent implements OnInit {
  sales: Sales = new Sales();
  constructor(private salesService: SalesService, private router: Router) {}

  ngOnInit(): void {}

  saveSales() {
    this.salesService.createSales(this.sales).subscribe({
      next: (data) => {
        console.log(data);
        this.goToSalesList();
      },
      error: (error) => {
        console.log(error);
      },
      complete: () => {
        console.log('Save sales completed');
      },
    });
  }

  goToSalesList() {
    this.router.navigate(['/sales']);
  }

  onSubmit() {
    this.saveSales();
  }
}
