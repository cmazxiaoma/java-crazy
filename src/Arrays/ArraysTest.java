package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
	
	public static void main(String[] args){
		int[] a=new int[]{3,4,5,6};
		int[] a1=new int[]{3,4,5,6};
		System.out.println(Arrays.equals(a,a1));
		//List接口重写equlas()，比较2个list集合里面的数据是否完全相等
		List<String> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		list1.add("xiaoma");
		list1.add("mayday");
		list2.add("xiaoma");
		list2.add("mayday");
		System.out.println(list1.equals(list2));
		int[] b=Arrays.copyOf(a,6);
		System.out.println(b.equals(a));
		System.out.println(Arrays.toString(b));
		//包括2， 但是不包括4， 也就是说给下标2,3的元素赋值
		Arrays.fill(b, 2, 4,100);
		Arrays.fill(b,4,5,-100);
		Arrays.fill(b,5,6,-1000);
		System.out.println(Arrays.toString(b));
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
	}
}
