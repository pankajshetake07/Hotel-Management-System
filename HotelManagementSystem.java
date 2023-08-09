package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener
{
    HotelManagementSystem()
    {
        setSize(1300,565);   //setBounds(50,100,1300,565);
        setLocation(50,100);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1300,565);//locationx,locationy,length,breadth
        add(image);
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setForeground(Color.WHITE);
        text.setBounds(50,450,700,50);
        text.setFont(new Font("serif",Font.BOLD,40));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1100,460,150,40);
        next.setFont(new Font("serif",Font.PLAIN,22));
        next.addActionListener(this);
        image.add(next);

        setVisible(true);
        while (true)
        {
            text.setVisible(false);
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            text.setVisible(true);
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
            setVisible(false);
            new Login().setVisible(true);
    }

    public static void main(String[] args)
    {
        new HotelManagementSystem();
    }
}
