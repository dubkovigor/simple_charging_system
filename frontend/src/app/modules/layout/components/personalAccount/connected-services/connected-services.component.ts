import { Component, OnInit } from '@angular/core';
import { ConnectedService} from '../../../../models/connectedService';
import {Service} from "../../../../models/service";
import {HttpService} from "../../../../../services/http.service";
import {User} from "../../../../models/user";
import {PersonalData} from "../../../../models/personal-data";

@Component({
  selector: 'app-connected-services',
  templateUrl: './connected-services.component.html',
  styleUrls: ['./connected-services.component.css']
})
export class ConnectedServicesComponent implements OnInit {

  servs: Service[] = [];
  customers: PersonalData[] = [];

  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.httpService.getService().subscribe((data)=>this.servs=data);
    this.httpService.getCustomer().subscribe((data)=>this.customers = data);
  }

}
