package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UserJFrame extends JFrame
{
    String name = "法外狂徒";
    JButton setting = new JButton("账号设置");
    JButton home= new JButton("系统首页");
    JButton check_btn = new JButton("图书查阅");
    JLabel check_label = new JLabel("图书查询");
    JLabel check_label1 = new JLabel("可浏览图书馆的所有图书资源");
    JLabel check_label2 = new JLabel("根据图书编号、图书名称查询图书信息");
    JLabel check_label3 = new JLabel("可查询图书的编号、名称、分类、作者、在馆数量等");
    JButton borrow_info_btn = new JButton("借阅信息");
    JLabel borrow_info_label = new JLabel("借阅信息");
    JLabel borrow_label1 = new JLabel("可查询现在借阅的图书的基本信息、借阅日期、截止还书时间、超期天数等");
    JButton borrow_hist_btn = new JButton("借阅历史");
    JLabel borrow_hist_label = new JLabel("借阅历史");
    JLabel borrow_label2 = new JLabel("可查询自己以往的借阅历史");
    JPanel panel = new JPanel(new GridLayout());
    JPanel panel1 = new JPanel(new BorderLayout());
    JLabel title = new JLabel("图书馆管理系统",JLabel.CENTER);
    JPanel rowPanel = new JPanel(new GridLayout(1,2));
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    Box col = Box.createVerticalBox();
    Box col2 = Box.createVerticalBox();
    Box row = Box.createHorizontalBox();
    Font btn_font = new Font("宋体",Font.BOLD,20);
    Font font1 = new Font("宋体",Font.BOLD,15);
    Font font2 = new Font("黑体",Font.BOLD,20);
    public UserJFrame()
    {
        this.setSize(900,700);
        this.setTitle("图书馆管理系统");
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);


        title.setFont(new Font("黑体",Font.BOLD,50));
//        this.add(title);


        panel1.setBounds(0,0,900,150);


        panel1.add(title,BorderLayout.CENTER);

        panel1.setBackground(new Color(43,120,174));
        this.add(panel1);

//        panel2.setBackground(new Color(176,168,185));
        panel2.setBounds(0,100,200,600);


        int interval = 20;
        JLabel label1 = new JLabel("欢迎您,");
        label1.setFont(new Font("宋体",Font.BOLD,30));
        col.add(Box.createVerticalStrut(60));
        col.add(label1);
        col.add(Box.createVerticalStrut(interval));

        JLabel label2 = new JLabel(name);
        label2.setFont(new Font("宋体",Font.BOLD,30));

        col.add(label2);
        col.add(Box.createVerticalStrut(interval));

        home.setFont(btn_font);

        col.add(home,BorderLayout.CENTER);
        col.add(Box.createVerticalStrut(interval));

        check_btn.setFont(btn_font);
        col.add(check_btn);
        col.add(Box.createVerticalStrut(interval));

        borrow_info_btn.setFont(btn_font);
        col.add(borrow_info_btn);
        col.add(Box.createVerticalStrut(interval));

        borrow_hist_btn.setFont(btn_font);
        col.add(borrow_hist_btn);
        col.add(Box.createVerticalStrut(interval));

        setting.setFont(btn_font);
        col.add(setting);

        col.add(Box.createVerticalStrut(interval));


        panel2.setBackground(new Color(0,210,252));

        panel2.add(col);

        this.add(panel2);

//        panel3.setBackground(new Color(254,254,223));
        panel3.setBounds(200,150,700,550);

        int t1 = 15,t2 = 10;

        col2.add(Box.createVerticalStrut(60));

        check_label.setFont(font2);
        col2.add(check_label);

        col2.add(Box.createVerticalStrut(t1));

        check_label1.setFont(font1);
        col2.add(Box.createVerticalStrut(t2));
        col2.add(check_label1);

        check_label2.setFont(font1);
        col2.add(Box.createVerticalStrut(t2));
        col2.add(check_label2);

        check_label3.setFont(font1);
        col2.add(Box.createVerticalStrut(t2));
        col2.add(check_label3);

        borrow_info_label.setFont(font2);
        col2.add(Box.createVerticalStrut(t1));

        col2.add(borrow_info_label);
        col2.add(Box.createVerticalStrut(t1));
        borrow_label1.setFont(font1);
        col2.add(borrow_label1);
        col2.add(Box.createVerticalStrut(t2));
        borrow_hist_label.setFont(font2);
        col2.add(Box.createVerticalStrut(t1));

        col2.add(borrow_hist_label);
        col2.add(Box.createVerticalStrut(t1));
        borrow_label2.setFont(font1);
        col2.add(borrow_label2);

        panel3.add(col2);
        this.add(panel3);


        this.setVisible(true);
    }
}
