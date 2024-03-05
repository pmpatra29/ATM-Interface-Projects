package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
    
    JButton back, deposit;
    String pinNumber;
    JTextField amount;
    
    Deposit(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds( 0, 0, 700, 650);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(130, 240, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(190, 280, 150, 25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(270, 330, 100, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(270, 360, 100, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700, 650);
        setLocation(300, 5);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else if(!checkDigit(number)){
                JOptionPane.showMessageDialog(null, "Please enter digit only");
            }else{
                try {
                    
                    Conn c = new Conn();
                    String query = "insert into bank values ('" + pinNumber + "' , '"+date+"','Deposit','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " depositted successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    
    private static boolean checkDigit(String amount){
        for(int i = 0; i < amount.length(); i++){
            if(!Character.isDigit(amount.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String...a){
        new Deposit("");
    }
    
}
