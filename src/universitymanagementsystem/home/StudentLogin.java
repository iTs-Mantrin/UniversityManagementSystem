package universitymanagementsystem.home;

import javax.swing.*;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;

/*
 * @author Manish Kumar
 */
public class StudentLogin extends JFrame implements ActionListener, MouseMotionListener{
    JPanel panel, panelHeading,detailsPanel,informationPanel, requestPanel, courseRegistrationDetailsPanel,admissionStstusPanel, requestStatusPanel, courseRegistrationDetailsStatusPanel;
    JLabel close, headingLabel, enrollmentLabel, programmeLabel, mediumLabel, nameLabel, admissionStatusLabel, requestStatusLabel, courseRegistrationDetailsLabel;
    JLabel admissionYearTitle, admissionValidTitle, guardianNameTitle, dateOfBirthTitle, currentAddressTitle, regionalCenterCodeTitle, studyCenterCodeTitle, mobileNumberTitle, emailAddressTitle; ;
    JLabel admissionYear, admissionValid, guardianName, dateOfBirth, address1 , address2, address3, city, state, regionalCenterCode, studyCenterCode, mobileNumber, emailAddress;       
    JButton signout,print;
    String UserName;
    StudentLogin(String UserName){
        this.UserName = UserName;
        
       setLayout(null);

        panelHeading = new JPanel();
        panelHeading.setBounds(0, 0,1280, 100);
        panelHeading.setBackground(new Color(123,7,127));
        panelHeading.setSize(1280,100);
        panelHeading.setLayout(null);
        add(panelHeading);

        headingLabel = new JLabel("Know Your Admission/Registration Details");
        headingLabel.setBounds(280, 10,700, 40);
        headingLabel.setFont(new Font("SAN_SERIF",Font.BOLD,30));
        headingLabel.setLocation(280,10);
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
        panel.setBounds(0,100, 1300, 1000); //575
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        addMouseMotionListener(this);
        add(panel);
        
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
         
        detailsPanel = new JPanel();
        detailsPanel.setBounds(5,5, 1270, 70);
        detailsPanel.setBorder(blackline);
        detailsPanel.setBackground(new Color(255,250,218));
        detailsPanel.setLayout(null);
        panel.add(detailsPanel);
        
        nameLabel = new JLabel();
        nameLabel.setBounds(450, 10,500, 30);
        nameLabel.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        nameLabel.setForeground(Color.BLUE);
        nameLabel.setText("Welcome "+"name");
        detailsPanel.add(nameLabel);
      
        enrollmentLabel = new JLabel();
        enrollmentLabel.setBounds(20, 40,400, 30);
        enrollmentLabel.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        enrollmentLabel.setText("Enrollment Number: "+"enroll");
        detailsPanel.add(enrollmentLabel);
        
        programmeLabel = new JLabel();
        programmeLabel.setBounds(550, 40,250, 30);
        programmeLabel.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        programmeLabel.setText("Programme: "+"Programme");
        detailsPanel.add(programmeLabel);
   
        mediumLabel = new JLabel("Medium:");
        mediumLabel.setBounds(1100, 40,250, 30);
        mediumLabel.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        mediumLabel.setText("Medium: "+"Medium");
        detailsPanel.add(mediumLabel);

        informationPanel = new JPanel();
        informationPanel.setBounds(5,80, 750, 400);
        informationPanel.setBorder(blackline);
        informationPanel.setBackground(new Color(255,250,218));
        informationPanel.setLayout(null);
        panel.add(informationPanel);
        
        admissionStstusPanel = new JPanel();
        admissionStstusPanel.setBounds(1,1, 748, 40);
        //admissionStstusPanel.setBorder(blackline);
        admissionStstusPanel.setBackground(new Color(239,186,96));
        admissionStstusPanel.setLayout(null);
        informationPanel.add(admissionStstusPanel);
        
        admissionStatusLabel = new JLabel("Admission Status");
        admissionStatusLabel.setBounds(300, 5, 250, 30);
        admissionStatusLabel.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        admissionStatusLabel.setForeground(Color.WHITE);
        admissionStstusPanel.add(admissionStatusLabel);
        
        admissionYearTitle = new JLabel("Admission Year");
        admissionYearTitle.setBounds(40, 40, 250, 30);
        admissionYearTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(admissionYearTitle);
        
        admissionYear = new JLabel("Year");
        admissionYear.setBounds(350, 40, 250, 30);
        admissionYear.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(admissionYear);
        
        admissionValidTitle = new JLabel("Admission Valid Upto");
        admissionValidTitle.setBounds(40, 70, 250, 30);
        admissionValidTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(admissionValidTitle);
        
        admissionValid = new JLabel("Year");
        admissionValid.setBounds(350, 70, 250, 30);
        admissionValid.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(admissionValid);
        
        guardianNameTitle = new JLabel("Father/Husband/Mother's Name");
        guardianNameTitle.setBounds(40, 100, 250, 30);
        guardianNameTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(guardianNameTitle);
        
        guardianName = new JLabel("guardian");
        guardianName.setBounds(350, 100, 250, 30);
        guardianName.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(guardianName);
        
        dateOfBirthTitle = new JLabel("dateOfBirthTitle");
        dateOfBirthTitle.setBounds(40, 130, 250, 30);
        dateOfBirthTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(dateOfBirthTitle);
        
        dateOfBirth = new JLabel("DD-MMM-YYYY");
        dateOfBirth.setBounds(350, 130, 250, 30);
        dateOfBirth.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(dateOfBirth);
        
        currentAddressTitle = new JLabel("Current Address");
        currentAddressTitle.setBounds(40, 200, 250, 30);
        currentAddressTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(currentAddressTitle);
        
        address1 = new JLabel("Address 1");
        address1.setBounds(350, 160, 250, 30);
        address1.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        address1.setBackground(Color.red);

        informationPanel.add(address1);
        
        address2 = new JLabel("Address 2");
        address2.setBounds(350, 180, 250, 30);
        address2.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(address2);
        
        address3 = new JLabel("Address 2");
        address3.setBounds(350, 200, 250, 30);
        address3.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(address3);
        
        city = new JLabel("City"+ "-"+"Pincode");
        city.setBounds(350, 220, 250, 30);
        city.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(city);
        
        state = new JLabel("State");
        state.setBounds(350, 240, 250, 30);
        state.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(state);
        
        regionalCenterCodeTitle = new JLabel("Regional Center Code");
        regionalCenterCodeTitle.setBounds(40, 270, 250, 30);
        regionalCenterCodeTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(regionalCenterCodeTitle);
        
        regionalCenterCode = new JLabel("DELHI-I");
        regionalCenterCode.setBounds(350, 270, 250, 30);
        regionalCenterCode.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(regionalCenterCode);
        
        studyCenterCodeTitle = new JLabel("Study Center Code");
        studyCenterCodeTitle.setBounds(40, 300, 250, 30);
        studyCenterCodeTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(studyCenterCodeTitle);
        
        studyCenterCode = new JLabel("NSUIT");
        studyCenterCode.setBounds(350, 300, 250, 30);
        studyCenterCode.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(studyCenterCode);
        
        mobileNumberTitle = new JLabel("Mobile Number");
        mobileNumberTitle.setBounds(40, 330, 250, 30);
        mobileNumberTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(mobileNumberTitle);
        
        mobileNumber = new JLabel("XXXXX-67979");
        mobileNumber.setBounds(350, 330, 250, 30);
        mobileNumber.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(mobileNumber);
        
        emailAddressTitle = new JLabel("Email Address");
        emailAddressTitle.setBounds(40, 360, 250, 30);
        emailAddressTitle.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(emailAddressTitle);
        
        emailAddress = new JLabel("XXXXXraj.kumar@gmail.com");
        emailAddress.setBounds(350, 360, 250, 30);
        emailAddress.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        informationPanel.add(emailAddress);
        
        
        requestPanel = new JPanel();
        requestPanel.setBounds(760,80, 515, 400);
        requestPanel.setBorder(blackline);
        requestPanel.setBackground(new Color(255,250,218));
        requestPanel.setLayout(null);
        panel.add(requestPanel);
        
        requestStatusLabel = new JLabel("Request Status");
        requestStatusLabel.setBounds(180, 5, 250, 30);
        requestStatusLabel.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        requestStatusLabel.setForeground(Color.WHITE);
        requestPanel.add(requestStatusLabel);
        
        requestStatusPanel = new JPanel();
        requestStatusPanel.setBounds(1,1, 513, 40);
        //requestStatusPanel.setBorder(blackline);
        requestStatusPanel.setBackground(new Color(239,186,96));
        requestStatusPanel.setLayout(null);
        requestPanel.add(requestStatusPanel);
        
        courseRegistrationDetailsPanel = new JPanel();
        courseRegistrationDetailsPanel.setBounds(5,485, 1270, 400);
        courseRegistrationDetailsPanel.setBorder(blackline);
        courseRegistrationDetailsPanel.setBackground(new Color(255,250,218));
        courseRegistrationDetailsPanel.setLayout(null);
        panel.add(courseRegistrationDetailsPanel);
        
        courseRegistrationDetailsLabel = new JLabel("Course Registration Detail Status");
        courseRegistrationDetailsLabel.setBounds(450, 5, 500, 30);
        courseRegistrationDetailsLabel.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        courseRegistrationDetailsLabel.setForeground(Color.WHITE);
        courseRegistrationDetailsPanel.add(courseRegistrationDetailsLabel);
        
        courseRegistrationDetailsStatusPanel = new JPanel();
        courseRegistrationDetailsStatusPanel.setBounds(1,1, 1268, 40);
        //courseRegistrationDetailsStatusPanel.setBorder(blackline);
        courseRegistrationDetailsStatusPanel.setBackground(new Color(239,186,96));
        courseRegistrationDetailsStatusPanel.setLayout(null);
        courseRegistrationDetailsPanel.add(courseRegistrationDetailsStatusPanel);
        
        


        

        
        
 


        /****************************************************/
        /*            Bottom down button                    */
        /****************************************************/
        ImageIcon down1 = new ImageIcon(ClassLoader.getSystemResource("icon/bottom.png"));
        Image down2 = down1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon down3 = new ImageIcon(down2);
        
        JLabel down = new JLabel(down3);
        down.setBounds(450, 150, 50, 50);
        
        requestPanel.add(down);
        down.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int value = 500;
            panel.setLocation(0,100-value); 
            
            }
        });
        
        /****************************************************/
        /*            Bottom Up button                    */
        /****************************************************/
        ImageIcon up1 = new ImageIcon(ClassLoader.getSystemResource("icon/up.png"));
        Image up2 = up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon up3 = new ImageIcon(up2);
        
        JLabel up = new JLabel(up3);
        up.setBounds(1200, 200, 50, 50);
        
        courseRegistrationDetailsPanel.add(up);
        up.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int value = 0;
            panel.setLocation(0,100-value); 
            
            }
        });

        print = new JButton("Print");
        print.addActionListener(this);
        print.setBounds(500,900,250,40);
        print.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        print.setBackground(new Color(113,177,249));
        print.setForeground(Color.WHITE);
        panel.add(print);
        
        setUndecorated(true);
        setVisible(true);
        setSize(1280,675); //675
        setLocation(0,0);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[]){
        new StudentLogin("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
         
         if(e.getSource() == signout){
            JOptionPane.showMessageDialog(null, "Logout Successfully...");
            setVisible(false);
            new Home().setVisible(true);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        panel.setLocation(0,100-e.getY());
        throw new UnsupportedOperationException("Not supported yet.");     }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
