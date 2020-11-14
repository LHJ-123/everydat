

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo extends JFrame{
    public static void main(String[] args) {
       Demo e=new Demo();
    }

    public Demo(){
        setTitle("My Frame");   //窗体名
        setSize(350,200);		//窗体大小
        Container c=getContentPane();
        c.setLayout(null);
        setLocation(800,500);   //设置窗体位置

        //顶部面板
        JPanel top=new JPanel();
        JPanel bot=new JPanel();
        JLabel l1=new JLabel("Sorce");
        l1.setFont(new Font("Times new roman", Font.BOLD, 18));  //设置字体样式
        JLabel l2=new JLabel("Target");
        l2.setFont(new Font("Times new roman", Font.BOLD, 18));
        JTextField t1=new JTextField(20);
        JTextField t2=new JTextField(20);
        top.add(l1);
        top.add(t1);
        top.add(l2);
        top.add(t2);
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.add(top);



        //添加按钮
        JButton jb1=new JButton("Clear");
        JButton jb2=new JButton("Copy");
        JButton jb3=new JButton("Close");
        bot.add(jb1);
        bot.add(jb2);
        bot.add(jb3);
        c.add(bot);

        //添加事件监听
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                t1.setText("");
                t2.setText("");
            }
        });
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str=t1.getText();
                t2.setText(str);
            }
        });
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
