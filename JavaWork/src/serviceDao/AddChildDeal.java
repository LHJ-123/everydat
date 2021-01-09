package serviceDao;
import Dao.KinderGartenDao;
import Interface.AddChild;
import Model.KinderGarten;
import exception.KinderGartenException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddChildDeal implements ActionListener {

    private AddChild event;

    public AddChildDeal(AddChild event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = event.textFields[0].getText();
       int age = 0;
        if (event.textFields[1].getText().trim().equals("")||event.textFields[1].getText() == null) {
            JOptionPane.showMessageDialog(event,"信息不能为空");
        }else {
             age  = Integer.parseInt(event.textFields[1].getText());

        }
        if (!checkAge(age)) {
            JOptionPane.showMessageDialog(event, "注意年龄大小");
            //将面板内容清空
            for (int i = 0; i < 2; i++) {
                event.textFields[i].setText("");
            }
            return;
        }


        //判断信息是否未填写
        if (check(name)) {
            String Class = (String) event.classBox.getSelectedItem();
            String status = (String) event.statusBox.getSelectedItem();
            String sex = (String)event.sexBox.getSelectedItem();
            int header = Integer.parseInt((String) event.headerBox.getSelectedItem());
            KinderGarten kinderGarten = new KinderGarten();
            kinderGarten.setChildName(name);
            kinderGarten.setChildAge(age);
            kinderGarten.setChildSex(sex);
            kinderGarten.setChildClass(Class);
            kinderGarten.setChildHeader(header);
            kinderGarten.setChildStatus(status);

            //数据库处理
            KinderGartenDao dao = new KinderGartenDao();
            try {
                dao.addChild(kinderGarten);
            } catch (KinderGartenException ex) {
                JOptionPane.showMessageDialog(event, "增加失败");
                //将面板内容清空
                for (int i = 0; i < 2; i++) {
                    event.textFields[i].setText("");
                }
                return;
            }
            //将面板内容清空
            for (int i = 0; i < 2; i++) {
                event.textFields[i].setText("");
            }
            JOptionPane.showMessageDialog(event, "增加成功");
        } else {
            JOptionPane.showMessageDialog(event, "请完整填写信息!");
        }

    }

    private boolean checkAge(int age) {

        if (age<=0 || age>20) {
            return false;
        }
     return true;
    }

    private boolean check(String name) {
        return name != null && !name.trim().equals("") ;
    }
}
