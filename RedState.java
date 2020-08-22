package bank;

//红色状态类：具体状态类
public class RedState extends AccountState{
    public RedState(AccountState state) {
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
        System.out.println("账户被冻结，取款失败");
    }
    @Override
    public void stateCheck() {
        if(balance>=0){
            account.setState(new GreenState(this));
        }else if(balance>=-1000){
            account.setState(new YellowState(this));
        }
    }
}