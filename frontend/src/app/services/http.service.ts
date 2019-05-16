import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PersonalData} from "../modules/models/personal-data";
import {User} from "../modules/models/user";
import {Service} from "../modules/models/service";
import {Wallet} from "../modules/models/wallet";
import {Billingaccount} from "../modules/models/billingaccount";

@Injectable({
  providedIn: "root"
})

export class HttpService {
  constructor(private http: HttpClient){}

  authUser(login: string, password: string): Observable<any> {
    console.log('authenfication');
    return this.http.get('http://localhost:8081/api/user/login=' + login + '&password=' + password);
  }

  getService(): Observable<Service[]>{
    return this.http.get<Service[]>('http://localhost:8081/api/service');
  }

  getWallet(): Observable<Wallet[]> {
    return this.http.get<Wallet[]>('http://localhost:8081/api/wallet');
  }

  getBA(): Observable<Billingaccount[]>{
    return this.http.get<Billingaccount[]>('http://localhost:8081/api/ba');
  }

  getCustomer(): Observable<PersonalData[]>{
    return this.http.get<PersonalData[]>('http://localhost:8081/api/customer');
  }
  saveCustomer(customer: PersonalData): Observable<PersonalData>{
    return this.http.post<PersonalData>('http://localhost:8081/api/customer', customer);
  }
  saveUser(user: User): Observable<User>{
    return this.http.post<User>('http://localhost:8081/api/user', user);
  }
  getUser(): Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8081/api/user');
  }
}
