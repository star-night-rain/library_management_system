package ui;

import javax.swing.*;

public class AdminJFrame
{
    JButton check_btn = new JButton("图书管理");
    JLabel check_label1 = new JLabel("可浏览图书馆的所有图书资源");
    JLabel check_label2 = new JLabel("根据图书编号、图书名称查询图书信息");
    JLabel check_label3 = new JLabel("可查询图书的编号、名称、分类、作者、在馆数量等");
    JLabel check_label4 = new JLabel("添加、修改、删除图书");
    JButton class_btn = new JButton("图书查阅");
    JLabel class_label1 = new JLabel("根据分类名称查询图书分类信息");
    JLabel class_label2 = new JLabel("添加、修改、删除图书分类");
    JButton borrow_btn = new JButton("图书借阅");
    JLabel borrow_label = new JLabel("展示所有正在借阅图书的信息");
    JButton return_btn = new JButton("图书归还");
    JLabel return_label = new JLabel("展示所有已归还的图书的信息");
    JButton reader_btn = new JButton("读者管理");
    JLabel reader_label1 = new JLabel("根据账号、姓名查阅读者基本信息");
    JLabel reader_label2 = new JLabel("添加、修改、删除读者信息");
}
