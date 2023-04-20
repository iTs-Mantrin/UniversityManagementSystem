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
public class AdmissionQualificationDetails extends JFrame implements ActionListener {
    JPanel panel, panelHeading, qualificationDetailsPanel,scrollPanel;
    JLabel close,headingLabel, qualificationDetails ,eligibilityCriteriaLabel,eligibilityCriteria, relavantQualificationLabel, mainSubjectsLabel, yearOfPassingLabel, divisionLabel, marksLabel,boardNameLabel;
    JLabel relavantQualificationAlert, mainSubjectsAlert, yearOfPassingAlert, divisionAlert, marksAlert, boardNameAlert;
    JCheckBox hindi, commerce, english, arts, mathematics, biology, science, others;
    JComboBox relavantQualification, yearOfPassing, division, boardName;
    JTextField marks;
    JButton signout,back, saveNext;
    JScrollBar scroll;
    String UserName,Programme;
    AdmissionQualificationDetails(String UserName, String Programme){
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
        
        
        /**********************************/
        
        
        
        panel = new JPanel();
        panel.setBounds(0,100, 1260, 1050); //575
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
               
        scrollPanel = new JPanel();
        scrollPanel.setBounds(1260,100, 20, 570);
        scrollPanel.setBackground(Color.BLUE);
        scrollPanel.setLayout(null);
        add(scrollPanel);
        
        scroll = new JScrollBar();
        scroll.setBounds(0,0,20,570);
        scroll.addAdjustmentListener(new AdjustmentListener(){
            int Value;
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Value = scroll.getValue();
                panel.setBounds(0,100-4*Value, 1260, 800);
                throw new UnsupportedOperationException("Not supported yet."); 
            }
        });
        scrollPanel.add(scroll);
        
        qualificationDetailsPanel = new JPanel();
        qualificationDetailsPanel.setBounds(0,3, 1260, 35);
        qualificationDetailsPanel.setBackground(Color.GRAY);
        qualificationDetailsPanel.setLayout(null);
        panel.add(qualificationDetailsPanel);
        
        
        qualificationDetails = new JLabel("Qualification Details");
        qualificationDetails.setBounds(50, 3,300, 30);
        qualificationDetails.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        //qualificationDetails.setLocation(900,70);
        qualificationDetails.setForeground(Color.WHITE);
        qualificationDetailsPanel.add(qualificationDetails);
        
        eligibilityCriteriaLabel = new JLabel("Eligibility Criteria:");
        eligibilityCriteriaLabel.setBounds(100, 100 ,400, 30);
        eligibilityCriteriaLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(eligibilityCriteriaLabel);
        
        eligibilityCriteria = new JLabel("Set eligibility here");
        eligibilityCriteria.setBounds(400, 100 ,400, 30);
        eligibilityCriteria.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(eligibilityCriteria);
        
      
        relavantQualificationLabel = new JLabel("Relavant Qualification*");
        relavantQualificationLabel.setBounds(100, 150 ,400, 30);
        relavantQualificationLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(relavantQualificationLabel);
   
        String relavantQualificationArr[] = {"Select","Graduation or equivalance","10+2or its equivalent"};
        relavantQualification = new JComboBox(relavantQualificationArr);
        relavantQualification.setBackground(Color.WHITE);
        relavantQualification.setBounds(400, 150 ,500, 30);
        relavantQualification.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(relavantQualification);
        
//        try{
//            String query = "SELECT DISTINCT modeOfStudy FROM programme";
//            JDBCConnection con = new JDBCConnection();
//            ResultSet rs = con.stmt.executeQuery(query);
//            relavantQualification.addItem("Select");
//            while(rs.next()){
//                String modeOfStudies= rs.getString("modeOfStudy");
//                relavantQualification.addItem(modeOfStudies);
//            }
//        }
//        catch(Exception e){System.out.println(e);}
        
        relavantQualificationAlert = new JLabel();
        relavantQualificationAlert.setBounds(400, 170 ,350, 30);
        relavantQualificationAlert.setForeground(Color.red);
        relavantQualificationAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(relavantQualificationAlert);
        
        mainSubjectsLabel = new JLabel("Main Subjects*");
        mainSubjectsLabel.setBounds(100, 200 ,400, 30);
        mainSubjectsLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(mainSubjectsLabel);
        
        hindi = new JCheckBox("Hindi");
        hindi.setBounds(400, 200 ,100, 30);
        hindi.setBackground(Color.WHITE);
        hindi.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(hindi);
        
        commerce = new JCheckBox("Commerce");
        commerce.setBounds(600, 200 ,100, 30);
        commerce.setBackground(Color.WHITE);
        commerce.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(commerce);
        
        english = new JCheckBox("English");
        english.setBounds(800, 200 ,100, 30);
        english.setBackground(Color.WHITE);
        english.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(english);
        
        arts = new JCheckBox("Arts");
        arts.setBounds(400, 230 ,100, 30);
        arts.setBackground(Color.WHITE);
        arts.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(arts);
        
        mathematics = new JCheckBox("Mathematics");
        mathematics.setBounds(600, 230 ,120, 30);
        mathematics.setBackground(Color.WHITE);
        mathematics.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(mathematics);
        
        biology = new JCheckBox("Biology");
        biology.setBounds(800, 230 ,100, 30);
        biology.setBackground(Color.WHITE);
        biology.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(biology);
        
        science = new JCheckBox("Science");
        science.setBounds(400, 260 ,100, 30);
        science.setBackground(Color.WHITE);
        science.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(science);
        
        others = new JCheckBox("Others");
        others.setBounds(600, 260 ,120, 30);
        others.setBackground(Color.WHITE);
        others.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(others);
        
        mainSubjectsAlert = new JLabel();
        mainSubjectsAlert.setBounds(800, 260 ,300, 30);
        mainSubjectsAlert.setForeground(Color.red);
        mainSubjectsAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(mainSubjectsAlert);
        
        
        yearOfPassingLabel = new JLabel("Year Of Passing*");
        yearOfPassingLabel.setBounds(100, 300 ,400, 30);
        yearOfPassingLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(yearOfPassingLabel);
        
        String yearOfPassingArr[] = {"Select","2023","2022","2021","2020","2019","2018","2017","2016","2015","2015","2014","2013","2012","2011","2010"};
        yearOfPassing = new JComboBox(yearOfPassingArr);
        yearOfPassing.setBackground(Color.WHITE);
        yearOfPassing.setBounds(400, 300 ,500, 30);
        yearOfPassing.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(yearOfPassing);
        
        yearOfPassingAlert = new JLabel();
        yearOfPassingAlert.setBounds(400, 320 ,350, 30);
        yearOfPassingAlert.setForeground(Color.red);
        yearOfPassingAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(yearOfPassingAlert);
        
        divisionLabel = new JLabel("Division*");
        divisionLabel.setBounds(100, 350 ,400, 30);
        divisionLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(divisionLabel);
   
        String divisionArr[] = {"Select","First","Second","Third","Passed"};
        division = new JComboBox(divisionArr);
        division.setBackground(Color.WHITE);
        division.setBounds(400, 350 ,500, 30);
        division.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(division);
        
        divisionAlert = new JLabel();
        divisionAlert.setBounds(400, 370 ,350, 30);
        divisionAlert.setForeground(Color.red);
        divisionAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(divisionAlert);
        
        marksLabel = new JLabel("% of Marks*");
        marksLabel.setBounds(100, 400 ,400, 30);
        marksLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(marksLabel);
   
        marks = new JTextField();
        marks.setBounds(400, 400 ,500, 30);
        marks.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(marks);

        marksAlert = new JLabel();
        marksAlert.setBounds(400, 420 ,350, 30);
        marksAlert.setForeground(Color.red);
        marksAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(marksAlert);
        
        boardNameLabel = new JLabel("Board Name*");
        boardNameLabel.setBounds(100, 450 ,400, 30);
        boardNameLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(boardNameLabel);
   
        boardName = new JComboBox();
        boardName.setBackground(Color.WHITE);
        boardName.setBounds(400, 450 ,500, 30);
        boardName.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(boardName);
        
        try{
            String query = "SELECT DISTINCT boardName FROM boardname";
            JDBCConnection con = new JDBCConnection();
            ResultSet rs = con.stmt.executeQuery(query);
            boardName.addItem("Select");
            while(rs.next()){
                String boardname= rs.getString("boardName");
                boardName.addItem(boardname);
            }
        }
        catch(Exception e){System.out.println(e);}

        boardNameAlert = new JLabel();
        boardNameAlert.setBounds(400, 470 ,350, 30);
        boardNameAlert.setForeground(Color.red);
        boardNameAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(boardNameAlert);
        
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
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[]){
        new AdmissionQualificationDetails("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String _relavantQualification = (String) relavantQualification.getSelectedItem();
        String _subject ="";
        if(hindi.isSelected()){
            _subject =""+hindi.getText();
        }
        if(commerce.isSelected()){
            _subject =","+commerce.getText();
        }
        if(english.isSelected()){
            _subject =","+english.getText();
        }
        if(arts.isSelected()){
            _subject =","+arts.getText();
        }
        if(biology.isSelected()){
            _subject =","+biology.getText();
        }
        if(mathematics.isSelected()){
            _subject =","+mathematics.getText();
        }
        if(science.isSelected()){
            _subject =","+science.getText();
        }
        if(others.isSelected()){
            _subject =","+others.getText();
        }
        System.out.println(_subject);
        String _yearOfPassing = (String) yearOfPassing.getSelectedItem();
        String _division = (String) division.getSelectedItem();
        String _marks = marks.getText();
        String _boardName = (String) boardName.getSelectedItem();
        
        if(e.getSource() == saveNext){
            if(_relavantQualification.equalsIgnoreCase("Select")||_subject.equals("")||_yearOfPassing.equalsIgnoreCase("Select")||_division.equalsIgnoreCase("Select")||_marks.equalsIgnoreCase("")||_boardName.equalsIgnoreCase("Select"))
                    if(_relavantQualification.equalsIgnoreCase("Select")){
                        relavantQualificationAlert.setText("Relavant Qualification cannot be blank");
                    }
                    if(_subject.equals("")){
                        mainSubjectsAlert.setText("Main Subject cannot be blank");
                    }
                    if(_yearOfPassing.equalsIgnoreCase("Select")){
                        yearOfPassingAlert.setText("Year of passing cannot be blank");
                    }
                    if(_division.equalsIgnoreCase("Select")){
                        divisionAlert.setText("Division cannot be blank");
                    }
                    if(_marks.equalsIgnoreCase("")){
                        marksAlert.setText("Marks cannot be blank");
                    }
                    if(_boardName.equalsIgnoreCase("Select")){
                        boardNameAlert.setText("Board name cannot be blank");
                    }
                }
            else{
                try{
                    JDBCConnection con = new JDBCConnection();
                    String query = "INSERT INTO admissionqualificationdetails (UserName,relevantQualification,mainSubjects,yearOfPassing,division,marksPercentage,boardName) values ('"+UserName+"','"+_relavantQualification+"','"+_subject+"','"+_yearOfPassing+"','"+_division+"','"+_marks+"','"+_boardName+"');";
                    con.stmt.executeUpdate(query);
                    setVisible(false);
                    new AdmissionCorrespondenceDetails(UserName,Programme).setVisible(true);
                }
                catch(Exception f){System.out.println(f);}
//           }
        } 
         if(e.getSource() == signout){
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Logout Successfully...");
            new AdmissionPortal().setVisible(true);
        }
        else if(e.getSource() == back){
         setVisible(false);
         new AdmissionProgrammeDetails(UserName).setVisible(true);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
