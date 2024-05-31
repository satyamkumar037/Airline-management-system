package airlinesmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener
{
    JButton save;
    JTextField tfaddress , tfname , tfnationality , tfaadhar , tfphone;
    JRadioButton  male , female;
    public AddCustomer()
    {
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("ARIAL" , Font.BOLD , 24));
        heading.setBounds(300 , 0 , 400 , 30);
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(10,40 , 200 , 30);
        name.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(230 , 40 , 200 , 30);
        add(tfname);
        
        JLabel nationality = new JLabel("Nationality");
        nationality.setBounds(10,80 , 200 , 30);
        nationality.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(nationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(230 , 80, 200 , 30);
        add(tfnationality);
        
        JLabel aadharnumber = new JLabel("Aadhar Number");
        aadharnumber.setBounds(10,120 , 200 , 30);
        aadharnumber.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(aadharnumber);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(230 , 120, 200 , 30);
        add(tfaadhar);
        
        JLabel phonenumber = new JLabel("Phone Number");
        phonenumber.setBounds(10,160 , 200 , 30);
        phonenumber.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(phonenumber);
        
        tfphone = new JTextField();
        tfphone.setBounds(230 , 160, 200 , 30);
        add(tfphone);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(10,200 , 200 , 30);
        gender.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(230 , 200 , 60 , 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBounds(300 , 200 , 80 , 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergp = new ButtonGroup();
        gendergp.add(male);
        gendergp.add(female);
        
        JLabel address = new JLabel("Address");
        address.setBounds(10,240 , 200 , 30);
        address.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(address);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(230 , 240, 200 , 30);
        add(tfaddress);
        
        save = new JButton("Save");
        save.setBounds(230 , 300 , 200 , 30);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setFont(new Font("ARIAL" , Font.BOLD , 18));
        save.addActionListener(this);
        add(save);
        
       ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinesmanagementsystem/icons/emp.png"));
       JLabel lblimage = new JLabel(image);
       lblimage.setBounds(500,80,280,400);
       add(lblimage);
        
        getContentPane().setBackground(Color.white);
        setSize(900,600);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String name = tfname.getText();
        String aadhar = tfaadhar.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String nationality = tfnationality.getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "male";
        }
        else
        {
            gender = "female";
        }
        try
        {
           Conn conn = new Conn();
           String query = "insert into passenger values('"+name+"' , '"+nationality+"' , '"+phone+"' , '"+address+"' , '"+aadhar+"' , '"+gender+"')";
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null , "Passenger Added Successfully");
           setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new AddCustomer();
    }
}
