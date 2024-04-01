package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterJFrame extends JFrame
{
    Box row = Box.createHorizontalBox();
    Box col1 = Box.createVerticalBox();
    Box col2 = Box.createVerticalBox();
    JLabel name_label = new JLabel("您的账号:");
    JLabel pwd1_label = new JLabel("您的密码:");
    JLabel pwd2_label = new JLabel("确认密码:");

    JTextField name_text = new JTextField(10);
    JPasswordField pwd1_text = new JPasswordField(10);
    JPasswordField pwd2_text = new JPasswordField(10);
    JButton register = new JButton("注册");
    JButton return_btn = new JButton("返回登录界面");
    public RegisterJFrame()
    {
        this.setSize(500,600);
        this.setTitle("注册界面");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        col1.add(name_label);
        col1.add(pwd1_label);
        col1.add(pwd2_label);

        col2.add(name_text);
        col2.add(pwd1_text);
        col2.add(pwd2_text);

        row.add(col1);
        Component interval = Box.createHorizontalStrut(10);
        row.add(interval);
        row.add(col2);
        this.add(row);
        this.add(register);
        this.add(return_btn);

        return_btn.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               new LoginJFrame();
               dispose();
           }
        });

        this.setVisible(true);
    }
}
