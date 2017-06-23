package staticdemo;

public class Boo {

	int a;
	static int b;

	void show() {
		System.out.println(a);
		System.out.println(b);
	}

	static void test() {
		// System.out.println(a);//编译错误 实例变量a必须通过对象来访问 静态方法不能直接访问实例成员
		System.out.println(b);
	}

}
