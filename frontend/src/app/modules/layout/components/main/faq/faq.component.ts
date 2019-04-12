import { Component, OnInit } from '@angular/core';
import { Faq} from '../../../../models/faq';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {

  faq: Faq = {

    payment: 'Оплата',
    paymentDescription: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium beatae asperiores debitis perspiciatis' +
      '  perferendis nemo tempore distinctio officia commodi et non tempora laudantium culpa nostrum, quidem, quasi ratione itaque nam.',
    information: 'Информация',
    informationDescription: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium beatae asperiores debitis perspiciatis' +
      '  perferendis nemo tempore distinctio officia commodi et non tempora laudantium culpa nostrum, quidem, quasi ratione itaque nam.',
    guarantee: 'Гарантии',
    guaranteeDescription: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium beatae asperiores debitis perspiciatis' +
      '  perferendis nemo tempore distinctio officia commodi et non tempora laudantium culpa nostrum, quidem, quasi ratione itaque nam.',
  };

  constructor() { }

  ngOnInit() {
  }

}
