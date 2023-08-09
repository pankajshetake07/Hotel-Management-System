package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener
{
    JLabel name,age,job,salary,phone,email,adharno,gender;
    JRadioButton male,female;
    ButtonGroup genderGroup;
    JComboBox jobrole;
    JButton submit;
    JTextField nameTextField,ageTextField,salaryTextField,phoneTextField,emailTextField,adharnoTextField;
    AddEmployee()
    {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,150,350,250);
        add(image);

        name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,18));
        name.setBounds(70,40,150,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(200,40,250,30);
        nameTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(nameTextField);

        age = new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,18));
        age.setBounds(70,100,150,30);
        add(age);

        ageTextField = new JTextField();
        ageTextField.setBounds(200,100,250,30);
        ageTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(ageTextField);

        gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,18));
        gender.setBounds(70,160,150,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(200,160,70,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(300,160,70,30);
        female.setBackground(Color.WHITE);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        String[] role = {"Manager","Porters","HouseKeeping","Kitchen Staff","Room Service","Chefs","Waiter","Accountant","Front Deak Clerks"};
        jobrole = new JComboBox(role);
        jobrole.setBounds(200,220,250,30);
        jobrole.setBackground(Color.WHITE);
        add(jobrole);

        job = new JLabel("JOB");
        job.setFont(new Font("Tahoma",Font.PLAIN,18));
        job.setBackground(Color.WHITE);
        job.setBounds(70,220,150,30);
        add(job);

        salary = new JLabel("SALARY");
        salary.setFont(new Font("Raleway",Font.PLAIN,18));
        salary.setBounds(70,280,150,30);
        add(salary);

        salaryTextField = new JTextField();
        salaryTextField.setBounds(200,280,250,30);
        salaryTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(salaryTextField);

        phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,18));
        phone.setBounds(70,340,150,30);
        add(phone);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(200,340,250,30);
        phoneTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(phoneTextField);

        email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,18));
        email.setBounds(70,400,150,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(200,400,250,30);
        emailTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(emailTextField);

        adharno = new JLabel("AADHAAR");
        adharno.setFont(new Font("Tahoma",Font.PLAIN,18));
        adharno.setBounds(70,460,150,30);
        add(adharno);

        adharnoTextField = new JTextField();
        adharnoTextField.setBounds(200,460,250,30);
        adharnoTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(adharnoTextField);

        submit = new JButton("SUBMIT");
        submit.setBounds(180,530,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma",Font.PLAIN,16));
        submit.addActionListener(this);
        add(submit);

        setBounds(200,50,900,650);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String getName = nameTextField.getText();
        String getAge = ageTextField.getText();
        String getSalary = salaryTextField.getText();
        String getPhone = phoneTextField.getText();
        String getEmail = emailTextField.getText();
        String getAadhaar = adharnoTextField.getText();

        String getGender = null;
        if (male.isSelected())
        {
            getGender = "Male";
        }
        else
        {
            getGender = "Female";
        }

        String getJobrole = (String) jobrole.getSelectedItem();

        try
        {
            Conn c = new Conn();
            String Query = "insert into AddEmployee values('"+getName+"','"+getAge+"','"+getGender+"','"+getJobrole+"','"+getSalary+"','"+getPhone+"','"+getEmail+"','"+getAadhaar+"')";
            c.s.executeUpdate(Query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new AddEmployee();
    }
}
