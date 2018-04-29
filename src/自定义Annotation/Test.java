package 自定义Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
	
	/**
	 * 定义2个成员变量的Annotation
	 *Annotation中的成员变量以方法的形式定义
	 * @return
	 */
	String name();
	int age();
}
