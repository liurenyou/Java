package staticdemo;

public class Aoo {
	int a;
	static int b;

	Aoo() {
		a++;
		b++;
	}

	void show() {
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}
}
