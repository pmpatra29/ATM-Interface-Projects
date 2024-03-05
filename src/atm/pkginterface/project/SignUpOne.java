package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class SignUpOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, pincodeTextField, stateTextField;
    JButton next;
    JRadioButton male, female, others, married, single, othersMaritial;
    JDateChooser dateChooser;
            
    SignUpOne(){
        
        setLayout(null);    // to perform setBounds function
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L); //compress random number into 4 number only
        
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("RALEWAY", Font.BOLD, 28));
        formNo.setBounds(150, 12, 600, 40);
        add(formNo);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("RALEWAY", Font.BOLD, 20));
        personDetails.setBounds(250, 65, 400, 40);
        add(personDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("RALEWAY", Font.BOLD, 16));
        name.setBounds(100, 130, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        nameTextField.setBounds(300, 130, 300, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("RALEWAY", Font.BOLD, 16));
        fname.setBounds(100, 175, 140, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        fnameTextField.setBounds(300, 175, 300, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("RALEWAY", Font.BOLD, 16));
        dob.setBounds(100, 220, 130, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("ARIAL", Font.BOLD, 14));
        dateChooser.setBounds(300, 220, 300, 30);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("RALEWAY", Font.BOLD, 16));
        gender.setBounds(100, 265, 100, 30);
        add(gender);
        
        //create radio button for male
        male = new JRadioButton("Male");
        male.setBounds(300, 265, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        //create radio button for female
        female = new JRadioButton("Female");
        female.setBounds(400, 265, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        //create radio button for others
        others = new JRadioButton("Others");
        others.setBounds(500, 265, 100, 30);
        others.setBackground(Color.WHITE);
        add(others);
        
        // create gender-group to avoid group value in radio button, after use that we can retirve only one value from that buttongroup
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("RALEWAY", Font.BOLD, 16));
        email.setBounds(100, 310, 140, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        emailTextField.setBounds(300, 310, 300, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("RALEWAY", Font.BOLD, 16));
        marital.setBounds(100, 355, 140, 30);
        add(marital);
        
        //create radio button for unmarried
        single = new JRadioButton("Unmarried");
        single.setBounds(300, 355, 100, 30);
        single.setBackground(Color.WHITE);
        add(single);
        
        //create radio button for married
        married = new JRadioButton("Married");
        married.setBounds(400, 355, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        othersMaritial = new JRadioButton("Other");
        othersMaritial.setBounds(500, 355, 100, 30);
        othersMaritial.setBackground(Color.WHITE);
        add(othersMaritial);
        
        // create marital-group to avoid group value in radio button, after use that we can retirve only one value from that buttongroup
        ButtonGroup maritialGroup = new ButtonGroup();
        maritialGroup.add(married);
        maritialGroup.add(single);
        maritialGroup.add(othersMaritial);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("RALEWAY", Font.BOLD, 16));
        address.setBounds(100, 400, 140, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        addressTextField.setBounds(300, 400, 300, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("RALEWAY", Font.BOLD, 16));
        city.setBounds(100, 445, 140, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        cityTextField.setBounds(300, 445, 300, 30);
        add(cityTextField);
        
        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("RALEWAY", Font.BOLD, 16));
        pincode.setBounds(100, 490, 140, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 490, 300, 30);
        add(pincodeTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("RALEWAY", Font.BOLD, 16));
        state.setBounds(100, 535, 140, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        stateTextField.setBounds(300, 535, 300, 30);
        add(stateTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("RALEWAY", Font.BOLD, 14));
        next.setBounds(500, 590, 100, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);    // set frame background's color
        
        setSize(750, 700);  // set Full Frame Size
        setLocation(280, 2);    // set Frame size's location
        setVisible(true);   // for frame visible
    }
    
    @Override 
    public void actionPerformed(ActionEvent ae){
        String formNo = ""+ random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        else if(others.isSelected()){
            gender = "Others";
        }
        String email = emailTextField.getText();
        String maritialStatus = null;
        if(single.isSelected()){
            maritialStatus = "Single";
        }
        else if(married.isSelected()){
            maritialStatus = "Married";
        }
        else if(othersMaritial.isSelected()){
            maritialStatus = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pincodeTextField.getText();
        String state = stateTextField.getText();
        
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values ('" + formNo + "', '" + name + "','" + fname + "' , '" + dob + "' , '" + gender + "' , '" + email + "' , '" + maritialStatus + "' , '" + address + "' , '" + city + "' , '" + pincode + "' , '" + state + "' )";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
        } catch (HeadlessException | SQLException e) {
        }
    }
    
    public static void main(String...a){
        new SignUpOne();
    }
    
}
