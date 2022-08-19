import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/Services/product.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

  listOfProducts:any;
  constructor(private product:ProductService) { 
    product.getProducts().subscribe((data)=>{
      this.listOfProducts=data;
      console.log(this.listOfProducts);
      
    });
  }

  ngOnInit(): void {
  }

}
