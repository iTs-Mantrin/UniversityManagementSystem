package universitymanagementsystem.admissionportal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Manish Kumar
 */
public class UserFound extends JFrame implements ActionListener{
    JLabel logo,heading, userLabel;
    JButton signin;
    String userName;
    UserFound(String userName){
        this.userName = userName;
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        Image img2 = img.getImage().getScaledInstance(150, 70,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        logo = new JLabel(img3);
        logo.setBounds(80, 10, 150, 70);
        add(logo);
        
        heading = new JLabel("User Name Found");
        heading.setBounds(70, 50, 300, 100);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        heading.setForeground(new Color(68,62,149));
        add(heading);
        
        userLabel = new JLabel("User Name: ");
        userLabel.setBounds(70, 110, 300, 100);
        userLabel.setFont(new Font("SAN_SERIF",Font.BOLD,12));
        userLabel.setForeground(Color.RED);
        userLabel.setText("UserName: "+userName);
        add(userLabel);
        


        
        signin = new JButton("Sign In");
        signin.addActionListener(this);
        signin.setBounds(120,200,100,30);
        signin.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        signin.setBackground(new Color(113,177,249));
        signin.setForeground(Color.WHITE);
        add(signin);
        
        setLayout(null);
        setVisible(true);
        setSize(350,300);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,50);
        
        
    }
    public static void main(String args[]){
        new UserFound("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) { 
        if(ae.getSource() == signin){
            setVisible(false);
            new AdmissionPortal().setVisible(true);
        }
             
     }
        
    
    
}
