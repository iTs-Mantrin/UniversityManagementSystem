package universitymanagementsystem.admissionportal;

import universitymanagementsystem.home.JDBCConnection;
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
public class ForgetUserName extends JFrame implements ActionListener{
    JLabel logo,heading, fullNameLabel, emailPhoneLabel, ualert,ealert;
    JTextField fullName, emailphone;
    JButton find,cancel;
    ForgetUserName(){
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        Image img2 = img.getImage().getScaledInstance(150, 70,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        logo = new JLabel(img3);
        logo.setBounds(80, 10, 150, 70);
        add(logo);
        
        heading = new JLabel("Request UserName");
        heading.setBounds(50, 50, 300, 100);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        heading.setForeground(new Color(68,62,149));
        add(heading);
        
        fullNameLabel = new JLabel("Full Name*");
        fullNameLabel.setBounds(50, 120, 200, 30);
        fullNameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //fullNameLabel.setForeground(new Color(68,62,149));
        add(fullNameLabel);
        
        fullName = new JTextField();
        fullName.setBounds(50, 150,250, 30);
        fullName.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //fullName.setForeground(new Color(68,62,149));
        add(fullName);
        
        ualert = new JLabel();
        ualert.setBounds(50,170, 250,30);
        ualert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        ualert.setForeground(Color.red);
        add(ualert);
        
        
        emailPhoneLabel = new JLabel("Email Address or Phone Number*");
        emailPhoneLabel.setBounds(50, 200, 300, 30);
        emailPhoneLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(emailPhoneLabel);
        
        emailphone = new JTextField();
        emailphone.setBounds(50,230, 250,30);
        emailphone.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(emailphone);

        ealert = new JLabel();
        ealert.setBounds(50,250, 300,30);
        ealert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        ealert.setForeground(Color.red);
        add(ealert);
        
        find = new JButton("Find UserName");
        find.addActionListener(this);
        find.setBounds(180,300,120,30);
        find.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        find.setBackground(new Color(113,177,249));
        find.setForeground(Color.WHITE);
        add(find);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(50,300,100,30);
        cancel.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        cancel.setBackground(new Color(113,177,249));
        cancel.setForeground(Color.WHITE);
        add(cancel);
        
        setLayout(null);
        setVisible(true);
        setSize(350,400);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public static void main(String args[]){
        new ForgetUserName();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = fullName.getText();
        String mailphone = emailphone.getText();
        if(ae.getSource() == find){
            if(name.equals("") && mailphone.equals("")){
                ualert.setText("Full Name cannot be blank");
                ealert.setText("Email or Mobile number cannot be blank");  
            }
            else if(name.equals("")){
                ualert.setText("Full Name cannot be blank");
            }
            else if(mailphone.equals("")){
                ealert.setText("Email or Mobile number cannot be blank");  
            }
            else{
                
                String query = "SELECT UserName FROM studentRegistration WHERE FullName = '"+name+"' && Email = '"+mailphone+"' ||PhoneNumber = '"+mailphone+"' ";
                try{
                    JDBCConnection con = new JDBCConnection();
                    ResultSet rs = con.stmt.executeQuery(query);
                    if(rs.next()){
                        String UserName = rs.getString("UserName");
                        JOptionPane.showMessageDialog(null,"User Found");
                        setVisible(false);
                        new UserFound(UserName).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"User not found...!");
                    }     
            }
                catch(Exception e){
                    System.out.println(e);
                }
                
            }
             
        }
        else if(ae.getSource() == cancel ){
            setVisible(false);
            new AdmissionPortal().setVisible(true);
        }
        
    }
    
}
