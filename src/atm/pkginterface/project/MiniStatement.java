package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JButton;

public class MiniStatement extends JFrame implements ActionListener{
    String pinNumber;
    
    JButton cancel;
    
    MiniStatement(String pinNumber) throws SQLException {
        this.pinNumber = pinNumber;
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 100, 600, 400);
        add(mini);
        
        JLabel bank = new JLabel("VeriTech Bank");
        bank.setBounds(150, 20, 100, 25);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        try{
            Conn c = new Conn();
            String query = "Select * from login where pin_number = '" + pinNumber + "'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                card.setText("Card Number:       " + rs.getString("card_number").substring(0, 4) + " - XXXX - XXXX - " + rs.getString("card_number").substring(12));
            }
        }catch(SQLException se){
            
        }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + pinNumber + "' order by date desc");
            int statementCount = 10;
            while(rs.next() && statementCount >= 0){
                statementCount--;
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
        }
        }catch(SQLException se){
            se.addSuppressed(se);
        }
        
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
        
        JLabel balanceDisplay = new JLabel("Available Balance:  " + balance);
        balanceDisplay.setFont(new Font("System", Font.BOLD, 14));
        balanceDisplay.setBounds(20, 480, 200, 20);
        add(balanceDisplay);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(240, 505, 110, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(400, 600);
        setLocation(450, 35);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
    public static void main(String... a) throws SQLException {
        new MiniStatement("");
    }
    
}
