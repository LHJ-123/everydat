
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Rules {

    private ArrayList condition;
    private String result;
    private int is_temp;
    private int is_use = 0;

    Rules() {
        condition = new ArrayList();
    }

    public ArrayList getCondition() {
        return condition;
    }

    public void setCondition(ArrayList condition) {
        this.condition = condition;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getIs_temp() {
        return is_temp;
    }

    public void setIs_temp(int is_temp) {
        this.is_temp = is_temp;
    }

    public int getIs_use() {
        return is_use;
    }

    public void setIs_use(int is_use) {
        this.is_use = is_use;
    }

    public static Rules[] r = new Rules[10];
    public static Rules[] RuleInit() {
        Rules rule0 = new Rules();
        r[0] = rule0;
        ArrayList c0 = new ArrayList();
        c0.add("体型小");
        c0.add("有轮子");
        r[0].setCondition(c0);
        r[0].setResult("车");
        r[0].setIs_temp(1);
        Rules rule1 = new Rules();
        r[1] = rule1;
        ArrayList c1 = new ArrayList();
        c1.add("体型大");
        c1.add("流线型");
        r[1].setCondition(c1);
        r[1].setResult("飞机");
        r[1].setIs_temp(1);
        Rules rule2 = new Rules();
        r[2] = rule2;
        ArrayList c2 = new ArrayList();
        c2.add("天上飞的");
        r[2].setCondition(c2);
        r[2].setResult("飞机");
        r[2].setIs_temp(1);
        Rules rule3 = new Rules();
        r[3] = rule3;
        ArrayList c3 = new ArrayList();
        c3.add("水上游的");
        r[3].setCondition(c3);
        r[3].setResult("船");
        r[3].setIs_temp(1);
        Rules rule4 = new Rules();
        r[4] = rule4;
        ArrayList c4 = new ArrayList();
        c4.add("地上跑的");
        r[4].setCondition(c4);
        r[4].setResult("车");
        r[4].setIs_temp(1);
        Rules rule5 = new Rules();
        r[5] = rule5;
        ArrayList c5 = new ArrayList();
        c5.add("体型大");
        c5.add("冒黑烟");
        c5.add("船");
        r[5].setCondition(c5);
        r[5].setResult("轮船");
        r[5].setIs_temp(0);
        Rules rule6 = new Rules();
        r[6] = rule6;
        ArrayList c6 = new ArrayList();
        c6.add("飞机");
        c6.add("有机翼");
        r[6].setCondition(c6);
        r[6].setResult("航天飞机");
        r[6].setIs_temp(0);
        Rules rule7 = new Rules();
        r[7] = rule7;
        ArrayList c7 = new ArrayList();
        c7.add("飞机");
        c7.add("有螺旋桨");
        r[7].setCondition(c7);
        r[7].setResult("直升机");
        r[7].setIs_temp(0);
        Rules rule8 = new Rules();
        r[8] = rule8;
        ArrayList c8 = new ArrayList();
        c8.add("车");
        c8.add("四个轮");
        r[8].setCondition(c8);
        r[8].setResult("汽车");
        r[8].setIs_temp(0);
        Rules rule9 = new Rules();
        r[9] = rule9;
        ArrayList c9 = new ArrayList();
        c9.add("车");
        c9.add("两个轮");
        r[9].setCondition(c9);
        r[9].setResult("两轮车");
        r[9].setIs_temp(0);
        return r;
    }

    @Override
    public String toString() {
        return "Rules{" +
                "condition=" + condition +
                ", result='" + result + '\'' +
                ", is_temp=" + is_temp +
                ", is_use=" + is_use +
                '}'+"\n";
    }
    public static String Judge(String s,Rules[] rules) {
        //地上跑的，四个轮
        for (int i = 0;i<rules.length;i++) {
            if (rules[i].getIs_use() == 0) {
                String s1 = rules[i].getCondition().toString().replace("[","");
                s1 = s1.replace("]","");

                String[] arr = s1.split(", ");
                boolean tmp = true;
                for (int x = 0;x<arr.length;x++) {
                    if (s.contains(arr[x])) {
                        continue;
                    }
                    tmp = false;
                }
               if (tmp) {
                   s = s+", "+rules[i].getResult();
                   rules[i].setIs_use(1);
                   if (rules[i].getIs_temp() == 0) {
                       return s;
                   }else {
                       i = 0;
                       continue;
                   }
               }else {
                   continue;
               }
            }
        }
        return "未找到";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Rules.RuleInit();
        if (s.equals("体型小，两个轮")) {
            s = "体型小, 有轮子, 两个轮";
        }
        if (s.equals("体型小，四个轮")) {
            s = "体型小, 有轮子, 四个轮";
        }
        String judge = Rules.Judge(s, Rules.r);
        String[] arr = judge.split(", ");
        System.out.println(arr[arr.length-1]);
    }
}