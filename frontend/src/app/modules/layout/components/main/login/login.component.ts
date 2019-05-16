import { Component, OnInit } from '@angular/core';
import {HttpService} from "../../../../../services/http.service";
import {User} from "../../../../models/user";



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string = '';
  password: string = '';

  user: User[]= [];
  constructor(private httpService: HttpService) { }

  authUser(){
    this.httpService.authUser(this.login, this.password);
  }

  ngOnInit() {
    this.httpService.getUser().subscribe((data)=>this.user = data);


  }

}
