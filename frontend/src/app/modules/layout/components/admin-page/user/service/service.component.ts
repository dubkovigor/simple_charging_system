import {Component, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {Service} from '../../../../../models/service';
import {HttpService} from '../../../../../../services/http.service';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {Subscription} from 'rxjs';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {ModalService} from '../../../../../../services/ModalService';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit, OnDestroy {

  services: Service[] = [];
  subscriptions: Subscription[] = [];
  public newService: Service = new Service();
  public modalRef: BsModalRef;
  public editMode = false;
  fileToUpload: File = null;

  constructor(private httpService: HttpService, private loadingService: Ng4LoadingSpinnerService, private modalService: ModalService,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.httpService.getService().subscribe((data) => {
      this.services = data;
    }, (e) => console.log(e), () => {
      for (let i = 0; i < this.services.length; i++) {
        this.subscriptions.push(this.httpService.getUsersOnServCount(this.services[i].id).subscribe(value => {
          this.services[i].countUsers = value;
        }));
      }
    });
  }


  public deleteService(serviceId: number): void {
    this.loadingService.show();
    this.subscriptions.push(this.httpService.deleteService(serviceId).subscribe(() => {
      this.loadService();
      this.toastr.success('Товар удален');
    }));
  }

  public openModal(template: TemplateRef<any>, service: Service): void {

    if (service) {
      this.editMode = true;
      this.newService = Service.cloneBase(service);
    } else {
      this.refreshService();
      this.editMode = false;
    }

    this.modalService.openModal(template); // and when the user clicks on the button to open the popup
    // we keep the modal reference and pass the template local name to the modalService.
  }

  public createService(): void {
    this.loadingService.show();
    this.subscriptions.push(this.httpService.saveService(this.newService).subscribe(() => {
      this.updateService();
      this.refreshService();
      this.closeModal();
    }, () => this.toastr.error('Что-то пошло не так!!'),
      () => this.toastr.success('Операция выполнена!')
    ));
  }

  public closeModal(): void {
    this.modalService.closeModal();
  }

  public updateService(): void {
    this.loadService();
  }

  private refreshService(): void {
    this.newService = new Service();
  }

  private loadService(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.httpService.getService().subscribe(data => {
      // Parse json response into local array
      this.services = data;
      // Check data in console
      console.log(this.services);
    }));
  }

  localUrl: any[];
      showPreviewImage(event: any) {
          if (event.target.files && event.target.files[0]) {
              var reader = new FileReader();
              reader.onload = (event: any) => {
                  this.localUrl = event.target.result;
              }
              reader.readAsDataURL(event.target.files[0]);
          }
          console.log(reader.readAsDataURL(event.target.files[0]));
      }

      FilePathHandler(fileName) {

        console.log("Files :",fileName.target.value);
        console.log("Files :",this.newService.picturePath);
        var filename = (this.newService.picturePath).replace(/^.*\\/, "");
        console.log("Files :",filename);
      }

  ngOnDestroy(): void {
    this.subscriptions.forEach(value => value.unsubscribe());
  }
}
