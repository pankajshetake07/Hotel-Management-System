package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener
{
    JMenuItem reception,addEmployee,addRooms,addDriver;
    Dashboard()
    {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1366,730);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setFont(new Font("Raleway",Font.BOLD,30));
        text.setForeground(Color.WHITE);
        text.setBounds(430,50,800,50);
        image.add(text);

        JMenuBar mb = new JMenuBar();  //Adding menubar on top of the screen
        mb.setBounds(0,0,1366,30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);

        reception = new JMenuItem("RECEPTION");  //Adding menu item into the hotel management menu
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        mb.add(admin);

        addEmployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addEmployee);
        addEmployee.addActionListener(this);
        addRooms = new JMenuItem("ADD ROOM");
        admin.add(addRooms);
        addRooms.addActionListener(this);
        addDriver = new JMenuItem("ADD DRIVER");
        admin.add(addDriver);
        addDriver.addActionListener(this);

        setBounds(0,0,1366,730);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOM"))
        {
            new AddRoom();
        }
        else if (ae.getActionCommand().equals("ADD DRIVER"))
        {
            new AddDriver();
        }
        else if (ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception();
        }
    }

    public static void main(String[] args)
    {
        new Dashboard();
    }
}
