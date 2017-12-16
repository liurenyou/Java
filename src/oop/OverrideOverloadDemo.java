package oop;

public class OverrideOverloadDemo {
	public static void main(String[] args) {
		// 重载看引用，重写看对象
		Eo eo = new Eo();
		Co o = new Do();
		eo.test(o);
	}
}

class Eo {
	void test(Co o) {
		System.out.println("父型参数");
		o.show();
	}

	void test(Do o) {
		System.out.println("子型参数");
	}
}

class Co {
	void show() {
		System.out.println("父类show");
	}
}

class Do extends Co {
	void show() {
		System.out.println("子类show");
	}
}
