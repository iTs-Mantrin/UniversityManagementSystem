
package universitymanagementsystem.adminportal;

import javax.swing.*;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import universitymanagementsystem.home.JDBCConnection;
/*
 * @author Manish Kumar
 */
public class AdminLogin extends JFrame implements ActionListener {
    JPanel panel, panelHeading;
    JLabel close,headingLabel;
    JButton signout;
    JLabel logo, alumniPortal, signIn, usernameLabel, passwordLabel, userAlert, passwordAlert,alert;
    JTextField username;
    JPasswordField password;
    JButton forgetPassword, newRegistration, login;
    public AdminLogin(){
      
        
       setLayout(null);

        panelHeading = new JPanel();
        panelHeading.setBounds(0, 0,1280, 100);
        panelHeading.setBackground(new Color(55,159,249));
        panelHeading.setSize(1280,100);
        panelHeading.setLayout(null);
        add(panelHeading);

        headingLabel = new JLabel("Admin Portal");
        headingLabel.setBounds(100, 30,300, 40);
        headingLabel.setFont(new Font("SAN_SERIF",Font.BOLD,30));
        headingLabel.setLocation(100,30);
        headingLabel.setForeground(Color.WHITE);
        panelHeading.add(headingLabel);
        
//        signout = new JButton("Sign out");
//        signout.setBounds(1190, 70,100, 30);
//        signout.addActionListener(this);
//        signout.setFont(new Font("SAN_SERIF",Font.BOLD,15));
//        signout.setLocation(1190,70);
//        signout.setForeground(Color.WHITE);
//        signout.setBackground(new Color(123,7,127));
//        panelHeading.add(signout);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/closeButton.png"));
        Image img2 = img.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        
        close = new JLabel(img3);
        close.setBounds(1230, 10,40, 30);
        panelHeading.add(close);
        close.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                setVisible(false);
                System.exit(0);
            }
        });
        
        
        panel = new JPanel();
        panel.setBounds(400,100, 400, 600); //575
        panel.setBackground(new Color(228,231,233));
        panel.setLayout(null);
        add(panel);
               
        ImageIcon img6 = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        Image img7 = img6.getImage().getScaledInstance(200, 100,Image.SCALE_DEFAULT);
        ImageIcon img8 = new ImageIcon(img7);
        logo = new JLabel(img8);
        logo.setBounds(100, 10, 200, 100);
        panel.add(logo);
        
        alumniPortal = new JLabel("Admin Portal");
        alumniPortal.setBounds(120, 80, 200, 100);
        alumniPortal.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        alumniPortal.setForeground(new Color(68,62,149));
        panel.add(alumniPortal);
        
        signIn = new JLabel("Sign In");
        signIn.setBounds(50, 170, 200, 40);
        signIn.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        signIn.setForeground(new Color(68,62,149));
        panel.add(signIn);
        
        usernameLabel = new JLabel("Username*");
        usernameLabel.setBounds(50, 200, 200, 30);
        usernameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //usernameLabel.setForeground(new Color(68,62,149));
        panel.add(usernameLabel);
        
        username = new JTextField();
        username.setBounds(50, 235, 300, 30);
        username.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //username.setForeground(new Color(68,62,149));
        panel.add(username);
        
        userAlert = new JLabel();
        userAlert.setBounds(50, 260, 300, 20);
        userAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        userAlert.setForeground(Color.red);
        panel.add(userAlert);

        passwordLabel = new JLabel("Password*");
        passwordLabel.setBounds(50, 300, 200, 30);
        passwordLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //passwordLabel.setForeground(new Color(68,62,149));
        panel.add(passwordLabel);
        
        password = new JPasswordField();
        password.setBounds(50, 330, 300, 30);
        password.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        //password.setForeground(new Color(68,62,149));
        panel.add(password);
        
        passwordAlert = new JLabel();
        passwordAlert.setBounds(50, 360, 300, 20);
        passwordAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        passwordAlert.setForeground(Color.red);
        panel.add(passwordAlert);
        
        alert = new JLabel();
        alert.setBounds(50, 360, 300, 20);
        alert.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        alert.setForeground(Color.red);
        panel.add(alert);
        
        forgetPassword = new JButton("Forget Password");
        forgetPassword.setBounds(20,500,124,30);
        forgetPassword.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        forgetPassword.setBackground(new Color(255,209,54));
        forgetPassword.addActionListener(this);
        forgetPassword.setForeground(Color.WHITE);
        panel.add(forgetPassword);
        
        newRegistration = new JButton("New Registration");
        newRegistration.addActionListener(this);
        newRegistration.setBounds(149,500,124,30);
        newRegistration.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        newRegistration.setBackground(new Color(255,209,54));
        newRegistration.setForeground(Color.WHITE);
        panel.add(newRegistration);
        
        login = new JButton("Login");
        login.addActionListener(this);
        login.setBounds(300,500,70,30);
        login.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        login.setBackground(new Color(113,177,249));
        login.setForeground(Color.WHITE);
        panel.add(login);
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        
        setUndecorated(true);
        setVisible(true);
        setSize(1280,675); //675
        setLocation(0,0);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[]){
        new AdminLogin();
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
