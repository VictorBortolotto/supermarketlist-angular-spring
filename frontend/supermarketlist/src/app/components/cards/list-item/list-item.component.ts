import { Component, OnInit } from '@angular/core';
import { ProductModel } from 'src/app/model/ProductModel';
import { ProductsService } from 'src/app/services/product.service';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.css']
})
export class ListItemComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
  }

}
