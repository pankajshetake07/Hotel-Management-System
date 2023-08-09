package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener
{
    JTable table;
    Department()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel j1 = new JLabel("Department");
        j1.setBounds(150,20,100,30);
        j1.setFont(new Font("Raleway",Font.BOLD,14));
        add(j1);

        JLabel j2 = new JLabel("Budget");
        j2.setBounds(500,20,100,30);
        j2.setFont(new Font("Raleway",Font.BOLD,14));
        add(j2);

        JButton back = new JButton("Back");
        back.setBounds(300,450,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        add(back);

        table = new JTable();
        table.setBounds(20,70,750,500);
        add(table);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from Department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        setBounds(200,150,800,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args)
    {
        new Department();
    }
}
