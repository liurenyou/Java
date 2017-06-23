package review02;

public class SuperDemo {
	public static void main(String[] args) {
		Coo o1 = new Doo();
		Boo o2 = new Boo();
	}
}

class Coo {
	int c;
	Coo(int c){
		this.c = c;
		System.out.println(c);
	}
}

class Doo extends Coo {
	Doo(){
		super(5);
	}
}

class Aoo {
	Aoo(){
		System.out.println("父类构造");
	}
}

class Boo extends Aoo {
	Boo(){
		super();
		System.out.println("子类构造");
	}
}
