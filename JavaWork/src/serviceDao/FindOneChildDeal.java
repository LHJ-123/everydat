package serviceDao;

import Dao.KinderGartenDao;
import Interface.FindChild;
import Model.KinderGarten;
import exception.KinderGartenException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FindOneChildDeal implements ActionListener {

    private FindChild event;

    public FindOneChildDeal(FindChild event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = event.nameText.getText();
        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请填写名字");
            return;
        }
        KinderGartenDao dao = new KinderGartenDao();
        KinderGarten kinderGarten = null;
        try {
            kinderGarten = dao.selectByName(name.trim());
            if (kinderGarten == null) {
                JOptionPane.showMessageDialog(event, "请检查这个姓名是否存在");
                return;
            }
        } catch (KinderGartenException ex) {
            JOptionPane.showMessageDialog(event, "未查到数据，请检查数据正确性");
            return;
        }

        event.answers[0].setText(kinderGarten.getChildName());
        event.answers[1].setText(String.valueOf(kinderGarten.getChildAge()));
        event.answers[2].setText(kinderGarten.getChildSex());
        event.answers[3].setText(kinderGarten.getChildClass());
        event.answers[4].setText(String.valueOf(kinderGarten.getChildHeader()));
        event.answers[5].setText(kinderGarten.getChildStatus());
    }
}
