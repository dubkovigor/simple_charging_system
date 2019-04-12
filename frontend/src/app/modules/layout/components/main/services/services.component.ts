import { Component, OnInit } from '@angular/core';
import { Service } from '../../../../models/services';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {

  service: Service = {

    nameService: 'Logger',
    descriptionService: 'Онлайн генератор логотипов и элементов фирменного стиля (new).',
    priceOfService: 6.99
  };
  constructor() { }

  ngOnInit() {
  }

}
