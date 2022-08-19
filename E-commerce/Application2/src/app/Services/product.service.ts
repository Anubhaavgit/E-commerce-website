import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }
  getProducts(){
    return this.http.get("http://localhost:8081/api/products");
  }

  getProductByCode(code:number){
    return this.http.get("http://localhost:8081/api/products"+"/"+code);
  }
  getProductByName(name:string){
    return this.http.get("http://localhost:8081/api/products"+"/name/"+name);
  }
  getProductByBrand(brand:string){
    return this.http.get("http://localhost:8081/api/products"+"/brand/"+brand);
  }

  getProductDescByCode(code:number){
    return this.http.get("http://localhost:8081/api/products"+"/"+code+"/desc");
  }

  getProductPriceByCode(code:number){
    return this.http.get("http://localhost:8081/api/products"+"/"+code+"/price");
  }
}
