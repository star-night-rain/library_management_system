package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UserJFrame extends JFrame
{
    String sql;
    Connection connection;
    Statement statement;
    PreparedStatement state;
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
    JPanel home_panel = new JPanel();
    JPanel check_panel = new JPanel();
    JPanel info_panel = new JPanel();
    JPanel his_panel = new JPanel();

    Box col = Box.createVerticalBox();
    Box col2 = Box.createVerticalBox();
    Box row = Box.createHorizontalBox();
    Font btn_font = new Font("宋体",Font.BOLD,20);
    Font font1 = new Font("宋体",Font.BOLD,15);
    Font font2 = new Font("黑体",Font.BOLD,20);
    int uid;
    JLabel label_of_check = new JLabel("请输入图书编号:");
    JTextField text_of_check = new JTextField(20);
    JButton btn_of_check = new JButton("查询");
    JTable table_of_check;
    JPanel panel_of_check = new JPanel();
    Box row_of_check = Box.createHorizontalBox();
    Box col_of_check = Box.createVerticalBox();
    JScrollPane scrollPane;
    DefaultTableModel model = new DefaultTableModel();
    JButton borrow_btn = new JButton("借阅");
    Box row_of_check1 = Box.createHorizontalBox();
    TableRowSorter<DefaultTableModel> sorter;

    JTable table_of_hist;
    JPanel panel_of_hist = new JPanel();
    Box row_of_hist = Box.createHorizontalBox();
    Box col_of_hist = Box.createVerticalBox();
    JScrollPane scrollPane_hist;
    DefaultTableModel model_hist = new DefaultTableModel();
    JButton return_btn = new JButton("归还图书");

    JTable table_of_info;
    JPanel panel_of_info = new JPanel();
    JScrollPane scrollPane_info;
    DefaultTableModel model_info = new DefaultTableModel();

    public UserJFrame(int id) throws SQLException, ClassNotFoundException
    {
        uid = id;
        connect();
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

//        home_panel.setBackground(new Color(254,254,223));
        home_panel.setBounds(200,150,700,550);

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

        home_panel.add(col2);

        home_panel.setVisible(false);

        this.add(home_panel);

        label_of_check.setFont(font1);
        row_of_check.add(label_of_check);
        row_of_check.add(Box.createHorizontalStrut(120));
        text_of_check.setFont(font1);
        row_of_check.add(text_of_check);
        row_of_check.add(Box.createHorizontalStrut(120));
        btn_of_check.setFont(font1);
        row_of_check.add(btn_of_check);

        col_of_check.add(Box.createVerticalStrut(20));
        col_of_check.add(row_of_check);
        col_of_check.add(Box.createVerticalStrut(10));


        table_of_check = new JTable(model);

        // 添加表头
        model.addColumn("图书编号");
        model.addColumn("图书名称");
        model.addColumn("作者");
        model.addColumn("在馆数量");
        model.addColumn("出版社");
        model.addColumn("类型");

        ResultSet rs = statement.executeQuery("select * from book;");
        // 将查询结果添加到表格中
        while (rs.next()) {
            Object[] row = {
                    rs.getInt("bid"),
                    rs.getString("name"),
                    rs.getString("author"),
                    rs.getInt("nums"),
                    rs.getString("press"),
                    rs.getString("type")
            };
            model.addRow(row);
        }
//        table_of_check.setPreferredScrollableViewportSize(new Dimension(400,200));

//        // 设置表格不可编辑
//        table_of_check.setEnabled(false);
//        table_of_check.setCellSelectionEnabled(true); // 设置单元格可选中


        // 创建 JScrollPane 并将 JTable 添加到其中
        scrollPane = new JScrollPane(table_of_check);

        sorter = new TableRowSorter<>(model);
        table_of_check.setRowSorter(sorter);

        col_of_check.add(scrollPane);

        row_of_check1.add(Box.createHorizontalStrut(500));
        borrow_btn.setFont(font1);
        row_of_check1.add(borrow_btn);

        col_of_check.add(row_of_check1);


        panel_of_check.setBounds(200,150,700,550);

        panel_of_check.add(col_of_check);

        panel_of_check.setBackground(new Color(254,254,223));

//        this.add(panel_of_check);

        table_of_hist = new JTable(model_hist);
        model_hist.addColumn("借阅编号");
        model_hist.addColumn("图书编号");
        model_hist.addColumn("借阅日期");
        model_hist.addColumn("归还日期");
        model_hist.addColumn("是否归还");

        rs = statement.executeQuery("select * from history;");
        // 将查询结果添加到表格中
        while (rs.next()) {
            Object[] row = {
                    rs.getInt("hid"),
                    rs.getInt("bid"),
                    rs.getString("borrow_date"),
                    rs.getString("return_date"),
                    rs.getInt("status"),
            };
            model_hist.addRow(row);
        }
        scrollPane_hist = new JScrollPane(table_of_hist);
        col_of_hist.add(Box.createVerticalStrut(20));
        col_of_hist.add(scrollPane_hist);

        row_of_hist.add(Box.createHorizontalStrut(500));
        return_btn.setFont(font1);
        row_of_hist.add(return_btn);

        col_of_hist.add(Box.createVerticalStrut(20));

        col_of_hist.add(row_of_hist);


        panel_of_hist.setBounds(200,150,700,550);

        panel_of_hist.add(col_of_hist);

        panel_of_hist.setBackground(new Color(254,254,223));

//        this.add(panel_of_hist);

        table_of_info = new JTable(model_info);
        model_info.addColumn("借阅编号");
        model_info.addColumn("读者编号");
        model_info.addColumn("图书编号");
        model_info.addColumn("借阅日期");
        model_info.addColumn("归还日期");
        model_info.addColumn("超期天数");

        rs = statement.executeQuery("select * from book;");
        // 将查询结果添加到表格中
        while (rs.next()) {
            Object[] row = {
                    rs.getInt("hid"),
                    rs.getInt("uid"),
                    rs.getInt("bid"),
                    rs.getString("borrow_date"),
                    rs.getString("press"),
                    rs.getString("type")
            };
            model_info.addRow(row);
        }

        return_btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int selectRow = table_of_hist.getSelectedRow();
                if(selectRow!=-1)
                {
                    int selectId = (int) table_of_hist.getValueAt(selectRow,0);
                    sql = "select * from history where hid = ?;";
                    try
                    {
                        state = connection.prepareStatement(sql);
                        state.setInt(1,selectId);
                        ResultSet resultSet = state.executeQuery();
                        resultSet.next();
                        int status = resultSet.getInt("status");
                        if(status==1)
                        {
                            JOptionPane.showMessageDialog(null,"该图书已归还","归还失败",JOptionPane.WARNING_MESSAGE);
                            return;
                        }


                        sql = "update history set return_date = ?,status = 1 where hid = ?;";
                        state = connection.prepareStatement(sql);

                        long millis = System.currentTimeMillis();
                        Date currentDate = new Date(millis);

                        state.setDate(1,currentDate);

                        state.setInt(2,selectId);
                        state.executeUpdate();


                        model_hist.setValueAt(currentDate,selectRow,3);
                        model_hist.setValueAt(1,selectRow,4);

                        JOptionPane.showMessageDialog(null,"您已成功归还该图书","归还成功",JOptionPane.INFORMATION_MESSAGE);


                    } catch (SQLException ex)
                    {
                        throw new RuntimeException(ex);
                    }

                }
                else
                    JOptionPane.showMessageDialog(null,"请选择您要归还的图书","归还失败",JOptionPane.WARNING_MESSAGE);

            }
        });

        btn_of_check.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String id = text_of_check.getText();
                if(id.isEmpty())
                    sorter.setRowFilter(null);
                else
                    sorter.setRowFilter(RowFilter.regexFilter(id,0));
            }


        });

        borrow_btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int selectRow = table_of_check.getSelectedRow();
//                System.out.println(selectRow);
//                System.out.println("sdf");
                if(selectRow!=-1)
                {
                    int selectId = (int) table_of_check.getValueAt(selectRow,0);
                    System.out.println(selectId);

                    sql = "select * from book where bid = ?;";

                    try
                    {
                        state = connection.prepareStatement(sql);
                        state.setInt(1,selectId);
                        ResultSet resultSet = state.executeQuery();
                        resultSet.next();
                        int nums = resultSet.getInt("nums");
                        int bid = resultSet.getInt("bid");
                        if(nums==0)
                        {
                            JOptionPane.showMessageDialog(null,"该图书暂无库存，无法借阅","借阅失败",JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        nums--;
                        //更新图书的库存
                        sql = "update book set nums = ? where bid = ?;";
                        state = connection.prepareStatement(sql);
                        state.setInt(1,nums);
                        state.setInt(2,selectId);
                        state.executeUpdate();

                        //插入借阅信息
                        sql = "insert into history(uid,bid,borrow_date) values(?,?,?);";
                        state = connection.prepareStatement(sql);
                        state.setInt(1,uid);
                        state.setInt(2,bid);


                        long millis = System.currentTimeMillis();
                        Date currentDate = new Date(millis);

                        state.setDate(3,currentDate);
                        state.execute();

                        model.setValueAt(nums,selectRow,3);

                        JOptionPane.showMessageDialog(null,"借阅成功","借阅成功",JOptionPane.INFORMATION_MESSAGE);


                    } catch (SQLException ex)
                    {
                        throw new RuntimeException(ex);
                    }

                }
                else
                    JOptionPane.showMessageDialog(null,"请选择您要借阅的图书","借阅失败",JOptionPane.WARNING_MESSAGE);

            }
        });

        setting.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("sdf");
                JTextField name1 = new JTextField(10);
                JTextField pwd1 = new JTextField(10);

                JPanel account_panel = new JPanel();
                Box account_col = Box.createVerticalBox();
                Box account_row1 = Box.createHorizontalBox();
                Box account_row2 = Box.createHorizontalBox();

                account_row1.add(new JLabel("新的账号:"));
                account_row1.add(Box.createHorizontalStrut(10));
                account_row1.add(name1);

                account_row2.add(new JLabel("新的密码:"));
                account_row2.add(Box.createHorizontalStrut(10));
                account_row2.add(pwd1);

                account_col.add(account_row1);
                account_col.add(Box.createVerticalStrut(20));
                account_col.add(account_row2);

                account_panel.add(account_col);
                int result = JOptionPane.showConfirmDialog(null,account_panel,"账号设置",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if(result == JOptionPane.OK_OPTION)
                {
                    String new_name = name1.getText();

                    if(new_name.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"您输入的账号不能为空！","修改失败",JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String new_pwd = pwd1.getText();
                    if(new_pwd.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"您输入的密码不能为空！","修改失败",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    sql = "select * from user where account = ?;";
                    try
                    {
                        state = connection.prepareStatement(sql);
                        state.setString(1,name);
                        ResultSet resultSet = state.executeQuery();
                        if(resultSet.next())
                        {
                            JOptionPane.showMessageDialog(null,"请重新输入您的账号！","账号已存在",JOptionPane.ERROR_MESSAGE);
                            return;

                        }
                    } catch (SQLException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                    sql = "update user set account = ?, password = ? where uid = ?;";
                    try
                    {

                        state = connection.prepareStatement(sql);
                        state.setString(1,new_name);
                        state.setString(2,new_pwd);
                        state.setInt(3,uid);
                        state.executeUpdate();
                        JOptionPane.showMessageDialog(null,"即将返回登录界面","修改成功",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new LoginJFrame();
                    } catch (SQLException | ClassNotFoundException ex)
                    {
                        throw new RuntimeException(ex);
                    }

                }

            }
        });




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

        sql = "select * from user where uid = ?;";
        state = connection.prepareStatement(sql);
        state.setInt(1,uid);
        ResultSet resultSet = state.executeQuery();
        resultSet.next();
        name = resultSet.getString("account");
    }
}
