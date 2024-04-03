package ui;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;


public class LoginJFrame extends JFrame implements MouseListener
{
    int uid = -1;
    Connection connection;
    Statement statement;
    String sql;
    String name;
    String pwd;
    String veri;
    Box row1 = Box.createHorizontalBox();
    Box row2 = Box.createHorizontalBox();
    Box row3 = Box.createHorizontalBox();
    Box row4 = Box.createHorizontalBox();
    Box col = Box.createVerticalBox();

    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel();

    JLabel title = new JLabel("欢迎使用图书馆管理系统",JLabel.CENTER);
    JLabel name_label = new JLabel("您的账号:");
    JLabel pwd_label = new JLabel("您的密码:");
    JLabel veri_label = new JLabel("验证码:");
    JTextField name_text = new JTextField(30);
    JPasswordField pwd_text = new JPasswordField(30);
    JTextField veri_text = new JTextField(10);
    JButton login = new JButton("登录");
    JButton register = new JButton("注册");
    Font font = new Font("宋体",Font.BOLD,30);
    CircleCaptcha captcha;
    Image image;
    ImageIcon imageIcon;
    JLabel label;
    public LoginJFrame() throws SQLException, ClassNotFoundException

    {

        init();
        connect();
        veri_init();

        initComponent();
        addComponent();

        setLogin();
        setRegister();



        //设置窗口的可见性
        this.setVisible(true);
    }
    private void connect() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/library_system?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "root230817";
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }
    private void init()
    {
        //设置窗口的大小
        this.setSize(900,700);
        //设置窗口的标题
        this.setTitle("登录界面");
        //设置窗口的位置居中
        this.setLocationRelativeTo(null);

        this.setLayout(null);

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
        row3.add(Box.createHorizontalStrut(40));
        row3.add(veri_text);
        row3.add(Box.createHorizontalStrut(10));
        row3.add(label);


        register.setFont(new Font("宋体",Font.BOLD,30));
        row4.add(register,BorderLayout.CENTER);
        row4.add(Box.createHorizontalStrut(300));

        login.setFont(new Font("宋体",Font.BOLD,30));
        row4.add(login);

        title.setFont(new Font("黑体",Font.BOLD,50));


        col.add(row1);
        col.add(Box.createVerticalStrut(10));
        col.add(row2);
        col.add(Box.createVerticalStrut(10));
        col.add(row3);
        col.add(Box.createVerticalStrut(30));
        col.add(row4);

        panel1.setBounds(0,0,900,300);
        panel1.add(title,BorderLayout.CENTER);
        this.add(panel1);

        panel2.setBounds(0,300,900,400);
        panel2.add(col);
        this.add(panel2);


    }
    private void setLogin()
    {
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                name = name_text.getText();
                if(name.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"您输入的账号不能为空！","账号不能为空",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                pwd = new String(pwd_text.getPassword());
                if(pwd.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"您输入的密码不能为空！","密码不能为空",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                veri = veri_text.getText();
                if(veri.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"您输入的验证码不能为空！","验证码不能为空",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                sql = "select * from user where account = ?;";
                try
                {
                    PreparedStatement state = connection.prepareStatement(sql);
                    state.setString(1,name);
                    ResultSet resultSet = state.executeQuery();
                    if(!resultSet.next())
                    {
                        JOptionPane.showMessageDialog(null,"您输入的账号不存在！","账号不存在",JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                    if(!Objects.equals(pwd, resultSet.getString("password")))
                    {

                        JOptionPane.showMessageDialog(null,"您输入的密码不正确！","密码错误",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                   if(!captcha.verify(veri))
                   {

                       JOptionPane.showMessageDialog(null,"您输入的验证码不正确！","验证码错误",JOptionPane.ERROR_MESSAGE);
                       veri_update();
                       return;
                   }
                    uid = resultSet.getInt("uid");
//                   sql = "update user set status = 1 where account = ?;";
//                   state = connection.prepareStatement(sql);
//                   state.setString(1,name);
//                   state.executeUpdate();
                    dispose();
                    try
                    {
                        new UserJFrame(uid);
                    } catch (ClassNotFoundException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                } catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    private void setRegister()
    {
        register.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    new RegisterJFrame();
                } catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex)
                {
                    throw new RuntimeException(ex);
                }

                dispose();
            }
        });

    }
}
