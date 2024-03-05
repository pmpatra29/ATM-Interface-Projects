package atm.pkginterface.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SignUpTwo extends JFrame implements ActionListener{
    
    JTextField aadharNoTextField, panNoTextField;
    JComboBox religionBox, categoryBox, incomeBox, qualificationBox, occupationBox;
    JButton next;
    JRadioButton noExisting, yesExisting, yesSenior, noSenior;
    String formNo;
            
    SignUpTwo(String formNo){
        
        this.formNo = formNo;
        
        setLayout(null);    // to perform setBounds function
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("RALEWAY", Font.BOLD, 20));
        additionalDetails.setBounds(250, 40, 400, 40);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("RALEWAY", Font.BOLD, 16));
        religion.setBounds(100, 130, 100, 30);
        add(religion);
        
        String [] religionVal = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox(religionVal);
        religionBox.setBounds(300, 130, 300, 30);
        religionBox.setBackground(Color.WHITE);
        religionBox.setForeground(Color.BLACK);
        add(religionBox);
        
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("RALEWAY", Font.BOLD, 16));
        category.setBounds(100, 175, 140, 30);
        add(category);
        
        String [] categoryVal = {"General", "OBC", "ST", "SC", "Other"};
        categoryBox = new JComboBox(categoryVal);
        categoryBox.setBounds(300, 175, 300, 30);
        categoryBox.setBackground(Color.WHITE);
        categoryBox.setForeground(Color.BLACK);
        add(categoryBox);
        
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("RALEWAY", Font.BOLD, 16));
        income.setBounds(100, 220, 130, 30);
        add(income);

        String [] incomeVal = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "> 5,00,000"};
        incomeBox = new JComboBox(incomeVal);
        incomeBox.setBounds(300, 220, 300, 30);
        incomeBox.setBackground(Color.WHITE);
        incomeBox.setForeground(Color.BLACK);
        add(incomeBox);
        
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("RALEWAY", Font.BOLD, 16));
        educational.setBounds(100, 265, 100, 30);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("RALEWAY", Font.BOLD, 16));
        qualification.setBounds(100, 285, 130, 30);
        add(qualification);
        
        String [] qualificationVal = {"Non-Graduated", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        qualificationBox = new JComboBox(qualificationVal);
        qualificationBox.setBounds(300, 280, 300, 30);
        qualificationBox.setBackground(Color.WHITE);
        qualificationBox.setForeground(Color.BLACK);
        add(qualificationBox);
        
        
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("RALEWAY", Font.BOLD, 16));
        occupation.setBounds(100, 330, 140, 30);
        add(occupation);
        
        String [] occupationalVal = {"Salaried", "Self-Employed", "Student", "Bussiness", "Retired", "Others"};
        occupationBox = new JComboBox(occupationalVal);
        occupationBox.setBounds(300, 280, 300, 30);
        occupationBox.setBackground(Color.WHITE);
        occupationBox.setForeground(Color.BLACK);
        add(occupationBox);
        occupationBox.setBounds(300, 330, 300, 30);
        add(occupationBox);
        
        JLabel panNo = new JLabel("PAN No: ");
        panNo.setFont(new Font("RALEWAY", Font.BOLD, 16));
        panNo.setBounds(100, 375, 140, 30);
        add(panNo);

        panNoTextField = new JTextField();
        panNoTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        panNoTextField.setBounds(300, 375, 300, 30);
        add(panNoTextField);
        
        
        JLabel aadharNo = new JLabel("Aadhar No: ");
        aadharNo.setFont(new Font("RALEWAY", Font.BOLD, 16));
        aadharNo.setBounds(100, 420, 140, 30);
        add(aadharNo);
        
        aadharNoTextField = new JTextField();
        aadharNoTextField.setFont(new Font("ARIAL", Font.BOLD, 14));
        aadharNoTextField.setBounds(300, 420, 300, 30);
        add(aadharNoTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("RALEWAY", Font.BOLD, 16));
        seniorCitizen.setBounds(100, 470, 140, 30);
        add(seniorCitizen);
        
        yesSenior = new JRadioButton("Yes");
        yesSenior.setBounds(300, 470, 100, 30);
        yesSenior.setBackground(Color.WHITE);
        add(yesSenior);
        
        noSenior = new JRadioButton("No");
        noSenior.setBounds(400, 470, 100, 30);
        noSenior.setBackground(Color.WHITE);
        add(noSenior);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(yesSenior);
        seniorGroup.add(noSenior);
        
        
        JLabel existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("RALEWAY", Font.BOLD, 16));
        existingAccount.setBounds(100, 515, 250, 30);
        add(existingAccount);
        
        yesExisting = new JRadioButton("Yes");
        yesExisting.setBounds(300, 515, 100, 30);
        yesExisting.setBackground(Color.WHITE);
        add(yesExisting);
        
        noExisting = new JRadioButton("No");
        noExisting.setBounds(400, 515, 100, 30);
        noExisting.setBackground(Color.WHITE);
        add(noExisting);
        
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(yesExisting);
        existingGroup.add(noExisting);
        
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
        String sReligion = (String)religionBox.getSelectedItem();
        String sCategory = (String)categoryBox.getSelectedItem();
        String sIncome = (String)incomeBox.getSelectedItem();
        String sQualification = (String) qualificationBox.getSelectedItem();
        String sOccupation = (String) occupationBox.getSelectedItem();
        String sPanNo = panNoTextField.getText();
        String sAadharNo = aadharNoTextField.getText();
        String sSeniorCitizen = null;
        if(yesSenior.isSelected()){
            sSeniorCitizen = "Yes";
        }
        else if(noSenior.isSelected()){
            sSeniorCitizen = "No";
        }
        String sExistingAccount = null;
        if(yesExisting.isSelected()){
            sExistingAccount = "Yes";
        }
        else if(noExisting.isSelected()){
            sExistingAccount = "No";
        }
        
        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values ('" + formNo + "', '" + sReligion + "','" + sCategory + "' , '" + sIncome + "' , '" + sQualification + "' , '" + sOccupation + "' , '" + sPanNo + "' , '" + sAadharNo + "' , '" + sSeniorCitizen + "' , '" + sExistingAccount + "' )";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignUpThree(formNo).setVisible(true);
        } catch (HeadlessException | SQLException e) {
                
        }
    }
    
    public static void main(String...a){
        new SignUpTwo("");
    }
}
