import { Component, OnInit } from '@angular/core';
import { Service } from '../../../../models/service';
import {HttpService} from "../../../../../services/http.service";

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {

  services: Service[] = [];

  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.httpService.getService()
      .subscribe((data) =>this.services=data);

  }

}
