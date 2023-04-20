package universitymanagementsystem.adminportal;

import universitymanagementsystem.home.JDBCConnection;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;

/*
 * @author Manish Kumar
 */
public class AdminPortal extends JFrame implements ActionListener {

    JPanel panelHeading, menuPanel, programmeMenu,programmePanel,addProgrammePanel,addCoursePanel, coursePanel,courseMenu,regionPanel,regionMenu;
    JLabel close, headingLabel, dashboard, programme, course, user, region;
    JButton signout,addProgrammeButton, saveProgrammeButton, addCourseButton,saveCourseButton;
    JLabel addProgrammeLabel,programmeTypeLabel,programmeDashboard,modeOfStudyLabel,programmeNameLabel,programmeCodeLabel,programmeDurationLabel,programmeDurationMinLabel,programmeDurationMaxLabel,programmeEligibiltyLabel,programmeFeesLabel,programmeMediumLabel;
    JTextField programmeName, programmeCode, programmeDurationMin,programmeDurationMax, programmeEligibilty, programmeFees;
    JCheckBox modeOfStudy1,modeOfStudy2,modeOfStudy3;
    JLabel courseDashboard;
    JLabel addCourseLabel, programmeCodeLabel2,courseCodeLabel,courseNameLabel,courseSemesterLabel,courseCreditsLabel;
    JComboBox programmeType,programmeMedium, programmeCode2,courseSemester,courseCredits;
    JTextField courseCode,courseName;
    
    
    
    AdminPortal() {

        setLayout(null);

        panelHeading = new JPanel();
        panelHeading.setBounds(0, 0, 1280, 100);
        panelHeading.setBackground(new Color(55, 159, 249));
        panelHeading.setSize(1280, 100);
        panelHeading.setLayout(null);
        add(panelHeading);

        headingLabel = new JLabel("Admin Portal");
        headingLabel.setBounds(100, 30, 300, 40);
        headingLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        headingLabel.setLocation(100, 30);
        headingLabel.setForeground(Color.WHITE);
        panelHeading.add(headingLabel);

        signout = new JButton("Sign out");
        signout.setBounds(1190, 70, 100, 30);
        signout.addActionListener(this);
        signout.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        signout.setLocation(1190, 70);
        signout.setForeground(Color.WHITE);
        signout.setBackground(new Color(55, 159, 249));
        panelHeading.add(signout);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/closeButton.png"));
        Image img2 = img.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);

        close = new JLabel(img3);
        close.setBounds(1230, 10, 40, 30);
        panelHeading.add(close);
        close.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                setVisible(false);
                System.exit(0);
            }
        });

//        panel = new JPanel();
//        panel.setBounds(400,100, 400, 600); //575
//        panel.setBackground(new Color(228,231,233));
//        panel.setLayout(null);
//        add(panel);
        menuPanel = new JPanel();
        menuPanel.setBounds(0, 110, 200, 560);
        menuPanel.setBackground(new Color(250, 178, 70));
        menuPanel.setLayout(null);
        add(menuPanel);

        dashboard = new JLabel("Dashboard");
        dashboard.setBounds(10, 10, 200, 30);
        dashboard.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        dashboard.setForeground(Color.white);
        menuPanel.add(dashboard);
        dashboard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

            }
        });

       /*******************Start Programme*******************************/ 
        programmePanel = new JPanel();
        programmePanel.setVisible(false);
        programmePanel.setBounds(210, 110, 1060, 560);
        programmePanel.setBackground(new Color(228, 231, 233));
        programmePanel.setLayout(null);
        add(programmePanel);
        
        programmeDashboard = new JLabel("Programme Dashboard");
        programmeDashboard.setBounds(100, 20, 350, 40);
        programmeDashboard.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        programmePanel.add(programmeDashboard);
        
        addProgrammeButton = new JButton("Add Programme");
        addProgrammeButton.setBounds(750, 20, 200, 40);
        addProgrammeButton.addActionListener(this);
        addProgrammeButton.setBackground(new Color(113,177,249));
        addProgrammeButton.setForeground(Color.WHITE);
        addProgrammeButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        programmePanel.add(addProgrammeButton);
        
       
        addProgrammePanel = new JPanel();
        addProgrammePanel.setVisible(false);
        addProgrammePanel.setBackground(new Color(228, 231, 233));
        addProgrammePanel.setBounds(210, 110, 1060, 560);           
        addProgrammePanel.setLayout(null);
        add(addProgrammePanel);
        
        programmeMenu = new JPanel();
        programmeMenu.setBounds(5, 70, 190, 40);
        programmeMenu.setBackground(new Color(175, 117, 30));
        programmeMenu.setLayout(null);
        menuPanel.add(programmeMenu);
        
        programme = new JLabel("Programme");
        programme.setBounds(20, 5, 200, 30);
        programme.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        programme.setForeground(Color.white);
        programmeMenu.add(programme);
        programmeMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {  
               programmePanel.setVisible(true);            
            }
        });

        addProgrammeLabel = new JLabel("Add Programme");
        addProgrammeLabel.setBounds(100, 20, 300, 40);
        addProgrammeLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        addProgrammePanel.add(addProgrammeLabel);
        
        programmeTypeLabel = new JLabel("Programme Type");
        programmeTypeLabel.setBounds(100, 120, 200, 30);
        programmeTypeLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeTypeLabel);

        String programmeTypeArr[] = {"Select","Bachelor","Master","Doctoral","M.Phil Programme","Diploma","PG Diploma","Certificate"};
        programmeType = new JComboBox(programmeTypeArr);
        programmeType.setBounds(350, 120, 150, 30);
        programmeType.setBackground(Color.WHITE);
        programmeType.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(programmeType);
        
        modeOfStudyLabel = new JLabel("Mode Of Study"); 
        modeOfStudyLabel.setBounds(100, 170, 200, 30);
        modeOfStudyLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(modeOfStudyLabel);

        modeOfStudy1 = new JCheckBox("Online");
        modeOfStudy1.setBounds(350, 170, 150, 30);
        modeOfStudy1.setBackground(new Color(228, 231, 233));
        modeOfStudy1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(modeOfStudy1);
        
        modeOfStudy2 = new JCheckBox("Distance");
        modeOfStudy2.setBackground(new Color(228, 231, 233));
        modeOfStudy2.setBounds(500, 170, 150, 30);
        modeOfStudy2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(modeOfStudy2);
        
        modeOfStudy3 = new JCheckBox("Regular");
        modeOfStudy3.setBounds(650, 170, 150, 30);
        modeOfStudy3.setBackground(new Color(228, 231, 233));
        modeOfStudy3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(modeOfStudy3);
        
        programmeNameLabel = new JLabel("Programme Name");
        programmeNameLabel.setBounds(100, 220, 200, 30);
        programmeNameLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeNameLabel);

        programmeName = new JTextField();
        programmeName.setBounds(350, 220, 450, 30);
        programmeName.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(programmeName);
        
        programmeCodeLabel = new JLabel("Programme Code");
        programmeCodeLabel.setBounds(100, 270, 200, 30);
        programmeCodeLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeCodeLabel);

        programmeCode = new JTextField();
        programmeCode.setBounds(350, 270, 450, 30);
        programmeCode.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(programmeCode);
        
        programmeDurationLabel = new JLabel("Programme Duration");
        programmeDurationLabel.setBounds(100, 320, 200, 30);
        programmeDurationLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeDurationLabel);

        programmeDurationMinLabel = new JLabel("Minimun");
        programmeDurationMinLabel.setBounds(350, 320, 90, 30);
        programmeDurationMinLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeDurationMinLabel);
        
        programmeDurationMin = new JTextField();
        programmeDurationMin.setBounds(440, 320, 100, 30);
        programmeDurationMin.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(programmeDurationMin);
        
        programmeDurationMaxLabel = new JLabel("Maximum");
        programmeDurationMaxLabel.setBounds(600, 320, 100, 30);
        programmeDurationMaxLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeDurationMaxLabel);
        
        programmeDurationMax = new JTextField();
        programmeDurationMax.setBounds(700, 320, 100, 30);
        programmeDurationMax.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(programmeDurationMax);
        
        programmeEligibiltyLabel = new JLabel("Programme Eligibilty");
        programmeEligibiltyLabel.setBounds(100, 370, 200, 30);
        programmeEligibiltyLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeEligibiltyLabel);

        programmeEligibilty = new JTextField();
        programmeEligibilty.setBounds(350, 370, 450, 30);
        programmeEligibilty.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(programmeEligibilty);
        
        programmeFeesLabel = new JLabel("Programme Fees");
        programmeFeesLabel.setBounds(100, 420, 200, 30);
        programmeFeesLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeFeesLabel);

        programmeFees = new JTextField();
        programmeFees.setBounds(350, 420, 450, 30);
        programmeFees.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(programmeFees);
        
        programmeMediumLabel = new JLabel("Programme Medium");
        programmeMediumLabel.setBounds(100, 470, 200, 30);
        programmeMediumLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addProgrammePanel.add(programmeMediumLabel);

        String programmeMediumArr[] ={"Select","Hindi","English"}; 
        programmeMedium = new JComboBox(programmeMediumArr);
        programmeMedium.setBackground(Color.WHITE);
        programmeMedium.setBounds(350, 470, 450, 30);
        programmeMedium.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(programmeMedium);
        
        saveProgrammeButton = new JButton("Save Programme");
        saveProgrammeButton.addActionListener(this);
        saveProgrammeButton.setBounds(700, 520, 200, 40);
        saveProgrammeButton.setBackground(new Color(113,177,249));
        saveProgrammeButton.setForeground(Color.WHITE);
        saveProgrammeButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addProgrammePanel.add(saveProgrammeButton);
        
        
        /***********************End Programme*********************************/
        
        /****************Start Course Dashboard *****************************/
        
        coursePanel = new JPanel();
        coursePanel.setVisible(false);
        coursePanel.setBounds(210, 110, 1060, 560);
        coursePanel.setBackground(new Color(228, 231, 233));
        coursePanel.setLayout(null);
        add(coursePanel);
        
        courseDashboard = new JLabel("Course Dashboard");
        courseDashboard.setBounds(100, 20, 350, 40);
        courseDashboard.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        coursePanel.add(courseDashboard);
        
        addCourseButton = new JButton("Add Course");
        addCourseButton.setBounds(750, 20, 200, 40);
        addCourseButton.addActionListener(this);
        addCourseButton.setBackground(new Color(113,177,249));
        addCourseButton.setForeground(Color.WHITE);
        addCourseButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        coursePanel.add(addCourseButton);
        
        addCoursePanel = new JPanel();
        addCoursePanel.setVisible(false);
        addCoursePanel.setBackground(new Color(228, 231, 233));
        addCoursePanel.setBounds(210, 110, 1060, 560);           
        addCoursePanel.setLayout(null);
        add(addCoursePanel);

        courseMenu = new JPanel();
        courseMenu.setLayout(null);
        courseMenu.setBounds(5, 120, 190, 40);
        courseMenu.setBackground(new Color(175, 117, 30));
        menuPanel.add(courseMenu);
        
        course = new JLabel("Course");
        course.setBounds(20, 5, 200, 30);
        course.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        course.setForeground(Color.white);
        courseMenu.add(course);
        courseMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            coursePanel.setVisible(true);

            }
        });
        
        addCourseLabel = new JLabel("Add Course");
        addCourseLabel.setBounds(100, 20, 300, 40);
        addCourseLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        addCoursePanel.add(addCourseLabel);
        
        programmeCodeLabel2 = new JLabel("Programme Code");
        programmeCodeLabel2.setBounds(100, 120, 200, 30);
        programmeCodeLabel2.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addCoursePanel.add(programmeCodeLabel2);

        programmeCode2 = new JComboBox();
        programmeCode2.setBounds(350, 120, 400, 30);
        programmeCode2.setBackground(Color.WHITE);
        programmeCode2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addCoursePanel.add(programmeCode2);
        
        programmeCodeLabel2 = new JLabel("Programme Code");
        programmeCodeLabel2.setBounds(100, 120, 200, 30);
        programmeCodeLabel2.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addCoursePanel.add(programmeCodeLabel2);

        programmeCode2 = new JComboBox();
        programmeCode2.setBounds(350, 120, 400, 30);
        programmeCode2.setBackground(Color.WHITE);
        programmeCode2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addCoursePanel.add(programmeCode2);
        
        courseCodeLabel = new JLabel("Course Code");
        courseCodeLabel.setBounds(100, 170, 200, 30);
        courseCodeLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addCoursePanel.add(courseCodeLabel);

        courseCode = new JTextField();
        courseCode.setBounds(350, 170, 400, 30);
        courseCode.setBackground(Color.WHITE);
        courseCode.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addCoursePanel.add(courseCode);
        
        courseNameLabel = new JLabel("Course Name");
        courseNameLabel.setBounds(100, 220, 200, 30);
        courseNameLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addCoursePanel.add(courseNameLabel);

        courseName = new JTextField();
        courseName.setBounds(350, 220, 400, 30);
        courseName.setBackground(Color.WHITE);
        courseName.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addCoursePanel.add(courseName);
        
        courseSemesterLabel = new JLabel("Course Semester");
        courseSemesterLabel.setBounds(100, 270, 200, 30);
        courseSemesterLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addCoursePanel.add(courseSemesterLabel);

        String courseSemesterArr[]={"Select","1","2","3","4","5","6"};
        courseSemester = new JComboBox(courseSemesterArr);
        courseSemester.setBounds(350, 270, 400, 30);
        courseSemester.setBackground(Color.WHITE);
        courseSemester.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addCoursePanel.add(courseSemester);
        
        courseCreditsLabel = new JLabel("Course Credits");
        courseCreditsLabel.setBounds(100, 320, 200, 30);
        courseCreditsLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        addCoursePanel.add(courseCreditsLabel);

        String courseCreditsArr[]={"Select","1","2","3","4","5","6","7","8","9","10"};
        courseCredits = new JComboBox(courseCreditsArr);
        courseCredits.setBounds(350, 320, 400, 30);
        courseCredits.setBackground(Color.WHITE);
        courseCredits.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addCoursePanel.add(courseCredits);
        
        saveCourseButton = new JButton("Save Course");
        saveCourseButton.setBounds(700, 500, 200, 40);
        saveCourseButton.addActionListener(this);
        saveCourseButton.setBackground(new Color(113,177,249));
        saveCourseButton.setForeground(Color.WHITE);
        saveCourseButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        addCoursePanel.add(saveCourseButton);
        
        /******************End Course Dashboard *****************/
        
        
        
        regionPanel = new JPanel();
        regionPanel.setVisible(false);
        regionPanel.setBounds(210, 110, 1060, 560);
        regionPanel.setBackground(new Color(228, 231, 233));
        add(regionPanel);

        regionMenu = new JPanel();
        regionMenu.setLayout(null);
        regionMenu.setBounds(5, 170, 190, 40);
        regionMenu.setBackground(new Color(175, 117, 30));
        menuPanel.add(regionMenu);
        
        region = new JLabel("Region");
        region.setBounds(20, 5, 200, 30);
        region.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        region.setForeground(Color.white);
        regionMenu.add(region);
        regionMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
              regionPanel.setVisible(true);  
                
            }
        });

        setUndecorated(true);
        setVisible(true);
        setSize(1280, 675); //675
        setLocation(0, 0);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String args[]) {
        new AdminPortal();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String _programmeType = (String)programmeType.getSelectedItem();
        boolean _online = false;
        if(modeOfStudy1.isSelected()){
            _online = true;
            System.out.println(_online);
        }
        boolean _distance = false;
        if(modeOfStudy2.isSelected()){
            _distance = true;
            System.out.println(_distance);
        }
        boolean _regular = false;
        if(modeOfStudy3.isSelected()){
            _regular = true;
            System.out.println(_regular);
        }
        String _programmeName = programmeName.getText();
        String _programmeCode = programmeCode.getText();
        String _programmeDurationMin  = programmeDurationMin.getText();
        String _programmeDurationMax = programmeDurationMax.getText();
        String _programmeEligibilty = programmeEligibilty.getText();
        String _programmeFees = programmeFees.getText();
        String _programmeMedium = (String)programmeMedium.getSelectedItem();
        
        String _programmeCode2 = (String)programmeCode2.getSelectedItem();
        String _courseCode = courseCode.getText();
        String _courseName = courseName.getText();
        String _courseSemester = (String)courseSemester.getSelectedItem();
        String _courseCredits = (String)courseCredits.getSelectedItem();
        
        if(ae.getSource() == saveProgrammeButton){
            String query1 = "INSERT INTO programme(programmeType,online,distance,regular,programmeName,programmeCode,programmeDurationMin,programmeDurationMax,programmeEligibility,programmeFees,medium) values('"+_programmeType+"','"+_online+"','"+_distance+"','"+_regular+"','"+_programmeName+"','"+_programmeCode+"','"+_programmeDurationMin+"','"+_programmeDurationMax+"','"+_programmeEligibilty+"','"+_programmeFees+"','"+_programmeMedium+"');";
            try{
                JDBCConnection con = new JDBCConnection();
                con.stmt.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Programme Saved successfully");
            }
            catch(Exception e){System.out.println(e);}
            addProgrammePanel.setVisible(false);
            programmePanel.setVisible(true);
        }
        if(ae.getSource() == saveCourseButton){
            String query2 = "INSERT INTO Course(Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('"+_programmeCode2+"','"+_courseCode+"','"+_courseName+"','"+_courseCredits+"','"+_courseSemester+"',);";
            try{
                JDBCConnection con =  new JDBCConnection();
                con.stmt.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Course Saved successfully");   
            }
            catch(Exception e){System.out.println(e);}
            addCoursePanel.setVisible(false);
            coursePanel.setVisible(true);
        }
        if(ae.getSource() == addProgrammeButton){
            programmePanel.setVisible(false);
            addProgrammePanel.setVisible(true);
        }
        else if(ae.getSource() == addCourseButton){
            coursePanel.setVisible(false);
            addCoursePanel.setVisible(true);
        }
        try {
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
