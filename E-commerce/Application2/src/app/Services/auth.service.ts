import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  login(){
    sessionStorage.setItem("IsLoggedIn","true");
  }
  logout(){
    sessionStorage.setItem("IsLoggedIn","false");
  }

  check(){
    return sessionStorage.getItem("IsLoggedIn")==="true"? true:false;
  }
}
