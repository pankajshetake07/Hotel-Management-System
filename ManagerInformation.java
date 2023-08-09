package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInformation extends JFrame implements ActionListener
{
    ManagerInformation()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel j1 = new JLabel("Name");
        j1.setFont(new Font("Raleway",Font.BOLD,16));
        j1.setBounds(50,20,90,30);
        add(j1);

        JLabel j2 = new JLabel("Age");
        j2.setFont(new Font("Raleway",Font.BOLD,16));
        j2.setBounds(220,20,90,30);
        add(j2);

        JLabel j3 = new JLabel("Gender");
        j3.setFont(new Font("Raleway",Font.BOLD,16));
        j3.setBounds(350,20,90,30);
        add(j3);

        JLabel j4 = new JLabel("Job");
        j4.setFont(new Font("Raleway",Font.BOLD,16));
        j4.setBounds(500,20,90,30);
        add(j4);

        JLabel j5 = new JLabel("Salary");
        j5.setFont(new Font("Raleway",Font.BOLD,16));
        j5.setBounds(640,20,90,30);
        add(j5);

        JLabel j6 = new JLabel("Phone");
        j6.setFont(new Font("Raleway",Font.BOLD,16));
        j6.setBounds(780,20,90,30);
        add(j6);

        JLabel j7 = new JLabel("Email");
        j7.setFont(new Font("Raleway",Font.BOLD,16));
        j7.setBounds(930,20,90,30);
        add(j7);

        JLabel j8 = new JLabel("Aadhar");
        j8.setFont(new Font("Raleway",Font.BOLD,16));
        j8.setBounds(1070,20,90,30);
        add(j8);

        JButton back = new JButton("Back");
        back.setBounds(520,450,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        add(back);

        JTable table = new JTable();
        table.setBounds(10,70,1170,500);
        add(table);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from AddEmployee where Job = 'Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        setBounds(100,150,1200,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args)
    {
        new ManagerInformation();
    }
}
