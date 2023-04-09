package universitymanagementsystem.home;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.toedter.calendar.*;
import universitymanagementsystem.counselorportal.*;
/**
 *
 * @author Manish Kumar
 */
public class Home extends JFrame implements ActionListener{
    JMenu home,portal, aboutUniversity,registerOnline,studentSupport,other;
    JMenuItem counselPortal,adminPortal, aluminiPortal;
    JMenuItem aboutUs, profile, schoolOfStudies, divisions, gallery;
    JMenuItem admission, reRegistration, termEndExam, reEvaluation, entranceExam, convocation;
    JMenuItem studentZone, studentGrievances, downloads, results;
    
    
    JPanel bannerPanel,loginPanel,panel1, panel2, panel3,panel4,panel5,panel6;
    JLabel bannerLabel,enrollmentLabel, programmeLabel,dateOfBirthLabel;
    JTextField enrollment;
    JDateChooser dateOfBirth; //import com.toedter.calendar.*;
    JComboBox programme;
    JButton login,clear;

    
    Home(){
        
        
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(113,177,249));
        
        home = new JMenu("Home");
        home.setForeground(Color.WHITE);
        home.setFont(new Font("SAN_SERIF",Font.BOLD,25));

        
        portal = new JMenu("Portal");
        portal.setForeground(Color.WHITE);
        portal.setFont(new Font("SAN_SERIF",Font.BOLD,15));

        counselPortal = new JMenuItem("Counselor Portal");
        portal.add(counselPortal);
        
        adminPortal = new JMenuItem("Admin Portal");
        portal.add(adminPortal);
        
        aluminiPortal = new JMenuItem("Alumni Portal");
        portal.add(aluminiPortal);

                
        aboutUniversity = new JMenu("About University");
        aboutUniversity.setForeground(Color.WHITE);
        aboutUniversity.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        
        aboutUs = new JMenuItem("About Us");
        aboutUniversity.add(aboutUs);
        
        profile = new JMenuItem("Profile");
        aboutUniversity.add(profile);
        
        schoolOfStudies = new JMenuItem("School Of Studies");
        aboutUniversity.add(schoolOfStudies);
        
        divisions = new JMenuItem("Divisions");
        aboutUniversity.add(divisions);
        
        gallery = new JMenuItem("Gallery");
        aboutUniversity.add(gallery);
        
        registerOnline = new JMenu("Register Online");
        registerOnline.setForeground(Color.WHITE);
        registerOnline.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        
        admission = new JMenuItem("Fresh Admission");
        admission.addActionListener(this);
        registerOnline.add(admission);
        
        reRegistration = new JMenuItem("Re-Registration");
        registerOnline.add(reRegistration);
        
        termEndExam = new JMenuItem("Term End Exam");
        registerOnline.add(termEndExam);
        
        reEvaluation = new JMenuItem("Re-Evaluation");
        registerOnline.add(reEvaluation);
        
        entranceExam = new JMenuItem("Entrance Exam");
        registerOnline.add(entranceExam);
        
        convocation = new JMenuItem("Convocation");
        registerOnline.add(convocation);
        
        studentSupport = new JMenu("Student Support");
        studentSupport.setForeground(Color.WHITE);
        studentSupport.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        
        studentZone = new JMenuItem("Student Zone");
        studentSupport.add(studentZone);
        
        studentGrievances = new JMenuItem("Student Grievances");
        studentSupport.add(studentGrievances);
        
        downloads = new JMenuItem("Downloads");
        studentSupport.add(downloads);
                
        results = new JMenuItem("Results");
        studentSupport.add(results);
        
        
        other = new JMenu("Other");
        other.setForeground(Color.WHITE);
        other.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        
        menuBar.add(home);
        menuBar.add(portal);
        menuBar.add(aboutUniversity);
        menuBar.add(registerOnline);
        menuBar.add(studentSupport);
        menuBar.add(other);
        
        setJMenuBar(menuBar);
        
       
        bannerPanel = new JPanel();
        bannerPanel.setBounds(5, 5, 850, 400);
        //bannerPanel.setBackground(Color.GRAY);
        bannerPanel.setLocation(5,5);
        bannerPanel.setLayout(null);
        add(bannerPanel);
        
        ImageIcon bannerImg = new ImageIcon(ClassLoader.getSystemResource("icon/first.jpg"));
        Image bannerImg2 = bannerImg.getImage().getScaledInstance(850, 390, Image.SCALE_DEFAULT);
        ImageIcon bannerImg3 = new ImageIcon(bannerImg2);
        
        bannerLabel = new JLabel(bannerImg3);
        bannerLabel.setBounds(5, 5, 840, 390);
        bannerPanel.add(bannerLabel);
        
        ImageIcon starImg = new ImageIcon(ClassLoader.getSystemResource("icon/star.png"));
        Image starImg2 = starImg.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon starImg3 = new ImageIcon(starImg2);
   
        JLabel star1 = new JLabel(starImg3);
        star1.setBounds(5, 20, 50, 50);
        
        JLabel star2 = new JLabel(starImg3);
        star2.setBounds(5, 20, 50, 50);
        
        JLabel star3 = new JLabel(starImg3);
        star3.setBounds(5, 20, 50, 50);
        
        JLabel star4 = new JLabel(starImg3);
        star4.setBounds(5, 20, 50, 50);
        
        JLabel star5 = new JLabel(starImg3);
        star5.setBounds(5, 20, 50, 50);
        
        JLabel star6 = new JLabel(starImg3);
        star6.setBounds(5, 20, 50, 50);
        
        panel1 = new JPanel();
        panel1.setBounds(5,410, 418, 100);
        panel1.setBackground(Color.WHITE);
        panel1.setLocation(5,410);
        panel1.setLayout(null);
        add(panel1);
        panel1.add(star1);
        JLabel text1 = new JLabel("Flexible Admission Rules");
        text1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text1.setBounds(65,20,350,50);
        panel1.add(text1);
        
        panel2 = new JPanel();
        panel2.setBounds(429,410, 417, 100);
        panel2.setBackground(Color.WHITE);
        panel2.setLocation(429,410);
        panel2.setLayout(null);
        add(panel2);  
        panel2.add(star2);
        JLabel text2 = new JLabel("Individualised Study Flexibility in");
        text2.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text2.setBounds(65,5,350,50);
        panel2.add(text2);
        JLabel text3 = new JLabel("Terms of Place, Pace & Duration");
        text3.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text3.setBounds(65,35,350,50);
        panel2.add(text3);
        
        panel3 = new JPanel();
        panel3.setBounds(851,410, 417, 100);
        panel3.setBackground(Color.WHITE);
        panel3.setLocation(851,410);
        panel3.setLayout(null);
        add(panel3);
        panel3.add(star3);
        JLabel text4 = new JLabel("Nationwide Student Support");
        text4.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text4.setBounds(65,5,350,50);
        panel3.add(text4);
        JLabel text5 = new JLabel("Services Network");
        text5.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text5.setBounds(65,35,350,50);
        panel3.add(text5);
        
        
        panel4 = new JPanel();
        panel4.setBounds(5,515, 418, 100);
        panel4.setBackground(Color.WHITE);
        panel4.setLocation(5,515);
        panel4.setLayout(null);
        add(panel4);
        panel4.add(star4);
        JLabel text6 = new JLabel("Cost Effective Programmes");
        text6.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text6.setBounds(65,20,350,50);
        panel4.add(text6);
        
        panel5 = new JPanel();
        panel5.setBounds(429,515, 417, 100);
        panel5.setBackground(Color.WHITE);
        panel5.setLocation(429,515);
        panel5.setLayout(null);
        add(panel5);
        panel5.add(star5);
        JLabel text7 = new JLabel("Resource Sharing, Collaboration &");
        text7.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text7.setBounds(65,5,350,50);
        panel5.add(text7);
        JLabel text8 = new JLabel("Networking with other Universities");
        text8.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text8.setBounds(65,35,350,50);
        panel5.add(text8);
        
        panel6 = new JPanel();
        panel6.setBounds(851,515, 417, 100);
        panel6.setBackground(Color.WHITE);
        panel6.setLocation(851,515);
        panel6.setLayout(null);
        add(panel6);
        panel6.add(star6);
        JLabel text9 = new JLabel("Programmes Based on Students");
        text9.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text9.setBounds(65,5,350,50);
        panel6.add(text9);
        JLabel text10 = new JLabel("Need Analysis");
        text10.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text10.setBounds(65,35,350,50);
        panel6.add(text10);
        
        loginPanel = new JPanel();
        loginPanel.setBounds(860, 5, 410, 400);
        //loginPanel.setBackground(Color.GRAY);
        loginPanel.setLocation(860,5);
        loginPanel.setLayout(null);
        add(loginPanel);
        
        programmeLabel = new JLabel("Student Login");
        programmeLabel.setBounds(80, 20, 300, 40);
        programmeLabel.setFont(new Font("SAN_SERIF",Font.BOLD,30));
        loginPanel.add(programmeLabel);
        
        enrollmentLabel = new JLabel("Enrollment Number:");
        enrollmentLabel.setBounds(10, 100, 180, 40);
        enrollmentLabel.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        //enrollmentLabel.setBackground(Color.GRAY);
        //enrollmentLabel.setForeground(Color.WHITE);
        loginPanel.add(enrollmentLabel);
        
        enrollment = new JTextField();
        enrollment.setBounds(190, 100, 200, 40);
        enrollment.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        loginPanel.add(enrollment);
        
        programmeLabel = new JLabel("Programme:");
        programmeLabel.setBounds(10, 150, 180, 40);
        programmeLabel.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        loginPanel.add(programmeLabel);
               
        String programmeArr[]={"Select Programme","BCA","B.Tech","MCA","M.Tech"};
        programme = new JComboBox(programmeArr);
        programme.setBounds(190, 150, 200, 40);
        programme.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        loginPanel.add(programme);
        
        dateOfBirthLabel = new JLabel("Date Of Birth:");
        dateOfBirthLabel.setBounds(10, 200, 180, 40);
        dateOfBirthLabel.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        loginPanel.add(dateOfBirthLabel);
        
        dateOfBirth = new JDateChooser();
        dateOfBirth.setBounds(190, 200, 200, 40);
        dateOfBirth.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        loginPanel.add(dateOfBirth);
        
        login = new JButton("Login");
        login.addActionListener(this);
        login.setBounds(50, 300, 150, 40);
        login.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        login.setBackground(new Color(113,177,249));
        login.setForeground(Color.WHITE);
        loginPanel.add(login);
        
        clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setBounds(210, 300, 150, 40);
        clear.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        clear.setBackground(new Color(113,177,249));
        clear.setForeground(Color.WHITE);
        loginPanel.add(clear);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1300,700);
        setLayout(null);
        setVisible(true);
        setLocation(0,0);
        
    }
    
    
    
    public static void main(String args[]){
        new Home();
    }

    private void setMenuBar(JMenuBar menuBar) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            if(ae.getSource() == admission){
              //new CounselorLogin().setVisible(true);
              
            }
            
        }
        catch(Exception e){System.out.println(e);}
    }
    
}
