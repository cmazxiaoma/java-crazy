package 使用Annotation;

import java.lang.reflect.Method;

public class ProcessorTest {

	public static void Process(String clazz) throws SecurityException, ClassNotFoundException{
		int passed=0;
		int failed=0;
		//遍历clazz对应的类里所有的方法
		for(Method m:Class.forName(clazz).getMethods()){
			
			//如果该方法被Testable修饰
			if(m.isAnnotationPresent(Testable.class)){
				//调用m的方法
				try{
					m.invoke(null);
					passed++;
				}catch(Exception e){
					System.out.println("调用"+m+"方法运行出错，异常:"+e.getMessage());
					failed++;
				}
			}
		}
		
		System.out.println("共运行的方法数:"+(failed+passed));
		System.out.println("运行成功方法数:"+passed);
		System.out.println("运行失败方法数:"+failed);
	}
}
