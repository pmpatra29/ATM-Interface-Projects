package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;


public class FastCash extends JFrame implements ActionListener{
    
    JButton hundread, fiveHundread, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pinNumber;
    
    FastCash(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds( 0, 0, 700, 650);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(165, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        hundread = new JButton("Rs 100");
        hundread.setBounds(135, 300, 125, 20);
        hundread.addActionListener(this);
        image.add(hundread);
        
        fiveHundread = new JButton("Rs 500");
        fiveHundread.setBounds(265, 300, 125, 20);
        fiveHundread.addActionListener(this);
        image.add(fiveHundread);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(135, 330, 125, 20);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(265, 330, 125, 20);
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(135, 360, 125, 20);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(265, 360, 125, 20);
        tenThousand.addActionListener(this);
        image.add(tenThousand);
        
        back = new JButton("Back");
        back.setBounds(355, 414, 80, 35);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700, 650);
        setLocation(300, 5);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + pinNumber + "'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else if(rs.getString("type").equals("Withdraw")){
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('" + pinNumber + "', '"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " debited successfully");
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
            catch(SQLException se){
            }
        }
    }
    
    public static void main(String...a){
        new FastCash("");
    }
}
