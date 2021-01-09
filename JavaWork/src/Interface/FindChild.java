package Interface;


import serviceDao.FindOneChildDeal;
import serviceDao.SettingColorDeal;

import javax.swing.*;
import java.awt.*;


public class FindChild extends JFrame {

    private JLabel message;
    //编号
    private JLabel name;
    public JTextField nameText;
    private JButton ok;

    private JPanel panel;
    // 标签
    public JLabel[] labels;
    // 返回的信息
    public JLabel[] answers;

    public FindChild() {
        this.setSize(500, 600);
        this.setTitle("显示具体孩子信息");
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
        init();
    }

    private void init() {
        message = new JLabel();
        message.setSize(400, 30);
        message.setLocation(0, 0);
        message.setText("根据编号查找信息");
        message.setFont(new Font("", 0, 20));
        this.add(message);
        name = new JLabel("孩子姓名");
        name.setSize(100, 30);
        name.setLocation(0, 50);
        name.setFont(new Font("", 1, 20));
        nameText = new JTextField();
        nameText.setSize(100, 40);
        nameText.setLocation(110, 50);
        nameText.setFont(new Font("", 0, 20));
        ok = new JButton("查找");
        ok.setFont(new Font("", 1, 15));
        ok.setSize(100, 30);
        ok.setLocation(250, 50);
        FindOneChildDeal deal = new FindOneChildDeal(this);
        ok.addActionListener(deal);
        this.add(ok);
        this.add(name);
        this.add(nameText);

        //初始化标签
        panel = new JPanel();
        panel.setSize(350, 340);
        panel.setLocation(100, 140);
        if (SettingColorDeal.theme != null) {
            panel.setBackground(SettingColorDeal.theme);
        }
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        String[] names = new String[] {"孩子姓名", "孩子年龄", "性别", "班级", "班主任","在校状况"};
        labels = new JLabel[6];
        answers = new JLabel[6];
        for (int i = 0; i < names.length; i++) {
            labels[i] = new JLabel(names[i]);
            labels[i].setFont(new Font("", 1, 23));
            answers[i] = new JLabel();
            answers[i].setFont(new Font("", 0, 15));
            panel.add(labels[i]);
            panel.add(answers[i]);
        }
        this.add(panel);
    }
}
