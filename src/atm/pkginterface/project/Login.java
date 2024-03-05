package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    
    JButton signin, signup, clear;
    JTextField cardNoTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("VeriTech ATM Interface");     // Title Set for Desktop Application
        
        setLayout(null); // to remove Border Layout for ImageIcon set into our recommended location
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // to get ImageIcon from ImageIcon
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  // Using Image class for image size
        ImageIcon i3 = new ImageIcon(i2);   // Converting Image class to ImageIcon class
        JLabel label = new JLabel(i3);  // Image deploy into JLabel
        label.setBounds(70, 10, 100, 100);  // give imageicons location
        add(label); // adding image into frame
        
        JLabel text = new JLabel("Welcome to VeriTech's ATM");  // set title inside frame
        text.setFont(new Font("Osward", Font.BOLD, 38));    // set title's font type with size
        text.setBounds(200, 40, 550, 40);   // give title's location
        add(text);  // adding text inside the frame
        
        //Same thing's for cardNo text 
        JLabel cardNo = new JLabel("Card No : ");  // set cardNo inside frame
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));    // set cardNo's font type with size
        cardNo.setBounds(180, 150, 150, 40);   // give cardNo's location
        add(cardNo);  // adding cardNo text inside the frame
        
        cardNoTextField = new JTextField();
        cardNoTextField.setBounds(350, 160, 200, 30);
        cardNoTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        add(cardNoTextField);
        
        //Same thing's for PIN text 
        JLabel pin = new JLabel("PIN : ");  // set pin inside frame
        pin.setFont(new Font("Raleway", Font.BOLD, 28));    // set pin's font type with size
        pin.setBounds(180, 220, 100, 40);   // give pin's location
        add(pin);  // adding pin text inside the frame
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 230, 200, 30);
        pinTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        add(pinTextField);
        
        signin = new JButton("SIGN IN"); // to create "SIGN IN" button
        signin.setBounds(350, 300, 90, 30); // to set location
        signin.setBackground(Color.BLACK);   // to set button's background color
        signin.setForeground(Color.WHITE);   // to set button's font color
        signin.addActionListener(this);      // get response back after clicking login's button
        add(signin); // add in screen
        
        signup = new JButton("SIGN UP"); // to create "SIGN UP" button
        signup.setBounds(460, 300, 90, 30); // to set location
        signup.setBackground(Color.BLACK);   // to set button's background color
        signup.setForeground(Color.WHITE);   // to set button's font color
        signup.addActionListener(this);     // get response back after clicking signup's button
        add(signup); // add in screen
        
        clear = new JButton("CLEAR"); // to create "CLEAR" button
        clear.setBounds(350, 350, 200, 30); // to set location
        clear.setBackground(Color.BLACK);   // to set clear's background color
        clear.setForeground(Color.WHITE);   // to set clear's font color
        clear.addActionListener(this);      // get response back after clicking clear's button
        add(clear); // add in screen
        
        
        
        getContentPane().setBackground(Color.WHITE); // set full frame background color
        
        setSize(750, 480);  // to set Frame Size
        setVisible(true);   // to visible frame in desktop
        setLocation(250, 100);  // to set location into desktop location
    }
    
    @Override 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardNoTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == signin){
            Conn c = new Conn();
            String cardNumber = cardNoTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "SELECT * FROM login WHERE card_number = '" + cardNumber + "' AND pin_number = '" + pinNumber + "'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Card No and Pin Number...");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    
    
    public static void main(String[] args) {
        new Login();
    }
    
}
