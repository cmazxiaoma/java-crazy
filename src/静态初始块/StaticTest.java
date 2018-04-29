package 静态初始块;
/**
 * 
 * @author Administrator
 * 得出结论:
 * 在JVM第一次主动使用某一个类时，系统会在类准备阶段为该类的所有静态成员变量分配内存，在初始化阶段
 * 则负责初始化这些静态成员变量，初始化静态成员变量就是执行类初始化代码或者声明类成员变量时指定的初始值，
 * 他们的执行顺序与源代码中的排序顺序相同。
 *
 */
public class StaticTest {

	static{
		a=6;
	}
	
	public static int a=9;
	public static void main(String[] args){
		System.out.println(StaticTest.a);
	}

}
