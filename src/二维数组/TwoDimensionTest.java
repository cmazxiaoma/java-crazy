package 二维数组;

public class TwoDimensionTest {
	
	public static void main(String[] args){
		//定义一个二维数组
		int a[][];
		a=new int[4][];
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		//初始化a数组的第一个元素
		a[0]=new int[2];
		a[0][0]=1;
		a[0][1]=2;
		for(int j=0;j<a[0].length;j++){
			System.out.println(a[0][j]);
		}
	}

}
