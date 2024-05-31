
package airlinesmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener
{
   
    public Home()
    {
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesmanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1600,800);
        add(image);
        
        JLabel heading = new JLabel("Hindustan Airways Welcomes you");
        heading.setBounds(450,40,1000,40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Arial" ,Font.BOLD , 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightdetails = new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);
        
        JMenuItem costomerdetail = new JMenuItem("Add Costomer Details");
        costomerdetail.addActionListener(this);
        details.add(costomerdetail);
        
        JMenuItem bookflight = new JMenuItem("Book Flight");
        bookflight.addActionListener(this);
        details.add(bookflight);
        
        JMenuItem journeydetail = new JMenuItem("Journey Details");
        journeydetail.addActionListener(this);
        details.add(journeydetail);
        
         JMenuItem ticketcacellation = new JMenuItem("Cancel Ticket");
         ticketcacellation.addActionListener(this);
         details.add(ticketcacellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingpass = new JMenuItem("boarding Pass");
        boardingpass.addActionListener(this);
        ticket.add(boardingpass);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setLocation(0, 0);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String text = ae.getActionCommand();
        if(text.equals("Flight Details"))
        {
            new FlightInfo();
        }
        else if(text.equals("Add Costomer Details"))
        {
            new AddCustomer();
        }
        else if(text.equals("Book Flight"))
        {
            new BookFlight();
        }
        else if(text.equals("Journey Details"))
        {
            new JourneyDetails();
        }
        else if(text.equals("Cancel Ticket"))
        {
            new Cancel();
        }
        else if (text.equals("boarding Pass"))
        {
            new BoardingPass();
        }
    }
    public static void main(String args[])
    {
        new Home();
    }
    
}