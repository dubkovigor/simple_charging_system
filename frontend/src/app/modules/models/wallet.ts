export class Wallet {
  id: number;
  amount: number;

  static cloneWallet(wallet: Wallet): Wallet {
    const cloneWallet: Wallet = new Wallet();
    cloneWallet.id = wallet.id;
    cloneWallet.amount = wallet.amount;
    return cloneWallet;
  }
}


