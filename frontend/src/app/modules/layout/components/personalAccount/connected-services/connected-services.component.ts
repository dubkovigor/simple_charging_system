import {Component, OnInit} from '@angular/core';
import {Service} from '../../../../models/service';
import {HttpService} from '../../../../../services/http.service';
import {AuthorizationService} from '../../../../../services/AuthorizationService';
import {User} from '../../../../models/user';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-connected-services',
  templateUrl: './connected-services.component.html',
  styleUrls: ['./connected-services.component.css']
})
export class ConnectedServicesComponent implements OnInit {

  servs: Service[] = [];
  authUser: User = new User();

  constructor(private httpService: HttpService, private  authService: AuthorizationService, private toastr: ToastrService) {
  }

  ngOnInit() {
    this.getAuthUser();
  }

  unsubscribeClick(service: Service) {
    this.httpService.unsubscribeUser(this.authUser, service)
      .subscribe(user => {
        this.authService.setAuthUser(user);
      }, () => this.toastr.error('Что-то пошло не так'),
        () => this.toastr.success('Товар удален из истории покупок', service.serviceName));
  }

  getAuthUser() {
    this.authService.subscribeToAuthUser().subscribe(value => {
      this.authUser = value;
    });
    this.authService.getAuthUser();
  }

  nameSubs(): string {
    let subs = '';
    this.authUser.servs.forEach(value => {
      subs += value.serviceName + ' , ';
    });
    return subs;
  }
}
