import { Component, OnInit } from '@angular/core';
import {User} from "../../../../../models/user";
import {PersonalData} from "../../../../../models/personal-data";
import {Wallet} from "../../../../../models/wallet";
import {HttpService} from "../../../../../../services/http.service";

@Component({
  selector: 'app-billing-account',
  templateUrl: './billing-account.component.html',
  styleUrls: ['./billing-account.component.css']
})
export class BillingAccountComponent implements OnInit {


  users: User[] = [];
  customers: PersonalData[] = [];
  wallets: Wallet[] = [];

  constructor(private httpService: HttpService) {
  }

  ngOnInit() {
    console.log('darova');
    // this.httpService.getUser().subscribe((data) => this.users =data);
    //   this.httpService.getUser().subscribe()

    this.httpService.getCustomer()
      .subscribe((data1) => this.customers = data1, (e) => console.log(e));
    this.httpService.getWallet()
      .subscribe((data1) => this.wallets = data1, (e) => console.log(e));
    this.httpService.getUser()
      .subscribe((data) =>
        this.users = data, (e) => console.log(e));
    //

  }
}
