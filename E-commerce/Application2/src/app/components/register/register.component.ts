import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/Services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private register:RegisterService, private router: Router) { }

  ngOnInit(): void {
  }
  getRegisterDetails(data:any){
    console.log(data);
    this.register.userRegister(data).subscribe();
    this.router.navigateByUrl("");
  }
}
