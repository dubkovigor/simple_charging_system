export class Autreguser {
  login: string;
  password: string;
  secondName: string;
  firstName: string;

  static cloneAutreguser(autreguser: Autreguser): Autreguser {
    const cloneAutreguser: Autreguser = new Autreguser();
    autreguser.login = autreguser.login;
    autreguser.password = autreguser.password;
    return cloneAutreguser;
  }
}
