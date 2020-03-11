import java.util.Scanner;

/*public class TestDemo {
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n%2 == 0) {
			System.out.println("当前数是偶数！");

		}else {
			System.out.println("当前数是奇数！");
		}

	}
}*/



/*public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
		if(n%2 == 0) {
			System.out.println("当前数是偶数！");

		}else {
			System.out.println("当前数是奇数！");
		}


		}
		
	}
}
*/
/*public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		if(year%4==0 && year%100!=0 || year%400==0) {
			System.out.println("当前" + year + "是闰年!");
		}
		
	}
}
*/
/*public class TestDemo {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while (i<=100) {
			sum = sum + i;
			i = i + 2;
		}
		System.out.println(sum);
		
	}
}
*/


//求1！+2！+3！+......+n!
/*public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int j = 1;
		int sum = 0;
		while (j<=n) {
			int ret = 1;
			int i = 1;
			while (i<=j) {
				ret = ret*i;
				i++;
			}
			sum = sum +ret;
			j++;
		}
		System.out.println(sum);
	}
}*/
/*public class TestDemo {
	public static void main(String[] args) {
		int i = 1;
		int m = 0;
		int n = 0;
		for(i = 1;i<100;i++) {
			if(i%10==9 ) {
				m++;
			}
			if(i/10==9) {
				n++;
			}
		}
		System.out.println(m+n);
		
	}
}*/
/*public class TestDemo {
	public static void main(String[] args) {
		int year = 1000;
		for(year = 1000;year<=2000;year++) {
			if(year%4==0 && year%100!=0 || year%400==0) {
			System.out.print(year + " ");
		}

		}
		
		
	}
}*/
/*public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 2;
		for(i=2;i<=100;i++) {
			int n = 2;
			while(n<=i) {
				if(i%n!=0) {
					n++;
				} else {
					break;
				} 
			}
			if(i==n) {
				System.out.println(i);
			}

		}
	}
}*/
/*public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 2;
		while(i<=n) {
			if(n%i!=0) {
				i++;
			}else {
				break;
			}
		}
		if(n==i) {
			System.out.println(n + "是素数");
		}else {
			System.out.println(n + "不是素数");
		}
	}
}*/
/*public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n<=18) {
			System.out.println("少年");
		}else if(n>=19 && n<=28) {
			System.out.println("青年");
		}else if(n>=29 && n<=55) {
			System.out.println("中年");
		}else {
			System.out.println("老年");
		}
		
	}
}*/
/*public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int t = 0;
		if (a < b) {
			t = b;
			b = a;
			a = t;

		}
		while (a%b!=0) {
			t = a % b;
			a = b;
			b = t;
		}
		System.out.println(b);


		
		
	}
}
*/
/*public class TestDemo {
	public static void main(String[] args) {
		double sum1 = 0;
		int i = 1;
		for( i = 1;i<=99;i+=2) {
			sum1+=(1.0/i);
		}
		double sum2 = 0;
		int j = 2;
		for( j = 2;j<=100;j+=2) {
			sum2+=(1.0/j);
		}
		System.out.println(sum1-sum2);

		

		
		
	}
}
*/
/*import java.util.Random;
public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
	
		Random random = new Random();
            int m = random.nextInt(100);
		while (true) {
			if(n>m) {
			System.out.println("大于随机数");
		}
		if(n<m) {
			System.out.println("小于随机数");
		}
		if(n==m) {
			System.out.println("等于随机数");
			break;
		}

		}
		scan.nextInt.close();

		

		
		
	}
}*/
/*import java.util.Random; 
import java.util.Scanner;; 
 
class Test {  public static void main(String[] args) {   
Random random = new Random();
   Scanner sc = new Scanner(System.in); 
    int toGuess = random.nextInt(100);   
 System.out.println("toGuess: " + toGuess);  
  while (true) {    
  	System.out.println("请输入要输入的数字: (1-100)");  
  int num = sc.nextInt();  

  if (num < toGuess) {     
  	System.out.println("低了");    } else if (num > toGuess) {     
   System.out.println("高了");    } else {    
    System.out.println("猜对了");     
    break;    
}   
}   
sc.close(); 
 } 
} 

*/
/*import java.util.Random;
public class TestDemo {
	public static void main(String[] args) {
		int i = 100;
		for(i = 100;i<=999;i++) {
			if(Math.pow(i/100,3)+Math.pow(i/10%10,3)+Math.pow(i%10,3)==i) {
				System.out.println(i);
			}
		}	
		
	}
}*/
public class TestDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 0;
		while(n!=0) {
			if((n&1)==1) {
				i++;
			}
			n = n>>1;
		}
		System.out.println(i);
	}
}

