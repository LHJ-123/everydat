import java.util.Scanner;
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        int tmp = n;
        while(tmp!=0) {
            count++;
            tmp = tmp/10;
        }

        for(int i = 1;i<=count;i++) {
            int m = n%10;
            n = n/10;
            System.out.println(m);
        }
    }
}*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 3;
        System.out.println("请输入密码，您有3次机会！");
        while(count!=0) {
            System.out.println("请输入正确密码:");
            String password = scan.next();
            if(password.equals("123456")) {
                System.out.println("密码正确！");
                break;
            }else {
                count--;
                System.out.println("您还有" + count +"次机会！");

            }
        }
    }
}
*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        while(n!=0) {
            count++;
            n = n & (n-1);
        }
        System.out.println(count);
    }
}
*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 31;i>=1;i -= 2) {
            System.out.print(((n>>>i)&1) + " ");
        }
        System.out.println();
        for(int i = 30;i>=0;i -=2) {
            System.out.print(((n>>>i)&1) + " ");
        }
    }
}
*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        addSum(n);


    }
    public static void addSum (int n) {
        int sum = 0;
        for(int i = 1;i<=n;i++) {
            sum = sum+i;
        }
        System .out .println(sum);
    }
}
*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int x = max2(n,m);
        System .out .println(x);
    }
    public static int max2(int n,int m) {
        if(n > m) {
            return n;
        }else if(n < m) {
            return m;
        }else {
            return n;
        }
    }

}
*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int x = facSum(n);
        System .out .println(x);
    }
    public static int facSum(int n) {
        int sum = 0;
        for(int i = 1;i<=n;i++) {
            int ret = 1;
            for(int j = 1;j<=i;j++) {
                ret = ret*j;
            }
            sum = sum+ret;
        }
        return sum;
    }

}

*/
/*public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int x = fac(n);
        System .out .println(x);
    }
    public static int fac(int n) {
       if(n==1) {
           return 1;
       }
       return n*fac(n-1);
    }

}*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int x = facSum(n);
        System .out .println(x);
    }
    public static int facSum(int n) {
        int ret = 1;
            for(int j = 1;j<=n;j++) {
                ret = ret*j;
            }
            return ret;
    }

}

*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int b = scan.nextInt();
        int x = max2(n,m);
        int r = max3(n,m,b);
        System .out .println(x);
        System .out .println(r);
    }
    public static int max2(int n,int m) {
        if(n > m) {
            return n;
        }else if(n < m) {
            return m;
        }else {
            return n;
        }
    }
    public static int max3(int n,int m,int b) {
        int s = max2(n,m);
        if(s > b) {
            return s;
        }else if(s < b) {
            return b;
        }else {
            return b;
        }
    }

}
*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int x = fac(n);
        System .out .println(x);
    }
    public static int fac(int n) {
        if(n == 1||n == 2) {
            return 1;
        }
        return fac(n-2)+fac(n-1);
    }

}

*/
/*
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        double c = scan.nextInt();
        double d = scan.nextInt();
        int x1 = maxNum(a,b);
        double x2 = maxNum(c,d);

        double x3 = maxNum(a,c,d);
        System .out .println(x1);
        System .out .println(x2);
        System .out .println(x3);    }
    public static int maxNum (int a,int b) {
        if(a>b) {
            return a;
        }else if(a<b) {
            return b;
        }else {
            return b;
        }
    }
    public static double maxNum (double c,double d) {
        if(c>d) {
            return c;
        }else if(c<d) {
            return d;
        }else {
            return d;
        }
    }
    public static double maxNum (double c,double d,int a) {
        if(maxNum(c,d)>a) {
            return maxNum(c,d);
        }else if(maxNum(c,d)<a) {
            return a;
        }else {
            return a;
        }
    }


}

*/
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int x1 = numSum(a,b);
        System .out .println(x1);
        double c = scan.nextDouble();
        double d = scan.nextDouble();
        double e = scan.nextDouble();

        double x2 = numSum(c,d,e);

        System .out .println(x2);
    }
    public static int numSum (int a,int b) {
        return a+b;
    }
    public static double numSum (double c,double d,double e) {
        return c+d+e;
    }

}



