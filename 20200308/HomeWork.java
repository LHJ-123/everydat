import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
/*public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int rand = random.nextInt(100);
		while(true) {
			System.out.println("请输入你要猜的数字:");
			int num = scan.nextInt();
			if(num > rand) {
				System.out.println("你猜得数字大了");
			}else if(num < rand) {
				System.out.println("你猜得数字小了");
			}else {
				System.out.println("猜对了");
				break;
			}
		}
		System.out.println("游戏结束");

	}
}*/
/*public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i =2;
		if(n == 1) {
			System.out.println("1不是素数");
		}
		for( i = 2;i < n;i++) {
			if(n % i == 0) {
				break;
			}
		}
		if(i == n) {
			System.out.println(n + "是素数");
		}
	}
}*/
/*public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i =2;
		if(n == 1) {
			System.out.println("1不是素数");
		}
		for( i = 2;i <= n/2;i++) {
			if(n % i == 0) {
				break;
			}
		}
		if(i > n/2) {
			System.out.println(n + "是素数");
		}
	}
}*/
/*public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i =2;
		if(n == 1) {
			System.out.println("1不是素数");
		}
		for( i = 2;i <= Math.sqrt(n);i++) {
			if(n % i == 0) {
				break;
			}
		}
		if(i > Math.sqrt(n)) {
			System.out.println(n + "是素数");
		}
	}
}*/
/*public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 1;
		int j = 1;
		for(i = 1;i <= n;i++) {
			for(j = 1;j <= i;j++) {
				System.out.print(i + "*" + j + "=" + i*j + " ");
			}
			System.out.println();
		}

	}	
}*/
/*public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = a % b;
		while (c != 0) {
			a = b;
			b = c;
			c = a%b;
		}
		System.out.println(b);

		

	}	
}*/
public class HomeWork {
public static int  test2(int n) {
	if (n == 1) {
		return 1;
	}
	return n*test2(n-1);
}




	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num = test2(n);
		System.out.println(num);
		
	}	
}
