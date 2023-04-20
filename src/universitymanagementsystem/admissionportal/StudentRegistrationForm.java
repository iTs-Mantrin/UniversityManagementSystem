package universitymanagementsystem.admissionportal;

import universitymanagementsystem.home.JDBCConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Manish Kumar
 */
public class StudentRegistrationForm extends JFrame implements ActionListener{
    
    JLabel label, userNameLabel, fullNameLabel, emailLabel, reEmailLabel, passwordLabel, rePasswordLabel,mNumberLabel, reMNumberLabel;
    JLabel userNameAlert, fullNameAlert, emailAlert, reEmailAlert, passwordAlert, rePasswordAlert,mNumberAlert, reMNumberAlert;
    JTextField userName, fullName, email, reEmail, mNumber, reMNumber;
    JPasswordField password, rePassword;
    JButton register, cancel;
    StudentRegistrationForm(){
        label = new JLabel("Student Registration Form");
        label.setBounds(180,30, 400,50);
        label.setFont(new Font("SAN_SERIF", Font.BOLD,30));
        add(label);
        
        userNameLabel = new JLabel("UserName (Used for Login)*");
        userNameLabel.setBounds(80,110, 400,30);
        userNameLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(userNameLabel);
        
        userName = new JTextField();
        userName.setBounds(350,110, 300,30);
        userName.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(userName);
        
        userNameAlert = new JLabel();
        userNameAlert.setBounds(350,130, 300,30);
        userNameAlert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        userNameAlert.setForeground(Color.red);
        add(userNameAlert);
        
        fullNameLabel = new JLabel("Applicant's Full Name*");
        fullNameLabel.setBounds(80,160, 400,30);
        fullNameLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(fullNameLabel);
        
        fullName = new JTextField();
        fullName.setBounds(350,160, 300,30);
        fullName.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(fullName);
        
        fullNameAlert = new JLabel();
        fullNameAlert.setBounds(350,180, 300,30);
        fullNameAlert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        fullNameAlert.setForeground(Color.red);
        add(fullNameAlert);
        
        emailLabel = new JLabel("Applicant's Email Address*");
        emailLabel.setBounds(80,210, 400,30);
        emailLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(emailLabel);
        
        email = new JTextField();
        email.setBounds(350,210, 300,30);
        email.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(email);
        
        emailAlert = new JLabel();
        emailAlert.setBounds(350,230, 300,30);
        emailAlert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        emailAlert.setForeground(Color.red);
        add(emailAlert);
        
        reEmailLabel = new JLabel("Re-Enter Applicant's Email Address*");
        reEmailLabel.setBounds(80,260, 400,30);
        reEmailLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(reEmailLabel);
        
        reEmail = new JTextField();
        reEmail.setBounds(350,260, 300,30);
        reEmail.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(reEmail);
        
        reEmailAlert = new JLabel();
        reEmailAlert.setBounds(350,280, 300,30);
        reEmailAlert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        reEmailAlert.setForeground(Color.red);
        add(reEmailAlert);
        
        passwordLabel = new JLabel("Password (Minimum 6 Characters)*");
        passwordLabel.setBounds(80,310, 400,30);
        passwordLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(passwordLabel);
        
        password = new JPasswordField();
        password.setBounds(350,310, 300,30);
        password.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(password);
        
        passwordAlert = new JLabel();
        passwordAlert.setBounds(350,330, 300,30);
        passwordAlert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        passwordAlert.setForeground(Color.red);
        add(passwordAlert);
        
        rePasswordLabel = new JLabel("Re-Enter Password*");
        rePasswordLabel.setBounds(80,360, 400,30);
        rePasswordLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(rePasswordLabel);
        
        rePassword = new JPasswordField();
        rePassword.setBounds(350,360, 300,30);
        rePassword.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(rePassword);
        
        rePasswordAlert = new JLabel();
        rePasswordAlert.setBounds(350,380, 300,30);
        rePasswordAlert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        rePasswordAlert.setForeground(Color.red);
        add(rePasswordAlert);
        
        mNumberLabel = new JLabel("Mobile Number*");
        mNumberLabel.setBounds(80,410, 400,30);
        mNumberLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(mNumberLabel);
        
        mNumber = new JTextField();
        mNumber.setBounds(350,410, 300,30);
        mNumber.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(mNumber);
        
        mNumberAlert = new JLabel();
        mNumberAlert.setBounds(350,430, 300,30);
        mNumberAlert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        mNumberAlert.setForeground(Color.red);
        add(mNumberAlert);
        
        reMNumberLabel = new JLabel("Re-Enter Mobile Number*");
        reMNumberLabel.setBounds(80,460, 400,30);
        reMNumberLabel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(reMNumberLabel);
        
        reMNumber = new JTextField();
        reMNumber.setBounds(350,460, 300,30);
        reMNumber.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        add(reMNumber);
        
        reMNumberAlert = new JLabel();
        reMNumberAlert.setBounds(350,480, 300,30);
        reMNumberAlert.setFont(new Font("SAN_SERIF", Font.PLAIN,12));
        reMNumberAlert.setForeground(Color.red);
        add(reMNumberAlert);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(140,510, 150,40);
        cancel.addActionListener(this);
        cancel.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        cancel.setBackground(new Color(113,177,249));
        cancel.setForeground(Color.WHITE);
        add(cancel);
        
        register = new JButton("Register");
        register.setBounds(450,510, 150,40);
        register.addActionListener(this);
        register.setFont(new Font("SAN_SERIF", Font.PLAIN,15));
        register.setBackground(new Color(113,177,249));
        register.setForeground(Color.WHITE);
        add(register);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setSize(800,650);
        setLocation(220,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String args[]){
        new StudentRegistrationForm();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String username = userName.getText();
        String fullname = fullName.getText();
        String mail = email.getText();
        String remail = reEmail.getText();
        String pass = new String (password.getPassword());
        String repass = new String(rePassword.getPassword());
        String mnumber = mNumber.getText();
        String remnumber = reMNumber.getText();
        if(ae.getSource() == register){
            if(username.equals("")||fullname.equals("")||mail.equals("")||remail.equals("")||pass.equals("")||repass.equals("")||mnumber.equals("")||remnumber.equals("")||!mail.equals(remail)||!pass.equals(repass)||!mnumber.equals(remnumber)){
               if(username.equals("")){
                    userNameAlert.setText("Username cannot be blank");
                }
                if(fullname.equals("")){
                    fullNameAlert.setText("Full Name cannot be blank");
                }
                if(mail.equals("")){
                    emailAlert.setText("Email cannot be blank");
                }
                if(remail.equals("")){
                    reEmailAlert.setText("Re-Enter Email cannot be blank");
                }
                if(pass.equals("")){
                    passwordAlert.setText("Password cannot be blank");
                }
                if(repass.equals("")){
                    rePasswordAlert.setText("Re-Enter Password cannot be blank");
                }
                if(mnumber.equals("")){
                    mNumberAlert.setText("Mobile Number cannot be blank");
                }
                if(remnumber.equals("")){
                    reMNumberAlert.setText("Re-Enter Mobile Number cannot be blank");
                }
                if(!mail.equals(remail)){
                    reEmailAlert.setText("Email and re-enter email not matched");             
                }
                if(!pass.equals(repass)){
                    rePasswordAlert.setText("Password and re-enter password not matched");             
                }
                if(!mnumber.equals(remnumber)){
                    reMNumberAlert.setText("Mobile number and re-enter mobile number not matched");             
                } 
            }
            else{
                
                String query = "INSERT INTO studentRegistration (UserName, FullName, Email, Password, PhoneNumber) VALUES('"+username+"','"+fullname+"','"+remail+"','"+repass+"','"+remnumber+"')";
                String query2 ="INSERT INTO admissionLogin (UserName,Password) VALUES('"+username+"','"+repass+"')";
                try{
                    JDBCConnection con = new JDBCConnection();
                    con.stmt.executeUpdate(query);
                    con.stmt.executeUpdate(query2);
                    setVisible(false);
                    new AdmissionPortal().setVisible(true);
                }
            catch(Exception e){System.out.println(e);}
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new AdmissionPortal().setVisible(true);
        }
    }
}
