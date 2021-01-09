package serviceDao;

import Interface.ChildManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class SettingColorDeal implements ActionListener {

    public static Color theme = null;

    private ChildManagement event;

    public SettingColorDeal(ChildManagement event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();

        //"蓝色", "青色", "灰色", "绿色", "浅灰", "紫色","橘色", "粉色", "红色", "黄色"
        Map<String, Color> choose = makeChoose();
        theme = choose.get(abstractButton.getText());
        //event.container.setBackground(theme);
        event.panel.setBackground(theme);
        event.getContentPane().setBackground(choose.get(abstractButton.getText()));

    }

    private Map<String, Color> makeChoose() {

        Map<String, Color> choose = new HashMap<>();
        choose.put("蓝色", Color.BLUE);
        choose.put("青色", Color.CYAN);
        choose.put("灰色", Color.GRAY);
        choose.put("绿色", Color.GREEN);
        choose.put("浅灰", Color.LIGHT_GRAY);
        choose.put("紫色", Color.MAGENTA);
        choose.put("橘色", Color.ORANGE);
        choose.put("粉色", Color.PINK);
        choose.put("红色", Color.RED);
        choose.put("黄色", Color.YELLOW);
        return choose;
    }
}
