package universitymanagementsystem.admissionportal;

import javax.swing.*;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import universitymanagementsystem.home.JDBCConnection;
/*
 * @author Manish KumarcityAlert
 */
public class AdmissionUploadsDocuments extends JFrame implements ActionListener {
    JPanel panel, panelHeading, UploadsDocumentsPanel, DocumentsPanel,documentsPanelHeading, doc1,doc2,doc3,doc4,doc5,doc6,doc7;
    JLabel close,headingLabel, UploadsDocuments ,documentsTypeLabel;
    JLabel sn1, type1, img1, sn2, type2, img2, sn3, type3, img3, sn4, type4, img4, sn5, type5, img5, sn6, type6, img6, sn7, type7, img7;
    boolean add1, add2, add3, add4, add5, add6, add7;
    JComboBox documentsType;
    JButton signout,add, back, saveNext, browse1, delete1, browse2, delete2, browse3, delete3, browse4, delete4, browse5, delete5, browse6, delete6, browse7, delete7;
    String UserName;
    Border blackline;
    int locate=0,serial=1;
    String fileName1,fileName2,fileName3,fileName4,fileName5,fileName6,fileName7;
    String typeName1 ="",typeName2="",typeName3="",typeName4="",typeName5="",typeName6="",typeName7="";
    ImageIcon file1,file2,file3,file4,file5,file6,file7;
    AdmissionUploadsDocuments(String UserName){
        this.UserName = UserName;
        blackline = BorderFactory.createLineBorder(Color.BLACK);

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
        
        ImageIcon imgClose = new ImageIcon(ClassLoader.getSystemResource("icon/closeButton.png"));
        Image imgClose2 = imgClose.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
        ImageIcon imgClose3 = new ImageIcon(imgClose2);
        
        close = new JLabel(imgClose3);
        close.setBounds(1230, 10,40, 30);
        panelHeading.add(close);
        close.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                setVisible(false);
                System.exit(0);
            }
        });
        
        panel = new JPanel();
        panel.setBounds(0,100, 1300, 1050); //575
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        UploadsDocumentsPanel = new JPanel();
        UploadsDocumentsPanel.setBounds(0,3, 1300, 35);
        UploadsDocumentsPanel.setBackground(Color.GRAY);
        UploadsDocumentsPanel.setLayout(null);
        panel.add(UploadsDocumentsPanel);
        
        
        UploadsDocuments = new JLabel("Upload Documents");
        UploadsDocuments.setBounds(50, 3,300, 30);
        UploadsDocuments.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        UploadsDocuments.setForeground(Color.WHITE);
        UploadsDocumentsPanel.add(UploadsDocuments);
       
        documentsTypeLabel = new JLabel("Select documents type*");
        documentsTypeLabel.setBounds(100, 50 ,400, 30);
        documentsTypeLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(documentsTypeLabel);
        
        String documentsTypeArr[] = {"Select", "Photo","Signature","Matriculation Marksheet or Certificate","Marksheet of Graduation","Others1","Others2","Others3"};
        documentsType = new JComboBox(documentsTypeArr);
        documentsType.setBounds(400, 50 ,400, 30);
        documentsType.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        panel.add(documentsType);
        
        add = new JButton("Add");
        add.setBounds(850, 50 ,70, 30);
        add.addActionListener(this);
        add.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add.setBackground(new Color(113,177,249));
        add.setForeground(Color.WHITE);
        panel.add(add);
        
//        documentsTypeAlert = new JLabel("alert");
//        documentsTypeAlert.setBounds(400, 80 ,350, 20);
//        documentsTypeAlert.setForeground(Color.red);
//        documentsTypeAlert.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
//        panel.add(documentsTypeAlert);
        
        documentsPanelHeading = new JPanel();
        documentsPanelHeading.setBounds(100,100,1100,30);
        documentsPanelHeading.setBackground(new Color(132,211,255));
        documentsPanelHeading.setLayout(null);
        panel.add(documentsPanelHeading);
        
        JLabel serialNumber  = new JLabel("Serial Number");
        serialNumber.setBounds(50, 0, 100, 30);
        documentsPanelHeading.add(serialNumber);
        
        JLabel ImageType  = new JLabel("IMAGE TYPE");
        ImageType.setBounds(250, 0, 100, 30);
        documentsPanelHeading.add(ImageType);
        
        JLabel preview  = new JLabel("Preview");
        preview.setBounds(650, 0, 100, 30);
        documentsPanelHeading.add(preview);
        
        JLabel action  = new JLabel("Action");
        action.setBounds(900, 0, 100, 30);
        documentsPanelHeading.add(action);
        
        DocumentsPanel = new JPanel();
        DocumentsPanel.setBounds(100, 130, 1100, 380);
        DocumentsPanel.setBackground(new Color(255,227,215));
        DocumentsPanel.setLayout(null);
        panel.add(DocumentsPanel);
        
        doc1 = new JPanel();
        doc1.setBackground(new Color(216,241,255));
        doc1.setLayout(null); 
        DocumentsPanel.add(doc1);
        
        sn1 = new JLabel();
        sn1.setBounds(50, 25, 50, 50);
        doc1.add(sn1);
        
        type1 = new JLabel();
        type1.setBounds(250, 25, 400, 50);
        doc1.add(type1);
        
  /********************************************************************/  
  /*              Image Browse and select
  /********************************************************************/
 
        browse1 = new JButton("Browse");
        browse1.setBounds(850, 50 ,100, 30);
        browse1.addActionListener(this);
        browse1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        browse1.setBackground(new Color(113,177,249));
        browse1.setForeground(Color.WHITE);
        doc1.add(browse1);
        
        img1 = new JLabel();
        img1.setBorder(blackline);
        img1.setBounds(650, 2, 100, 115);
        doc1.add(img1);
                    
            browse1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
                file.addChoosableFileFilter(filter);
                int result  = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    fileName1 = selectedFile.getName();
                    file1 = new ImageIcon(path);
                    
                    ImageIcon image = new ImageIcon(path);
                    Image image1 = image.getImage().getScaledInstance(100, 115, Image.SCALE_DEFAULT);
                    ImageIcon image2 = new ImageIcon(image1);
                    img1.setIcon(image2);
                    System.out.println("Working");
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("Image not found");
                }
                }   
            });
                

        
        
    /************************************************************/ 
    /*                 End Here                                 */
    /************************************************************/       
        
        delete1 = new JButton("Delete");
        delete1.setBounds(970, 50 ,100, 30);
        delete1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        delete1.setBackground(new Color(113,177,249));
        delete1.setForeground(Color.WHITE);
        doc1.add(delete1);
        delete1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                img1.setIcon(null);
            }
        });

        
        
        doc2 = new JPanel();
        doc2.setLayout(null);
        doc2.setBackground(new Color(216,241,255));
        DocumentsPanel.add(doc2);
        
        sn2 = new JLabel();
        sn2.setBounds(50, 25, 50, 50);
        sn2.setText(""+serial);
        doc2.add(sn2);

        type2 = new JLabel();
        type2.setBounds(250, 25, 400, 50);
        doc2.add(type2);

  /********************************************************************/  
  /*              Image Browse and select
  /********************************************************************/
 
        browse2 = new JButton("Browse");
        browse2.setBounds(850, 50 ,100, 30);
        browse2.addActionListener(this);
        browse2.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        browse2.setBackground(new Color(113,177,249));
        browse2.setForeground(Color.WHITE);
        doc2.add(browse2);
        
        img2 = new JLabel();
        img2.setBorder(blackline);
        img2.setBounds(650, 2, 100, 115);
        doc2.add(img2);
                    
            browse2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
                file.addChoosableFileFilter(filter);
                int result  = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    
                    fileName2 = selectedFile.getName();
                    file2 = new ImageIcon(path);
                    
                    ImageIcon image = new ImageIcon(path);
                    Image image1 = image.getImage().getScaledInstance(100, 115, Image.SCALE_DEFAULT);
                    ImageIcon image2 = new ImageIcon(image1);
                    img2.setIcon(image2);
                    System.out.println("Working");
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("Image not found");
                }
                }   
            });
                

        
        
    /************************************************************/ 
    /*                 End Here                                 */
    /************************************************************/       
        
        delete2 = new JButton("Delete");
        delete2.setBounds(970, 50 ,100, 30);
        delete2.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        delete2.setBackground(new Color(113,177,249));
        delete2.setForeground(Color.WHITE);
        doc2.add(delete2);
        delete2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                img2.setIcon(null);
            }
        });

        doc3 = new JPanel();
        doc3.setLayout(null);
        doc3.setBackground(new Color(216,241,255));
        DocumentsPanel.add(doc3);
        
        sn3 = new JLabel();
        sn3.setBounds(50, 25, 50, 50);
        sn3.setText(""+serial);
        doc3.add(sn3);

        type3 = new JLabel();
        type3.setBounds(250, 25, 400, 50);
        doc3.add(type3);

  /********************************************************************/  
  /*              Image Browse and select
  /********************************************************************/
 
        browse3 = new JButton("Browse");
        browse3.setBounds(850, 50 ,100, 30);
        browse3.addActionListener(this);
        browse3.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        browse3.setBackground(new Color(113,177,249));
        browse3.setForeground(Color.WHITE);
        doc3.add(browse3);
        
        img3 = new JLabel();
        img3.setBorder(blackline);
        img3.setBounds(650, 2, 100, 115);
        doc3.add(img3);
                    
            browse3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
                file.addChoosableFileFilter(filter);
                int result  = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    
                    
                    fileName3 = selectedFile.getName();
                    file3 = new ImageIcon(path);
                    
                    ImageIcon image = new ImageIcon(path);
                    Image image1 = image.getImage().getScaledInstance(100, 115, Image.SCALE_DEFAULT);
                    ImageIcon image2 = new ImageIcon(image1);
                    img3.setIcon(image2);
                    System.out.println("Working");
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("Image not found");
                }
                }   
            });
                

        
        
    /************************************************************/ 
    /*                 End Here                                 */
    /************************************************************/       
        
        delete3 = new JButton("Delete");
        delete3.setBounds(970, 50 ,100, 30);
        delete3.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        delete3.setBackground(new Color(113,177,249));
        delete3.setForeground(Color.WHITE);
        doc3.add(delete3);
        delete3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                img3.setIcon(null);
            }
        });
      
        doc4 = new JPanel();
        doc4.setLayout(null);
        doc4.setBackground(new Color(216,241,255));
        DocumentsPanel.add(doc4);
        
        sn4 = new JLabel();
        sn4.setBounds(50, 25, 50, 50);
        sn4.setText(""+serial);
        doc4.add(sn4);

        type4 = new JLabel();
        type4.setBounds(250, 25, 400, 50);
        doc4.add(type4);

  /********************************************************************/  
  /*              Image Browse and select
  /********************************************************************/
 
        browse4 = new JButton("Browse");
        browse4.setBounds(850, 50 ,100, 30);
        browse4.addActionListener(this);
        browse4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        browse4.setBackground(new Color(113,177,249));
        browse4.setForeground(Color.WHITE);
        doc4.add(browse4);
        
        img4 = new JLabel();
        img4.setBorder(blackline);
        img4.setBounds(650, 2, 100, 115);
        doc4.add(img4);
                    
            browse4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
                file.addChoosableFileFilter(filter);
                int result  = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    
                    fileName4 = selectedFile.getName();
                    file4 = new ImageIcon(path);
                    
                    ImageIcon image = new ImageIcon(path);
                    Image image1 = image.getImage().getScaledInstance(100, 115, Image.SCALE_DEFAULT);
                    ImageIcon image2 = new ImageIcon(image1);
                    img4.setIcon(image2);
                    System.out.println("Working");
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("Image not found");
                }
                }   
            });
                

        
        
    /************************************************************/ 
    /*                 End Here                                 */
    /************************************************************/       
        
        delete4 = new JButton("Delete");
        delete4.setBounds(970, 50 ,100, 30);
        delete4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        delete4.setBackground(new Color(113,177,249));
        delete4.setForeground(Color.WHITE);
        doc4.add(delete4);
        delete4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                img4.setIcon(null);
            }
        });
        
        doc5 = new JPanel();
        doc5.setLayout(null);
        doc5.setBackground(new Color(216,241,255));
        DocumentsPanel.add(doc5);
        
        sn5 = new JLabel();
        sn5.setBounds(50, 25, 50, 50);
        sn5.setText(""+serial);
        doc5.add(sn5);

        type5 = new JLabel();
        type5.setBounds(250, 25, 400, 50);
        doc5.add(type5);

  /********************************************************************/  
  /*              Image Browse and select
  /********************************************************************/
 
        browse5 = new JButton("Browse");
        browse5.setBounds(850, 50 ,100, 30);
        browse5.addActionListener(this);
        browse5.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        browse5.setBackground(new Color(113,177,249));
        browse5.setForeground(Color.WHITE);
        doc5.add(browse4);
        
        img5 = new JLabel();
        img5.setBorder(blackline);
        img5.setBounds(650, 2, 100, 115);
        doc5.add(img5);
                    
            browse5.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
                file.addChoosableFileFilter(filter);
                int result  = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    
                    fileName5 = selectedFile.getName();
                    file5 = new ImageIcon(path);
                   
                    ImageIcon image = new ImageIcon(path);
                    Image image1 = image.getImage().getScaledInstance(100, 115, Image.SCALE_DEFAULT);
                    ImageIcon image2 = new ImageIcon(image1);
                    img5.setIcon(image2);
                    System.out.println("Working");
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("Image not found");
                }
                }   
            });
                

        
        
    /************************************************************/ 
    /*                 End Here                                 */
    /************************************************************/       
        
        delete5 = new JButton("Delete");
        delete5.setBounds(970, 50 ,100, 30);
        delete5.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        delete5.setBackground(new Color(113,177,249));
        delete5.setForeground(Color.WHITE);
        doc5.add(delete5);
        delete5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                img5.setIcon(null);
            }
        });

        doc6 = new JPanel();
        doc6.setLayout(null);
        doc6.setBackground(new Color(216,241,255));
        DocumentsPanel.add(doc6);
        
        sn6 = new JLabel();
        sn6.setBounds(50, 25, 50, 50);
        sn6.setText(""+serial);
        doc6.add(sn6);

        type6 = new JLabel();
        type6.setBounds(250, 25, 400, 50);
        doc6.add(type6);

  /********************************************************************/  
  /*              Image Browse and select
  /********************************************************************/
 
        browse6 = new JButton("Browse");
        browse6.setBounds(850, 50 ,100, 30);
        browse6.addActionListener(this);
        browse6.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        browse6.setBackground(new Color(113,177,249));
        browse6.setForeground(Color.WHITE);
        doc6.add(browse6);
        
        img6 = new JLabel();
        img6.setBorder(blackline);
        img6.setBounds(650, 2, 100, 115);
        doc6.add(img6);
                    
            browse6.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
                file.addChoosableFileFilter(filter);
                int result  = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    
                    fileName6 = selectedFile.getName();
                    file6 = new ImageIcon(path);
                    
                    ImageIcon image = new ImageIcon(path);
                    Image image1 = image.getImage().getScaledInstance(100, 115, Image.SCALE_DEFAULT);
                    ImageIcon image2 = new ImageIcon(image1);
                    img6.setIcon(image2);
                    System.out.println("Working");
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("Image not found");
                }
                }   
            });
                

        
        
    /************************************************************/ 
    /*                 End Here                                 */
    /************************************************************/       
        
        delete6 = new JButton("Delete");
        delete6.setBounds(970, 50 ,100, 30);
        delete6.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        delete6.setBackground(new Color(113,177,249));
        delete6.setForeground(Color.WHITE);
        doc6.add(delete6);
        delete6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                img6.setIcon(null);
            }
        });
        
        doc7 = new JPanel();
        doc7.setLayout(null);
        doc7.setBackground(new Color(216,241,255));
        DocumentsPanel.add(doc7);
        
        sn7 = new JLabel();
        sn7.setBounds(50, 25, 50, 50);
        sn7.setText(""+serial);
        doc7.add(sn7);

        type7 = new JLabel();
        type7.setBounds(250, 25, 400, 50);
        doc7.add(type7);

  /********************************************************************/  
  /*              Image Browse and select
  /********************************************************************/
 
        browse7 = new JButton("Browse");
        browse7.setBounds(850, 50 ,100, 30);
        browse7.addActionListener(this);
        browse7.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        browse7.setBackground(new Color(113,177,249));
        browse7.setForeground(Color.WHITE);
        doc7.add(browse7);
        
        img7 = new JLabel();
        img7.setBorder(blackline);
        img7.setBounds(650, 2, 100, 115);
        doc7.add(img7);
                    
            browse7.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
                file.addChoosableFileFilter(filter);
                int result  = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    
                    fileName7 = selectedFile.getName();
                    file7 = new ImageIcon(path);
                    
                    ImageIcon image = new ImageIcon(path);
                    Image image1 = image.getImage().getScaledInstance(100, 115, Image.SCALE_DEFAULT);
                    ImageIcon image2 = new ImageIcon(image1);
                    img7.setIcon(image2);
                    System.out.println("Working");
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("Image not found");
                }
                }   
            });
                

        
        
    /************************************************************/ 
    /*                 End Here                                 */
    /************************************************************/       
        
        delete7 = new JButton("Delete");
        delete7.setBounds(970, 50 ,100, 30);
        delete7.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        delete7.setBackground(new Color(113,177,249));
        delete7.setForeground(Color.WHITE);
        doc7.add(delete7);
        delete7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                img7.setIcon(null);
            }
        });
        
        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(350,530,177,40);
        back.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        back.setBackground(new Color(113,177,249));
        back.setForeground(Color.WHITE);
        panel.add(back);
        
        saveNext = new JButton("Save & Next");
        saveNext.addActionListener(this);
        saveNext.setBounds(700,530,177,40);
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
        
        new AdmissionUploadsDocuments("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String _DocType = (String) documentsType.getSelectedItem();
        
        if(e.getSource() == add){
            String docType = (String) documentsType.getSelectedItem();
            
            if(docType.equalsIgnoreCase("Select")){
                JOptionPane.showMessageDialog(null,"Please select document type");
            }
            else if(docType.equalsIgnoreCase("Photo")){   
                if(add1 == false){
                typeName1 = "Photo";
                add1 = true;
                doc1.setBounds(0,locate,1100,120);
                doc1.setBorder(blackline);
                sn1.setText(""+serial);
                locate += 120;
                serial += 1;
                type1.setText((String)documentsType.getSelectedItem());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Photo field already added" );
                }
                
            }
            else if(docType.equalsIgnoreCase("Signature")){
                if(add2 == false){
                add2 = true;
                typeName2 = "Signature";
                doc2.setBounds(0,locate,1100,120);
                doc2.setBorder(blackline);
                sn2.setText(""+serial);
                locate += 120;
                serial += 1;
                type2.setText((String)documentsType.getSelectedItem());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Signature field already added" );
                }

            }
            else if(docType.equalsIgnoreCase("Matriculation Marksheet or Certificate")){
                if(add3 == false){
                add3 = true;
                typeName3 = "Matriculation Marksheet or Certificate";
                doc3.setBounds(0,locate,1100,120);
                doc3.setBorder(blackline);
                sn3.setText(""+serial);
                locate += 120;
                serial += 1;
                type3.setText((String)documentsType.getSelectedItem());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Matriculation Marksheet or Certificate field already added" );
                }
            }
            else if(docType.equalsIgnoreCase("Marksheet of Graduation")){
                if(add4 == false){
                add4 = true;
                typeName4 = "Marksheet of Graduation";
                doc4.setBounds(0,locate,1100,120);
                doc4.setBorder(blackline);
                sn4.setText(""+serial);
                locate += 120;
                serial += 1;
                type4.setText((String)documentsType.getSelectedItem());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Marksheet of Graduation field already added" );
                }
                
            }
            else if(docType.equalsIgnoreCase("Others1")){
                if(add5 == false){
                add5 = true;
                typeName5 = "Others1";
                doc5.setBounds(0,locate,1100,120);
                doc5.setBorder(blackline);
                sn5.setText(""+serial);
                locate += 120;
                serial += 1;
                type5.setText((String)documentsType.getSelectedItem());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Others1 field already added" );
                }
                
            }
            else if(docType.equalsIgnoreCase("Others2")){
                if(add6 == false){
                add6 = true;
                typeName6 = "Others2";
                doc6.setBounds(0,locate,1100,120);
                doc6.setBorder(blackline);
                sn6.setText(""+serial);
                locate += 120;
                serial += 1;
                type6.setText((String)documentsType.getSelectedItem());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Others2 field already added" );
                }
                
            }
            else if(docType.equalsIgnoreCase("Others3")){
                if(add7 == false){
                add7 = true;
                typeName7 = "Others3";
                doc7.setBounds(0,locate,1100,120);
                doc7.setBorder(blackline);
                sn7.setText(""+serial);
                locate += 120;
                serial += 1;
                type7.setText((String)documentsType.getSelectedItem());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Others3 field already added" );
                }
                
            }
            
        }
        
        
        if(e.getSource() == saveNext){
            String query1 = "INSERT INTO admissionuploadsdocuments(UserName, DocType, FileName, File) VALUES ('"+UserName+"','"+typeName1+"','"+fileName1+"','"+file1+"')";
            String query2 = "INSERT INTO admissionuploadsdocuments(UserName, DocType, FileName, File) VALUES ('"+UserName+"','"+typeName2+"','"+fileName2+"','"+file2+"')";
            String query3 = "INSERT INTO admissionuploadsdocuments(UserName, DocType, FileName, File) VALUES ('"+UserName+"','"+typeName3+"','"+fileName3+"','"+file3+"')";
            String query4 = "INSERT INTO admissionuploadsdocuments(UserName, DocType, FileName, File) VALUES ('"+UserName+"','"+typeName4+"','"+fileName4+"','"+file4+"')";
            String query5 = "INSERT INTO admissionuploadsdocuments(UserName, DocType, FileName, File) VALUES ('"+UserName+"','"+typeName5+"','"+fileName5+"','"+file5+"')";
            String query6 = "INSERT INTO admissionuploadsdocuments(UserName, DocType, FileName, File) VALUES ('"+UserName+"','"+typeName6+"','"+fileName6+"','"+file6+"')";
            String query7 = "INSERT INTO admissionuploadsdocuments(UserName, DocType, FileName, File) VALUES ('"+UserName+"','"+typeName7+"','"+fileName7+"','"+file7+"')";
           try{
               JDBCConnection con = new JDBCConnection();
               if(!typeName1.equals("")){
                   con.stmt.executeUpdate(query1);
               }
               if(!typeName2.equals("")){
                   con.stmt.executeUpdate(query2);
               }
               if(!typeName3.equals("")){
                   con.stmt.executeUpdate(query3);
               }
               if(!typeName4.equals("")){
                   con.stmt.executeUpdate(query4);
               }
               if(!typeName5.equals("")){
                   con.stmt.executeUpdate(query5);
               }
               if(!typeName6.equals("")){
                   con.stmt.executeUpdate(query6);
               }
               if(!typeName7.equals("")){
                   con.stmt.executeUpdate(query7);
               }
               
           }
           catch(Exception ae){System.out.println(ae);}
           
        } 
         if(e.getSource() == signout){
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Logout Successfully...");
            new AdmissionPortal().setVisible(true);
        }
        else if(e.getSource() == back){
         setVisible(false);
         new AdmissionCorrespondenceDetails(UserName,"").setVisible(true);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

