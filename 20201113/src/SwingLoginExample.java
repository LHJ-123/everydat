import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SwingLoginExample {

    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Student inform");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(800,500);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    public static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);


        // 创建 JLabel
        JLabel userLabel = new JLabel("学号:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
      JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 输入姓名的文本域
        JLabel nameLabel = new JLabel("姓名:");
        nameLabel.setBounds(10,50,80,25);
        panel.add(nameLabel);

        /*
         *这个类似用于输入的文本域
         */
        JTextField nameText = new JTextField(20);
        nameText.setBounds(100,50,165,25);
        panel.add(nameText);

        // 输入性别的文本域

        JLabel jLabel = new JLabel("性别:");
        jLabel.setBounds(10,80,80,25);
        String[] sex = {"男","女"};
        JComboBox jComboBox = new JComboBox(sex);
        jComboBox.setBounds(100,80,165,25);
        panel.add(jLabel);
        panel.add(jComboBox);

        // 创建按钮
        JButton addButton = new JButton("添加");
        addButton.setBounds(40, 120, 80, 25);
        panel.add(addButton);
       addButton.addActionListener(new ActionListener() {
           StudentDao studentDao = new StudentDao();

           @Override
           public void actionPerformed(ActionEvent e) {
                   Student student = new Student();
                   String sno = userText.getText();
                   String name = nameText.getText();
                   String sex = (String)jComboBox.getSelectedItem();
               if (sno == null || name == null || sex == null) {
                   System.out.println("信息不完整不能添加");
                   return;
               }
                   student.setSno(sno);
                   student.setName(name);
                   student.setSex(sex);
                   studentDao.add(student);
           }
       });


        JButton clearButton = new JButton("清空");
        clearButton.setBounds(200, 120, 80, 25);
        panel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               userText.setText("");
                nameText.setText("");
                System.out.println("清除成功");
            }
        });

    }



}
