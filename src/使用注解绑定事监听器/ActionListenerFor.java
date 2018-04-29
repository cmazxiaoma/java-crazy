package 使用注解绑定事监听器;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface ActionListenerFor {
	/**
	 * 定义一个成员变量，用于设置元数据
	 * 该listener成员变量用于保存监听器实现类
	 * 
	 */
	Class<? extends ActionListener> listener();
}
