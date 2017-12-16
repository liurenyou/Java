package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 该Person类用于测试对象流读写的实例 当一个类的实例希望被ObjectOutputStream写出 那么该类必须实现Serializable接口
 * 
 * Serializable可序列化接口 
 * 序列化:将一个数据结构转换为一组字节的过程
 * 
 * @author liurenyou
 *
 */
public class Person implements Serializable {

	/**
	 * 当一个类实现了Serializable接口后，应当定义一个常量:版本号 版本号决定着对象反序列化的成功与否，反序列化的对象的版本号
	 * 与当前对象的版本号一致时，反序列化才会成功，否则一定失败。 若不定义版本号，该对象也会有默认的版本号，默认版本号是根据
	 * 当前类的结构生成的，只要当前类的内容发生改变版本号也会改变 所以一般都是自行维护版本号，这样才能决定反序列化的成功与否
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * transient关键字 transient关键字修饰属性，作用是在当前对象进行序列化时该属性 被忽略，从而达到对象序列化时的"瘦身"工作
	 */
	private transient List<String> otherInfo;

	public Person(String name, int age, String gender, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

}
