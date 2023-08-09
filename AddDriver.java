package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener
{

    JLabel title,DName,DAge,DGender,CarModel,Availability,Location;
    JTextField DNameTextField,DAgeTextField,LocationTextField,CarModelTextField;
    JComboBox val,model;
    JRadioButton male,female;
    ButtonGroup genderGroup;
    JButton addDriver,cancel;
    AddDriver()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,450,450);
        add(image);

        title = new JLabel("Add Driver");
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setBounds(150,20,200,20);
        add(title);

        DName = new JLabel("Name");
        DName.setBounds(50,80,150,30);
        DName.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(DName);

        DNameTextField = new JTextField();
        DNameTextField.setBounds(180,80,170,30);
        DNameTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(DNameTextField);

        DAge = new JLabel("Age");
        DAge.setBounds(50,140,150,30);
        DAge.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(DAge);

        DAgeTextField = new JTextField();
        DAgeTextField.setBounds(180,140,170,30);
        DAgeTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(DAgeTextField);

        DGender = new JLabel("Gender");
        DGender.setBounds(50,200,150,30);
        DGender.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(DGender);

        male = new JRadioButton("Male");
        male.setBounds(180,200,70,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(280,200,70,30);
        female.setBackground(Color.WHITE);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        CarModel = new JLabel("Car Model");
        CarModel.setBounds(50,260,150,30);
        CarModel.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(CarModel);

        String[] option = {"Creta","Fortuner","Kia","Alto","Swift","HondaCity","Harrier","Ciaz","Verna"};
        model = new JComboBox(option);
        model.setBounds(180,260,170,30);
        model.setBackground(Color.WHITE);
        model.setFont(new Font("Raleway",Font.PLAIN,14));
        add(model);

//        CarModelTextField = new JTextField();
//        CarModelTextField.setBounds(180,260,170,30);
//        CarModelTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
//        add(CarModelTextField);

        Availability = new JLabel("Availability");
        Availability.setBounds(50,320,150,30);
        Availability.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Availability);

        String[] value = {"Available","Occupied"};
        val = new JComboBox(value);
        val.setBounds(180,320,170,30);
        val.setBackground(Color.WHITE);
        add(val);

        Location = new JLabel("Location");
        Location.setBounds(50,380,150,30);
        Location.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Location);

        LocationTextField = new JTextField();
        LocationTextField.setBounds(180,380,170,30);
        LocationTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(LocationTextField);

        addDriver = new JButton("Add Driver");
        addDriver.setBounds(50,450,130,30);
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.addActionListener(this);
        add(addDriver);

        cancel = new JButton("Cancel ");
        cancel.setBounds(220,450,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(200,90,900,580);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==addDriver)
        {
            String name = DNameTextField.getText();
            String age = DAgeTextField.getText();
            String carmodel = (String) model.getSelectedItem();
            String available = (String) val.getSelectedItem();
            String location = LocationTextField.getText();
            String getGender = null;
            if (male.isSelected())
            {
                getGender = "Male";
            }
            else
            {
                getGender = "Female";
            }

            try
            {
                Conn c = new Conn();
                String Query = "Insert into AddDriver values ('"+name+"','"+age+"','"+getGender+"','"+carmodel+"','"+available+"','"+location+"')";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null,"Driver added successfully");
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
        new AddDriver();
    }
}
