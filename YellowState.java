package bank;
// 黄色状态类：具体状态类
public class YellowState extends AccountState{
    public YellowState(AccountState state) {
        this.balance = state.balance;
        this.account = state.account;
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
        if(balance>=0){
            account.setState(new GreenState(this));
        }else if(balance<-1000){
            account.setState(new RedState(this));
        }
    }

}