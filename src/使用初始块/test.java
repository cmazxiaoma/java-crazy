package 使用初始块;
/**
 * 
 * @author Administrator
 * 得出结论:
 * 当创建java对象时，系统总是想调用该类里面定义的初始化块，如果一个类里定义了2个普通代码块，
 * 则前面定义的初始化块先执行，后面定义的初始化块后执行。
 *
 */
public class test {
	
	public static void main(String[] args){
		new test();
	}
	
	{
		int a=6;
		if(a>4){
			System.out.println("test初始化块,局部变量a的值大于4");
		}
	}
	
	{
		System.out.println("test类的第二个初始化块");
	}
	
	public test(){
		System.out.println("test类的无参数构造器");
	}

}
