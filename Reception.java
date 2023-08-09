package Hotel_Management_System;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener
{

    JButton NewCustForm,Room,Department,AllEmpInfo,CustInfo,ManagerInfo,Checkout,UpdateStatus,UpdateRoomStatus,PickUpService,SearchRoom,Logout;
    Reception()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(220,10,550,470);
        add(image);

        NewCustForm = new JButton("New Customer Form");
        NewCustForm.setBackground(Color.BLACK);
        NewCustForm.setForeground(Color.WHITE);
        NewCustForm.setBounds(10,10,200,30);
        NewCustForm.setFont(new Font("Raleway",Font.BOLD,16));
        NewCustForm.addActionListener(this);
        add(NewCustForm);

        Room = new JButton("Rooms");
        Room.setBackground(Color.BLACK);
        Room.setForeground(Color.WHITE);
        Room.setBounds(10,50,200,30);
        Room.setFont(new Font("Raleway",Font.BOLD,16));
        Room.addActionListener(this);
        add(Room);

        Department = new JButton("Department");
        Department.setBackground(Color.BLACK);
        Department.setForeground(Color.WHITE);
        Department.setBounds(10,90,200,30);
        Department.setFont(new Font("Raleway",Font.BOLD,16));
        Department.addActionListener(this);
        add(Department);

        AllEmpInfo = new JButton("All Employee Info");
        AllEmpInfo.setBackground(Color.BLACK);
        AllEmpInfo.setForeground(Color.WHITE);
        AllEmpInfo.setBounds(10,130,200,30);
        AllEmpInfo.setFont(new Font("Raleway",Font.BOLD,16));
        AllEmpInfo.addActionListener(this);
        add(AllEmpInfo);

        CustInfo = new JButton("Customer Information");
        CustInfo.setBackground(Color.BLACK);
        CustInfo.setForeground(Color.WHITE);
        CustInfo.setBounds(10,170,200,30);
        CustInfo.setFont(new Font("Raleway",Font.BOLD,16));
        CustInfo.addActionListener(this);
        add(CustInfo);

        ManagerInfo = new JButton("Manager Information");
        ManagerInfo.setBackground(Color.BLACK);
        ManagerInfo.setForeground(Color.WHITE);
        ManagerInfo.setBounds(10,210,200,30);
        ManagerInfo.setFont(new Font("Raleway",Font.BOLD,16));
        ManagerInfo.addActionListener(this);
        add(ManagerInfo);

        Checkout = new JButton("Check Out");
        Checkout.setBackground(Color.BLACK);
        Checkout.setForeground(Color.WHITE);
        Checkout.setBounds(10,250,200,30);
        Checkout.setFont(new Font("Raleway",Font.BOLD,16));
        Checkout.addActionListener(this);
        add(Checkout);

        UpdateStatus = new JButton("Update Status");
        UpdateStatus.setBackground(Color.BLACK);
        UpdateStatus.setForeground(Color.WHITE);
        UpdateStatus.setBounds(10,290,200,30);
        UpdateStatus.setFont(new Font("Raleway",Font.BOLD,16));
        UpdateStatus.addActionListener(this);
        add(UpdateStatus);

        UpdateRoomStatus = new JButton("Update Room Status");
        UpdateRoomStatus.setBackground(Color.BLACK);
        UpdateRoomStatus.setForeground(Color.WHITE);
        UpdateRoomStatus.setBounds(10,330,200,30);
        UpdateRoomStatus.setFont(new Font("Raleway",Font.BOLD,16));
        UpdateRoomStatus.addActionListener(this);
        add(UpdateRoomStatus);

        PickUpService = new JButton("Pick up Service");
        PickUpService.setBackground(Color.BLACK);
        PickUpService.setForeground(Color.WHITE);
        PickUpService.setBounds(10,370,200,30);
        PickUpService.setFont(new Font("Raleway",Font.BOLD,16));
        PickUpService.addActionListener(this);
        add(PickUpService);

        SearchRoom = new JButton("Search Rooms");
        SearchRoom.setBackground(Color.BLACK);
        SearchRoom.setForeground(Color.WHITE);
        SearchRoom.setBounds(10,410,200,30);
        SearchRoom.setFont(new Font("Raleway",Font.BOLD,16));
        SearchRoom.addActionListener(this);
        add(SearchRoom);

        Logout = new JButton("Logout");
        Logout.setBackground(Color.BLACK);
        Logout.setForeground(Color.WHITE);
        Logout.setBounds(10,450,200,30);
        Logout.setFont(new Font("Raleway",Font.BOLD,16));
        Logout.addActionListener(this);
        add(Logout);

        setBounds(290,150,800,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==NewCustForm)
        {
            setVisible(false);
            new AddCustomer();
        }
        else if (ae.getSource()==Room)
        {
            setVisible(false);
            new DisplayRoom();
        }
        else if (ae.getSource()==Department)
        {
            setVisible(false);
            new Department();
        }
        else if (ae.getSource()==AllEmpInfo)
        {
            setVisible(false);
            new EmployeeInformation();
        }
        else if (ae.getSource()==CustInfo)
        {
            setVisible(false);
            new CustomerInformation();
        }
        else if (ae.getSource()==SearchRoom)
        {
            setVisible(false);
            new SearchRoom();
        }
        else if (ae.getSource()==PickUpService)
        {
            setVisible(false);
            new PickUpService();
        }
        else if (ae.getSource()==UpdateRoomStatus)
        {
            setVisible(false);
            new UpdateRoomStatus();
        }
        else if (ae.getSource()==UpdateStatus)
        {
            setVisible(false);
            new UpdateStatus();
        }
        else if (ae.getSource()==Checkout)
        {
            setVisible(false);
            new CheckOut();
        }
        else if (ae.getSource()==ManagerInfo)
        {
            setVisible(false);
            new ManagerInformation();
        }
        else
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new Reception();
    }
}
