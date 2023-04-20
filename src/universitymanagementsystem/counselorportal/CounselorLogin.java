
package universitymanagementsystem.counselorportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author manis
 */
public class CounselorLogin extends JFrame implements ActionListener{
    JLabel logo, alumniPortal, signIn, usernameLabel, passwordLabel, userAlert, passwordAlert,alert;
    JTextField username;
    JPasswordField password;
    JButton forgetPassword, newRegistration, login;
    
    
    public CounselorLogin(){
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        Image img2 = img.getImage().getScaledInstance(200, 100,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        logo = new JLabel(img3);
        logo.setBounds(100, 10, 200, 100);
        add(logo);
        
        alumniPortal = new JLabel("Academic Counselor Portal");
        alumniPortal.setBounds(60, 80, 300, 100);
        alumniPortal.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        alumniPortal.setForeground(new Color(68,62,149));
        add(alumniPortal);
        
        signIn = new JLabel("Sign In");
        signIn.setBounds(50, 170, 200, 40);
        signIn.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        signIn.setForeground(new Color(68,62,149));
        add(signIn);
        
        usernameLabel = new JLabel("Username*");
        usernameLabel.setBounds(50, 200, 200, 30);
        usernameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //usernameLabel.setForeground(new Color(68,62,149));
        add(usernameLabel);
        
        username = new JTextField();
        username.setBounds(50, 235, 300, 30);
        username.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //username.setForeground(new Color(68,62,149));
        add(username);
        
        userAlert = new JLabel();
        userAlert.setBounds(50, 260, 300, 20);
        userAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        userAlert.setForeground(Color.red);
        add(userAlert);

        passwordLabel = new JLabel("Password*");
        passwordLabel.setBounds(50, 300, 200, 30);
        passwordLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //passwordLabel.setForeground(new Color(68,62,149));
        add(passwordLabel);
        
        password = new JPasswordField();
        password.setBounds(50, 330, 300, 30);
        password.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //password.setForeground(new Color(68,62,149));
        add(password);
        
        passwordAlert = new JLabel();
        passwordAlert.setBounds(50, 360, 300, 20);
        passwordAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        passwordAlert.setForeground(Color.red);
        add(passwordAlert);
        
        alert = new JLabel();
        alert.setBounds(50, 360, 300, 20);
        alert.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        alert.setForeground(Color.red);
        add(alert);
        
        forgetPassword = new JButton("Forget Password");
        forgetPassword.setBounds(20,500,124,30);
        forgetPassword.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        forgetPassword.setBackground(new Color(255,209,54));
        forgetPassword.addActionListener(this);
        forgetPassword.setForeground(Color.WHITE);
        add(forgetPassword);
        
        newRegistration = new JButton("New Registration");
        newRegistration.addActionListener(this);
        newRegistration.setBounds(149,500,124,30);
        newRegistration.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        newRegistration.setBackground(new Color(255,209,54));
        newRegistration.setForeground(Color.WHITE);
        add(newRegistration);
        
        login = new JButton("Login");
        login.addActionListener(this);
        login.setBounds(300,500,70,30);
        login.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        login.setBackground(new Color(113,177,249));
        login.setForeground(Color.WHITE);
        add(login);
        
        setLayout(null);
        setVisible(true);
        setSize(400,600);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,50);
        
        
    }
    
    public static void main(String args[]){
        new CounselorLogin();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = username.getText();
        String pass = new String(password.getPassword());
        try{
            if(e.getSource() == login){
            if(user.equals("")){
                userAlert.setText("Username cannot be blank");
            }
            else if(pass.equals("")){
                passwordAlert.setText("Password cannot be blank");
            }
            else if(user.equals("") && pass.equals("")){
            alert.setText("Incorrect.. username or password");
            }
            }
            }
            catch(Exception ae){
                    System.out.println(ae);
                    }
            
        
        
    }
    
}
