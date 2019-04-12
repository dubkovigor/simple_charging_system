import { Component, OnInit } from '@angular/core';
import { ConnectedService} from '../../../../models/connectedService';

@Component({
  selector: 'app-connected-services',
  templateUrl: './connected-services.component.html',
  styleUrls: ['./connected-services.component.css']
})
export class ConnectedServicesComponent implements OnInit {

  connectedService: ConnectedService = {

    nameService: 'Logger',
    descriptionService: 'fghjk',
    priceOfService: 10.5
  };
  constructor() { }

  ngOnInit() {
  }

}
