package Java8新增的重复注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;




@Repeatable(CmazTags.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.TYPE)
public @interface CmazTag {
	
	
	String name();
	int age();
	
}
