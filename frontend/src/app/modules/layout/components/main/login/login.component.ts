import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpService} from '../../../../../services/http.service';
import {User} from '../../../../models/user';
import {ModalService} from '../../../../../services/ModalService';
import {AuthorizationService} from '../../../../../services/AuthorizationService';
import {TokenStorageService} from '../../../../../services/token-storage';
import {NgFlashMessageService} from 'ng-flash-messages';
import {ToastrService} from 'ngx-toastr';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputUser: User = new User();
  public editMode = false;

  constructor(private modalService: ModalService, private authService: AuthorizationService,
              private userService: HttpService, private tokenService: TokenStorageService,
              private toastr: ToastrService) {
  }

  ngOnInit() {
  }

  authorization() {
    this.authService.attemptAuth(this.inputUser).subscribe(data => {
      this.tokenService.saveToken(data.token);
      this.tokenService.saveLogin(data.login);
      this.tokenService.saveAuthorities(data.role);
    }, () => {

      this.toastr.error('Логин или пароль введены неверно. Попробуйте ещё раз.');

    }, () => {
      this.toastr.success('Вы авторизированы!');
      this.userService.getLoggedUser(this.tokenService.getLogin()).subscribe(data => {
        this.authService.setAuthUser(data);
        this.modalService.closeModal();
      });
    });
  }
}
