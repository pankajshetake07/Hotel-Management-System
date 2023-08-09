package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener
{
    JLabel title,RoomNo,Available,CleaningStatus,Price,BedType;
    JTextField RoomNoTextField,PriceTextField;
    JComboBox val,val1,val2;
    JButton addroom,cancel;
    AddRoom()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,450,400);
        add(image);

        title = new JLabel("Add Rooms");
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setBounds(150,30,200,20);
        add(title);

        RoomNo = new JLabel("Room Number");
        RoomNo.setBounds(50,90,150,30);
        RoomNo.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(RoomNo);

        RoomNoTextField = new JTextField();
        RoomNoTextField.setBounds(220,90,150,30);
        RoomNoTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(RoomNoTextField);

        Available = new JLabel("Available");
        Available.setBounds(50,150,150,30);
        Available.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Available);

        String[] value1 = {"Available","Occupied"};
        val = new JComboBox(value1);
        val.setBounds(220,150,150,30);
        val.setBackground(Color.WHITE);
        add(val);

        CleaningStatus = new JLabel("Cleaning Status");
        CleaningStatus.setBounds(50,210,150,30);
        CleaningStatus.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(CleaningStatus);

        String[] value2 = {"Cleaned","Dirty"};
        val1 = new JComboBox(value2);
        val1.setBounds(220,210,150,30);
        val1.setBackground(Color.WHITE);
        add(val1);

        Price = new JLabel("Price");
        Price.setBounds(50,270,150,30);
        Price.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Price);

        PriceTextField = new JTextField();
        PriceTextField.setBounds(220,270,150,30);
        PriceTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(PriceTextField);

        BedType = new JLabel("Bed Type");
        BedType.setBounds(50,330,150,30);
        BedType.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(BedType);

        String[] value3 = {"Single","Double"};
        val2 = new JComboBox(value3);
        val2.setBounds(220,330,150,30);
        val2.setBackground(Color.WHITE);
        add(val2);

        addroom = new JButton("Add Room");
        addroom.setBounds(50,390,150,30);
        addroom.setBackground(Color.BLACK);
        addroom.setForeground(Color.WHITE);
        addroom.addActionListener(this);
        add(addroom);

        cancel = new JButton("Cancel ");
        cancel.setBounds(220,390,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(230,170,900,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==addroom)
        {
            String roomNumber = RoomNoTextField.getText();
            String availability = (String) val.getSelectedItem();
            String status = (String) val1.getSelectedItem();
            String price = PriceTextField.getText();
            String type = (String) val2.getSelectedItem();

            try
            {
                Conn c = new Conn();
                String Query = "Insert into AddRoom values('"+roomNumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null,"Room added successfully");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new AddRoom();
    }
}
