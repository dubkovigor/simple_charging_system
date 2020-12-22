import {Injectable, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';


@Injectable({
    providedIn: 'root'
  }
)

export class ModalService {
  public modelRef: BsModalRef;

  constructor(private modalService: BsModalService) {
  }

  public openModal(template: TemplateRef<any>) {
    this.modelRef = this.modalService.show(template);
  }
  public closeModal() {
    this.modelRef.hide();
  }
}
