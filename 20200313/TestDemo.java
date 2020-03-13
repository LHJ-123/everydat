import java.util.Scanner;
//n的阶乘  递归
/*
public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt() ;
        int x = fac(n);
        System .out.println(x);
    }
    public static int fac(int n) {
        if(n == 1) {
            return 1;
        }
        return n*fac(n-1);
    }
}*/

//正序输出:1 2 3  递归
/*
public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt() ;
         print(n);

    }
    public static void print(int n) {
        if(n > 9) {
            print(n/10);
        }
        System.out.println(n%10);;
    }
}*/

//输入非负数，返回组成它数字的和  递归
/*
public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt() ;
        int x = numSum(n);
        System.out.println(x);

    }
    public static int numSum(int n) {
        if(n < 10) {
            return n;
        }
        return n%10 + numSum(n/10);
    }
}
*/

//汉诺塔问题
/*public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        hanoi(n, 'A', 'B', 'C');
    }

    public static void move(char pos1, char pos3) {

        System.out.println(pos1 + "->" + pos3 + " ");
    }

    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            move(pos1, pos3);
             return;
        }
        hanoi(n - 1, pos1, pos3, pos2);
        move(pos1, pos3);
        hanoi(n - 1, pos2, pos1, pos3);
    }
}*/

/*
public class TestDemo {
    public static void main(String[] args) {

        int x = numSum(10);
        System.out.println(x);

    }
    public static int numSum(int n) {
        if(n == 1) {
            return 1;
        }

        return n+numSum(n-1);
    }
}

*/
/*
public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt() ;
        int x = fac(n);
        System.out.println(x);

    }
    public static int fac(int n) {
        if(n == 1) {
            return 1;
        }

        return n*fac(n-1);
    }
}*/

//青蛙跳台阶问题  递归
public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int x = fac(n);
        System.out.println(x);
    }

    public static int fac(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return fac(n - 2) + fac(n - 1);
        }

    }
}


