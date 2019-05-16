import { Component, OnInit } from '@angular/core';
import {User} from "../../../../models/user";
import {HttpService} from "../../../../../services/http.service";
import {PersonalData} from "../../../../models/personal-data";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  repeatPassword: string;
  customer: PersonalData = new PersonalData();
  constructor(private httpService: HttpService) { }

  saveCustomer(){
    console.log(this.customer);
    this.httpService.saveCustomer(this.customer)
      .subscribe((data)=> console.log(data));
  }

  saveUser(){
    console.log(this.user);
    this.httpService.saveUser(this.user)
      .subscribe((data)=> console.log(data));
  }

  ngOnInit() {

  }

}
