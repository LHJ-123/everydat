package Login;

import Interface.ChildManagement;
import serviceDao.MainInterfaceDeal;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{

    JLabel jl1,jl2,jl3;
    JLabel label;
    JTextField jtf;
    JPasswordField jpf;
    JButton jb1,jb2,jb3;
    ImageIcon background;
    JPanel jp1,jp2,jp3,jp4;
    JPanel myPanel;		//要放置的背景

    public Login(){




        jl1=new JLabel("账号：");
        jl2=new JLabel("密码：");
//		jl3=new JLabel(new ImageIcon("images/背景.jpg"));
        jtf=new JTextField(16);
        jpf=new JPasswordField(16);
        jb1=new JButton("登录");

        jb2=new JButton("取消");
        jb3=new JButton("清空");

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
//		jp4=new JPanel();

        background = new ImageIcon("images/背景.jpg");	//创建一个背景图片
        label = new JLabel(background);		//把背景图片添加到标签里
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//把标签设置为和图片等高等宽
        myPanel = (JPanel)this.getContentPane();		//把我的面板设置为内容面板
        myPanel.setOpaque(false);					//把我的面板设置为不可视
        myPanel.setLayout(new FlowLayout());		//把我的面板设置为流动布局
        this.getLayeredPane().setLayout(null);		//把分层面板的布局置空

        jp1.add(jl1);
        jp1.add(jtf);
        jp2.add(jl2);
        jp2.add(jpf);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);

//		jp4.add(jl3);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);


        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//把标签添加到分层面板的最底层

        //监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        this.setTitle("登录界面");
        this.setSize(400,300);
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
	/*jb1=new JButton("登录");
		jb2=new JButton("取消");
		jb3=new JButton("清空");
		JTextField jtf;
	JPasswordField jpf;*/
        if(e.getSource()==jb1) {
            String name="123";
            String psw="456";

            String j1=jtf.getText();
            String p1=jpf.getText();
            if (j1 == null || j1.length() == 0 ||p1 == null || p1.length() == 0) {
                JOptionPane.showMessageDialog(this, "用户名或者密码不能为空");
                return;
            }
            if(name.equals(j1)&&psw.equals(p1)) {
                JOptionPane.showMessageDialog(this, "登陆成功");
                ChildManagement childManagement = new ChildManagement();
                MainInterfaceDeal mainInterfaceDeal = new MainInterfaceDeal(childManagement);
                this.setVisible(false);
                //jb1.addActionListener(mainInterfaceDeal);

            }else {
                JOptionPane.showMessageDialog(this, "登陆失败");
            }

        }else if(e.getSource()==jb2) {
            this.setVisible(false);

        }else if(e.getSource()==jb3) {
            jtf.setText(null);
            jpf.setText(null);

        }

    }
}
class test extends JPanel{

}
