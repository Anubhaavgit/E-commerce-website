import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions =  {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})

export class RegisterService {

  constructor(private http: HttpClient) { }

  userRegister(user:any){
    return this.http.post("http://localhost:8081/register",user,httpOptions);
  }
}
