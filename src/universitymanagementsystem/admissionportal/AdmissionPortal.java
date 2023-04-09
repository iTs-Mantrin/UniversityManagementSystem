
package universitymanagementsystem.admissionportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

/**
 *
 * @author manis
 */
public class AdmissionPortal extends JFrame implements ActionListener{
    JLabel logo, admissionPortal, signIn, usernameLabel, passwordLabel, userAlert, passwordAlert,alert;
    JTextField username;
    JPasswordField password;
    JButton forgetPassword, forgetUsername, newRegistration , login;
    
    
    AdmissionPortal(){
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        Image img2 = img.getImage().getScaledInstance(200, 100,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        logo = new JLabel(img3);
        logo.setBounds(100, 10, 200, 100);
        add(logo);
        
        admissionPortal = new JLabel("Admission Portal");
        admissionPortal.setBounds(120, 80, 200, 100);
        admissionPortal.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        admissionPortal.setForeground(new Color(68,62,149));
        add(admissionPortal);
        
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
        
        newRegistration = new JButton("New Registration");
        newRegistration.addActionListener(this);
        newRegistration.setBounds(50,380,130,30);
        newRegistration.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        newRegistration.setBackground(new Color(255,209,54));
        newRegistration.setForeground(Color.WHITE);
        add(newRegistration);
        
        login = new JButton("Login");
        login.addActionListener(this);
        login.setBounds(215,380,130,30);
        login.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        login.setBackground(new Color(113,177,249));
        login.setForeground(Color.WHITE);
        add(login);
        
        forgetPassword = new JButton("Forget Password");
        forgetPassword.setBounds(20,500,150,30);
        forgetPassword.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        forgetPassword.setBackground(new Color(255,209,54));
        forgetPassword.addActionListener(this);
        forgetPassword.setForeground(Color.WHITE);
        add(forgetPassword);

        forgetUsername = new JButton("Forget Username");
        forgetUsername.addActionListener(this);
        forgetUsername.setBounds(200,500,150,30);
        forgetUsername.setFont(new Font("SAN_SERIF",Font.BOLD,11));
        forgetUsername.setBackground(new Color(255,209,54));
        forgetUsername.setForeground(Color.WHITE);
        add(forgetUsername);
        
        setLayout(null);
        setVisible(true);
        setSize(400,600);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,50);
        
        
    }
    
    public static void main(String args[]){
        new AdmissionPortal();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = username.getText();
        String pass = new String(password.getPassword());
            if(e.getSource() == login){
                 if(user.equals("") && pass.equals("")){
                        userAlert.setText("Username cannot be blank");
                        passwordAlert.setText("Password cannot be blank");
                    }
                    else if(user.equals("")){
                        userAlert.setText("Username cannot be blank");
                    }
                    else if(pass.equals("")){
                        passwordAlert.setText("Password cannot be blank");
                    }
                    else{
                        String query = "SELECT* FROM studentLogin WHERE username = '"+user+"' && password = '"+pass+"'";
                        
                try{
                  
                    JDBCConnection con = new JDBCConnection();
                    ResultSet rs = con.stmt.executeQuery(query);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Login Successfully");
                        setVisible(false);
                        //new AdmissionPortalLogin().setVisible(true);

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Username and Password...");
                    }
                }
                catch(Exception ae){
                    ae.printStackTrace();}
                    }      
            }
            else if(e.getSource() == newRegistration){
                setVisible(false);
                new StudentRegistrationForm();
            }
            else if(e.getSource() == forgetPassword){
                setVisible(false);
                new ForgetPassword().setVisible(true);
            }
            else if(e.getSource() == forgetUsername){
               setVisible(false);
                new ForgetUserName().setVisible(true);
            }
    }
    
}
