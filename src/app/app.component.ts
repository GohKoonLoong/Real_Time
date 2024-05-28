import { Component } from '@angular/core';
import { RouterOutlet, RouterModule } from '@angular/router';
import { SalesListComponent } from './sales-list/sales-list.component';
import { CommonModule } from '@angular/common';
import { NgxPaginationModule } from 'ngx-pagination';
import { CreateSalesComponent } from './create-sales/create-sales.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterModule,
    RouterOutlet,
    CommonModule,
    SalesListComponent,
    NgxPaginationModule,
    CreateSalesComponent,
    FormsModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'angular--frontend';
}
