import { Routes } from '@angular/router';
import { SalesListComponent } from './sales-list/sales-list.component';
import { CreateSalesComponent } from './create-sales/create-sales.component';
import { UpdateSalesComponent } from './update-sales/update-sales.component';
import { SalesDetailsComponent } from './sales-details/sales-details.component';

export const routes: Routes = [
  { path: 'sales', component: SalesListComponent },
  { path: 'create-sales', component: CreateSalesComponent },
  { path: 'update-sales/:invoiceNo', component: UpdateSalesComponent },
  { path: 'sales-details/:invoiceNo', component: SalesDetailsComponent },
  { path: '', redirectTo: 'sales', pathMatch: 'full' },
];
