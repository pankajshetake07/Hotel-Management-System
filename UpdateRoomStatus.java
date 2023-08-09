package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoomStatus extends JFrame implements ActionListener
{
    JTextField TFGID,TFRoomNo,TFAvailability,TFCheckStatus;
    Choice ch;
    JButton check,update,back;
    UpdateRoomStatus()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Room Status");
        text.setForeground(Color.BLACK);
        text.setBounds(100,20,200,30);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);

        JLabel GuestId = new JLabel("Guest Id");
        GuestId.setBounds(30,80,100,30);
        GuestId.setFont(new Font("Raleway",Font.BOLD,16));
        add(GuestId);

        ch = new Choice();
        ch.setBounds(200,80,200,30);
        add(ch);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from Customer");
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
        RoomNo.setBounds(30,150,200,30);
        RoomNo.setFont(new Font("Raleway",Font.BOLD,16));
        add(RoomNo);

        TFRoomNo = new JTextField();
        TFRoomNo.setBounds(200,150,200,30);
        add(TFRoomNo);

        JLabel Availability = new JLabel("Availability");
        Availability.setBounds(30,220,200,30);
        Availability.setFont(new Font("Raleway",Font.BOLD,16));
        add(Availability);

        TFAvailability = new JTextField();
        TFAvailability.setBounds(200,220,200,30);
        add(TFAvailability);

        JLabel CheckStatus = new JLabel("Clean Status");
        CheckStatus.setBounds(30,290,200,30);
        CheckStatus.setFont(new Font("Raleway",Font.BOLD,16));
        add(CheckStatus);

        TFCheckStatus = new JTextField();
        TFCheckStatus.setBounds(200,290,200,30);
        add(TFCheckStatus);

        check = new JButton("Check");
        check.setBounds(30,380,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Releway",Font.BOLD,16));
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(165,380,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Releway",Font.BOLD,16));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(300,380,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Releway",Font.BOLD,16));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("seventh.jpg"));
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
        if (ae.getSource()==check)
        {
            String id = ch.getSelectedItem();
            String Query = "Select * from Customer where ID_Number = '"+id+"'";
            try
            {
                Conn c = new Conn();
                ResultSet rs1 = c.s.executeQuery(Query);
                while (rs1.next())
                {
                    TFRoomNo.setText(rs1.getString("Room_No"));
                }
                ResultSet rs = c.s.executeQuery("Select * from AddRoom where Room_Number = '"+TFRoomNo.getText()+"'");
                while (rs.next())
                {
                    TFAvailability.setText(rs.getString("Availability"));
                    TFCheckStatus.setText(rs.getString("Cleaning_Status"));
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
            String roomno = TFRoomNo.getText();
            String availability = TFAvailability.getText();
            String status = TFCheckStatus.getText();

            try
            {
                Conn c = new Conn();
                c.s.executeUpdate("Update AddRoom set Availability = '"+availability+"',Cleaning_Status = '"+status+"' where Room_Number = '"+roomno+"'");
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
        new UpdateRoomStatus();
    }
}
