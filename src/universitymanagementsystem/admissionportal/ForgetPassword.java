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
public class ForgetPassword extends JFrame implements ActionListener{
    JLabel logo,heading, usernameLabel, emailPhoneLabel, ualert,ealert;
    JTextField username, emailphone;
    JButton reset,cancel;
    ForgetPassword(){
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        Image img2 = img.getImage().getScaledInstance(150, 70,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        logo = new JLabel(img3);
        logo.setBounds(80, 10, 150, 70);
        add(logo);
        
        heading = new JLabel("Request Password Reset");
        heading.setBounds(50, 50, 300, 100);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        heading.setForeground(new Color(68,62,149));
        add(heading);
        
        usernameLabel = new JLabel("Username*");
        usernameLabel.setBounds(50, 120, 200, 30);
        usernameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //usernameLabel.setForeground(new Color(68,62,149));
        add(usernameLabel);
        
        username = new JTextField();
        username.setBounds(50, 150,250, 30);
        username.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //username.setForeground(new Color(68,62,149));
        add(username);
        
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
        
        reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setBounds(200,300,100,30);
        reset.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        reset.setBackground(new Color(113,177,249));
        reset.setForeground(Color.WHITE);
        add(reset);
        
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
        new ForgetPassword();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String user = username.getText();
        String mailphone = emailphone.getText();
        if(ae.getSource() == reset){
            if(user.equals("") && mailphone.equals("")){
                ualert.setText("User name cannot be blank");
                ealert.setText("Email or Mobile number cannot be blank");  
            }
            else if(user.equals("")){
                ualert.setText("User name cannot be blank");
            }
            else if(mailphone.equals("")){
                ealert.setText("Email or Mobile number cannot be blank");  
            }
            else{
                String query1 = "SELECT* FROM studentRegistration WHERE UserName = '"+user+"' && Email = '"+mailphone+"' || '"+mailphone+"' ";
                try{
                    JDBCConnection con = new JDBCConnection();
                    ResultSet rs = con.stmt.executeQuery(query1);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"User found...!");
                        setVisible(false);
                        new SetPassword(user).setVisible(true);
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
