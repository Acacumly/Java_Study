package bank;

//绿色状态类：具体状态类
public class GreenState extends AccountState{
    public GreenState(AccountState state) {
        this.balance =state.balance;
        this.account = state.account;
    }

    public GreenState(double balance,Account account) {
        this.balance = balance;
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
        stateCheck();
    }

    @Override
    public void stateCheck() {
        if(balance>=-1000&&balance<0){
            account.setState(new YellowState(this));
        }else if(balance<-1000){
            account.setState(new RedState(this));
        }
    }
}