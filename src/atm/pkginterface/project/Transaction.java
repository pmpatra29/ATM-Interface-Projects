package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    
    Transaction(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds( 0, 0, 700, 650);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(165, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(135, 300, 125, 20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(265, 300, 125, 20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(135, 330, 125, 20);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(265, 330, 125, 20);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("PIN Change");
        pinChange.setBounds(135, 360, 125, 20);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Know Balance");
        balanceEnquiry.setBounds(265, 360, 125, 20);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 414, 80, 35);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(700, 650);
        setLocation(300, 5);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
        else if(e.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(e.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if(e.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(e.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(e.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(e.getSource() == miniStatement){
            setVisible(false);
            try {
                new MiniStatement(pinNumber).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String...a){
        new Transaction("");
    }
}
