import {Component, OnInit} from '@angular/core';
import {ModalService} from '../../../../../services/ModalService';
import {AuthorizationService} from '../../../../../services/AuthorizationService';
import {User} from '../../../../models/user';
import {TokenStorageService} from '../../../../../services/token-storage';

@Component({
  selector: 'app-header-main',
  templateUrl: './header-main.component.html',
  styleUrls: ['./header-main.component.css']
})
export class HeaderMainComponent implements OnInit {


  authUser: User = new User();

  constructor(private modalService: ModalService, private autUser: AuthorizationService, private tokenService: TokenStorageService) {
  }

  ngOnInit() {
    console.log(this.autUser)
    this.getAuthUser();
  }

  outFromAccount() {
    this.tokenService.signOut();
    this.autUser.outFromAccount();
    this.getAuthUser();
  }

  isRole(): boolean {
    return this.autUser.isRole();
  }

  getAuthUser() {
    this.autUser.subscribeToAuthUser().subscribe(value => {
      this.authUser = value;
    });
    this.autUser.getAuthUser();
  }

}
