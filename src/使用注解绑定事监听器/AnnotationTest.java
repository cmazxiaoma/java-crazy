package 使用注解绑定事监听器;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AnnotationTest {
	
	private JFrame mainFrame=new JFrame("使用注解绑定事件监听器");
	
	@ActionListenerFor(listener=OkListener.class)
	private JButton ok=new JButton("确定");
	
	@ActionListenerFor(listener=CancelListener.class)
	private JButton cancel=new JButton("取消");
	
	
	public void init(){
		//初始化界面的方法
		JPanel jp=new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainFrame.add(jp);
		/**
		 * ActionListenerInstaller类来处理本程序的注解，该处理器分析目标对象中的所有成员变量
		 * 如果该成员变量前使用了@ActionListenerFor修饰，则取出Annotation中的listener元数据
		 * 并且根据该数据来绑定事件监听器
		 */
		
		ActionListenerInstaller.processAnnotation(this);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}
	
	
	public static void main(String[] args){
		AnnotationTest test=new AnnotationTest();
		test.init();
	}
	
	public static class OkListener implements ActionListener{
		private String params;
		 public OkListener(String params) {
			// TODO Auto-generated constructor stub
			 this.params=params;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null,"单击了确认按钮,params="+params);
		}
	}
	
	public static class CancelListener implements ActionListener{
		private String params;
		 public CancelListener(String params) {
			// TODO Auto-generated constructor stub
			 this.params=params;
		}
		 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null,"单击了取消按钮,params="+params);
			
		}
		
	}
}
