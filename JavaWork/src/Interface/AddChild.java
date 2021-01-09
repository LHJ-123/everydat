package Interface;
import serviceDao.AddChildDeal;
import serviceDao.SettingColorDeal;
import javax.swing.*;
import java.awt.*;

public class AddChild extends JFrame {

    public JPanel panel;
    public JLabel[] labels;
    public JTextField[] textFields;
    public JComboBox headerBox, statusBox,classBox,sexBox;
    private JButton ok;

    public AddChild() {
        this.setSize(500, 600);
        this.setTitle("新增孩子");
        this.setLayout(null);
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
        init();
    }

    private void init() {

        panel = new JPanel();
        panel.setSize(350, 340);
        panel.setLocation(85, 40);
        if (SettingColorDeal.theme != null) {
            panel.setBackground(SettingColorDeal.theme);
        }
        //班主任 1 2 3 4
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        headerBox = new JComboBox();
        headerBox.addItem("1");
        headerBox.addItem("2");
        headerBox.addItem("3");
        headerBox.addItem("4");
        headerBox.setFont(new Font("", 1, 20));
        // 在校情况 是 否
        statusBox = new JComboBox();
        statusBox.addItem("是");
        statusBox.addItem("否");
        statusBox.setFont(new Font("", 1, 20));

        classBox = new JComboBox();
        classBox.addItem("大班一");
        classBox.addItem("大班二");
        classBox.addItem("大班三");
        classBox.addItem("中班一");
        classBox.addItem("中班二");
        classBox.addItem("中班三");
        classBox.addItem("小班一");
        classBox.addItem("小班二");
        classBox.addItem("小班三");
        classBox.setFont(new Font("", 1, 20));

        sexBox = new JComboBox();
        sexBox.addItem("男");
        sexBox.addItem("女");
        sexBox.setFont(new Font("", 1, 20));
        //初始化其他
        String[] labelNames = new String[] {"孩子姓名", "孩子年龄", "性别", "班级", "班主任","在校状况"};
        labels = new JLabel[6];
        textFields = new JTextField[2];
        int indexText = 0;
        for (int i = 0; i < labelNames.length; i++) {
            labels[i] = new JLabel(labelNames[i]);
            labels[i].setFont(new Font("", 1, 20));
            panel.add(labels[i]);
            if (i == 2 || i == 3 || i == 4 || i == 5) {
                if (i == 2) {
                    panel.add(sexBox);
                } else if(i == 3){
                    panel.add(classBox);
                }else if(i == 4) {
                    panel.add(headerBox);
                }else {
                    panel.add(statusBox);
                }
            } else {
                textFields[indexText] = new JTextField();
                textFields[indexText].setFont(new Font("", 0, 20));
                panel.add(textFields[indexText]);
                indexText++;
            }
        }
        this.add(panel);
        ok = new JButton("提交");
        ok.setSize(100, 60);
        ok.setLocation(200, 400);
        ok.setFont(new Font("", 1, 30));
        AddChildDeal deal = new AddChildDeal(this);
        ok.addActionListener(deal);
        this.add(ok);

    }
}
