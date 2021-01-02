
import java.util.Scanner;
public class Demo3{
    public static void main(String[] args) {

        System.out.println("请输入 S、K、L以表示该动物是属于水、空、陆中的其中一种");
        Scanner sc = new Scanner(System.in);
        String s = judge1(sc.nextLine());
        inferenceMachine(sc, s);				// 推理机
    }



    private static void inferenceMachine(Scanner sc, String s) {

        if(s.equals("S")) {
            System.out.println("请您摁下 GO 或者 END");
            String s12 = judge2(sc.nextLine());
            if (s12.equals("END")) {
                System.out.println("您要找的是：水生动物");
            } else {
                System.out.println("您所要查询的水生动物是否用肺呼吸（Y or N）");
                String s13 = judge0(sc.nextLine());
                if (s13.equals("Y")) {
                    System.out.println("请您摁下 GO 或者 END");
                    String s13_ = judge2(sc.nextLine());
                    if (s13_.equals("END")) {
                        System.out.println("您要找的是：鲸鱼");
                    } else {
                        System.out.println("您所要查询的用肺呼吸的水生动物是否有牙齿（Y or N）");
                        String s14 = judge0(sc.nextLine());
                        if (s14.equals("Y")) {
                            System.out.println("您要找的动物是：虎鲸");
                        } else {
                            System.out.println("您要找的动物是：须鲸");
                        }
                    }
                } else if (s13.equals("N")) {
                    System.out.println("您要找的是用腮呼吸的是：普通鱼");
                }
            }
        }else if(s.equals("K")) {
            System.out.println("请您摁下 GO or END");
            String s21 = judge2(sc.nextLine());
            if (s21.equals("GO")) {
                System.out.println("请问该空中动物是节肢动物吗？（Y or N）");
                String s21_ = judge0(sc.nextLine());
                if (s21_.equals("Y")) {
                    System.out.println("请您摁下 GO or END");
                    String s22 = judge2(sc.nextLine());
                    if (s22.equals("GO")) {
                        System.out.println("请问该空中飞行的节肢动物是害虫还是益虫：害虫为N，益虫为Y？");
                        String s22_ = judge0(sc.nextLine());
                        if (s22_.equals("Y")) {
                            System.out.println("您所查询的为：蜜蜂");
                        } else {
                            System.out.println("您所查询的为：蝗虫");
                        }
                    } else {
                        System.out.println("您输入的是：空中飞行的节肢动物");
                    }
                } else {
                    System.out.println("请您摁下 GO or END");
                    String s23 = judge2(sc.nextLine());
                    if (s23.equals("GO")) {
                        System.out.println("请问该空中飞行的非节肢动物能否模仿人类说话（Y or N）");
                        String s23_ = judge0(sc.nextLine());
                        if (s23_.equals("Y")) {
                            System.out.println("您所查询的是：鹦鹉");
                        } else {
                            System.out.println("您所查询的是：麻雀");
                        }
                    } else {
                        System.out.println("您输入的是：空中飞行的非节肢动物");
                    }
                }
            } else {
                System.out.println("您输入的是：空中动物");
            }
        }else if(s.equals("L")) {
            System.out.println("请您摁下 GO or END");
            String s21 = judge2(sc.nextLine());
            if (s21.equals("GO")) {
                System.out.println("请问该陆地动物是食肉动物还是食草动物 食肉用Y，食草用N？");
                String s21_ = judge0(sc.nextLine());
                if (s21_.equals("Y")) {
                    System.out.println("请您摁下 GO or END");
                    String s22 = judge2(sc.nextLine());
                    if (s22.equals("GO")) {
                        System.out.println("请问该动物是否为猫科动物？（Y or N）");
                        String s22_ = judge0(sc.nextLine());
                        if (s22_.equals("Y")) {
                            System.out.println("您所查询的为：老虎");
                        } else {
                            System.out.println("您所查询的为：狼");
                        }
                    } else {
                        System.out.println("您输入的是：陆地上的食肉动物");
                    }
                } else {
                    System.out.println("请您摁下 GO or END");
                    String s23 = judge2(sc.nextLine());
                    if (s23.equals("GO")) {
                        System.out.println("请问该动物是否有角（Y or N）");
                        String s23_ = judge0(sc.nextLine());
                        if (s23_.equals("Y")) {
                            System.out.println("您所查询的是：山羊");
                        } else {
                            System.out.println("您所查询的是：熊猫");
                        }
                    } else {
                        System.out.println("您输入的是：食草动物");
                    }
                }
            } else {
                System.out.println("您输入的是：陆地动物");
            }
        }else {
            System.out.println("程序运行出错了，请重新运行！！！");
        }
    }


    /*判断输入是否为 Y or N，若不是则循环采集正确格式*/
    public static String judge0(String s) {

        Scanner sc = new Scanner(System.in);
        while (!(s.equals("Y") || s.equals("N"))) {
            System.out.println("您输入的字母有误，请重新输入:Y, N");
            String ss = sc.nextLine();
            s = ss;
        }
        return s;
    }



    /*判断输入是否为 L、K or S，若不是则循环采集正确格式*/

    public static String judge1(String s) {

        Scanner sc = new Scanner(System.in);
        while (!(s.equals("L") || s.equals("K") || s.equals("S"))) {
            System.out.println("您输入的字母有误，请重新输入:L, K, S");
            String ss = sc.nextLine();
            s = ss;
        }
        return s;
    }




    /*判断输入是否为 END or GO，若不是则循环采集正确格式*/
    public static String judge2(String s) {

        Scanner sc = new Scanner(System.in);
        while (!(s.equals("END") || s.equals("GO"))) {
            System.out.println("您输入的指令有误，请重新输入:END or GO");
            String ss = sc.nextLine();
            s = ss;
        }
        return s;
    }
}