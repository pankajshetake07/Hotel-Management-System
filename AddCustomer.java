package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.jar.JarEntry;

public class AddCustomer extends JFrame implements ActionListener
{

    JLabel Number,CID,name,gender,country,AllocatedRoomNo,CheckInTime,Deposit,check;
    JComboBox IDValue;
    JTextField numberTextField,nameTextField,countryTextField,DepositTextField;
    ButtonGroup genderGroup;
    JRadioButton male,female;
    Choice ch;
    JButton add,back;
    AddCustomer()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel Text = new JLabel("NEW CUSTOMER FORM");
        Text.setBounds(100,25,300,30);
        Text.setFont(new Font("Raleway",Font.BOLD,20));
        add(Text);

        CID = new JLabel("ID");
        CID.setBounds(40,90,100,30);
        CID.setFont(new Font("Raleway",Font.BOLD,16));
        add(CID);

        String[] option = {"Aadhar Card","Passport","Driving License","Voter Id Card","PAN Card"};
        IDValue = new JComboBox(option);
        IDValue.setBackground(Color.WHITE);
        IDValue.setBounds(200,90,200,30);
        add(IDValue);

        Number = new JLabel("Number");
        Number.setBounds(40,130,100,30);
        Number.setFont(new Font("Raleway",Font.BOLD,14));
        add(Number);

        numberTextField = new JTextField();
        numberTextField.setBounds(200,130,200,25);
        numberTextField.setFont(new Font("Raleway",Font.PLAIN,14));
        add(numberTextField);

        name = new JLabel("Name");
        name.setBounds(40,170,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,14));
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(200,170,200,25);
        nameTextField.setFont(new Font("Raleway",Font.PLAIN,14));
        add(nameTextField);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,14));
        gender.setBounds(40,210,100,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(200,210,70,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(300,210,70,30);
        female.setBackground(Color.WHITE);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        country = new JLabel("Country");
        country.setBounds(40,250,100,30);
        country.setFont(new Font("Raleway",Font.BOLD,14));
        add(country);

        countryTextField = new JTextField();
        countryTextField.setBounds(200,250,200,25);
        countryTextField.setFont(new Font("Raleway",Font.PLAIN,14));
        add(countryTextField);

        AllocatedRoomNo = new JLabel("Room No.");
        AllocatedRoomNo.setBounds(40,290,100,30);
        AllocatedRoomNo.setFont(new Font("Raleway",Font.BOLD,14));
        add(AllocatedRoomNo);

        ch = new Choice();

        try
        {
            Conn c = new Conn();
            String Query = "select * from AddRoom where Availability = 'Available'";
            ResultSet rs = Conn.s.executeQuery(Query);
            while (rs.next())
            {
                ch.add(rs.getString("Room_Number"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        ch.setBounds(200,290,200,30);
        ch.setBackground(Color.WHITE);
        add(ch);

        CheckInTime = new JLabel("Check Time");
        CheckInTime.setBounds(40,330,100,30);
        CheckInTime.setFont(new Font("Raleway",Font.BOLD,14));
        add(CheckInTime);

        Date date = new Date();

        check = new JLabel(" " + date);
        check.setBounds(200,330,200,30);
        check.setFont(new Font("Raleway",Font.BOLD,14));
        add(check);

        Deposit = new JLabel("Deposit");
        Deposit.setBounds(40,370,100,30);
        Deposit.setFont(new Font("Raleway",Font.BOLD,14));
        add(Deposit);

        DepositTextField = new JTextField();
        DepositTextField.setBounds(200,370,200,25);
        DepositTextField.setFont(new Font("Raleway",Font.PLAIN,14));
        add(DepositTextField);

        add = new JButton("Add");
        add.setFont(new Font("Raleway",Font.PLAIN,16));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(40,430,150,30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.PLAIN,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(240,430,150,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cust.png"));
        Image i2 = i1.getImage().getScaledInstance(370,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,300,400);
        add(image);

        setBounds(290,150,800,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==add)
        {
            String getid = (String) IDValue.getSelectedItem();
            String getNumber = numberTextField.getText();
            String getname = nameTextField.getText();
            String getGender = null;
            if (male.isSelected())
            {
                getGender = "Male";
            }
            else
            {
                getGender = "Female";
            }
            String getcountry = countryTextField.getText();
            String getroom = ch.getSelectedItem();
            String gettime = check.getText();
            String getdeposit = DepositTextField.getText();

            try
            {
                Conn c = new Conn();
                String Query1 = "insert into Customer values('"+getid+"','"+getNumber+"','"+getname+"','"+getGender+"','"+getcountry+"','"+getroom+"','"+gettime+"','"+getdeposit+"')";
                String Query2 = "update AddRoom set Availability = 'Occupied' where Room_Number = '"+getroom+"'";
                c.s.executeUpdate(Query1);
                c.s.executeUpdate(Query2);
                JOptionPane.showMessageDialog(null,"Customer added successfully");

                setVisible(false);
                new Reception();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args)
    {
        new AddCustomer();
    }
}
