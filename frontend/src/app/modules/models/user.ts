import {Service} from './service';
import {Billingaccount} from './billingaccount';
import {Role} from './role';

export class User {

  id: number;
  login: string;
  password: string;
  firstName: string;
  secondName: string;
  role: Role;
  ba_Id: Billingaccount;
  servs: Service[];

  static cloneUser(user: User): User {
    let cloneUser: User = new User();
    cloneUser.id = user.id;
    cloneUser.password = user.password;
    return cloneUser;
  }
}
