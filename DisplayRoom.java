package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DisplayRoom extends JFrame implements ActionListener
{
    JTable table;
    JButton back;
    DisplayRoom()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,470,480);
        add(image);

        JLabel j1 = new JLabel("Room Number");
        j1.setBounds(10,20,100,20);
        j1.setFont(new Font("Raleway",Font.BOLD,12));
        add(j1);

        JLabel j2 = new JLabel("Availability");
        j2.setBounds(120,20,100,20);
        j2.setFont(new Font("Raleway",Font.BOLD,12));
        add(j2);

        JLabel j3 = new JLabel("Status");
        j3.setBounds(230,20,100,20);
        j3.setFont(new Font("Raleway",Font.BOLD,12));
        add(j3);

        JLabel j4 = new JLabel("Price");
        j4.setBounds(340,20,100,20);
        j4.setFont(new Font("Raleway",Font.BOLD,12));
        add(j4);

        JLabel j5 = new JLabel("Type");
        j5.setBounds(430,20,100,20);
        j5.setFont(new Font("Raleway",Font.BOLD,12));
        add(j5);

        back = new JButton("Back");
        back.setBounds(200,450,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        table.setBounds(0,50,500,480);
        add(table);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from AddRoom");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        setBounds(200,150,1000,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args)
    {
        new DisplayRoom();
    }
}
