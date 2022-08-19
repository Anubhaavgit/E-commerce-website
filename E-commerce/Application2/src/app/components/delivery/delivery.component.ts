import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PincodeService } from 'src/app/Services/pincode.service';
import { ProductService } from 'src/app/Services/product.service';

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css']
})
export class DeliveryComponent implements OnInit {

  constructor(private router: ActivatedRoute, private productService:ProductService
    , private pincodeService: PincodeService) { }


  productCode:any;
  product:any;
  ngOnInit(): void {
    this.productCode=this.router.snapshot.paramMap.get("code");
    this.productService.getProductByCode(this.productCode).subscribe((value)=>this.product=value);
  }

  errorMessageStatus:boolean=false;
  successMessageStatus:boolean=false;

  serviceMessage:string="";
  
  checkPincode(data:any){
    data.productcode=+this.productCode;
    data.pincode=+data.pincode;
    this.pincodeService.checkDeliveryStatus(data).subscribe((value:any)=>{
      if(value==null) {
        this.successMessageStatus=false;
        this.errorMessageStatus=true;
        this.serviceMessage='Service not available at this pincode';
      } else if(value.availability) {
        this.errorMessageStatus=false;
        this.successMessageStatus=true;
        this.serviceMessage='Product deliverable at this pincode';
      } else {
        this.successMessageStatus=false;
        this.errorMessageStatus=true;
        this.serviceMessage='Product out of stock for this pincode';
      }
    })
  }



}
