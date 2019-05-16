import { Component, OnInit } from '@angular/core';
import { Wallet } from '../../../../models/wallet';
import {HttpService} from "../../../../../services/http.service";
import {Billingaccount} from "../../../../models/billingaccount";

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {

  wallets: Wallet[] = [];
  ba: Billingaccount[] = [];

  constructor(private httpService: HttpService) { }

  ngOnInit() {

    this.httpService.getBA()
      .subscribe((data) => this.ba = data);


    this.httpService.getWallet()
      .subscribe((data) => this.wallets = data)
  }
}
