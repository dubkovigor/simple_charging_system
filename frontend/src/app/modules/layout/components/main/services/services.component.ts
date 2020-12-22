import { Component, OnInit } from '@angular/core';
import { Service } from '../../../../models/service';
import {HttpService} from '../../../../../services/http.service';
import {User} from '../../../../models/user';
import {Subscription} from 'rxjs';
import {AuthorizationService} from '../../../../../services/AuthorizationService';
import {Autreguser} from '../../../../models/autreguser';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {

  services: Service[] = [];
  authUser: User = new User();

  constructor(private httpService: HttpService, private autUser: AuthorizationService, private toastr: ToastrService) { }

  ngOnInit() {
    this.getAuthUser();

  }

  getAuthUser() {
    this.autUser.subscribeToAuthUser().subscribe(value => {
      this.authUser = value;
    });
    this.autUser.getAuthUser();
    this.httpService.getService()
      .subscribe((data1) => this.services = data1, (e) => console.log(e));
  }

  subscribeClick(service: Service) {

    if (this.isRole() === true) {
      if (this.authUser.ba_Id.wallet.amount < service.price) {
        this.toastr.error('Недостаточно средств!');
      } else {
        this.httpService.subscribeUser(this.authUser, service)
          .subscribe(user => {
            this.autUser.setAuthUser(user);
          }, () => {
            this.toastr.error('Что-то пошло не так');
          }, () => {
            this.toastr.success('Вы купили товар и деньги были списаны с вашего счета!');
          });
      }
    } else this.toastr.error('Авторизириуйтесь!');
  }

  unsubscribeClick(service: Service) {
    this.httpService.unsubscribeUser(this.authUser, service)
      .subscribe(user => {
        this.autUser.setAuthUser(user);
      }, () => {
        this.toastr.error('Что-то пошло не так');
      }, () => {
        this.toastr.success('Вы удалили товар из истории покупок!');
      });
  }

  isRole(): boolean {
    return this.autUser.isRole();
  }
}
