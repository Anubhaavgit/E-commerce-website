import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions =  {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class PincodeService {

  constructor(private http: HttpClient) { }

  checkDeliveryStatus(pin:any){
    return this.http.post("http://localhost:8081/delivery",pin,httpOptions);
  }
}
