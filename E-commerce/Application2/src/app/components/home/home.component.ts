import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/Services/product.service';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/Services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  listOfProducts:any;
  constructor(private product:ProductService, private authService: AuthService,
     private router: Router) { 
    product.getProducts().subscribe((data)=>{
      this.listOfProducts=data;
      console.log(this.listOfProducts);
      
    });
  }

  ngOnInit(): void {
  }

  Logout(){
    this.authService.logout();
    this.router.navigateByUrl("");
  }

  userData:any;
  getData(data:any){
    this.userData=data;    
    console.log(this.userData);

    let value=data.userInput;
    let category=data.category;

    switch(category){
      case "Name": this.product.getProductByName(value).subscribe((result)=>{
        this.listOfProducts=result;
      })
      break;
      case "Brand":this.product.getProductByBrand(value).subscribe((result2)=>{
          this.listOfProducts=result2;
      })
      break;

      case "Product Code": this.product.getProductByCode(value).subscribe((result3)=>{
        this.listOfProducts=result3;
      })
      break;
    }
     
  }
}
