package 使用注解绑定事监听器;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

public class ActionListenerInstaller {
	
	//处理Annotation的方法,其中obj是包含Annotation的对象
	public static void processAnnotation(Object obj){
		try{
			//获取obj对象的类
			Class class1=obj.getClass();
			//获取指定obj对象的所有成员变量，并遍历每个成员变量
			for(Field f:class1.getDeclaredFields()){
				
				System.out.println("f="+f);
				
				//将该成员变量设置成可自由访问
				f.setAccessible(true);
				//获取该成员变量上ActionListenerFor类型的Annotation
				ActionListenerFor a=f.getAnnotation(ActionListenerFor.class);
				
				//获取成员变量f的值
				Object object=f.get(obj);
				
				System.out.println("object="+object);
				
				if(a!=null&&object!=null&&object instanceof AbstractButton){
					
					//获取a注解里的listener元数据
					Class<? extends ActionListener> listenerClass=a.listener();
					System.out.println("listener="+listenerClass);
					
//					//使用反射来创建listener类的对象
//					ActionListener a1=listenerClass.newInstance();
					ActionListener a1=listenerClass.getConstructor(String.class).newInstance("我是小马哥");
					
					System.out.println("a1="+a1);
					AbstractButton ab=(AbstractButton) object;
					System.out.println("ab="+ab.toString());
					ab.addActionListener(a1);
				}	
			}
		}catch(Exception e){
			
		}
	}
}
