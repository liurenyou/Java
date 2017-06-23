package staticdemo;

public class Coo {

	static {
		System.out.println("静态块");
	}

	Coo() {
		System.out.println("构造方法");
	}

}
