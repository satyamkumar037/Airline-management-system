package airlinesmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JButton close , submit , reset;
    JTextField tfusername;
    JPasswordField tfpassword;
    JLabel lblusername , lblpassword;
    public Login()
    {
        setLayout(null);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(20,20,100,20);
        lblusername.setFont(new Font("Arial" ,Font.BOLD , 14));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130,20,200,20);
        tfusername.setFont(new Font("Arial" ,Font.BOLD , 14));
        add(tfusername);
        
        lblpassword = new JLabel("Password");
        lblpassword.setBounds(20,50 , 100 , 20);
        lblpassword.setFont(new Font("Arial" ,Font.BOLD , 14));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 50,200,20);
        tfpassword.setFont(new Font("Arial" ,Font.BOLD , 14));
        add(tfpassword);
        
        submit = new JButton("submit");
        submit.setBounds(100 , 100 , 80 , 30);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        reset = new JButton("reset");
        reset.setBounds(200 , 100 , 80, 30);
        reset.setBackground(Color.blue);
        reset.setForeground(Color.white);
        reset.addActionListener(this);
        add(reset);
        
        close = new JButton("close");
        close.setBounds(150 , 150 , 80 , 30);
        close.setBackground(Color.blue);
        close.setForeground(Color.white);
        close.addActionListener(this);
        add(close);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400 , 300 );
        setVisible(true);
        setLocation(500 , 150);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== submit)
        {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            try
            {
                Conn c = new Conn();
                String query = "select * from login where username ='"+ username+"'and password = '"+ password +"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    new Home();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "invalid user");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== reset)
        {
            tfusername.setText("");
            tfpassword.setText("");
        }
        else if(ae.getSource()==close)
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new Login();
    }
    
}