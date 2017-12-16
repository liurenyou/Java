package entity;
/**
 * 测试Object方法的重写
 * @author liurenyou
 *
 */
public class Point implements Comparable<Point> {
	private int x;
	private int y;
	
	public Point() {
		super();
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/*
	 * 重写toString
	 * toString返回的字符串格式没有具体要求，可以根据开发情况而定
	 * 但原则上应当包含当前类的属性信息，可直观看到当前对象需要知道
	 * 的属性值
	 */
	public String toString() {
		return "("+x+","+y+")";
	}
	
	/*
	 * 重写equals
	 * 作用是比较当前对象与给定对象的内容是否一致
	 * 而==是比较是否为同一个对象
	 * equals是比较两个对象的属性值是否一致，可以不要求所有属性都
	 * 相同，可根据开发情况而定
	 */
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(o == this) {
			return true;
		}
		if(o instanceof Point) {
			Point p = (Point) o;
			return this.x == p.x && this.y == p.y;
		}
		return false;
	}
	
	/*
	 * 实现Comparable接口后必须实现下面的方法来定义比较大小的规则：
	 * 比较当前对象this与参与给定对象o比较，返回值只关注取值范围
	 * 返回值>0时：this比o大
	 * 返回值<0时：this比o小
	 * 返回值=0时：this等于o
	 * 
	 */
	public int compareTo(Point o) {
		/*
		 * 判断规则：比较点到原点的距离
		 */
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}
	
	public static void main(String[] args) {
		String str = new String("123");
		String str2 = new String("123");
		System.out.println(str==str2);//比较的是地址
		System.out.println(str.equals(str2));//比较的是对象的内容
	}
}
