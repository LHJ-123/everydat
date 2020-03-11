/*public class TestDemo {
	public static void main(String[] args) {
		int a = 10;
		System.out.println("a = " + a);
	}
}*/
/*public class TestDemo {
	public static void main(String[] args) {
		char c = '高';
		System.out.println(c);
	}
}*/
/*public class TestDemo {
	public static void main(String[] args) {*/
		/*byte b = 12;
		System.out.println(b);
		int a = Integer.MAX_VALUE;
		System.out.println(a);
		System.out.println(Integer.MAX_VALUE+1);*/
		/*boolean x = true;
		System.out.println(x);
		String s =  "abcdef";
		System.out.println(s);*/
		/*int a = 10;
		System.out.println("a = " + a);
		int c = 20;
		System.out.println( a + c);
		System.out.println("a+c = " + a + c);
		System.out.println("a+c = " + a + " " + c);*/
/*		String s = "\"hello\"";
		System.out.println(s);
		final int B = 200;
		System.out.println(B);
}

	}*/
/*	public class TestDemo {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(a);
		System.out.println(b);
		int t = 0;
		t =a;
		a = b;
		b = t;
		System.out.println(a);
		System.out.println(b);
	}
}*/
public class TestDemo {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 30;
		int t = 0;
		if(a > b)
		{
			t = a;
			a = b;
			b = t;

		}
		if(b > c)
		{
			t = b;
			b = c;
			c = t;

		}
		System.out.println("最大值为" + c);
		System.out.println("最小值为" + a);
		}
}
