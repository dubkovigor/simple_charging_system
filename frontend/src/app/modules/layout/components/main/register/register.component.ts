import { Component, OnInit } from '@angular/core';
import {User} from '../../../../models/user';
import {HttpService} from '../../../../../services/http.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {ModalService} from '../../../../../services/ModalService';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  repeatPassword: string;
  constructor(private httpService: HttpService, private router: Router, private modalService: ModalService, private toastr: ToastrService) { }

  saveUser() {
    if (this.user.password === this.repeatPassword  ) {
      console.log(this.user);
      this.httpService.saveUser(this.user)
        .subscribe((data) => {
          console.log(data);
          this.router.navigateByUrl('/main');
          this.toastr.success('Вы зарегистрированы!');
          this.modalService.closeModal();
        },() => {
        this.toastr.error("Что-то пошло не так :(");});
    } else {
      this.toastr.info('Проверьте данные еще раз');
    }
  }

  ngOnInit() {

  }

}
