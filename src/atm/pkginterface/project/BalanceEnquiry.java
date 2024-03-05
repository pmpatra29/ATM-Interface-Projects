package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinNumber;
    JButton back;
    
    BalanceEnquiry(String pinNumber){
        
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds( 0, 0, 700, 650);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(270, 360, 100, 25);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + pinNumber + "'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else if(rs.getString("type").equals("Withdraw")){
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(SQLException se){
                        
        }
        
        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(130, 225, 400, 30);
        image.add(text);
                
        
        setSize(700, 650);
        setLocation(300, 5);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pinNumber).setVisible(true);
    }
    
    public static void main(String...a){
        new BalanceEnquiry("");
    }

}
