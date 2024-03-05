package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener{
    
    JButton back, change;
    JPasswordField pin1, pin2;
    String pinNumber;

    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds( 0, 0, 700, 650);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(200, 240, 400, 20);
        image.add(text);
        
        JLabel pinText = new JLabel("Enter New PIN:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 14));
        pinText.setBounds(140, 280, 200, 20);
        image.add(pinText);
        
        pin1 = new JPasswordField();
        pin1.setFont(new Font("Raleway", Font.BOLD, 14));
        pin1.setBounds( 275, 280, 80, 25);
        image.add(pin1);
        
        
        JLabel rePinText = new JLabel("Re-enter New PIN:");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 14));
        rePinText.setBounds(140, 320, 200, 20);
        image.add(rePinText);
        
        pin2 = new JPasswordField();
        pin2.setFont(new Font("Raleway", Font.BOLD, 14));
        pin2.setBounds( 275, 320, 80, 25);
        image.add(pin2);
        
        change = new JButton("CHANGE");
        change.setBounds(275, 360, 90, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(180, 360, 80, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700, 650);
        setLocation(300, 5);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change){
            try{
                String nPin = pin1.getText();
                String rPin = pin2.getText();
                
                if(!nPin.equals(rPin)){
                    JOptionPane.showMessageDialog(null, "Both are not matched");
                    return;
                }else if(nPin.length() != 4 || rPin.length() != 4){
                    JOptionPane.showMessageDialog(null, "4 digit pin only allow");
                    return;
                }else if(!checkDigit(rPin) || !checkDigit(nPin)){
                    JOptionPane.showMessageDialog(null, "Only digit allow for pin");
                    return;
                }else{
                
                Conn c = new Conn();
                String query1 = "update bank set pin = '" + rPin +"' where pin = '" + pinNumber + "'";
                String query2 = "update login set pin_number = '" + rPin +"' where pin_number = '" + pinNumber + "'";
                String query3 = "update signupthree set pin_number = '" + rPin +"' where pin_number = '" + pinNumber + "'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rPin).setVisible(true);
                }
                
            }catch(SQLException se){
                System.out.println(se);
            }
        }
        else{
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    
    private static boolean checkDigit(String pin){
        for(int i = 0; i < pin.length(); i++){
            if(!Character.isDigit(pin.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String...a){
        new PinChange("");
    }
    
}
