package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener
{
    JTable table;
    JButton back,search;
    JComboBox val;
    JCheckBox status;
    SearchRoom()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Search for Room");
        text.setBounds(370,20,200,30);
        text.setFont(new Font("Raleway",Font.PLAIN,24));
        add(text);

        status = new JCheckBox("Only display available");
        status.setBounds(650,80,200,30);
        status.setFont(new Font("Raleway",Font.BOLD,14));
        status.setBackground(Color.WHITE);
        add(status);

        JLabel l1 = new JLabel("Room Bed Type");
        l1.setBounds(50,80,150,30);
        l1.setFont(new Font("Raleway",Font.BOLD,14));
        add(l1);

        String[] type = {"Single","Double"};
        val = new JComboBox(type);
        val.setBounds(180,80,150,30);
        val.setBackground(Color.WHITE);
        val.setFont(new Font("Raleway",Font.PLAIN,14));
        add(val);

        JLabel j1 = new JLabel("Room Number");
        j1.setBounds(50,160,100,20);
        j1.setFont(new Font("Raleway",Font.BOLD,14));
        add(j1);

        JLabel j2 = new JLabel("Availability");
        j2.setBounds(250,160,100,20);
        j2.setFont(new Font("Raleway",Font.BOLD,14));
        add(j2);

        JLabel j3 = new JLabel("Status");
        j3.setBounds(450,160,100,20);
        j3.setFont(new Font("Raleway",Font.BOLD,14));
        add(j3);

        JLabel j4 = new JLabel("Price");
        j4.setBounds(650,160,100,20);
        j4.setFont(new Font("Raleway",Font.BOLD,14));
        add(j4);

        JLabel j5 = new JLabel("Type");
        j5.setBounds(840,160,100,20);
        j5.setFont(new Font("Raleway",Font.BOLD,14));
        add(j5);

        back = new JButton("Back");
        back.setBounds(530,450,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        search = new JButton("Search");
        search.setBounds(320,450,150,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        table = new JTable();
        table.setBounds(10,200,960,500);
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
        if (ae.getSource()==search)
        {
            try
            {
                String Query1 = "Select * from AddRoom where Bed_Type =  '"+val.getSelectedItem()+"'";
                String Query2 = "Select * from AddRoom where Availability = 'Available' AND Bed_Type = '"+val.getSelectedItem()+"'";
                Conn c = new Conn();
                ResultSet rs;
                if (status.isSelected())
                {
                    rs = c.s.executeQuery(Query2);
                }
                else
                {
                    rs = c.s.executeQuery(Query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args)
    {
        new SearchRoom();
    }
}
