package staticdemo;

public class Test {
	public static void main(String[] args) {
		Aoo o1 = new Aoo();
		o1.show();
		Aoo o2 = new Aoo();
		o2.show();
		System.out.println(Aoo.b);
		System.out.println(o1.b);

		Boo.test();

		Coo o3 = new Coo();
		Coo o4 = new Coo();
		Coo o5 = new Coo();
	}
}
