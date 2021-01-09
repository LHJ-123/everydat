package Interface;



import serviceDao.MainInterfaceDeal;
import serviceDao.SettingColorDeal;

import javax.swing.*;
import java.awt.*;

public class ChildManagement extends JFrame {

    //设置窗体颜色的菜单
    public JMenuBar bar; //菜单栏
    public JMenu menu; //菜单
    public JMenuItem[] items; //菜单项

    //标签
    private JLabel label;
    //实现6个功能按钮
    private JButton[] jButtons;
    //放按钮的面板
    public JPanel panel;
    //容器
    public Container container;

    public ChildManagement() {
        this.setSize(800, 600);
        this.setTitle("幼儿园信息管理");
        this.setLayout(null);
        //初始化菜单
        initMenu();
        //初始化其他控件
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //点击一个关闭所有并退出程序
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
    }

    private void initMenu() {
        menu = new JMenu("设置窗体颜色");
        menu.setFont(new Font("", 1, 20));
        String[] colors = new String[] {"蓝色", "青色", "灰色", "绿色", "浅灰", "紫色","橘色", "粉色", "红色", "黄色"};
        items = new JMenuItem[colors.length];
        SettingColorDeal deal = new SettingColorDeal(this);
        for (int i = 0; i < colors.length; i++) {
            items[i] = new JMenuItem(colors[i]);
            items[i].addActionListener(deal);
            menu.add(items[i]);
        }
        bar = new JMenuBar();
        bar.add(menu);
        this.setJMenuBar(bar);
    }

    //添加控件
    private void init() {
        System.out.println(111);
        //添加标签
        label = new JLabel();
        label.setText("欢迎您来到阳光幼儿园信息管理系统");
        label.setFont(new Font("", 1, 30));
        label.setSize(600, 100);
        label.setLocation(140, 80);
        //this.add(label);
        //添加按钮
        panel = new JPanel();
        panel.setSize(400, 220);
        panel.setLocation(200, 230);
        panel.setLayout(new GridLayout(3, 2, 20, 40));
        jButtons = new JButton[5];
        String[] names = new String[] {"显示所有孩子", "查找具体孩子", "增加孩子信息",
                                      "修改孩子信息", "删除具体孩子"};
        //添加按钮 注册事件
        MainInterfaceDeal deal = new MainInterfaceDeal(this);
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(names[i]);
            jButtons[i].setFont(new Font("", Font.PLAIN, 20));
            //注册监听器
            jButtons[i].addActionListener(deal);
            panel.add(jButtons[i]);
        }
        //this.add(panel);
        container = this.getContentPane();
        container.add(label);
        container.add(panel);

    }
}
