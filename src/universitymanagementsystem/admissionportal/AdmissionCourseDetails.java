package universitymanagementsystem.admissionportal;

import javax.swing.*;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import universitymanagementsystem.home.JDBCConnection;
/*
 * @author Manish Kumar
 */
public class AdmissionCourseDetails extends JFrame implements ActionListener {
    JPanel panel, panelHeading,courseDetailsPanel,courseTitlePanel,course1Panel,course2Panel,course3Panel,course4Panel,course5Panel,course6Panel,course7Panel,course8Panel,course9Panel,course10Panel;
    JLabel close,headingLabel,courseDetails;
    JLabel courseCodeTitle, courseCode1, courseCode2, courseCode3, courseCode4, courseCode5, courseCode6, courseCode7, courseCode8, courseCode9, courseCode10;
    JLabel courseNameTitle, courseName1,courseName2,courseName3,courseName4,courseName5,courseName6,courseName7,courseName8,courseName9,courseName10;
    JLabel creditTitle, credit1, credit2,credit3, credit4, credit5, credit6, credit7, credit8, credit9, credit10;
    JButton signout,back, saveNext ;
    String UserName,Programme;
    AdmissionCourseDetails(String UserName,String Programme){
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
        panel.setBounds(0,100, 1300, 600); //575
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
         
        courseDetailsPanel = new JPanel();
        courseDetailsPanel.setBounds(0,3, 1300, 35);
        courseDetailsPanel.setBackground(Color.GRAY);
        courseDetailsPanel.setLayout(null);
        panel.add(courseDetailsPanel);
        
        
        courseDetails = new JLabel("Course Details");
        courseDetails.setBounds(50, 3,300, 30);
        courseDetails.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        courseDetails.setForeground(Color.WHITE);
        courseDetailsPanel.add(courseDetails);
        
        courseTitlePanel = new JPanel();
        courseTitlePanel.setBounds(100,100, 1000, 35);
        courseTitlePanel.setBackground(Color.GRAY);
        courseTitlePanel.setLayout(null);
        panel.add(courseTitlePanel);
        
        courseCodeTitle = new JLabel("Course Code");
        courseCodeTitle.setBounds(100, 3,100, 30);
        courseCodeTitle.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        courseCodeTitle.setForeground(Color.WHITE);
        courseTitlePanel.add(courseCodeTitle);
        
        courseNameTitle = new JLabel("Course Name");
        courseNameTitle.setBounds(300, 3,150, 30);
        courseNameTitle.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        courseNameTitle.setForeground(Color.WHITE);
        courseTitlePanel.add(courseNameTitle);
        
        creditTitle = new JLabel("Credit");
        creditTitle.setBounds(800, 3,100, 30);
        creditTitle.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        creditTitle.setForeground(Color.WHITE);
        courseTitlePanel.add(creditTitle);
        
        course1Panel = new JPanel();
        course1Panel.setBounds(100,135, 1000, 35);
        course1Panel.setBackground(Color.WHITE);
        course1Panel.setLayout(null);
        panel.add(course1Panel);
        
        
 
        courseCode1 = new JLabel();
        courseCode1.setBounds(100, 3,1000, 30);
        courseCode1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course1Panel.add(courseCode1);
        
        courseName1 = new JLabel();
        courseName1.setBounds(300, 3,450, 30);
        courseName1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course1Panel.add(courseName1);
        
        credit1 = new JLabel();
        credit1.setBounds(800, 3,100, 30);
        credit1.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course1Panel.add(credit1);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 0;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course1Panel.setBackground(new Color(249,236,212));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode1.setText(courseCode);
                courseName1.setText(courseName);
                credit1.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        
        course2Panel = new JPanel();
        course2Panel.setBounds(100,170, 1000, 35);
        course2Panel.setBackground(Color.WHITE);
        course2Panel.setLayout(null);
        panel.add(course2Panel);
        
        JLabel CourseCode = new JLabel("Course");
        CourseCode.setBounds(100,5,150, 30);
        CourseCode.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course2Panel.add(CourseCode);
        
        courseCode2 = new JLabel();
        courseCode2.setBounds(100,5,150, 30);
        courseCode2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course2Panel.add(courseCode2);
        
        JLabel CourseName = new JLabel("Course");
        CourseName.setBounds(300,5,450, 30);
        CourseName.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course2Panel.add(CourseName);
       
        courseName2 = new JLabel();
        courseName2.setBounds(300,3,200, 30);
        courseName2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course2Panel.add(courseName2);
        
        credit2 = new JLabel("Course");
        credit2.setBounds(800,3,100, 30);
        credit2.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course2Panel.add(credit2);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 1;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course2Panel.setBackground(new Color(212,235,249));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                CourseCode.setText(courseCode);
                CourseName.setText(courseName);
                credit2.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}

        course3Panel = new JPanel();
        course3Panel.setBounds(100,205, 1000, 35);
        course3Panel.setBackground(Color.WHITE);
        course3Panel.setLayout(null);
        panel.add(course3Panel);
        
        courseCode3 = new JLabel();
        courseCode3.setBounds(100, 3,1000, 30);
        courseCode3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course3Panel.add(courseCode3);
        
        courseName3 = new JLabel();
        courseName3.setBounds(300, 3,450, 30);
        courseName3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course3Panel.add(courseName3);
        
        credit3 = new JLabel();
        credit3.setBounds(800, 3,100, 30);
        credit3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course3Panel.add(credit3);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 2;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course3Panel.setBackground(new Color(249,236,212));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode3.setText(courseCode);
                courseName3.setText(courseName);
                credit3.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        course4Panel = new JPanel();
        course4Panel.setBounds(100,240, 1000, 35);
        course4Panel.setBackground(Color.WHITE);
        course4Panel.setLayout(null);
        panel.add(course4Panel);
        
        courseCode4 = new JLabel();
        courseCode4.setBounds(100, 3,1000, 30);
        courseCode4.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course4Panel.add(courseCode4);
        
        courseName4 = new JLabel();
        courseName4.setBounds(300, 3,450, 30);
        courseName4.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course4Panel.add(courseName4);
        
        credit4 = new JLabel();
        credit4.setBounds(800, 3,100, 30);
        credit4.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course4Panel.add(credit4);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 3;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course4Panel.setBackground(new Color(212,235,249));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode4.setText(courseCode);
                courseName4.setText(courseName);
                credit4.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        course5Panel = new JPanel();
        course5Panel.setBounds(100,275, 1000, 35);
        course5Panel.setBackground(Color.WHITE);
        course5Panel.setLayout(null);
        panel.add(course5Panel);
        
        courseCode5 = new JLabel();
        courseCode5.setBounds(100, 3,1000, 30);
        courseCode5.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course5Panel.add(courseCode5);
        
        courseName5 = new JLabel();
        courseName5.setBounds(300, 3,450, 30);
        courseName5.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course5Panel.add(courseName5);
        
        credit5 = new JLabel();
        credit5.setBounds(800, 3,100, 30);
        credit5.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course5Panel.add(credit5);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 4;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course5Panel.setBackground(new Color(249,236,212));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode5.setText(courseCode);
                courseName5.setText(courseName);
                credit5.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        course6Panel = new JPanel();
        course6Panel.setBounds(100,310, 1000, 35);
        course6Panel.setBackground(Color.WHITE);
        course6Panel.setLayout(null);
        panel.add(course6Panel);
        
        courseCode6 = new JLabel();
        courseCode6.setBounds(100, 3,1000, 30);
        courseCode6.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course6Panel.add(courseCode6);
        
        courseName6 = new JLabel();
        courseName6.setBounds(300, 3,450, 30);
        courseName6.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course6Panel.add(courseName6);
        
        credit6 = new JLabel();
        credit6.setBounds(800, 3,100, 30);
        credit6.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course6Panel.add(credit6);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 5;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course6Panel.setBackground(new Color(212,235,249));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode6.setText(courseCode);
                courseName6.setText(courseName);
                credit6.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        course7Panel = new JPanel();
        course7Panel.setBounds(100,345, 1000, 35);
        course7Panel.setBackground(Color.WHITE);
        course7Panel.setLayout(null);
        panel.add(course7Panel);
        
        courseCode7 = new JLabel();
        courseCode7.setBounds(100, 3,1000, 30);
        courseCode7.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course7Panel.add(courseCode7);
        
        courseName7 = new JLabel();
        courseName7.setBounds(300, 3,450, 30);
        courseName7.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course7Panel.add(courseName7);
        
        credit7 = new JLabel();
        credit7.setBounds(800, 3,100, 30);
        credit7.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course7Panel.add(credit7);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 6;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course7Panel.setBackground(new Color(249,236,212));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode7.setText(courseCode);
                courseName7.setText(courseName);
                credit7.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        course8Panel = new JPanel();
        course8Panel.setBounds(100,380, 1000, 35);
        course8Panel.setBackground(Color.WHITE);
        course8Panel.setLayout(null);
        panel.add(course8Panel);
        
        courseCode8 = new JLabel();
        courseCode8.setBounds(100, 3,1000, 30);
        courseCode8.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course8Panel.add(courseCode2);
        
        courseName8 = new JLabel();
        courseName8.setBounds(300, 3,450, 30);
        courseName8.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course8Panel.add(courseName8);
        
        credit8 = new JLabel();
        credit8.setBounds(800, 3,100, 30);
        credit8.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course8Panel.add(credit8);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 7;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course8Panel.setBackground(new Color(212,235,249));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode8.setText(courseCode);
                courseName8.setText(courseName);
                credit8.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        course9Panel = new JPanel();
        course9Panel.setBounds(100,415, 1000, 35);
        course9Panel.setBackground(Color.WHITE);
        course9Panel.setLayout(null);
        panel.add(course9Panel);
        
        courseCode9 = new JLabel();
        courseCode9.setBounds(100, 3,1000, 30);
        courseCode9.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course9Panel.add(courseCode9);
        
        courseName9 = new JLabel();
        courseName9.setBounds(300, 3,450, 30);
        courseName9.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course9Panel.add(courseName2);
        
        credit9 = new JLabel();
        credit9.setBounds(800, 3,100, 30);
        credit9.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course9Panel.add(credit9);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 8;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course9Panel.setBackground(new Color(249,236,212));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode9.setText(courseCode);
                courseName9.setText(courseName);
                credit9.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        course10Panel = new JPanel();
        course10Panel.setBounds(100,450, 1000, 35);
        course10Panel.setBackground(Color.WHITE);
        course10Panel.setLayout(null);
        panel.add(course10Panel);
        
        courseCode10 = new JLabel();
        courseCode10.setBounds(100, 3,1000, 30);
        courseCode10.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course10Panel.add(courseCode10);
        
        courseName10 = new JLabel();
        courseName10.setBounds(300, 3,450, 30);
        courseName10.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course10Panel.add(courseName10);
        
        credit10 = new JLabel();
        credit10.setBounds(800, 3,100, 30);
        credit10.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        course10Panel.add(credit10);
        
        try{
            JDBCConnection c = new JDBCConnection();
            String query= "SELECT* FROM Course WHERE Programme = 'bca' && semester = '1' ORDER BY semester LIMIT 1 OFFSET 9;";
            ResultSet rs = c.stmt.executeQuery(query);
            if(rs.next()){
                course10Panel.setBackground(new Color(212,235,249));
                String ProgramCode = rs.getString("Programme");
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("NameofCourse");
                String credit = rs.getString("Credit");
                String semester = rs.getString("Semester"); 
                courseCode10.setText(courseCode);
                courseName10.setText(courseName);
                credit10.setText(credit);
            }
        }
        catch(Exception e){System.out.println(e);}
        back = new JButton("Cancel");
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
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[]){
        new AdmissionCourseDetails("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        if(e.getSource() == saveNext){

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
