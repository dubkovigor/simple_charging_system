import {Component, OnInit} from '@angular/core';
import {PersonalData} from "../../../../models/personal-data";
import {HttpService} from "../../../../../services/http.service";
import {User} from "../../../../models/user";
import {Log} from "@angular/core/testing/src/logger";

// import {enumCountry, enumSex, PersonalData} from '../../../../models/personal-data';

@Component({
  selector: 'app-personal-data',
  templateUrl: './personal-data.component.html',
  styleUrls: ['./personal-data.component.css']
})
export class PersonalDataComponent implements OnInit {

  users: User[] = [];
  customers: PersonalData[] = [];

  constructor(private httpService: HttpService) { }

  ngOnInit() {console.log('darova');
  // this.httpService.getUser().subscribe((data) => this.users =data);
  //   this.httpService.getUser().subscribe()
    this.httpService.getCustomer()
      .subscribe((data1) => this.customers = data1, (e) => console.log(e))
    this.httpService.getUser()
      .subscribe((data) =>
        this.users = data, (e) => console.log(e));
    //

  }
}
