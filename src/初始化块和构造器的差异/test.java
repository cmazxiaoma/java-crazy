package 初始化块和构造器的差异;
/**
 * 
 * @author Administrator
 * 当java创建了一个对象时，系统先为对象的所有实例变量分配内存(前提类的字节码被jvm加载到内存中)，接着
 * 程序开始对这些实例变量执行初始化，其初始化顺序是:先执行初始化块或者声明实例变量时指定的初始值(这2个
 * 地方指定初始值的执行允许与它们在源代码中排列顺序相同),再执行构造器里指定的初始值。
 *
 */
public class test {
	{
		a=6;
	}
	
	private int a=9;
	
	public static void main(String[] args){
		//输出9
		System.out.println(new test().a);
	}

}
