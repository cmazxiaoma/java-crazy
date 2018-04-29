package 强制类型转换;


public class NarrowConversion{
	
	public static void main(String[] args){
		int iValue=233;
		byte bValue=(byte)iValue;
		System.out.println(bValue);
		double dValue=3.98;
		int tol=(int)dValue;
		System.out.println(tol);
	}
}
