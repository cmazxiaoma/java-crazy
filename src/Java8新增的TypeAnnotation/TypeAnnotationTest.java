package Java8新增的TypeAnnotation;

import java.awt.List;
import java.io.Serializable;

/**
 * 允许在如下位置使用TypeAnnotation
 * 创建对象(用new运算符)
 * 强制类型转换
 * 使用implements实现接口
 * 使用throws 声明抛出异常
 * 
 * 但是这些注解暂时不会起任何作用，因为没有为这些注解提供处理工具
 * 而且Java8 本身并没有提供对 Type Annotation执行检查的框架
 * @author Administrator
 *
 */
@NotNull
public class TypeAnnotationTest implements @NotNull Serializable{
	
	public static void main(@NotNull String[] args){
		
		
		Object object="Cmazxiaoma";
		
		String string=(@NotNull String) object;
		
		System.out.println("string="+string);
		
		String str=new @NotNull String("我不想改变世界，我只想不被世界改变");
		System.out.println("str="+str);
	}
	
	public void m(@NotNull List list){
	
	}
	
	
	
	

}
