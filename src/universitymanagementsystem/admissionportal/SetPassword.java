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
public class SetPassword extends JFrame implements ActionListener{
    JLabel logo,heading, passwordLabel, confirmPasswordLabel, ualert,ealert;
    JTextField password, cpassword;
    JButton confirm,cancel;
    String userName;
    SetPassword(String userName){
        this.userName = userName;
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
        
        passwordLabel = new JLabel("Enter New Password*");
        passwordLabel.setBounds(50, 120, 200, 30);
        passwordLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //passwordLabel.setForeground(new Color(68,62,149));
        add(passwordLabel);
        
        password = new JTextField();
        password.setBounds(50, 150,250, 30);
        password.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //password.setForeground(new Color(68,62,149));
        add(password);
        
        ualert = new JLabel();
        ualert.setBounds(50,170, 250,30);
        ualert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        ualert.setForeground(Color.red);
        add(ualert);
        
        
        confirmPasswordLabel = new JLabel("Re-Enter New Password*");
        confirmPasswordLabel.setBounds(50, 200, 300, 30);
        confirmPasswordLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(confirmPasswordLabel);
        
        cpassword = new JTextField();
        cpassword.setBounds(50,230, 250,30);
        cpassword.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(cpassword);

        ealert = new JLabel();
        ealert.setBounds(50,250, 300,30);
        ealert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        ealert.setForeground(Color.red);
        add(ealert);
        
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        confirm.setBounds(200,300,100,30);
        confirm.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        confirm.setBackground(new Color(113,177,249));
        confirm.setForeground(Color.WHITE);
        add(confirm);
        
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
        
        
    }
    public static void main(String args[]){
        new SetPassword("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String Password = password.getText();
        String cPassword = cpassword.getText();
        if(ae.getSource() == confirm){
            if(Password.equals("") && cPassword.equals("")){
                ualert.setText("New password cannot be blank");
                ealert.setText("Re-Enter new passsord cannot be blank");  
            }
            else if(Password.equals("")){
                ualert.setText("New password cannot be blank");
            }
            else if(cPassword.equals("")){
                ealert.setText("Re-Enter new passsord cannot be blank");  
            }
            else{
                String query1 = "UPDATE studentRegistration SET Password = '"+cPassword+"' WHERE UserName = '"+userName+"' ";
                String query2 = "UPDATE studentLogin SET Password = '"+cPassword+"' WHERE UserName = '"+userName+"'";
                
                try{
                    JDBCConnection con = new JDBCConnection();
                    con.stmt.executeUpdate(query1);
                    con.stmt.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Password set Successfully...");           
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
