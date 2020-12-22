import {Injectable} from '@angular/core';
import {User} from '../modules/models/user';
import {Observable, Subject} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {Service} from '../modules/models/service';
import {AuthToken} from '../modules/models/auth-token';

// import {Autreguser} from '../modules/models/autreguser';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  private autUser: User = new User();

  private subject = new Subject<User>();

  private path = '/api/auth';

  constructor(private http: HttpClient) {
  }

  public setAuthUser(user: User) {
    this.autUser = user;
    this.getAuthUser();
  }

  public getAuthUser() {
    this.subject.next(this.autUser);
  }

  public subscribeToAuthUser(): Observable<User> {
    return this.subject.asObservable();
  }

  attemptAuth(user: User): Observable<AuthToken> {
    return this.http.post<AuthToken>('http://localhost:8082/api/token/login', user);
  }

  public outFromAccount() {
    this.autUser = new User();
    this.subject.next(this.autUser);
  }

  public isRole(): boolean {
    if (typeof this.autUser.role === 'undefined') {
      return false;
    }
    return true;
  }
}
