package serviceDao;

import Dao.KinderGartenDao;
import Interface.UpdateChild;
import Model.KinderGarten;
import exception.KinderGartenException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;


public class UpdateDeal implements ActionListener {

    private UpdateChild event;


    public UpdateDeal(UpdateChild event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        KinderGarten kinderGarten = null;
        if ((kinderGarten = checkHave()) != null) {

            String newName = event.textFields[0].getText();
            int newAge = 0;
            if (event.textFields[1].getText()!=null && !event.textFields[1].getText().trim().equals("")) {
                newAge = Integer.parseInt(event.textFields[1].getText().trim());
            }else {
                JOptionPane.showMessageDialog(event, "年龄不能为空");
            }
            String newSex = (String)event.sexBox.getSelectedItem();
            String newClass = (String) event.classBox.getSelectedItem();
            int newHeader = 0;
            if (event.headerBox.getSelectedItem().toString()!=null &&!event.headerBox.getSelectedItem().toString().trim().equals("")) {
                newHeader = Integer.parseInt(event.headerBox.getSelectedItem().toString());
            }else {
                JOptionPane.showMessageDialog(event, "班主任编号不能为空");
            }
            String newStatus = (String) event.statusBox.getSelectedItem();

            if (allNull(newName, newSex, newClass, newHeader, newStatus,newAge)) {
                JOptionPane.showMessageDialog(event, "都为空");
                return;
            }

            if (confirm()) {
                return;
            }

            if (updateChild(kinderGarten, newName, newSex, newClass, newHeader, newStatus,newAge)) {
                JOptionPane.showMessageDialog(event, "修改成功");

                event.textFields[0].setText("");
                event.textFields[1].setText("");
                //event.textFields[2].setText("");
                event.classBox.setSelectedIndex(0);
                event.statusBox.setSelectedIndex(0);
                return;
            }
            JOptionPane.showMessageDialog(event, "修改失败");
        }


    }

    private boolean allNull(String newName, String newSex, String newClass,
                            int newHeader, String newStatus,int newAge) {

        return (newSex == null || newSex.trim().equals(""))
                && (newHeader+"" == null || (""+newHeader).trim().equals(""))
                && (newClass == null || newClass.trim().equals(""))
                && (newStatus == null || newStatus.trim().equals(""))
                && (newName == null || newName.trim().equals(""))
                && (newAge+"" == null || (""+newAge).trim().equals(""));
    }

    private boolean updateChild(KinderGarten child, String newName, String newSex, String newClass,
                             int newHeader,String newStatus, int newAge) {
        String name = child.getChildName();
        KinderGartenDao dao = new KinderGartenDao();

        try {


            if (newAge>=4 && newAge<=10) {
                dao.updateChildAgeByName(name, newAge);
            }


            if (newClass != null && !newClass.trim().equals("")) {
                dao.updateChildClassByName(name, newClass);
            }
            if (newSex != null && !newSex.trim().equals("")) {
                dao.updateChildSexByName(name, newSex);
            }


            if (newHeader>=1&&newHeader<=4) {
                dao.updateChildHeaderByName(name, newHeader);
            }

            if (newStatus != null && !newStatus.trim().equals("")) {
                dao.updateChildStatusByName(name, newStatus);
            }

            if (newName != null && !newName.trim().equals("")) {
                dao.updateChildNameByName(name, newName);
            }
        } catch (KinderGartenException e) {
            JOptionPane.showMessageDialog(event, e.getMessage());
            return false;
        }
        return true;
    }



    private KinderGarten checkHave() {

        String num = event.numText.getText();
        if (num == null || num.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请输入孩子编号");
            return null;
        }
        KinderGartenDao dao = new KinderGartenDao();
        KinderGarten child = null;
        try {
            child = dao.selectByNum(Integer.parseInt(num.trim()));
            if (child == null) {
                JOptionPane.showMessageDialog(event, "请检查编号是否正确");
                return null;
            }
        } catch (KinderGartenException e) {
            JOptionPane.showMessageDialog(event, "数据错误");
            return null;
        }
        return child;
    }

    private boolean confirm() {
        int ret = JOptionPane.showConfirmDialog(event, "确认修改?","警告", YES_NO_CANCEL_OPTION);
        return ret != JOptionPane.YES_OPTION;
    }
}
