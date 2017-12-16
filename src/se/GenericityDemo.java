package se;
/**
 * 泛型，JDK1.5之后推出的新特性
 * 泛型又称为参数化类型：在创建该类实例时通过类似穿参的形式将泛型的实际类型指定。
 * @author liurenyou
 *
 */
public class GenericityDemo<T> {//若不指定则使用Object类型
	private T x;
	private T y;
	
	public GenericityDemo() {
		super();
	}
	public GenericityDemo(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "GenericityDemo [x=" + x + ", y=" + y + "]";
	}
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	
	public static void main(String[] args) {
		GenericityDemo<Integer> g = new GenericityDemo<Integer>(1,2);
		int i = g.getX();
		System.out.println("x(int):"+i);
		g.setY(1);
		System.out.println(g.toString());
		
		GenericityDemo<Double> g2 = new GenericityDemo<Double>(1.2,2.3);
		g2.setX(2.3);
		System.out.println(g2.toString());
		
		GenericityDemo<String> g3 = new GenericityDemo<String>("一","二");
		System.out.println(g3.toString());
	}
}
