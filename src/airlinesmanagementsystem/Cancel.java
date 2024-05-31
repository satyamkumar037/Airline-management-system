package airlinesmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Cancel extends JFrame implements ActionListener
{
    JLabel PNR , name , cancelationno , flightcode , date  , tfname , tfcancelationo , tfflightcode , tfdate;
    JTextField tfpnr;
    JButton showdetails , cancel;
    public Cancel()
    {
        setLayout(null);
        
        JLabel heading = new JLabel("CANCELATION");
        heading.setBounds(170 , 10 , 200 , 50);
        heading.setFont(new Font("ARIAL" , Font.BOLD , 20));
        add(heading);
        
        PNR = new JLabel("PNR");
        PNR.setBounds(10, 70 , 100 , 30);
        add(PNR);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(130 , 70 , 100 , 30);
        add(tfpnr);
        
        showdetails = new JButton("Show Details");
        showdetails.setBounds(240 , 70 , 150 , 30);
        showdetails.setBackground(Color.black);
        showdetails.setForeground(Color.WHITE);
        showdetails.addActionListener(this);
        add(showdetails);
        
        name = new JLabel("Name");
        name.setBounds(10 , 110 , 100 , 30);
        add(name);
        
        tfname = new JLabel();
        tfname.setBounds(130 , 110 , 100 , 30);
        add(tfname);
        
        cancelationno = new JLabel("Cancelation number");
        cancelationno.setBounds(10 , 150 , 100 , 30);
        add(cancelationno);
        
        Random random = new Random();
        tfcancelationo = new JLabel(""+random.nextInt(1000000));
        tfcancelationo.setBounds(130 , 150 , 100 , 30);
        add(tfcancelationo);
        
        flightcode = new JLabel("Flight Code");
        flightcode.setBounds(10 , 190 , 100 , 30);
        add(flightcode);
        
        tfflightcode = new JLabel();
        tfflightcode.setBounds(130 , 190 , 100 , 30);
        add(tfflightcode);
        
        date = new JLabel("Date");
        date.setBounds(10 , 230 , 100 , 30);
        add(date);
        
        tfdate = new JLabel();
        tfdate.setBounds(130 , 230 , 100 ,30);
        add(tfdate);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(130 , 270 , 100 , 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesmanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lblimage = new JLabel(i3);
        lblimage.setBounds(240,120,230,300);
        add(lblimage);
        
        
                
                setSize(500,500);
                setLocation(400 , 100);
                setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== showdetails)
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
                    tfflightcode.setText(rs.getString("flightcode"));
                    tfdate.setText(rs.getString("ddate"));
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please Enter Correct PNR");
                }
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
        else if(e.getSource()== cancel)
        {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String fcode = tfflightcode.getText();
            String cancelationno = tfcancelationo.getText();
            String date = tfdate.getText();
            
            try
            {
                Conn c = new Conn();
                String query = "insert into cancel values('"+pnr+"' , '"+name+"' , '"+cancelationno+"' , '"+fcode+"' , '"+date+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                JOptionPane.showMessageDialog(null,"Ticket Cancelled");
                setVisible(false);
            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
    }
    public static void main(String args[])
    {
        new Cancel();
    }
}
