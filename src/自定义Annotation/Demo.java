package 自定义Annotation;

import java.lang.annotation.Annotation;

public class Demo {
	
	public static void main(String[]args){
		
		//获取xiaoma类的info方法的所有注解
		Annotation[] annotations;
		try{
			
			annotations=Class.forName("自定义Annotation.xiaoma").getMethod("lovemjl").getAnnotations();
		}catch(Exception e){
			throw new RuntimeException("反射错误");
		}
		
		for(Annotation a:annotations){
			if(a instanceof Test){
				System.out.println(a);
				System.out.println(((Test) a).name());
				System.out.println(((Test) a).age());
			}
		}
		
	}

}
