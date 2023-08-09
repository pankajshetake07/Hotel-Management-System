package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInformation extends JFrame implements ActionListener
{
    CustomerInformation()
    {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel j1 = new JLabel("Customer ID");
        j1.setFont(new Font("Raleway",Font.BOLD,14));
        j1.setBounds(40,20,90,25);
        add(j1);

        JLabel j2 = new JLabel("ID Number");
        j2.setFont(new Font("Raleway",Font.BOLD,14));
        j2.setBounds(190,20,90,25);
        add(j2);

        JLabel j3 = new JLabel("Name");
        j3.setFont(new Font("Raleway",Font.BOLD,14));
        j3.setBounds(350,20,90,25);
        add(j3);

        JLabel j4 = new JLabel("Gender");
        j4.setFont(new Font("Raleway",Font.BOLD,14));
        j4.setBounds(500,20,90,25);
        add(j4);

        JLabel j5 = new JLabel("Country");
        j5.setFont(new Font("Raleway",Font.BOLD,14));
        j5.setBounds(640,20,90,25);
        add(j5);

        JLabel j6 = new JLabel("Room No");
        j6.setFont(new Font("Raleway",Font.BOLD,14));
        j6.setBounds(780,20,90,25);
        add(j6);

        JLabel j7 = new JLabel("Time");
        j7.setFont(new Font("Raleway",Font.BOLD,14));
        j7.setBounds(930,20,90,25);
        add(j7);

        JLabel j8 = new JLabel("Deposit");
        j8.setFont(new Font("Raleway",Font.BOLD,14));
        j8.setBounds(1070,20,90,25);
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
            ResultSet rs = c.s.executeQuery("Select * from Customer");
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
        new CustomerInformation();
    }
}
