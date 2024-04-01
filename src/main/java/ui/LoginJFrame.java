package ui;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginJFrame extends JFrame implements MouseListener
{
    String name;
    String pwd;
    String veri;
    Box row1 = Box.createHorizontalBox();
    Box row2 = Box.createHorizontalBox();
    Box row3 = Box.createHorizontalBox();
    Box row4 = Box.createHorizontalBox();
    Box row5 = Box.createHorizontalBox();
    Box col = Box.createVerticalBox();

    JLabel title = new JLabel("欢迎使用图书馆管理系统");
    JLabel name_label = new JLabel("您的账号:");
    JLabel pwd_label = new JLabel("您的密码:");
    JLabel veri_label = new JLabel("验证码:");
    JTextField name_text = new JTextField(30);
    JPasswordField pwd_text = new JPasswordField(30);
    JTextField veri_text = new JTextField(10);
    JButton login = new JButton("登录");
    JButton register = new JButton("注册");
    Font font = new Font("宋体",Font.BOLD,25);
    CircleCaptcha captcha;
    Image image;
    ImageIcon imageIcon;
    JLabel label;
    public LoginJFrame()
    {
        init();

        veri_init();

        initComponent();
        addComponent();



        login.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               name = name_text.getText();
               pwd = new String(pwd_text.getPassword());
               veri = veri_text.getText();
               System.out.println(name);
               System.out.println(pwd);
               System.out.println(veri);
               String result = captcha.getCode();
               System.out.println(captcha.verify(veri));
           }
        });

        register.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new RegisterJFrame();
                dispose();
            }
        });

        //设置窗口的可见性
        this.setVisible(true);
    }
    private void init()
    {
        //设置窗口的大小
        this.setSize(900,700);
        //设置窗口的标题
        this.setTitle("登录界面");
        //设置窗口的位置居中
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());

        //设置窗口的关闭模式
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    private void veri_update()
    {
        // 定义图形验证码的长、宽、验证码字符数、干扰元素个数
        captcha = CaptchaUtil.createCircleCaptcha(100, 40, 4, 30);


        image = captcha.getImage();
        imageIcon = new ImageIcon(image);
        if(label == null)
            label = new JLabel(imageIcon);
        else
            label.setIcon(imageIcon);
    }

    private void veri_init()
    {
        veri_update();
        label.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource()==label)
        {
            veri_update();
            label.repaint();
        }
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}

    private void initComponent()
    {
        name_label.setFont(font);
        name_text.setFont(font);
        pwd_label.setFont(font);
        pwd_text.setFont(font);
        veri_label.setFont(font);
        veri_text.setFont(font);

    }


    private void addComponent()
    {
        row1.add(name_label);
        row1.add(Box.createHorizontalStrut(10));
        row1.add(name_text);

        row2.add(pwd_label);
        row2.add(Box.createHorizontalStrut(10));
        row2.add(pwd_text);

        row3.add(veri_label);
        row3.add(Box.createHorizontalStrut(35));
        row3.add(veri_text);
        row3.add(Box.createHorizontalStrut(10));
        row3.add(label);

        row4.add(Box.createHorizontalStrut(20));


        row4.add(register);
        row4.add(Box.createHorizontalStrut(30));


        row4.add(login);

        col.add(Box.createVerticalStrut(100));
        title.setFont(new Font("黑体",Font.BOLD,40));
        col.add(title);
        col.add(row1);
        col.add(row2);
        col.add(row3);
        col.add(row4);

        this.add(col);
    }
}
