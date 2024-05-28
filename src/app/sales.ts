export class Sales {
  invoiceNo: number;
  stockCode: string;
  description: string;
  quantity: number;
  invoiceDate: string;
  unitPrice: number;
  customerID: string;
  country: string;

  constructor(
    stockCode: string = '',
    description: string = '',
    quantity: number = 0,
    unitPrice: number = 0,
    customerID: string = '',
    country: string = '',
    invoiceNo: number = 0,
    invoiceDate: string = ''
  ) {
    this.invoiceNo = invoiceNo;
    this.stockCode = stockCode;
    this.description = description;
    this.quantity = quantity;
    this.invoiceDate = invoiceDate;
    this.unitPrice = unitPrice;
    this.customerID = customerID;
    this.country = country;
  }
}

export interface ApiResponse {
  data: Sales;
  httpStatus: string;
  message: string;
}
