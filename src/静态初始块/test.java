package 静态初始块;
/**
 * 
 * @author Administrator
 * 结论:类初始化阶段，先执行最顶层父类的静态初始化块，然后依次向下，直到执行到当前类的静态初始化块
 * 对象初始化阶段，先执行最顶层父类的初始化块，最顶层父类的构造器，然后依次向下，直到执行当前类的
 * 初始化块，当前类的构造器。
 * 
 * 难点:1.如果定义初始化块时使用了static修饰符，则这个初始化块就变成了静态初始化块，也称为类初始化块
 * 普通初始化块负责对对象的初始化，静态初始化块时对类的初始化。
 * 2。静态初始化块与类相关的，用于对整个类进行初始化处理，通常用于对类变量执行初始化处理。静态初始化块
 * 不能对实例变量进行初始化处理
 * 3.一旦Leaf类初始化成功后，Leaf类在该JVM里一直存在，因此当第二次创建Leaf实例时无需再次对Leaf类
 * 进行初始化了。
 * 
 * 
 * 
 *
 */
public class test {
	public static void main(String[] args){
		new Leaf();
		new Leaf();
	}
	
}

class Root{
	static{
		System.out.println("Root类的静态初始块");
	}
	{
		System.out.println("Root类的普通初始块");
	}
	public Root(){
		System.out.println("Root类的无参数的构造器");
	}
}

class Mid extends Root{
	static{
		System.out.println("Mid的静态初始化块");
	}
	{
		System.out.println("Mid的普通初始化块");
	}
	public Mid(){
		System.out.println("Mid的无参数的构造器");
	}
	public Mid(String msg){
		this();
		System.out.println("Mid的有参数的构造器,参数="+msg);
	}
}

class Leaf extends Mid{
	static{
		System.out.println("Leaf的静态初始化块");
	}
	
	{
		System.out.println("Leaf的普通的初始化块");
	}
	
	public Leaf(){
		super("烟火跟我都是越黑越灿烂");
		System.out.println("Leaf的无参数的构造器");
	
	}
}









