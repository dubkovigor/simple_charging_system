import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from './services/token-storage';
import {AuthorizationService} from './services/AuthorizationService';
import {HttpService} from './services/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Service';

  constructor(private tokenService: TokenStorageService, private authServie: AuthorizationService, private httpService: HttpService) {
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.httpService.getLoggedUser(this.tokenService.getLogin()).subscribe((data) => {
        this.authServie.setAuthUser(data);
      });
    }
  }
}
