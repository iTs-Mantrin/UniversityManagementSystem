package universitymanagementsystem.admissionportal;

import javax.swing.*;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import universitymanagementsystem.home.JDBCConnection;
/*
 * @author Manish KumarcityAlert
 */
public class AdmissionCorrespondenceDetails extends JFrame implements ActionListener {
    JPanel panel, panelHeading, correspondenceDetailsPanel;
    JLabel close,headingLabel, correspondenceDetails ,addressLine1Label,addressLine2Label, addressLine3Label, stateLabel, cityLabel, pinCodeLabel, mobileNumberLabel,emailLabel;
    JLabel addressLine1Alert, stateAlert, cityAlert, pinCodeAlert;
    JComboBox state, city;
    JTextField addressLine1, addressLine2, addressLine3,pinCode, mobileNumber, email;
    JButton signout,back, saveNext;
    String UserName,Programme;
    AdmissionCorrespondenceDetails(String UserName,String Programme){
        this.UserName = UserName;
        this.Programme = Programme;
        
       setLayout(null);

        panelHeading = new JPanel();
        panelHeading.setBounds(0, 0,1280, 100);
        panelHeading.setBackground(new Color(123,7,127));
        panelHeading.setSize(1280,100);
        panelHeading.setLayout(null);
        add(panelHeading);

        headingLabel = new JLabel("Admission Informtion Bulletin");
        headingLabel.setBounds(100, 10,300, 30);
        headingLabel.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        headingLabel.setLocation(100,10);
        headingLabel.setForeground(Color.WHITE);
        panelHeading.add(headingLabel);
        
        signout = new JButton("Sign out");
        signout.setBounds(1190, 70,100, 30);
        signout.addActionListener(this);
        signout.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        signout.setLocation(1190,70);
        signout.setForeground(Color.WHITE);
        signout.setBackground(new Color(123,7,127));
        panelHeading.add(signout);
        
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
        panel.setBounds(0,100, 1260, 1050); //575
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        correspondenceDetailsPanel = new JPanel();
        correspondenceDetailsPanel.setBounds(0,3, 1260, 35);
        correspondenceDetailsPanel.setBackground(Color.GRAY);
        correspondenceDetailsPanel.setLayout(null);
        panel.add(correspondenceDetailsPanel);
        
        
        correspondenceDetails = new JLabel("Correspondence Details");
        correspondenceDetails.setBounds(50, 3,300, 30);
        correspondenceDetails.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        correspondenceDetails.setForeground(Color.WHITE);
        correspondenceDetailsPanel.add(correspondenceDetails);
       
        addressLine1Label = new JLabel("Address Line 1*");
        addressLine1Label.setBounds(100, 100 ,400, 30);
        addressLine1Label.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(addressLine1Label);
        
        addressLine1 = new JTextField();
        addressLine1.setBounds(400, 100 ,400, 30);
        addressLine1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(addressLine1);
        
        addressLine1Alert = new JLabel("alert");
        addressLine1Alert.setBounds(820, 100 ,350, 20);
        addressLine1Alert.setForeground(Color.red);
        addressLine1Alert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(addressLine1Alert);
        
        addressLine2Label = new JLabel("Address Line 2");
        addressLine2Label.setBounds(100, 140 ,400, 30);
        addressLine2Label.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(addressLine2Label);
        
        addressLine2 = new JTextField();
        addressLine2.setBounds(400, 140 ,400, 30);
        addressLine2.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(addressLine2);
        
        addressLine3Label = new JLabel("Address Line 3");
        addressLine3Label.setBounds(100, 180 ,400, 30);
        addressLine3Label.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(addressLine3Label);
        
        addressLine3 = new JTextField();
        addressLine3.setBounds(400, 180 ,400, 30);
        addressLine3.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(addressLine3);
        
      
        stateLabel = new JLabel("State*");
        stateLabel.setBounds(100, 220 ,400, 30);
        stateLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(stateLabel);
   
        state = new JComboBox();
        state.setBackground(Color.WHITE);
        state.setBounds(400, 220 ,400, 30);
        state.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(state);
        
        try{
            String query = "SELECT DISTINCT state FROM location";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            state.addItem("Select");
            while(rs.next()){
                String states= rs.getString("state");
                state.addItem(states);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        stateAlert = new JLabel("alert");
        stateAlert.setBounds(820, 220 ,350, 30);
        stateAlert.setForeground(Color.red);
        stateAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(stateAlert);

        cityLabel = new JLabel("City*");
        cityLabel.setBounds(100, 260 ,400, 30);
        cityLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(cityLabel);
   
        city = new JComboBox();
        city.setBackground(Color.WHITE);
        city.setBounds(400, 260 ,400, 30);
        city.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(city);
        
        try{
            String query = "SELECT DISTINCT city FROM location";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            city.addItem("Select");
            while(rs.next()){
                String cities= rs.getString("city");
                city.addItem(cities);
                String states= rs.getString("state");
                state.addItem(states);

            }
        }
        catch(Exception e){System.out.println(e);}
        
        cityAlert = new JLabel("alert");
        cityAlert.setBounds(820, 260 ,350, 30);
        cityAlert.setForeground(Color.red);
        cityAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(cityAlert);

        pinCodeLabel = new JLabel("Pincode*");
        pinCodeLabel.setBounds(100, 300 ,400, 30);
        pinCodeLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(pinCodeLabel);
        
        pinCode = new JTextField();
        pinCode.setBounds(400, 300 ,400, 30);
        pinCode.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(pinCode);
        
        pinCodeAlert = new JLabel("alert");
        pinCodeAlert.setBounds(820, 300 ,350, 20);
        pinCodeAlert.setForeground(Color.red);
        pinCodeAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(pinCodeAlert);

        mobileNumberLabel = new JLabel("Mobile Number*");
        mobileNumberLabel.setBounds(100, 340 ,400, 30);
        mobileNumberLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(mobileNumberLabel);
        
        mobileNumber = new JTextField();
        mobileNumber.disable();
        mobileNumber.setBounds(400, 340 ,400, 30);
        mobileNumber.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(mobileNumber);
        
        emailLabel = new JLabel("Email Address*");
        emailLabel.setBounds(100, 380 ,400, 30);
        emailLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(emailLabel);
        
        email = new JTextField();
        email.disable();
        email.setBounds(400, 380 ,400, 30);
        email.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(email);
        
        try{
            String query = "SELECT Email, PhoneNumber FROM studentregistration WHERE UserName = '"+UserName+"'";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            if(rs.next()){
                String mail = rs.getString("Email");
                email.setText(mail);
                String mNumber = rs.getString("PhoneNumber");
                mobileNumber.setText(mNumber);
            }
        }
        catch(Exception e){System.out.println(e);}
       
        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(350,520,250,40);
        back.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        back.setBackground(new Color(113,177,249));
        back.setForeground(Color.WHITE);
        panel.add(back);
        
        saveNext = new JButton("Save & Next");
        saveNext.addActionListener(this);
        saveNext.setBounds(700,520,250,40);
        saveNext.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        saveNext.setBackground(new Color(113,177,249));
        saveNext.setForeground(Color.WHITE);
        panel.add(saveNext);
        
        setUndecorated(true);
        setVisible(true);
        setSize(1280,675); //675
        setLocation(0,0);
//        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[]){
        new AdmissionCorrespondenceDetails("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String _addressLine1  = addressLine1.getText();
        String _addressLine2  = addressLine2.getText();
        String _addressLine3  = addressLine3.getText();
        String _state = (String) state.getSelectedItem();
        String _city = (String) city.getSelectedItem();
        String _pinCode = pinCode.getText();
        String _mobileNumber = mobileNumber.getText();
        String _email = email.getText();
     
        
        if(e.getSource() == saveNext){
            if(_addressLine1.equalsIgnoreCase("")||_state.equalsIgnoreCase("Select")||_city.equalsIgnoreCase("Select")||_pinCode.equalsIgnoreCase(""))
                {    
                    if(_addressLine1.equals("")){
                        addressLine1Alert.setText("Address 1 cannot be blank");
                    }
                    if(_state.equalsIgnoreCase("Select")){
                        stateAlert.setText("State cannot be blank");
                    }
                    if(_city.equalsIgnoreCase("Select")){
                        cityAlert.setText("City cannot be blank");
                    }
                    if(_pinCode.equalsIgnoreCase("")){
                        pinCodeAlert.setText("Pincode cannot be blank");
                    }
                }
            else{
                try{
                    JDBCConnection con = new JDBCConnection();
                    String query = "INSERT INTO admissioncorrespondencedetails (UserName, address1, address2, address3, state, city, pincode, mobileNumber, email) VALUES ('"+UserName+"', '"+_addressLine1+"','"+_addressLine2+"','"+_addressLine3+"','"+_state+"','"+_city+"','"+_pinCode+"','"+_mobileNumber+"','"+_email+"');";
                    con.stmt.executeUpdate(query);
                    setVisible(false);
                    new AdmissionUploadsDocuments(UserName).setVisible(true);
                }
                catch(Exception f){System.out.println(f);}
           }
        } 
         if(e.getSource() == signout){
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Logout Successfully...");
            new AdmissionPortal().setVisible(true);
        }
        else if(e.getSource() == back){
         setVisible(false);
         new AdmissionQualificationDetails(UserName,Programme).setVisible(true);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
