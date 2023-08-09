package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateStatus extends JFrame implements ActionListener
{
    JButton check,update,back;
    Choice ch;
    JTextField TFRoom,TFName,TFAmountPaid,TFCheckIn,TFPendingAmount;
    UpdateStatus()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel text = new JLabel("Update Status");
        text.setForeground(Color.BLACK);
        text.setBounds(150,15,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,24));
        add(text);

        JLabel custId = new JLabel("Customer Id");
        custId.setBounds(30,70,150,20);
        custId.setFont(new Font("Raleway",Font.BOLD,16));
        add(custId);

        ch = new Choice();
        ch.setBounds(200,70,200,30);
        add(ch);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Customer");
            while (rs.next())
            {
                ch.add(rs.getString("ID_Number"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        JLabel RoomNo = new JLabel("Room Number");
        RoomNo.setBounds(30,120,200,20);
        RoomNo.setFont(new Font("Raleway",Font.BOLD,16));
        add(RoomNo);

        TFRoom = new JTextField();
        TFRoom.setBounds(200,120,200,30);
        TFRoom.setFont(new Font("Raleway",Font.PLAIN,14));
        add(TFRoom);

        JLabel Name = new JLabel("Name");
        Name.setBounds(30,170,200,20);
        Name.setFont(new Font("Raleway",Font.BOLD,16));
        add(Name);

        TFName = new JTextField();
        TFName.setBounds(200,170,200,30);
        TFName.setFont(new Font("Raleway",Font.PLAIN,14));
        add(TFName);

        JLabel checkIn = new JLabel("Check In");
        checkIn.setBounds(30,220,200,20);
        checkIn.setFont(new Font("Raleway",Font.BOLD,16));
        add(checkIn);

        TFCheckIn = new JTextField();
        TFCheckIn.setBounds(200,220,200,30);
        TFCheckIn.setFont(new Font("Raleway",Font.PLAIN,16));
        add(TFCheckIn);

        JLabel AmountPaid = new JLabel("Amount Paid");
        AmountPaid.setBounds(30,270,200,20);
        AmountPaid.setFont(new Font("Raleway",Font.BOLD,16));
        add(AmountPaid);

        TFAmountPaid = new JTextField();
        TFAmountPaid.setBounds(200,270,200,30);
        TFAmountPaid.setFont(new Font("Raleway",Font.PLAIN,16));
        add(TFAmountPaid);

        JLabel PendingAmount = new JLabel("Pending Amount");
        PendingAmount.setBounds(30,320,200,20);
        PendingAmount.setFont(new Font("Raleway",Font.BOLD,16));
        add(PendingAmount);

        TFPendingAmount = new JTextField();
        TFPendingAmount.setBounds(200,320,200,30);
        TFPendingAmount.setFont(new Font("Raleway",Font.PLAIN,16));
        add(TFPendingAmount);

        check = new JButton("Check");
        check.setBounds(30,390,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Raleway",Font.BOLD,16));
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150,390,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Raleway",Font.BOLD,16));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,390,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,70,400,300);
        add(image);

        setBounds(230,170,900,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==check)
        {
            String id = ch.getSelectedItem();
            String Query = "Select * from Customer where ID_Number = '"+id+"'";
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(Query);
                while (rs.next())
                {
                    TFRoom.setText(rs.getString("Room_No"));
                    TFName.setText(rs.getString("Cust_Name"));
                    TFCheckIn.setText(rs.getString("Check_In_Time"));
                    TFAmountPaid.setText(rs.getString("Deposit"));
                }
                ResultSet rs1 = c.s.executeQuery("Select * from AddRoom where Room_Number = '"+TFRoom.getText()+"'");
                while (rs1.next())
                {
                    String price = rs1.getString("Price");
                    int AmountPaid = Integer.parseInt(price) - Integer.parseInt(TFAmountPaid.getText());
                    TFPendingAmount.setText(" " +AmountPaid);
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource()==update)
        {
            String id = ch.getSelectedItem();
            String RoomNo = TFRoom.getText();
            String name = TFName.getText();
            String checkin = TFCheckIn.getText();
            String deposit = TFAmountPaid.getText();

            try
            {
                Conn c = new Conn();
                c.s.executeUpdate("Update Customer set Room_No = '"+RoomNo+"',Cust_Name = '"+name+"',Check_In_Time = '"+checkin+"',Deposit = '"+deposit+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");

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
        new UpdateStatus();
    }
}
