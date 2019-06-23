class A {
	{
		System.out.println("父类构造代码块");
	}
	A(){
		System.out.println("父类无参构造方法");
	}
	static {
		System.out.println("父类静态代码块");
	}
}
 
class B extends A{
	B(){
		System.out.println("子类构造方法");
	}
	{
		System.out.println("子类构造代码块");
	}
	static {
		System.out.println("子类静态代码块");
	}
}

public class Course0623 {
	public static void main(String[] args) {
	
	System.out.println("开始");
	//new A();
	new B();
	System.out.println("结束");
	}
}























































