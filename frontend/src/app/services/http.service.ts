import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../modules/models/user';
import {Service} from '../modules/models/service';
import {Wallet} from '../modules/models/wallet';
import {Billingaccount} from '../modules/models/billingaccount';
import {Autreguser} from '../modules/models/autreguser';

@Injectable({
  providedIn: 'root'
})

export class HttpService {
  constructor(private http: HttpClient) {
  }

  subscribeUser(autUser: Autreguser, service: Service): Observable<User> {
    console.log(service.id);
    return this.http.post<User>('http://localhost:8082/api/user/join?service_id=' + service.id, autUser);
  }

  unsubscribeUser(autUser: Autreguser, service: Service): Observable<User> {
    console.log(service.id);
    return this.http.post<User>('http://localhost:8082/api/user/refuse?service_id=' + service.id, autUser);
  }

  deleteService(serviceId: number): Observable<void> {
    return this.http.delete<void>('http://localhost:8082/api/service/delete/' + serviceId);
  }

  deleteUser(userId: number): Observable<void> {
    return this.http.delete<void>('http://localhost:8082/api/user/' + userId);
  }

  public getLoggedUser(login: string): Observable<User> {
    return this.http.post<User>('http://localhost:8082/api/user/login', login);
  }

  getService(): Observable<Service[]> {
    return this.http.get<Service[]>('http://localhost:8082/api/service');
  }

  saveService(service: Service): Observable<Service> {
    return this.http.post<Service>('http://localhost:8082/api/service', service);
  }

  getWallet(): Observable<Wallet[]> {
    return this.http.get<Wallet[]>('http://localhost:8082/api/wallet');
  }

  getUsersOnServCount(id: number): Observable<number> {
    return this.http.get<number>('http://localhost:8080/api/service/count/' + id);
  }

  getBA(): Observable<Billingaccount[]> {
    return this.http.get<Billingaccount[]>('http://localhost:8082/api/ba');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8082/api/user', user);
  }

  saveWallet(wallet: Wallet): Observable<Wallet> {
    return this.http.post<Wallet>('http://localhost:8082/api/wallet', wallet);
  }

  getUser(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8082/api/user');
  }
}
