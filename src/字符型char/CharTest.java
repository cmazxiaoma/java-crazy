package 字符型char;

public class CharTest {
	
	public static void main(String[] args){
		//直接指定单个字符作为字符值
		char aChar='a';
		//使用转义字符来作为字符值
		char enterChar='\r';
		//使用Unicode编码值来指定字符值
		char ch='\u9999';
		log(ch);
		//定义一个疯 字符值
		char zhong='疯';
		int  zhongValue=zhong;
		log(zhongValue);
		//直接把一个0-65535范围内的int整数赋给char变量
		char c=97;
		log(c);
		
	}
	
	public static void log(char  data){
		System.out.println(data);
	}
	
	public static void log(int data){
		System.out.println(data);
	}
}
