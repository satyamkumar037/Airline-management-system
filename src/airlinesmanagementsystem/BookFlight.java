package airlinesmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener
{
    JLabel tfname , tfphone , tfnationality , tfaddress , labelgender ,tfflightname , tffcode,aadharnumber,name,nationality;
    JLabel phonenumber , gender , lblsource , lbldestination,address , flightname,fcode , date;
    JButton flight , bookflight,fetchbutton;
    JTextField  tfaadhar ;
    JDateChooser dcdate;
    Choice destination , source;
    public BookFlight()
    {
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("ARIAL" , Font.BOLD , 24));
        heading.setBounds(400 , 0 , 400 , 35);
        add(heading);
        
        aadharnumber = new JLabel("Aadhar Number");
        aadharnumber.setBounds(10,40 , 200 , 30);
        aadharnumber.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(aadharnumber);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(230 , 40, 200 , 30);
        add(tfaadhar);
        
        fetchbutton = new JButton("Fetch");
        fetchbutton.setBackground(Color.black);
        fetchbutton.setForeground(Color.WHITE);
        fetchbutton.setBounds(450 , 40 , 100 , 30);
        fetchbutton.addActionListener(this);
        add(fetchbutton);
        
        name = new JLabel("Name");
        name.setBounds(10,120 , 200 , 30);
        name.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(name);
        
        tfname = new JLabel();
        tfname.setBounds(230 , 120 , 200 , 30);
        add(tfname);
        
        nationality = new JLabel("Nationality");
        nationality.setBounds(10,80 , 200 , 30);
        nationality.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(nationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(230 , 80, 200 , 30);
        add(tfnationality);
        
        
        phonenumber = new JLabel("Phone Number");
        phonenumber.setBounds(10,160 , 200 , 30);
        phonenumber.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(phonenumber);
        
        tfphone = new JLabel();
        tfphone.setBounds(230 , 160, 200 , 30);
        add(tfphone);
        
        gender = new JLabel("Gender");
        gender.setBounds(10,200 , 200 , 30);
        gender.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(gender);
        
        labelgender = new JLabel("");
        labelgender.setBounds(230,200 , 200 , 30);
        labelgender.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(labelgender);
        
        lblsource = new JLabel("Source");
        lblsource.setBounds(10,270 , 200 , 30);
        lblsource.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(230,270,100,30);
        add(source);
        
        lbldestination = new JLabel("Destination");
        lbldestination.setBounds(10,310 , 200 , 30);
        lbldestination.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(lbldestination);
        
        destination = new Choice();
        destination.setBounds(230,310,100,30);
        add(destination);
        
        try
        {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next())
            {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }
        catch(Exception e)
         {
              e.printStackTrace();
         }
        
        address = new JLabel("Address");
        address.setBounds(10,340 , 200 , 30);
        address.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(address);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(230 , 340, 200 , 30);
        add(tfaddress);
        
        flight = new JButton("fetch flight");
        flight.setBounds(340 , 310 , 200 , 25);
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setFont(new Font("ARIAL" , Font.BOLD , 18));
        flight.addActionListener(this);
        add(flight);
        
        flightname = new JLabel("Flight Name");
        flightname.setBounds(10,380 , 200 , 30);
        flightname.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(flightname);
        
        tfflightname = new JLabel("");
        tfflightname.setBounds(230,380 , 200 , 30);
        tfflightname.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(tfflightname);
        
        fcode = new JLabel("Flight Code");
        fcode.setBounds(10,420 , 200 , 30);
        fcode.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(fcode);
        
        tffcode = new JLabel("");
        tffcode.setBounds(230,420 , 200 , 30);
        tffcode.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(tffcode);
        
        bookflight = new JButton("Book Flight");
        bookflight.setBounds(200,500,100,30);
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.white);
        bookflight.addActionListener(this);
        add(bookflight);
        
        date = new JLabel("Date of Travel");
        date.setBounds(10,460 , 200 , 30);
        date.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(date);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(230,460,100,30);
        add(dcdate);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesmanagementsystem/icons/details.jpg"));
       Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel lblimage = new JLabel(i3);
       lblimage.setBounds(550,80,500,410);
       add(lblimage);
        
        getContentPane().setBackground(Color.white);
        setSize(1100,600);
        setLocation(150,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== fetchbutton)
        {
         String aadhar = tfaadhar.getText();
        try
        {
           Conn conn = new Conn();
           String query = "select * from passenger where aadhar= '"+aadhar+"'";
           ResultSet rs = conn.s.executeQuery(query);
           if(rs.next())
           {
               tfname.setText(rs.getString("name"));
               tfnationality.setText(rs.getString("nationality"));
               tfphone.setText(rs.getString("phone"));
               tfaddress.setText(rs.getString("address"));
               labelgender.setText(rs.getString("gender"));
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Please Enter Correct Aadhar Card");
           }
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
         else if(ae.getSource()== flight)
        {
         String src = source.getSelectedItem();
         String dest = destination.getSelectedItem();
        try
        {
           Conn conn = new Conn();
           String query = "select * from flight where source= '"+src+"' and destination= '"+dest+"'";
           ResultSet rs = conn.s.executeQuery(query);
           if(rs.next())
           {
               tfflightname.setText(rs.getString("f_name"));
               tffcode.setText(rs.getString("f_code"));
           }
           else
           {
               JOptionPane.showMessageDialog(null, "No Flights Found");
           }
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        else
         {
             Random random = new Random();
             String aadhar = tfaadhar.getText();
             String name = tfname.getText();
             String nationality = tfnationality.getText();
             String flightname = tfflightname.getText();
             String flightcode = tffcode.getText();
             String src =source.getSelectedItem();
             String dest = destination.getSelectedItem();
             String ddate =((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
             
             try
        {
           Conn conn = new Conn();
           String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"' , 'TIC-"+random.nextInt(10000)+"' ,'"+aadhar+"' , '"+name+"' , '"+nationality+"' , '"+flightname+"' , '"+flightcode+"' , '"+src+"' , '"+dest+"' , '"+ddate+"')";
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
           setVisible(false);
           
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
         }
    }
    public static void main(String args[])
    {
        new BookFlight();
    }
}
