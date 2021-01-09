package Interface;

import serviceDao.SettingColorDeal;
import serviceDao.UpdateDeal;

import javax.swing.*;
import java.awt.*;


public class UpdateChild extends JFrame {

    private JLabel message;
    //编号
    private JLabel num;
    public JTextField numText;


    public JPanel panel;
    //nameLabel, lengthLabel, locationLabel, classLabel, statusLabel
    public JLabel[] labels;
    //nameField, lengthField, locationField
    public JTextField[] textFields;
    public JComboBox headerBox, statusBox, classBox, sexBox;
    private JButton ok;


    public UpdateChild() {
        this.setSize(500, 700);
        this.setTitle("修改孩子信息");
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
        message.setText("编号不可修改, 只可根据编号修改其他内容");
        message.setFont(new Font("", 0, 20));
        this.add(message);
        num = new JLabel("孩子编号");
        num.setSize(100, 30);
        num.setLocation(0, 50);
        num.setFont(new Font("", 1, 20));
        numText = new JTextField();
        numText.setSize(60, 30);
        numText.setLocation(110, 50);
        numText.setFont(new Font("", 0, 20));
        this.add(num);
        this.add(numText);

        panel = new JPanel();
        panel.setSize(350, 340);
        panel.setLocation(85, 140);
        if (SettingColorDeal.theme != null) {
            panel.setBackground(SettingColorDeal.theme);
        }
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        //初始化comboBox

        headerBox = new JComboBox();
        headerBox.addItem("");
        headerBox.addItem("1");
        headerBox.addItem("2");
        headerBox.addItem("3");
        headerBox.addItem("4");

        headerBox.setFont(new Font("", 1, 20));
        // 河道整治情况有 优 良 差
        statusBox = new JComboBox();
        statusBox.addItem("");
        statusBox.addItem("是");
        statusBox.addItem("否");

        statusBox.setFont(new Font("", 1, 20));
        classBox = new JComboBox();
        classBox.addItem("");
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
        sexBox.addItem("");
        sexBox.addItem("男");
        sexBox.addItem("女");
        sexBox.setFont(new Font("", 1, 20));
        //初始化其他
        String[] labelNames = new String[]{"孩子名称", "孩子年龄", "性别", "班级", "班主任", "在校状态"};
        labels = new JLabel[6];
        textFields = new JTextField[2];
        int indexText = 0;
        for (int i = 0; i < labelNames.length; i++) {
            labels[i] = new JLabel(labelNames[i]);
            labels[i].setFont(new Font("", 1, 20));
            panel.add(labels[i]);
            if (i < 2) {
                textFields[i] = new JTextField();
                textFields[i].setFont(new Font("", 0, 20));
                panel.add(textFields[i]);
            }
            if (i == 2 || i == 3 || i == 4 || i == 5) {
                if (i == 2) {
                    panel.add(sexBox);
                } else if (i == 3) {
                    panel.add(classBox);
                } else if (i == 4) {
                    panel.add(headerBox);
                } else {
                    panel.add(statusBox);
                }
            }
        }

            this.add(panel);
            ok = new JButton("确认");
            ok.setSize(100, 60);
            ok.setLocation(200, 500);
            ok.setFont(new Font("", 1, 30));
            UpdateDeal deal = new UpdateDeal(this);
            ok.addActionListener(deal);
            this.add(ok);

        }
    }
