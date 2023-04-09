
package universitymanagementsystem;

import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Manish Kumar
 */
public class ImageSlide extends JFrame{
    
    JLabel imgSlide;
    Timer tm;
    int x= 0;
    String List[] = {
        "icons/UV1.webp",
        "icons/UV2.webp" 
    };
    ImageSlide(){
        imgSlide = new JLabel();
        imgSlide.setBounds(100, 100, 1200, 500);
        setImageSize(6);
        tm = new Timer(1000, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }    
        });  
        add(imgSlide);


    }
    public void setImageSize(int i){

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(List[i]));
        Image img2 = img.getImage().getScaledInstance(1100, 500, Image.SCALE_SMOOTH);
        ImageIcon newimg = new ImageIcon(img2);
        imgSlide.setIcon(newimg);
        
        
        setSize(850,400);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLocation(100,100);
    }
        
    public static void main(String args[]){
        new ImageSlide();
    }
}
