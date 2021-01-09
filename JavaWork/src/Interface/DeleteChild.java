package Interface;


import serviceDao.DeleteDeal;
import serviceDao.SettingColorDeal;

import javax.swing.*;
import java.awt.*;


public class DeleteChild extends JFrame {

    private JPanel panel;
    public JLabel name;
    public JTextField text;
    public JButton ok;

    public DeleteChild() {
        this.setSize(500, 400);
        this.setTitle("删除孩子");
        this.setLayout(null);
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
        init();
    }

    private void init() {
        //初始化面板
        panel = new JPanel();
        panel.setSize(300, 50);
        panel.setLocation(100, 50);
        if (SettingColorDeal.theme != null) {
            panel.setBackground(SettingColorDeal.theme);
        }
        panel.setLayout(new GridLayout(1, 2, 0, 10));
        //初始化控件
        name = new JLabel("孩子名称");
        name.setFont(new Font("", 1, 30));
        text = new JTextField();
        text.setFont(new Font("", 0, 20));
        panel.add(name);
        panel.add(text);
        this.add(panel);
        ok = new JButton("删除");
        ok.setSize(100, 60);
        ok.setLocation(250, 150);
        ok.setFont(new Font("", 1, 30));
        DeleteDeal deleteDeal = new DeleteDeal(this);
        ok.addActionListener(deleteDeal);
        this.add(ok);

    }
}
