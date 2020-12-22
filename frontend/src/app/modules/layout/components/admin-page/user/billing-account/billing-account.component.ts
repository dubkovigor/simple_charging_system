import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from '../../../../../models/user';
import {Wallet} from '../../../../../models/wallet';
import {HttpService} from '../../../../../../services/http.service';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {Subscription} from 'rxjs/internal/Subscription';
import {Service} from '../../../../../models/service';
import {ModalService} from '../../../../../../services/ModalService';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-billing-account',
  templateUrl: './billing-account.component.html',
  styleUrls: ['./billing-account.component.css']
})
export class BillingAccountComponent implements OnInit {


  selectedUser: User = new User();
  users: User[] = [];
  wallets: Wallet[] = [];
  services: Service[] = [];
  subscriptions: Subscription[] = [];

  constructor(private httpService: HttpService, private modalService: ModalService,
              private loadingService: Ng4LoadingSpinnerService, private toastr: ToastrService) {
  }

  public _updateUser(): void {
    this.loadUser();
  }

  public _deleteUser(userId: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.httpService.deleteUser(userId).subscribe(() => {
      this.loadUser();
      this.toastr.success('Пользователь удален!');
    }));
  }

  public openModal(template: TemplateRef<any>, user: User): void {
    this.selectedUser = user;
    this.modalService.openModal(template); // and when the user clicks on the button to open the popup
    // we keep the modal reference and pass the template local name to the modalService.
  }

  private loadUser(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.httpService.getUser().subscribe(data => {
      // Parse json response into local array
      this.users = data;
      // Check data in console
      console.log(this.users);
    }));
  }


  ngOnInit() {
    // this.httpService.getUser().subscribe((data) => this.users = data);
    this.httpService.getWallet()
      .subscribe((data1) => this.wallets = data1, (e) => console.log(e));
    this.httpService.getUser()
      .subscribe((data) =>
        this.users = data, (e) => console.log(e));
  }
}
