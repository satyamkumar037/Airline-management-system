
package airlinesmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass  extends JFrame implements ActionListener
{
    JLabel PNR , name , nationality , source , date  , tfname , tfnationality , tfdestination , tfsource , destination , tfdate , flightname , tfflightname , tfflightcode , flightcode;
    JTextField tfpnr;
    JButton enter;
    public BoardingPass()
    {
        setLayout(null);
        
        JLabel heading = new JLabel("Hindustan Airways");
        heading.setBounds(300 , 0 , 200 , 50);
        heading.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(heading);
        
        JLabel heading2 = new JLabel("Boarding Pass");
        heading2.setBounds(320 , 30 , 200 , 50);
        heading2.setFont(new Font("ARIAL" , Font.BOLD , 16));
        heading2.setForeground(Color.blue);
        add(heading2);
        
        PNR = new JLabel("PNR Detail");
        PNR.setBounds(10, 70 , 100 , 30);
        add(PNR);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(130 , 70 , 100 , 30);
        add(tfpnr);
        
        enter = new JButton("Enter");
        enter.setBounds(240 , 70 , 150 , 30);
        enter.setBackground(Color.black);
        enter.setForeground(Color.WHITE);
        enter.addActionListener(this);
        add(enter);
        
        name = new JLabel("Name");
        name.setBounds(10 , 110 , 100 , 30);
        add(name);
        
        tfname = new JLabel();
        tfname.setBounds(130 , 110 , 100 , 30);
        add(tfname);
        
        nationality = new JLabel("Nationality");
        nationality.setBounds(10 , 150 , 100 , 30);
        add(nationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(130 , 150 , 100 , 30);
        add(tfnationality);
        
        source = new JLabel("Source");
        source.setBounds(10 , 190 , 100 , 30);
        add(source);
        
        tfsource = new JLabel();
        tfsource.setBounds(130 , 190 , 100 , 30);
        add(tfsource);
        
        destination = new JLabel("Destination");
        destination.setBounds(10 , 230 , 100 , 30);
        add(destination);
        
        tfdestination = new JLabel();
        tfdestination.setBounds(130 , 230 , 100 , 30);
        add(tfdestination);
        
        flightname = new JLabel("Flight Name");
        flightname.setBounds(10 , 270 , 100 , 30);
        add(flightname);
        
        tfflightname = new JLabel();
        tfflightname.setBounds(130 , 270 , 100 , 30);
        add(tfflightname);
        
        flightcode = new JLabel("Flight code");
        flightcode.setBounds(10 , 310 , 100 , 30);
        add(flightcode);
        
        tfflightcode = new JLabel();
        tfflightcode.setBounds(130 , 310 , 100 , 30);
        add(tfflightcode);
        
        date = new JLabel("Date");
        date.setBounds(10 , 350 , 100 , 30);
        add(date);
        
        tfdate = new JLabel();
        tfdate.setBounds(130 , 350 , 100 ,30);
        add(tfdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesmanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 320, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lblimage = new JLabel(i3);
        lblimage.setBounds(340,100,430,350);
        add(lblimage);
        
        
        setSize(800 , 450);
        setLocation(400 , 100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String pnr = tfpnr.getText();
        
        try
        {
            Conn c = new Conn();
            
            String query = "select * from reservation where PNR = '"+pnr+"'";
                ResultSet rs = c.s.executeQuery(query);
            if(rs.next())
            {
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfsource.setText(rs.getString("src"));
                tfdestination.setText(rs.getString("dest"));
                tfflightname.setText(rs.getString("flightname"));
                tfflightcode.setText(rs.getString("flightcode"));
                tfdate.setText(rs.getString("ddate"));
            }
            else 
            {
                JOptionPane.showMessageDialog(null , "Please Enter Correct PNR");
            }
        }
        catch(Exception ae)
        {
            ae.printStackTrace();
        }
    }
    
    public static void main(String arge[])
    {
        new BoardingPass();
    }
}
