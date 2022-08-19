import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { LoginService } from 'src/app/Services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private login: LoginService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }
  details:any
  getLoginDetails(loginDetails:any){
    this.details=loginDetails
    this.login.getUserDetails(loginDetails.username).subscribe((user:any)=>{
      if(user==null){
        alert("wrong username");
      }
      else if(user.password===user.password){
        this.authService.login();
        this.router.navigateByUrl("home");
      }
      else{
        alert("wrong password");
      }
    })
  }
}
