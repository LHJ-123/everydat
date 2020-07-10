import java.util.Scanner;

class Resource {
    //资源种类数
    int m = 0;
    //进程个数
    int n = 0;
    int[] available = null;
    int[][] max = null;
    int[][] allocation = null;
    int[][] need = null;
    int[] available1 = null ;
    int[][] max1 = null;
    int[][] allocation1 = null;
    int[][] need1 = null;

    public Resource() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入资源种类数->");
        m = scanner.nextInt();
        System.out.println("请输入进程个数->");
        n = scanner.nextInt();
        available = new int[m];
        max = new int[n][m];
        allocation = new int[n][m];
        need = new int[n][m];
        available1 = new int[m];
        max1 = new int[n][m];
        allocation1 = new int[n][m];
        need1 = new int[n][m];
        System.out.println("请设置当前可用资源数->");
        for(int i = 0;i<available.length;i++) {
            available[i] = scanner.nextInt();
            available1[i] = available[i];
        }
        System.out.println("请设置最大需求数->");
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<m;j++) {
                max[i][j] = scanner.nextInt();
                max1[i][j] = max[i][j];
            }
        }
        System.out.println("请设置已分配资源数->");
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<m;j++) {
                allocation[i][j] = scanner.nextInt();
                allocation1[i][j] = allocation[i][j];
            }
        }
        //还需资源数
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<m;j++) {
                need[i][j] = max[i][j]-allocation[i][j];
                need1[i][j] = need[i][j];
            }
        }

        display(available,max,allocation,need);
        System.out.println("================");
        System.out.println("请输入发出请求的进程号:");
        int i = scanner.nextInt();
        System.out.println("请输入需要的资源种类:");
        int j = scanner.nextInt();
        int[][] request = new int[n][m];
        System.out.println("请输入需要这种资源多少个:");
        int k = scanner.nextInt();
        request[i][j] = k;

        TryDist(request[i][j],i,j);
        //display(available,max,allocation,need);
    }

    public void TryDist(int a,int i,int j) {
      if (a>need[i][j]) {
          System.out.println("所需资源数超过所宣布最大值");
          return;
      }
      if (a>available[j]) {
          System.out.println("尚没有足够资源去分配");
          return;
      }
      available[j] = available[j]-a;
      allocation[i][j] = allocation[i][j]+a;
      need[i][j] = need[i][j]-a;
      int[] work = new int[m];
      for (int x4 = 0;x4<m;x4++) {
          work[x4] = available[x4];
      }
      boolean[] Finish = new boolean[n];
      for (int x3 = 0;x3<n;x3++) {
          Finish[x3] = false;
      }
      for (int x1 = 0;x1<n;x1++) {
          if (Finish[x1] == false) {
                  if (work[j]>=need[x1][j]) {
                   work[j] = allocation[i][j]+work[j];
                   Finish[x1] = true;
                   x1 = 0;
                  }else {
                      continue;
                  }
          }else {
              continue;
          }
      }
        for (int x3 = 0;x3<n;x3++) {
            if(Finish[x3] == true) {
                continue;
            }else {
                System.out.println("系统不安全");
                restore(n,m);
                return;
            }
        }
        System.out.println("系统安全");
    }

    public void restore(int n,int m) {
        for (int i = 0;i<m;i++) {
            available[i] = available1[i];
        }
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<m;j++) {
                max[i][j] = max1[i][j];
                allocation[i][j] = allocation1[i][j];
                need[i][j] = need1[i][j];
            }
        }
    }

    public void display(int[] a,int[][] b,int[][] c,int[][] d) {
        System.out.println("可用资源数为:");
        for(int i = 0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("最大资源需求数为:");
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<m;j++) {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("已分配资源数为:");
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<m;j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("还需资源数为:");
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<m;j++) {
                System.out.print(d[i][j]+" ");
            }
            System.out.println();
        }
    }
}
public class TestBanker {
    public static void main(String[] args) {

        Resource resource = new Resource();
    }
}
