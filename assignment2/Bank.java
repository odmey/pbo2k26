public class Bank {
    private double balance;
    private double deposit;
    private double withdraw;


    public Bank(){
        this.balance = 0;
        this.deposit = 0;
        this.withdraw = 0;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getDeposit(){
        return deposit;
    }
    public void setDeposit(double deposit){
        this.deposit = deposit;
    }
    
    public double getWithdraw(){
        return withdraw;
    }
    public void setWithdraw(double withdraw){
        this.withdraw = withdraw;
    }

    public double addDeposit(double deposit){
        balance = balance + deposit;
        return balance;
    }

    public double withdrawMoney(double w){
        return balance = balance - withdraw;
    }
    
}
