import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }
  getUserDetails(username:string){
    return this.http.get("http://localhost:8081/login/"+username);
  }
}
