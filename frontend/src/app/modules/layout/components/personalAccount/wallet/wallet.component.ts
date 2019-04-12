import { Component, OnInit } from '@angular/core';
import { Wallet } from '../../../../models/wallet';
import {HttpService} from "../../../../../services/http.service";

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {

  wallet: Wallet = {
    purseNumber: 1005245,
    amount: 100
  };

  ngOnInit() {
  }

}
