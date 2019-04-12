import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {PersonalData} from "../modules/models/personal-data";
import {User} from "../modules/models/user";

@Injectable({
  providedIn: "root"
})

export class HttpService {
  constructor(private http: HttpClient){}

  getCustomer(): Observable<PersonalData[]>{
    return this.http.get<PersonalData[]>('http://localhost:8081/api/customer');
  }

  getUser(): Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8081/api/user');
  }
}
