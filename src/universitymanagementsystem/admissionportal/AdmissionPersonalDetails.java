package universitymanagementsystem.admissionportal;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import universitymanagementsystem.home.JDBCConnection;
/*
 * @author Manish Kumar
 */
public class AdmissionPersonalDetails extends JFrame implements ActionListener {
    JPanel panel, panelHeading, personalDetailsPanel,otherDetailsPanel,scholarshipDetailsPanel,scrollPanel;
    JLabel close,headingLabel, personalDetails, otherDetails,scholarshipDetails,fullNameLabel, motherNameLabel, guardianRelationLabel, gaurdianNameLabel, dateOfBirthLabel, categoryLabel,genderLabel,citizenshipLabel, territoryLabel, minorityLabel, religionLabel, maritalStatusLabel,socialStatusLabel ;
    JLabel emailLabel, alternateEmailLabel, mobileNumberLabel, alternateMobileNumberLabel,disabilityLabel, disabilityCategoryLabel, otherDisabilityLabel, employementStatusLabel, scholarshipAmountLabel, scholarshipDepartmentLabel, familyIncomeLabel, belowPovertyLineLabel;
    JLabel fullNameAlert, motherNameAlert, guardianRelationAlert, gaurdianNameAlert, dateOfBirthAlert, categoryAlert, genderAlert, citizenshipAlert, territoryAlert, minorityAlert, religionAlert, maritalStatusAlert, socialStatusAlert, disabilityAlert, employementStatusAlert;
    JTextField fullName, motherName, gaurdianName,email, alternateEmail, mobileNumber, alternateMobileNumber, otherDisability,scholarshipAmount,familyIncome;
    JRadioButton male, female, transGender;
    ButtonGroup genderGroup;
    JDateChooser dateOfBirth;
    JComboBox guardianRelation, category, citizenship, territoryArea, minority, religion, maritalStatus, socialStatus, disability, disabilityCategory, employementStatus,scholarshipDepartment,belowPovertyLine;
    JButton personal, programme, qualification, course, correspondenceDetails, upload, preview, fee, signout,cancel, saveNext;
    JScrollBar scroll;
    String UserName;
    AdmissionPersonalDetails(String UserName){
        this.UserName = UserName;
        
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
        
        
        /**********************************/
        
        
        
        panel = new JPanel();
        panel.setBounds(0,100, 1260, 1050); //575
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
                
        /****************************************************/
        /*            Bottom down button                    */
        /****************************************************/
        ImageIcon down1 = new ImageIcon(ClassLoader.getSystemResource("icon/bottom.png"));
        Image down2 = down1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon down3 = new ImageIcon(down2);
        
        JLabel down = new JLabel(down3);
        down.setBounds(1200, 150, 50, 50);
        
        panel.add(down);
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
        up.setBounds(1200, 800, 50, 50);
        
        panel.add(up);
        up.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int value = 0;
            panel.setLocation(0,100-value); 
            
            }
        });
        

//        scrollPanel = new JPanel();
//        scrollPanel.setBounds(1260,100, 20, 575);
//        scrollPanel.setBackground(Color.BLUE);
//        scrollPanel.setLayout(null);
//        add(scrollPanel);
//        
//        scroll = new JScrollBar();
//        scroll.setBounds(0,0,20,600);
//        scroll.addAdjustmentListener(new AdjustmentListener(){
//            int Value;
//            @Override
//            public void adjustmentValueChanged(AdjustmentEvent e) {
//                Value = scroll.getValue();
//                panel.setBounds(0,100-Value, 1260, 800);
//                throw new UnsupportedOperationException("Not supported yet."); 
//            }
//        });
//        scrollPanel.add(scroll);
        
        personalDetailsPanel = new JPanel();
        personalDetailsPanel.setBounds(0,3, 1260, 35);
        personalDetailsPanel.setBackground(Color.GRAY);
        personalDetailsPanel.setLayout(null);
        panel.add(personalDetailsPanel);
        
        
        personalDetails = new JLabel("Personal Details");
        personalDetails.setBounds(50, 3,300, 30);
        personalDetails.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        //personalDetails.setLocation(900,70);
        personalDetails.setForeground(Color.WHITE);
        personalDetailsPanel.add(personalDetails);
        
        fullNameLabel = new JLabel("Full Name of the Applicant (as per Educational Documents)*");
        fullNameLabel.setBounds(50, 50 ,370, 30);
        fullNameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(fullNameLabel);
        
        fullName = new JTextField();
        fullName.setBounds(50, 80 ,350, 30);
        fullName.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(fullName);
        
        fullNameAlert = new JLabel();
        fullNameAlert.setBounds(50, 100 ,370, 30);
        fullNameAlert.setForeground(Color.red);
        fullNameAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(fullNameAlert);
        
        motherNameLabel = new JLabel("Mother Name*");
        motherNameLabel.setBounds(450, 50 ,100, 30);
        motherNameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(motherNameLabel);
        
        motherName = new JTextField();
        motherName.setBounds(450, 80 ,350, 30);
        motherName.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(motherName);
        
        motherNameAlert = new JLabel();
        motherNameAlert.setBounds(450, 100 ,350, 30);
        motherNameAlert.setForeground(Color.red);
        motherNameAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(motherNameAlert);
        
        guardianRelationLabel = new JLabel("Guardian Relation*");
        guardianRelationLabel.setBounds(830, 50 ,150, 30);
        guardianRelationLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(guardianRelationLabel);
        
        String guardianRelationArr[] = {"Select","Fathers Name","Mothers Name","Husbands Name"};
        guardianRelation = new JComboBox(guardianRelationArr);
        guardianRelation.setBackground(Color.WHITE);
        guardianRelation.setBounds(830, 80 ,140, 30);
        guardianRelation.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(guardianRelation);
    
        guardianRelationAlert = new JLabel();
        guardianRelationAlert.setBounds(830, 100 ,370, 30);
        guardianRelationAlert.setForeground(Color.red);
        guardianRelationAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(guardianRelationAlert);
        
        gaurdianNameLabel = new JLabel("Guardian Name*");
        gaurdianNameLabel.setBounds(980, 50 ,150, 30);
        gaurdianNameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(gaurdianNameLabel);
        
        gaurdianName = new JTextField();
        gaurdianName.setBounds(980, 80 ,250, 30);
        gaurdianName.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(gaurdianName);
    
        gaurdianNameAlert = new JLabel();
        gaurdianNameAlert.setBounds(980, 100 ,370, 30);
        gaurdianNameAlert.setForeground(Color.red);
        gaurdianNameAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(gaurdianNameAlert);
        
        dateOfBirthLabel = new JLabel("Date of Birth*");
        dateOfBirthLabel.setBounds(50, 150 ,370, 30);
        dateOfBirthLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(dateOfBirthLabel);
        
        dateOfBirth = new JDateChooser();
        dateOfBirth.setBounds(50, 180 ,350, 30);
        dateOfBirth.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(dateOfBirth);
        
        dateOfBirthAlert = new JLabel();
        dateOfBirthAlert.setBounds(50, 200 ,370, 30);
        dateOfBirthAlert.setForeground(Color.red);
        dateOfBirthAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(dateOfBirthAlert);
        
        categoryLabel = new JLabel("Category*");
        categoryLabel.setBounds(450, 150 ,370, 30);
        categoryLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(categoryLabel);
        
        String categoryArr[] = {"Select","Unreserved (UR)","Scheduled Caste (SC)","Scheduled Tribes (ST)","OBC (Creamy)","OBC (Non-Creamy)","Economically Weaker Section"};
        category = new JComboBox(categoryArr);
        category.setBackground(Color.WHITE);
        category.setBounds(450, 180 ,350, 30);
        category.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(category);
        
        categoryAlert = new JLabel();
        categoryAlert.setBounds(450, 200 ,350, 30);
        categoryAlert.setForeground(Color.red);
        categoryAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(categoryAlert);
        
        
        genderLabel = new JLabel("Gender*");
        genderLabel.setBounds(830, 150 ,350, 30);
        genderLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(genderLabel);
        
        
        male = new JRadioButton("Male");
        male.setBounds(830, 180 ,100, 30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(940, 180 ,100, 30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(female);
        
        transGender = new JRadioButton("Transgender");
        transGender.setBackground(Color.WHITE);
        transGender.setBounds(1050, 180 ,110, 30);
        transGender.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(transGender);
        
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(transGender);
        
        genderAlert = new JLabel();
        genderAlert.setBounds(830, 200 ,370, 30);
        genderAlert.setForeground(Color.red);
        genderAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(genderAlert);
        
        
        citizenshipLabel = new JLabel("Citizenship Country Name*");
        citizenshipLabel.setBounds(50, 250 ,350, 30);
        citizenshipLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(citizenshipLabel);
        
        citizenship = new JComboBox();
        citizenship.setBackground(Color.WHITE);
        citizenship.setBounds(50, 280 ,350, 30);
        citizenship.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(citizenship);
        
         try{
          //String citizenshipArr[] = {"Select","Unreserved (UR)","Scheduled Caste (SC)","Scheduled Tribes (ST)","OBC (Creamy)","OBC (Non-Creamy)","Economically Weaker Section"};
        JDBCConnection con = new JDBCConnection();
        String query ="SELECT country FROM citizenShip";
        ResultSet rs = con.stmt.executeQuery(query);
        citizenship.addItem("Select");
            while(rs.next()){
                String country = rs.getString("country");
                citizenship.addItem(country);
            }
        
        }
        catch(Exception e){System.out.println(e);}
        
        citizenshipAlert = new JLabel();
        citizenshipAlert.setBounds(50, 310 ,350, 30);
        citizenshipAlert.setForeground(Color.red);
        citizenshipAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(citizenshipAlert);
        
        territoryLabel = new JLabel("Territory/Area*");
        territoryLabel.setBounds(450, 250 ,350, 30);
        territoryLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(territoryLabel);
        
        String territoryAreaArr[] = {"Select","Urban", "Rural", "Tribal"};
        territoryArea = new JComboBox(territoryAreaArr);
        territoryArea.setBackground(Color.WHITE);
        territoryArea.setBounds(450, 280 ,350, 30);
        territoryArea.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(territoryArea);

        
        territoryAlert = new JLabel();
        territoryAlert.setBounds(450, 310 ,350, 30);
        territoryAlert.setForeground(Color.red);
        territoryAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(territoryAlert);
        
        minorityLabel = new JLabel("Minority*");
        minorityLabel.setBounds(830, 250 ,350, 30);
        minorityLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(minorityLabel);
        
        String minorityArr[] = {"Select","No", "Yes"};
        minority = new JComboBox(minorityArr);
        minority.setBackground(Color.WHITE);
        minority.setBounds(830, 280 ,350, 30);
        minority.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(minority);

        
        minorityAlert = new JLabel();
        minorityAlert.setBounds(830, 310 ,350, 30);
        minorityAlert.setForeground(Color.red);
        minorityAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(minorityAlert);
        
        religionLabel = new JLabel("Religion*");
        religionLabel.setBounds(50, 360 ,350, 30);
        religionLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(religionLabel);
        
        religion = new JComboBox();
        religion.setBackground(Color.WHITE);
        religion.setBounds(50, 390 ,350, 30);
        religion.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(religion);
        
         try{
          //String religionArr[] = {"Select","Hindu","Muslim"};
        JDBCConnection con = new JDBCConnection();
        String query ="SELECT religion FROM religion";
        ResultSet rs = con.stmt.executeQuery(query);
        religion.addItem("Select");
            while(rs.next()){
                String religions = rs.getString("religion");
                religion.addItem(religions);
            }
        
        }
        catch(Exception e){System.out.println(e);}
        
        religionAlert = new JLabel();
        religionAlert.setBounds(50, 410 ,350, 30);
        religionAlert.setForeground(Color.red);
        religionAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(religionAlert);
        
        maritalStatusLabel = new JLabel("Marital Status*");
        maritalStatusLabel.setBounds(450, 360 ,350, 30);
        maritalStatusLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(maritalStatusLabel);
        
        String maritalStatusArr[] = {"Select","Single","Married","Widows"};
        maritalStatus = new JComboBox(maritalStatusArr);
        maritalStatus.setBackground(Color.WHITE);
        maritalStatus.setBounds(450, 390 ,350, 30);
        maritalStatus.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(maritalStatus);
        
        maritalStatusAlert = new JLabel();
        maritalStatusAlert.setBounds(450, 410 ,350, 30);
        maritalStatusAlert.setForeground(Color.red);
        maritalStatusAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(maritalStatusAlert);
        
        socialStatusLabel = new JLabel("Social Status*");
        socialStatusLabel.setBounds(830, 360 ,350, 30);
        socialStatusLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(socialStatusLabel);
        
        String socialStatusArr[] = {"Select","EX-Serviceman","Kashmiri Migrant","Not Applicable"};
        socialStatus = new JComboBox(socialStatusArr);
        socialStatus.setBackground(Color.WHITE);
        socialStatus.setBounds(830, 390 ,350, 30);
        socialStatus.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(socialStatus);
        
        socialStatusAlert = new JLabel();
        socialStatusAlert.setBounds(830, 410 ,350, 30);
        socialStatusAlert.setForeground(Color.red);
        socialStatusAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(socialStatusAlert);
        
        emailLabel = new JLabel("Email address*");
        emailLabel.setBounds(50, 460 ,250, 30);
        emailLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(emailLabel);
        
        email = new JTextField();
        email.disable();
        //email.setBackground(new Color(223,223,223));
        email.setForeground(Color.BLACK);
        email.setBounds(50, 490 ,250, 30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        panel.add(email);
        
        alternateEmailLabel = new JLabel("Altenate Email address");
        alternateEmailLabel.setBounds(345, 460 ,250, 30);
        alternateEmailLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(alternateEmailLabel);
        
        alternateEmail = new JTextField();
        alternateEmail.setForeground(Color.BLACK);
        alternateEmail.setBounds(345, 490 ,250, 30);
        alternateEmail.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        panel.add(alternateEmail);
        
        mobileNumberLabel = new JLabel("Mobile Number*");
        mobileNumberLabel.setBounds(640, 460 ,250, 30);
        mobileNumberLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(mobileNumberLabel);
        
        mobileNumber = new JTextField();
        mobileNumber.setForeground(Color.BLACK);
        mobileNumber.disable();
        mobileNumber.setBounds(640, 490 ,250, 30);
        mobileNumber.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        panel.add(mobileNumber);
        
        try{
            String query = "SELECT FullName, Email, PhoneNumber FROM studentRegistration WHERE UserName = '"+UserName+"'";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            if(rs.next()){
                String mail = rs.getString("Email");
                email.setText(mail);
                String mNumber = rs.getString("PhoneNumber");
                mobileNumber.setText(mNumber);
                String name  = rs.getString("FullName");
                fullName.setText(name);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        alternateMobileNumberLabel = new JLabel("Alternate Mobile Number");
        alternateMobileNumberLabel.setBounds(935, 460 ,250, 30);
        alternateMobileNumberLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(alternateMobileNumberLabel);
        
        alternateMobileNumber = new JTextField();
        alternateMobileNumber.setForeground(Color.BLACK);
        alternateMobileNumber.setBounds(935, 490 ,250, 30);
        alternateMobileNumber.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        panel.add(alternateMobileNumber);

        otherDetailsPanel = new JPanel();
        otherDetailsPanel.setBounds(0,550, 1260, 35);
        otherDetailsPanel.setBackground(Color.GRAY);
        otherDetailsPanel.setLayout(null);
        panel.add(otherDetailsPanel);
        
        otherDetails = new JLabel("Other Details");
        otherDetails.setBounds(50, 3,300, 30);
        otherDetails.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        //otherDetails.setLocation(50,3);
        otherDetails.setForeground(Color.WHITE);
        otherDetailsPanel.add(otherDetails);
        
        
        disabilityLabel = new JLabel("Person With Disability applicable*");
        disabilityLabel.setBounds(50, 600 ,250, 30);
        disabilityLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(disabilityLabel);
        
        String disabilityArr[] = {"Select","No", "Yes"};
        disability = new JComboBox(disabilityArr);
        disability.addActionListener(this);
        disability.setBackground(Color.WHITE);
        disability.setBounds(50, 630 ,250, 30);
        disability.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(disability);
        
        disabilityAlert = new JLabel();
        disabilityAlert.setBounds(50, 660 ,250, 30);
        disabilityAlert.setForeground(Color.red);
        disabilityAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(disabilityAlert);
        
        disabilityCategoryLabel = new JLabel("Person With Disability applicable Category");
        disabilityCategoryLabel.setBounds(345, 600 ,300, 30);
        disabilityCategoryLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(disabilityCategoryLabel);
        
        
        String disabilityCategoryArr[] = {"Select","Speech and Hearing Impairement","Locomoter Impairements","Visual Impairements", "Reading Disability", "Any Other"};
        
        disabilityCategory = new JComboBox(disabilityCategoryArr);
        disabilityCategory.disable();    
        disabilityCategory.setBackground(Color.WHITE);
        disabilityCategory.addActionListener(this);
        disabilityCategory.setBounds(345, 630 ,300, 30);
        disabilityCategory.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(disabilityCategory);
        
        otherDisabilityLabel = new JLabel("Person With Disability applicable Other");
        otherDisabilityLabel.setBounds(670, 600 ,350, 30);
        otherDisabilityLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(otherDisabilityLabel);
        
        otherDisability = new JTextField();
        otherDisability.setForeground(Color.BLACK);
        otherDisability.disable();
        otherDisability.setBounds(670, 630 ,300, 30);
        otherDisability.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        panel.add(otherDisability);
        
        employementStatusLabel = new JLabel("Employement Status*");
        employementStatusLabel.setBounds(50, 680 ,300, 30);
        employementStatusLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(employementStatusLabel);
        
        String employementStatusArr[] = {"Select","Unemployed", "Employed", ""};
        employementStatus = new JComboBox(employementStatusArr);
        employementStatus.setBackground(Color.WHITE);
        employementStatus.setBounds(50, 710 ,250, 30);
        employementStatus.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(employementStatus);
        
        employementStatusAlert = new JLabel();
        employementStatusAlert.setBounds(50, 740 ,250, 30);
        employementStatusAlert.setForeground(Color.red);
        employementStatusAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(employementStatusAlert);
        
        scholarshipDetailsPanel = new JPanel();
        scholarshipDetailsPanel.setBounds(0,790, 1260, 35);
        scholarshipDetailsPanel.setBackground(Color.GRAY);
        scholarshipDetailsPanel.setLayout(null);
        panel.add(scholarshipDetailsPanel);
        
        scholarshipDetails = new JLabel("Scholarship Details");
        scholarshipDetails.setBounds(50, 3,300, 30);
        scholarshipDetails.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        //scholarshipDetails.setLocation(50,3);
        scholarshipDetails.setForeground(Color.WHITE);
        scholarshipDetailsPanel.add(scholarshipDetails);

        scholarshipAmountLabel = new JLabel("Scholarship Amount");
        scholarshipAmountLabel.setBounds(50, 840 ,250, 30);
        scholarshipAmountLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(scholarshipAmountLabel);
        
        scholarshipAmount = new JTextField();
        scholarshipAmount.setForeground(Color.BLACK);
        scholarshipAmount.setBounds(50, 870 ,250, 30);
        scholarshipAmount.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        panel.add(scholarshipAmount);
        
        scholarshipDepartmentLabel = new JLabel("Scholarship Department");
        scholarshipDepartmentLabel.setBounds(350, 840 ,250, 30);
        scholarshipDepartmentLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(scholarshipDepartmentLabel);
        
        String scholarshipDepartmentArr[] = {"Select","Govt. Deptt.","Other"};
        scholarshipDepartment = new JComboBox(scholarshipDepartmentArr);
        scholarshipDepartment.setBackground(Color.WHITE);
        scholarshipDepartment.setBounds(350, 870 ,250, 30);
        scholarshipDepartment.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(scholarshipDepartment);
        
        familyIncomeLabel = new JLabel("Family Income");
        familyIncomeLabel.setBounds(650, 840 ,250, 30);
        familyIncomeLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(familyIncomeLabel);
        
        familyIncome = new JTextField();
        familyIncome.setForeground(Color.BLACK);
        familyIncome.setBounds(650, 870 ,250, 30);
        familyIncome.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        panel.add(familyIncome);
        
        belowPovertyLineLabel = new JLabel("Below Poverty Line");
        belowPovertyLineLabel.setBounds(950, 840 ,250, 30);
        belowPovertyLineLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(belowPovertyLineLabel);
        
        String belowPovertyLineArr[] = {"Select","No","Yes"};
        belowPovertyLine = new JComboBox(belowPovertyLineArr);
        belowPovertyLine.setBackground(Color.WHITE);
        belowPovertyLine.setBounds(950, 870 ,250, 30);
        belowPovertyLine.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(belowPovertyLine);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(350,950,250,40);
        cancel.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        cancel.setBackground(new Color(113,177,249));
        cancel.setForeground(Color.WHITE);
        panel.add(cancel);
        
        saveNext = new JButton("Save & Next");
        saveNext.addActionListener(this);
        saveNext.setBounds(700,950,250,40);
        saveNext.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        saveNext.setBackground(new Color(113,177,249));
        saveNext.setForeground(Color.WHITE);
        panel.add(saveNext);
        
        setUndecorated(true);
        setVisible(true);
        setSize(1280,675); //675
        setLocation(0,0);
        //getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[]){
        new AdmissionPersonalDetails("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String _name = fullName.getText();
        String _motherName = motherName.getText();
        String _guardianrelation = (String) guardianRelation.getSelectedItem();
        String _guardianName = gaurdianName.getText();
        String _dateOfBirth = ((JTextField) dateOfBirth.getDateEditor().getUiComponent()).getText();
        String _category = (String) category.getSelectedItem();
        String _gender = "";
        if(male.isSelected()){
            _gender = "Male";
        }
        else if(female.isSelected()){
            _gender = "Female";
        }
        else if(transGender.isSelected()){
            _gender ="Transgender";
        }
        String _citizenship = (String) citizenship.getSelectedItem();
        String _territoryArea = (String) territoryArea.getSelectedItem();
        String _minority = (String) minority.getSelectedItem();
        String _religion = (String) religion.getSelectedItem();
        String _maritalStatus = (String) maritalStatus.getSelectedItem();
        String _socialStatus = (String) socialStatus.getSelectedItem();
        String _email = email.getText();
        String _alternateEmail = alternateEmail.getText();
        String _mobileNumber = mobileNumber.getText();
        String _alternateMobileNumber = alternateMobileNumber.getText();
        String _disability = (String)disability.getSelectedItem();
        String _disabilityCategory = (String) disabilityCategory.getSelectedItem();
        String _otherDisability = otherDisability.getText();
        String _employmentStatus = (String) employementStatus.getSelectedItem();
        String _scholarshipAmount = scholarshipAmount.getText();
        String _scholarshipDepartment = (String) scholarshipDepartment.getSelectedItem();
        String _familyIncome = familyIncome.getText();
        String _belowPovertyLine = (String) belowPovertyLine.getSelectedItem();
        
        if(e.getSource() == disability){
            if(_disability.equalsIgnoreCase("Yes")){
            disabilityCategory.enable();
            }
            else {
            disabilityCategory.disable();
            _disabilityCategory = "Select";
            }
        }
        
        if(e.getSource() == disabilityCategory){
            if(_disabilityCategory.equalsIgnoreCase("Any Other")){
            otherDisability.enable();
            }
            else {
            otherDisability.disable();
            _otherDisability = "";
            }
        }
        if(e.getSource() == saveNext){
            if(_name.equals("")||_motherName.equals("")||_guardianrelation.equalsIgnoreCase("Select")||_guardianName.equals("")||_dateOfBirth.equals("")||_category.equalsIgnoreCase("Select")||_gender.equals("")||_citizenship.equalsIgnoreCase("Select")||_territoryArea.equalsIgnoreCase("Select")||_minority.equalsIgnoreCase("Select")||_religion.equalsIgnoreCase("Select")||_maritalStatus.equalsIgnoreCase("Select")||_socialStatus.equalsIgnoreCase("Select")||_disability.equalsIgnoreCase("Select")||_employmentStatus.equalsIgnoreCase("Select")){ 
                if(_name.equals("")){
                    fullNameAlert.setText("Name cannot be blank");
                }
                if(_motherName.equals("")){
                    motherNameAlert.setText("Mother Name cannot be blank");
                }
                if(_guardianrelation.equalsIgnoreCase("Select")){
                    guardianRelationAlert.setText("Guardian Name Type cannot be blank");
                }
                if(_guardianName.equals("")){
                    gaurdianNameAlert.setText("Guardian Name cannot be blank");
                }
                if(_dateOfBirth.equals("")){
                    dateOfBirthAlert.setText("Date of Birth cannot be blank");
                }
                if(_category.equalsIgnoreCase("Select")){
                    categoryAlert.setText("Category cannot be blank");
                }
                if(_gender.equals("")){
                    genderAlert.setText("Gender cannot be blank");
                }
                if(_citizenship.equalsIgnoreCase("Select")){
                    citizenshipAlert.setText("Citizenship Country name cannot be blank");
                }
                if(_territoryArea.equalsIgnoreCase("Select")){
                    territoryAlert.setText("Territory cannot be blank");
                }
                if(_minority.equalsIgnoreCase("Select")){
                    minorityAlert.setText("Minority cannot be blank");
                }
                if(_religion.equalsIgnoreCase("Select")){
                    religionAlert.setText("Religion cannot be blank");
                }
                if(_maritalStatus.equalsIgnoreCase("Select")){
                    maritalStatusAlert.setText("Marital Status cannot be blank");
                }
                if(_socialStatus.equalsIgnoreCase("Select")){
                    socialStatusAlert.setText("Social Status cannot be blank");
                }
                if(_disability.equalsIgnoreCase("Select")){
                    disabilityAlert.setText("Person With Disability applicable cannot be blank");
                }
                if(_employmentStatus.equalsIgnoreCase("Select")){
                    employementStatusAlert.setText("Employement Status cannot be blank");
                } 
                panel.setLocation(0,100);
            }
            else{
                try{
                    JDBCConnection con = new JDBCConnection();
                    String query ="INSERT INTO admissionpersonaldetails (UserName, FullName, MotherName, GuardianRelation, GuardianName, DateOfBirth, Category, Gender, Citizenship, Territory, Minority, Religion, MaritalStatus, SocialStatus, Email, alternateEmail, MobileNumber, alternateMobileNumber, Disability, DisabilityCategory, otherDisability, EmployementStatus, scholarshipAmount, scholarshipDepartment, familyIncome, belowPovertyLine) VALUES ('"+UserName+"','"+_name+"', '"+_motherName+"', '"+_guardianrelation+"','"+_guardianName+"','"+_dateOfBirth+"','"+_category+"','"+_gender+"','"+_citizenship+"','"+_territoryArea+"','"+_minority+"','"+_religion+"','"+_maritalStatus+"','"+_socialStatus+"', '"+_email+"','"+_alternateEmail+"', '"+_mobileNumber+"','"+_alternateMobileNumber+"','"+_disability+"','"+_disabilityCategory+"','"+_otherDisability+"','"+_employmentStatus+"','"+_scholarshipAmount+"','"+_scholarshipDepartment+"','"+_familyIncome+"','"+_belowPovertyLine+"')";
                    con.stmt.executeUpdate(query);
                    setVisible(false);
                    new AdmissionProgrammeDetails(UserName).setVisible(true);
                }
                catch(Exception f){System.out.println(f);}
            }
        } 
        else if(e.getSource() == signout){
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Logout Successfully...");
            new AdmissionPortal().setVisible(true);
        }
        else if(e.getSource() == cancel){
         setVisible(false);
         new AdmissionPortal().setVisible(true);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
