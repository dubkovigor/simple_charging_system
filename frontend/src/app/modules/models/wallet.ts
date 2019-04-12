export class Wallet{

  purseNumber: number;
  amount: number;

  static cloneBase(wallet: Wallet): Wallet{
    let cloneWallet: Wallet = new Wallet();
    cloneWallet.amount = wallet.amount;
    cloneWallet.purseNumber = wallet.purseNumber;
    return cloneWallet;
  }
}


