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
public class AdmissionProgrammeDetails extends JFrame implements ActionListener {
    JPanel panel, panelHeading, programmeDetailsPanel;
    JLabel close,headingLabel, programmeDetails ,programmeTypeLabel, modeOfStudyLabel, programmeLabel, regionCodeLabel, programmeStudeyCenterLabel, mediumLabel ;
    JLabel programmeTypeAlert, modeOfStudyAlert, programmeAlert, regionCodeAlert, programmeStudeyCenterAlert, mediumAlert;
    JComboBox programmeType, modeOfStudy,selectProgramme, regionCode, programmeStudeyCenter, medium;
    JButton  signout,back, saveNext;
    String UserName, Programme;
    AdmissionProgrammeDetails(String UserName){
        
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
      

        programmeDetailsPanel = new JPanel();
        programmeDetailsPanel.setBounds(0,3, 1260, 35);
        programmeDetailsPanel.setBackground(Color.GRAY);
        programmeDetailsPanel.setLayout(null);
        panel.add(programmeDetailsPanel);
        
        
        programmeDetails = new JLabel("Programme Details");
        programmeDetails.setBounds(50, 3,300, 30);
        programmeDetails.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        //programmeDetails.setLocation(900,70);
        programmeDetails.setForeground(Color.WHITE);
        programmeDetailsPanel.add(programmeDetails);
        
        programmeTypeLabel = new JLabel("Programme Type*");
        programmeTypeLabel.setBounds(50, 50 ,400, 30);
        programmeTypeLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(programmeTypeLabel);
        
        
        programmeType = new JComboBox();
        programmeType.setBounds(450, 50 ,500, 30);
        programmeType.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(programmeType);
        
        try{
            String query = "SELECT DISTINCT programmeType FROM programme";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            programmeType.addItem("Select");
            while(rs.next()){
                String programmeTypes= rs.getString("programmeType");
                programmeType.addItem(programmeTypes);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        programmeTypeAlert = new JLabel();
        programmeTypeAlert.setBounds(450, 70 ,370, 30);
        programmeTypeAlert.setForeground(Color.red);
        programmeTypeAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(programmeTypeAlert);
        
        modeOfStudyLabel = new JLabel("Mode Of Study*");
        modeOfStudyLabel.setBounds(50, 100 ,400, 30);
        modeOfStudyLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(modeOfStudyLabel);
        
        modeOfStudy = new JComboBox();
        modeOfStudy.setBounds(450, 100 ,500, 30);
        modeOfStudy.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(modeOfStudy);
        
        try{
            String query = "SELECT DISTINCT modeOfStudy FROM programme";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            modeOfStudy.addItem("Select");
            while(rs.next()){
                String modeOfStudies= rs.getString("modeOfStudy");
                modeOfStudy.addItem(modeOfStudies);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        modeOfStudyAlert = new JLabel();
        modeOfStudyAlert.setBounds(450, 120 ,350, 30);
        modeOfStudyAlert.setForeground(Color.red);
        modeOfStudyAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(modeOfStudyAlert);
        
        
        programmeLabel = new JLabel("Select Programme For Enrollment*");
        programmeLabel.setBounds(50, 150 ,400, 30);
        programmeLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(programmeLabel);
        
        selectProgramme = new JComboBox();
        selectProgramme.setBounds(450, 150 ,500, 30);
        selectProgramme.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(selectProgramme);
        
        try{
            String query = "SELECT DISTINCT programme FROM programme";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            selectProgramme.addItem("Select");
            while(rs.next()){
                String programmes= rs.getString("programme");
                selectProgramme.addItem(programmes);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        programmeAlert = new JLabel();
        programmeAlert.setBounds(450, 170 ,350, 30);
        programmeAlert.setForeground(Color.red);
        programmeAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(programmeAlert);
        
        regionCodeLabel = new JLabel("Region Code for Admission*");
        regionCodeLabel.setBounds(50, 200 ,400, 30);
        regionCodeLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(regionCodeLabel);
        
        regionCode = new JComboBox();
        regionCode.setBounds(450, 200 ,500, 30);
        regionCode.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(regionCode);
        
        try{
            String query = "SELECT DISTINCT region FROM centers";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            regionCode.addItem("Select");
            while(rs.next()){
                String region= rs.getString("region");
                regionCode.addItem(region);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        regionCodeAlert = new JLabel();
        regionCodeAlert.setBounds(450, 220 ,350, 30);
        regionCodeAlert.setForeground(Color.red);
        regionCodeAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(regionCodeAlert);
        
        programmeStudeyCenterLabel = new JLabel("Programme Study Center Code*");
        programmeStudeyCenterLabel.setBounds(50, 250 ,400, 30);
        programmeStudeyCenterLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(programmeStudeyCenterLabel);
        
        programmeStudeyCenter = new JComboBox();
        programmeStudeyCenter.setBounds(450, 250 ,500, 30);
        programmeStudeyCenter.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(programmeStudeyCenter);
        
        try{
            String query = "SELECT DISTINCT studyCenter FROM centers";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            programmeStudeyCenter.addItem("Select");
            while(rs.next()){
                String studyCenter= rs.getString("studyCenter");
                programmeStudeyCenter.addItem(studyCenter);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        programmeStudeyCenterAlert = new JLabel();
        programmeStudeyCenterAlert.setBounds(450, 270 ,350, 30);
        programmeStudeyCenterAlert.setForeground(Color.red);
        programmeStudeyCenterAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(programmeStudeyCenterAlert); 
        
        mediumLabel = new JLabel("Medium*");
        mediumLabel.setBounds(50, 300 ,100, 30);
        mediumLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(mediumLabel);
        
        medium = new JComboBox();
        medium.setBounds(450, 300 ,500, 30);
        medium.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(medium);
        
        try{
            String query = "SELECT DISTINCT medium FROM programme";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            medium.addItem("Select");
            while(rs.next()){
                String mediums= rs.getString("medium");
                medium.addItem(mediums);
            }
        }
        catch(Exception e){System.out.println(e);}
        
        mediumAlert = new JLabel();
        mediumAlert.setBounds(450, 320 ,350, 30);
        mediumAlert.setForeground(Color.red);
        mediumAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(mediumAlert); 
        


        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(350,500,250,40);
        back.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        back.setBackground(new Color(113,177,249));
        back.setForeground(Color.WHITE);
        panel.add(back);
        
        saveNext = new JButton("Save & Next");
        saveNext.addActionListener(this);
        saveNext.setBounds(700,500,250,40);
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
        new AdmissionProgrammeDetails("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String _programmeType = (String) programmeType.getSelectedItem();
        String _modeOfStudy = (String) modeOfStudy.getSelectedItem();
        String _selectProgramme = (String) selectProgramme.getSelectedItem();
        String _regionCode = (String) regionCode.getSelectedItem();
        String _programmeStudeyCenter = (String) programmeStudeyCenter.getSelectedItem();
        String _medium = (String) medium.getSelectedItem();
     
        
        if(e.getSource() == saveNext){
            if(_programmeType.equalsIgnoreCase("Select")||_modeOfStudy.equalsIgnoreCase("Select")||_selectProgramme.equalsIgnoreCase("Select")||_regionCode.equalsIgnoreCase("Select")||_programmeStudeyCenter.equalsIgnoreCase("Select")||_medium.equalsIgnoreCase("Select"))
                {    
                    if(_programmeType.equalsIgnoreCase("Select")){
                        programmeTypeAlert.setText("Programme Type cannot be blank");
                    }
                    if(_modeOfStudy.equalsIgnoreCase("Select")){
                        modeOfStudyAlert.setText("Mode of Study cannot be blank");
                    }
                    if(_selectProgramme.equalsIgnoreCase("Select")){
                        programmeAlert.setText("Select Programme cannot be blank");
                    }
                    if(_regionCode.equalsIgnoreCase("Select")){
                        regionCodeAlert.setText("Region code cannot be blank");
                    }
                    if(_programmeStudeyCenter.equalsIgnoreCase("Select")){
                        programmeStudeyCenterAlert.setText("Study Center cannot be blank");
                    }
                    if(_medium.equalsIgnoreCase("Select")){
                         mediumAlert.setText("Medium cannot be blank");
                    }
                        panel.setLocation(0,100);
                }
            else{
                try{
                    JDBCConnection con = new JDBCConnection();
                    String query = "INSERT INTO admissionprogrammedetails (UserName, programmeType, modeOfStudy, programme, regionCode, studyCenterCode, medium) VALUES ('"+UserName+"','"+_programmeType+"','"+_modeOfStudy+"','"+_selectProgramme+"','"+_regionCode+"','"+_programmeStudeyCenter+"','"+_medium+"');";
                    con.stmt.executeUpdate(query);
                    setVisible(false);
                    new AdmissionQualificationDetails(UserName,_selectProgramme).setVisible(true);
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
         new AdmissionPersonalDetails(UserName).setVisible(true);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
