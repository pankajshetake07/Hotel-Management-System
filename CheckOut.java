package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class CheckOut extends JFrame implements ActionListener
{
    JTextField TFRoomNo;
    JLabel RoomNo1;
    Choice ch;
    JButton check,back;
    JLabel j2,j1;
    CheckOut()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Check Out");
        text.setForeground(Color.BLUE);
        text.setBounds(100,20,200,30);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);

        JLabel GuestId = new JLabel("Customer Id");
        GuestId.setBounds(30,80,100,30);
        GuestId.setFont(new Font("Raleway",Font.BOLD,16));
        add(GuestId);

        ch = new Choice();
        ch.setBounds(200,80,200,30);
        add(ch);

        ImageIcon t1 = new ImageIcon(ClassLoader.getSystemResource("t.png"));
        Image t2 = t1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon t3 = new ImageIcon(t2);
        JLabel image1 = new JLabel(t3);
        image1.setBounds(410,80,20,20);
        add(image1);


        JLabel RoomNo = new JLabel("Room Number");
        RoomNo.setBounds(30,150,200,30);
        RoomNo.setFont(new Font("Raleway",Font.BOLD,16));
        add(RoomNo);

        RoomNo1 = new JLabel();
        RoomNo1.setBounds(200,150,200,30);
        add(RoomNo1);

        JLabel Availability = new JLabel("CheckedIn Time");
        Availability.setBounds(30,220,200,30);
        Availability.setFont(new Font("Raleway",Font.BOLD,16));
        add(Availability);

        //Date date = new Date();
        j1 = new JLabel();
        j1.setBounds(200,220,250,30);
        j1.setFont(new Font("Raleway",Font.BOLD,14));
        add(j1);

        JLabel CheckStatus = new JLabel("CheckedOut Time");
        CheckStatus.setBounds(30,290,200,30);
        CheckStatus.setFont(new Font("Raleway",Font.BOLD,16));
        add(CheckStatus);

        Date date = new Date();
        j2 = new JLabel(" "+date);
        j2.setBounds(200,290,250,30);
        j2.setFont(new Font("Raleway",Font.BOLD,14));
        add(j2);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from Customer");
            while (rs.next())
            {
                ch.add(rs.getString("ID_Number"));
                RoomNo1.setText(rs.getString("Room_No"));
                j1.setText(rs.getString("Check_In_Time"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        check = new JButton("CheckOut");
        check.setBounds(30,380,170,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Releway",Font.BOLD,16));
        check.addActionListener(this);
        add(check);


        back = new JButton("Back");
        back.setBounds(220,380,170,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Releway",Font.BOLD,16));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320,0,700,500);
        add(image);

        setBounds(200,170,950,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==check) {
            String id = ch.getSelectedItem();
            String Query = "delete from Customer where ID_Number = '" + ch.getSelectedItem() + "'";
            String Query1 = "update AddRoom set Availability = 'Available' where Room_Number = '"+RoomNo1.getText()+"'";
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate(Query);
                c.s.executeUpdate(Query1);

                JOptionPane.showMessageDialog(null,"Check out Done");
                setVisible(false);
                new Reception();

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
        new CheckOut();
    }
}
