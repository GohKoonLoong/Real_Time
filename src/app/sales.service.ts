import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { ApiResponse, Sales } from './sales';

@Injectable({
  providedIn: 'root',
})
export class SalesService {
  private baseURL = 'http://localhost:8080/api/sales';

  constructor(private httpClient: HttpClient) {}

  getSalesList(): Observable<Sales[]> {
    return this.httpClient
      .get<any>(`${this.baseURL}`)
      .pipe(map((response) => response.data));
  }

  createSales(sales: Sales): Observable<Object> {
    return this.httpClient.post(this.baseURL, sales, {
      responseType: 'text',
      observe: 'response',
    });
  }

  getSalesByInvoiceNo(invoiceNo: number): Observable<ApiResponse> {
    return this.httpClient.get<ApiResponse>(`${this.baseURL}/${invoiceNo}`);
  }

  updateSales(invoiceNo: number, sales: Sales): Observable<ApiResponse> {
    return this.httpClient.put<ApiResponse>(
      `${this.baseURL}/${invoiceNo}`,
      sales
    );
  }

  deleteSales(invoiceNo: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${invoiceNo}`);
  }
}
