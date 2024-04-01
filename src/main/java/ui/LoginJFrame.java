package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginJFrame extends JFrame
{
    String name;
    String pwd;
    Box name_box = Box.createHorizontalBox();
    Box pwd_box = Box.createHorizontalBox();

    Box row = Box.createHorizontalBox();
    Box col1 = Box.createVerticalBox();
    Box col2 = Box.createVerticalBox();

    JPanel name_panel = new JPanel();
    JPanel pwd_panel = new JPanel();
    JLabel name_label = new JLabel("您的账号:");
    JLabel pwd_label = new JLabel("您的密码:");
    JTextField name_text = new JTextField(10);
    JPasswordField pwd_text = new JPasswordField(10);
    JButton login = new JButton("登录");
    JButton register = new JButton("注册");
    public LoginJFrame()
    {
        //设置窗口的大小
        this.setSize(600,700);
        //设置窗口的标题
        this.setTitle("登录界面");
        //设置窗口的位置居中
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());

        //设置窗口的关闭模式
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

//        name_panel.setOpaque(false);



//        pwd_panel.setOpaque(false);
//        name_label.setOpaque(false);
//        pwd_label.setOpaque(false);
//        name_text.setOpaque(false);
//        pwd_text.setOpaque(false);
//        login.setOpaque(false);
//        register.setOpaque(false);

//        name_panel.setLayout(new GridLayout(1,2));
//        name_panel.add(name_label);
//        name_panel.add(name_text);

        Dimension dim = new Dimension(20,20);
//        name_text.setPreferredSize(dim);
//        pwd_text.setPreferredSize(dim);

        Component part = Box.createHorizontalStrut(10);

//        name_box.add(name_label);
//        name_box.add(part);
//        name_box.add(name_text);
//
//        pwd_box.add(pwd_label);
//        pwd_box.add(part);
//        pwd_box.add(pwd_text);



        col1.add(name_label);
        col1.add(pwd_label);

        col2.add(name_text);
        col2.add(pwd_text);


        row.add(col1);

        Component interval = Box.createHorizontalStrut(10);
        row.add(interval);

        row.add(col2);
        this.add(row);


        login.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               name = name_text.getText();
               pwd = new String(pwd_text.getPassword());
               System.out.println(name);
               System.out.println(pwd);
           }
        });
        this.add(login);

        register.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new RegisterJFrame();
                dispose();
            }

        });
        this.add(register);


//        this.add(name_box);
//        this.add(pwd_box);
//
//        this.add(login);
//        this.add(register);



        //设置窗口的可见性
        this.setVisible(true);
    }

}
