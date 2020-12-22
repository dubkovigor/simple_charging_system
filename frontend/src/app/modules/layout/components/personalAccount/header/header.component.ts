import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../../../../../services/token-storage';
import {AuthorizationService} from '../../../../../services/AuthorizationService';
import {User} from '../../../../models/user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  authUser: User = new User();

  constructor(private tokenService: TokenStorageService, private autUser: AuthorizationService, private router: Router) { }

  ngOnInit() {
  }

  outFromAccount() {
    this.tokenService.signOut();
    this.autUser.outFromAccount();
    this.getAuthUser();
    this.router.navigateByUrl('/main');
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
