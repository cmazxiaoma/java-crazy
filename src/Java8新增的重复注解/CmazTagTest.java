package Java8新增的重复注解;


/**
 * 
 * 多个重复注解其实会被作为 容器注解的value成员变量的数组元素
 * 
 * @author Administrator
 *
 */

@CmazTag(name="wutao", age=21)
@CmazTag(name="majinlan",age=22)
public class CmazTagTest {
	
	
	public  static void main(String[] args){
		
		
		Class<CmazTagTest> clazz=CmazTagTest.class;
		CmazTags cmazTags=clazz.getDeclaredAnnotation(CmazTags.class);
		System.out.println(cmazTags);
		
		
		for(CmazTag c:cmazTags.value()){
			
			System.out.println("name="+c.name()+",age="+c.age());
		}
		
		
		CmazTag[] value=(CmazTag[]) clazz.getDeclaredAnnotationsByType(CmazTag.class);
		
		for(CmazTag v:value){
			
			System.out.println("name="+v.name()+",age="+v.age());
		}
		
		
	}

}
