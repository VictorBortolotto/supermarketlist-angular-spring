import { Component, OnInit } from '@angular/core';
import { ProductModel } from 'src/app/model/ProductModel';
import { ProductsService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products-page',
  templateUrl: './products-page.component.html',
  styleUrls: ['./products-page.component.css']
})
export class ProductsPageComponent implements OnInit {

  
  products: ProductModel[] = [{
    id: 0,
    name: ''
  }]

  pages = {
    initialPage: 1,
    pageCount: 14
  }

  constructor() { }

  ngOnInit(): void {
    const response = ProductsService();

    response.then(data =>{
        this.products = data;
    });
  }

}
