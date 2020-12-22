export class Service {

  id: number;
  price: number;
  serviceDescription: string;
  serviceName: string;
  countUsers: number;
  picturePath: string;

  static cloneBase(service: Service): Service {
    const clonedService: Service = new Service();
    clonedService.id = service.id;
    clonedService.price = service.price;
    clonedService.serviceDescription = service.serviceDescription;
    clonedService.serviceName = service.serviceName;
    clonedService.picturePath = service.picturePath;
    return clonedService;
  }
}
