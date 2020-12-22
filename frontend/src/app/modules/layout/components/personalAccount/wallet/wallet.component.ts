import {Component, OnInit} from '@angular/core';
import {Wallet} from '../../../../models/wallet';
import {Billingaccount} from '../../../../models/billingaccount';
import {HttpService} from '../../../../../services/http.service';
import {User} from '../../../../models/user';
import {AuthorizationService} from '../../../../../services/AuthorizationService';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {

  autUser: User = new User();

  public inputSum: number;

  constructor(private httpService: HttpService, private authService: AuthorizationService, private toastr: ToastrService) {
  }


  ngOnInit() {
    this.getAuthUser();
  }

  getAuthUser() {
    this.authService.subscribeToAuthUser().subscribe(value => {
      this.autUser = value;
    });
    this.authService.getAuthUser();
  }

  replenishBalance() {
    let updatableWallet = Wallet.cloneWallet(this.autUser.ba_Id.wallet);
    updatableWallet.amount += this.inputSum;
    console.log(updatableWallet);
    this.httpService.saveWallet(updatableWallet).subscribe(data => {
      console.log(data);
      this.autUser.ba_Id.wallet.amount = updatableWallet.amount;
      this.authService.setAuthUser(this.autUser);
      this.toastr.success('Вы пополнили баланс!');
    });
  }
}
