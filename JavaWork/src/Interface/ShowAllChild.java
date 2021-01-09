package Interface;


import Dao.KinderGartenDao;
import Model.Header;
import Model.KinderGarten;
import exception.KinderGartenException;
import serviceDao.SettingColorDeal;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ShowAllChild extends JFrame {
    //使用表格和滚动面板实现河流信息的展示
    private JTable table;
    private JScrollPane pane;

    public ShowAllChild() {
        this.setSize(1000, 500);
        this.setTitle("显示所有孩子信息");
        this.setLayout(null);
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
        //获取所有河流信息
        KinderGartenDao kinderGartenDao = new KinderGartenDao();
        try {
            List<KinderGarten> childs = kinderGartenDao.SelectAll();
            init(childs);
        } catch (KinderGartenException e) {
            JOptionPane.showMessageDialog(this, "获取信息异常!");
        }
    }

    private void init(List<KinderGarten> childs) throws KinderGartenException {
        //设置表格标题 和表格信息
        String[] titles = new String[] {"编号", "姓名", "年龄", "性别", "班级", "班主任编号","在校状态","班主任信息"};
        String[][] values = new String[childs.size()][8];
        KinderGartenDao dao = new KinderGartenDao();
        for (int i = 0; i < childs.size(); i++) {
            KinderGarten child = childs.get(i);
            values[i][0] = String.valueOf(child.getChildNum());
            values[i][1] = child.getChildName();
            values[i][2] = String.valueOf(child.getChildAge());
            values[i][3] = child.getChildSex();
            values[i][4] = child.getChildClass();
            values[i][5] = String.valueOf(child.getChildHeader());
            values[i][6] = child.getChildStatus();
            Header header = dao.selectHeaderByNum(child.getChildHeader());
            values[i][7] = header.getName()+","+header.getSex()+","+header.getAge()+"岁";
        }
        //初始化表格和滚动面板
        table = new JTable(values, titles);
        table.getTableHeader().setFont(new Font("标楷体",Font.BOLD,16));
        table.setFont(new Font("",0,16));
        pane = new JScrollPane(table);
        pane.setSize(900, 400);
        pane.setLocation(50, 50);
        //总是出现垂直滚动条
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(pane);


    }
}
