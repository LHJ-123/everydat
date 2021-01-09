package serviceDao;

import Dao.KinderGartenDao;
import Interface.DeleteChild;
import Model.KinderGarten;
import exception.KinderGartenException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;


public class DeleteDeal implements ActionListener{

    private DeleteChild event;

    public DeleteDeal(DeleteChild event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //获取删除的名字
        String name = event.text.getText();
        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请填写完整信息");
            return;
        }
        KinderGartenDao dao = new KinderGartenDao();

        try {
            KinderGarten child = dao.selectByName(name);
            if (child == null) {
                JOptionPane.showMessageDialog(event, "请检查孩子姓名是否存在");
                return;
            }
        } catch (KinderGartenException ex) {
            JOptionPane.showMessageDialog(event, "数据库错误");
            return;
        }


        if (confirm()) {
            return;
        }

        try {
            dao.deleteChildByName(name.trim());
        } catch (KinderGartenException ex) {
            JOptionPane.showMessageDialog(event, "删除失败");
            return;
        }
        event.text.setText("");
        JOptionPane.showMessageDialog(event, "删除成功");
    }

    private boolean confirm() {
        int ret = JOptionPane.showConfirmDialog(event, "确认删除?","警告", YES_NO_CANCEL_OPTION);
        return ret != JOptionPane.YES_OPTION;
    }
}
