import java.util.Scanner;
public class Main4{
    public static int MinChance(int x){
        if(x % 1000000007 == 0){
            return 0;
        }
        int count = 0;
        while (x != 0 && count <= 300000) {
            x = ((x << 1) + 1) % 1000000007;
            count++;
        }
        int res = (count + 2) / 3;
        return res > 100000 ? -1 : res;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int pop = in.nextInt();
            int nums = MinChance(pop);
            System.out.println(nums);
        }
    }
}