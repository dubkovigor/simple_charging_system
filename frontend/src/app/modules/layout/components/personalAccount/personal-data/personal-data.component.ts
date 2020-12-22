import {Component, OnInit} from '@angular/core';
import {Wallet} from '../../../../models/wallet';
import {User} from '../../../../models/user';
import {HttpService} from '../../../../../services/http.service';
import {AuthorizationService} from '../../../../../services/AuthorizationService';

// import {enumCountry, enumSex, PersonalData} from '../../../../models/personal-data';

@Component({
  selector: 'app-personal-data',
  templateUrl: './personal-data.component.html',
  styleUrls: ['./personal-data.component.css']
})
export class PersonalDataComponent implements OnInit {


  autUser: User = new User();
  wallets: Wallet[] = [];


  constructor(private httpService: HttpService, private  authService: AuthorizationService) {}

  ngOnInit() {
    // this.httpService.getWallet()
    //   .subscribe((data1) => this.wallets = data1, (e) => console.log(e));
    // this.httpService.getUser()
    //   .subscribe((data) =>
    //     this.users = data, (e) => console.log(e));
    // //
    this.getAuthUser();
  }

  getAuthUser() {
    this.authService.subscribeToAuthUser().subscribe(value => {
      this.autUser = value;
    });
    this.authService.getAuthUser();
  }
}
