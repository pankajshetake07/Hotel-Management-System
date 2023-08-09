package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JTextField userTextField;
    JPasswordField passField;
    JLabel username,password;
    JButton login,cancel;
    Login()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        username = new JLabel("Username");
        username.setBounds(20,20,90,30);
        username.setFont(new Font("Raleway",Font.BOLD,16));
        add(username);

        userTextField = new JTextField();
        userTextField.setBounds(130,20,200,30);
        userTextField.setFont(new Font("Raleway",Font.PLAIN,14));
        add(userTextField);

        password = new JLabel("Password");
        password.setBounds(20,70,90,30);
        password.setFont(new Font("Raleway",Font.BOLD,16));
        add(password);

        passField = new JPasswordField();
        passField.setBounds(130,70,200,30);
        passField.setFont(new Font("Raleway",Font.PLAIN,14));
        add(passField);

        login = new JButton("Login");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(20,150,150,30);
        login.setFont(new Font("Raleway",Font.BOLD,16));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,150,150,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360,5,200,200);
        add(image);

        setBounds(500,200,600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==login)
        {
            String user = userTextField.getText();
            String pass = passField.getText();

            try
            {
                Conn c = new Conn();
                String Query = "select * from Login where Username = '"+user+"' and Password = '"+pass+"'";
                ResultSet rs = c.s.executeQuery(Query);
                if(rs.next())
                {
                    setVisible(false);
                    new Dashboard();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username and Password");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new Login();
    }
}
