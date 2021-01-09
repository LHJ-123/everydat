package serviceDao;

import Interface.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainInterfaceDeal implements ActionListener {

    private ChildManagement event;

    public MainInterfaceDeal(ChildManagement event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();

        switch (text.trim()) {
            case "显示所有孩子":
                new ShowAllChild();
                break;
            case "查找具体孩子":
                new FindChild();
                break;
            case "增加孩子信息":
                new AddChild();
                break;
            case "修改孩子信息":
                new UpdateChild();
                break;
            case "删除具体孩子":
                new DeleteChild();
                break;

        }

    }
}
