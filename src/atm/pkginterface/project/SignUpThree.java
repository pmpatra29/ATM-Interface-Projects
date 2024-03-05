package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton savingAccount, currentAccount, fixedDepositAccount, recuuringDepositAccount;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatement, declaration;
    JButton submit, cancel;
    String formNo = "";

    SignUpThree(String formNo) {
        
        setLayout(null);
        
        this.formNo = formNo;
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("RALEWAY", Font.BOLD, 20));
        l1.setBounds(240, 40, 400, 40);
        add(l1);
        
        JLabel accountType = new JLabel("Account Type ");
        accountType.setFont(new Font("RALEWAY", Font.BOLD, 16));
        accountType.setBounds(120, 100, 150, 40);
        add(accountType);
        
        savingAccount = new JRadioButton("Saving Account ");
        savingAccount.setFont(new Font("RALEWAY", Font.BOLD, 12));
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(120, 140, 150, 20);
        add(savingAccount);
        
        fixedDepositAccount = new JRadioButton("Fixed Deposit Account ");
        fixedDepositAccount.setFont(new Font("RALEWAY", Font.BOLD, 12));
        fixedDepositAccount.setBackground(Color.WHITE);
        fixedDepositAccount.setBounds(350, 140, 250, 20);
        add(fixedDepositAccount);
        
        currentAccount = new JRadioButton("Current Account ");
        currentAccount.setFont(new Font("RALEWAY", Font.BOLD, 12));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(120, 180, 150, 20);
        add(currentAccount);
        
        recuuringDepositAccount = new JRadioButton("Reccurring Deposit Account ");
        recuuringDepositAccount.setFont(new Font("RALEWAY", Font.BOLD, 12));
        recuuringDepositAccount.setBackground(Color.WHITE);
        recuuringDepositAccount.setBounds(350, 180, 250, 20);
        add(recuuringDepositAccount);
        
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingAccount);
        accountTypeGroup.add(fixedDepositAccount);
        accountTypeGroup.add(currentAccount);
        accountTypeGroup.add(recuuringDepositAccount);
        
        JLabel card = new JLabel("Card Number ");
        card.setFont(new Font("RALEWAY", Font.BOLD, 16));
        card.setBounds(120, 230, 150, 40);
        add(card);
        
        JLabel cardNumberDemo = new JLabel("XXXX-XXXX-XXXX-4184 ");
        cardNumberDemo.setFont(new Font("RALEWAY", Font.BOLD, 16));
        cardNumberDemo.setBounds(320, 230, 250, 40);
        cardNumberDemo.setBackground(Color.WHITE);
        add(cardNumberDemo);
        
        JLabel cardNumberMsg = new JLabel("Your 16 Digit Card Number ");
        cardNumberMsg.setFont(new Font("RALEWAY", Font.BOLD, 10));
        cardNumberMsg.setBounds(120, 250, 250, 40);
        cardNumberMsg.setBackground(Color.WHITE);
        add(cardNumberMsg);
        
        JLabel pinHeading = new JLabel("PIN: ");
        pinHeading.setFont(new Font("RALEWAY", Font.BOLD, 16));
        pinHeading.setBounds(120, 290, 150, 40);
        add(pinHeading);
        
        JLabel pinNumberDemo = new JLabel("XXXX ");
        pinNumberDemo.setFont(new Font("RALEWAY", Font.BOLD, 16));
        pinNumberDemo.setBounds(320, 290, 100, 40);
        pinNumberDemo.setBackground(Color.WHITE);
        add(pinNumberDemo);
        
        JLabel pinNumberMsg = new JLabel("Your 4 Digit Password ");
        pinNumberMsg.setFont(new Font("RALEWAY", Font.BOLD, 10));
        pinNumberMsg.setBounds(120, 310, 200, 40);
        pinNumberMsg.setBackground(Color.WHITE);
        add(pinNumberMsg);
        
        JLabel serviceReqired = new JLabel("Services Required: ");
        serviceReqired.setFont(new Font("RALEWAY", Font.BOLD, 16));
        serviceReqired.setBounds(120, 360, 250, 40);
        add(serviceReqired);
        
        atmCard = new JCheckBox("ATM Card ");
        atmCard.setFont(new Font("RALEWAY", Font.BOLD, 12));
        atmCard.setBackground(Color.WHITE);
        atmCard.setBounds(120, 410, 250, 20);
        add(atmCard);
        
        internetBanking = new JCheckBox("Internet Banking ");
        internetBanking.setFont(new Font("RALEWAY", Font.BOLD, 12));
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setBounds(370, 410, 250, 20);
        add(internetBanking);
        
        mobileBanking = new JCheckBox("Mobile Banking ");
        mobileBanking.setFont(new Font("RALEWAY", Font.BOLD, 12));
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setBounds(120, 450, 250, 20);
        add(mobileBanking);
        
        emailAlerts = new JCheckBox("Email & SMS Alerts ");
        emailAlerts.setFont(new Font("RALEWAY", Font.BOLD, 12));
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setBounds(370, 450, 250, 20);
        add(emailAlerts);
        
        chequeBook = new JCheckBox("Cheque Book ");
        chequeBook.setFont(new Font("RALEWAY", Font.BOLD, 12));
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setBounds(120, 490, 250, 20);
        add(chequeBook);
        
        eStatement = new JCheckBox("E-Statements ");
        eStatement.setFont(new Font("RALEWAY", Font.BOLD, 12));
        eStatement.setBackground(Color.WHITE);
        eStatement.setBounds(370, 490, 250, 20);
        add(eStatement);
        
        declaration = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge. ");
        declaration.setFont(new Font("RALEWAY", Font.BOLD, 12));
        declaration.setBackground(Color.WHITE);
        declaration.setBounds(120, 550, 540, 20);
        add(declaration);
        
        cancel = new JButton("Cancel ");
        cancel.setFont(new Font("RALEWAY", Font.BOLD, 16));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200, 590, 100, 40);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("Submit ");
        submit.setFont(new Font("RALEWAY", Font.BOLD, 16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(400, 590, 100, 40);
        submit.addActionListener(this);
        add(submit);

        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750, 700);  
        setLocation(280, 2);    
        setVisible(true); 
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(declaration.isSelected()){
            if(ae.getSource() == submit){
                String accountType = null;
                if(savingAccount.isSelected()){
                    accountType = "Saving Account";
                }else if(currentAccount.isSelected()){
                    accountType = "Current Account";
                }else if(fixedDepositAccount.isSelected()){
                    accountType = "Fixed Deposit Account";
                }else if(recuuringDepositAccount.isSelected()){
                    accountType = "Reccurring Deposit Account";
                }
                Random random = new Random();
                String cardNumber = "" + Math.abs((random.nextLong() % 90000000L)) + 5040936000000000L;
                cardNumber = cardNumber.substring(0,16);
            
                String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
                String services = "";
                if(atmCard.isSelected()){
                    services += "ATM Card, ";
                }if(internetBanking.isSelected()){
                    services += "Internet Banking, ";
                }if(mobileBanking.isSelected()){
                    services += "Mobile Banking, ";
                }if(emailAlerts.isSelected()){
                    services += "Emails and SMS Alerts, ";
                }if(chequeBook.isSelected()){
                    services += "Cheque Book, ";
                }if(eStatement.isSelected()){
                    services += "E-Statements, ";
                }
                services = services.substring(0, services.length()-2);
                
                try{
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('" + formNo + "','" + accountType + "','" + cardNumber + "', '" + pinNumber + "', '" + services+"')";
                    String query2 = "insert into login values ('" + formNo + "','" + cardNumber + "', '" + pinNumber + "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPin: " + pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
                catch(HeadlessException | SQLException e){
                }
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String... a){
        new SignUpThree("");
    }
    
}
