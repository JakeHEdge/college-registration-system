package Enrolment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AddStudentDetails {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JTextField txtsurname;
	private JTextField txtdateofbirth;
	private JTextField txtforename;
	private JTextField txtnationalinsurance;
	private JButton btnback;
	private JButton btnsave;
	private JTextField txtidseen;
	private JTextField txtsex;
	private JLabel lblsurname;
	private JTextField txtnationality;
	private JLabel lblnationality;
	private JTextField txtemergencycontactinformation;
	private JLabel lblemergencycontactinformation;
	private JTextField txtethnicity;
	private JLabel lblethnicity;
	private JTextField txtemailaddress;
	private JLabel lblemailaddress;
	private JTextField txtnextofkin;
	private JLabel lblnextofkin;
	private JLabel lblnextofkinaddress;
	private JTextField txtnextofkinaddress;
	private JTextField txtnextofkinphonenumber;
	private JLabel lblnextofkinphonenumber;
	private JTextField txtnextofkinrelationship;
	private JLabel lblnextofkinrelationship;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentDetails window = new AddStudentDetails();
					window.frmEnrolmentSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddStudentDetails() {
		initialize();
		System.out.println("AddStudentDetails");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(AddStudentDetails.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 440, 513);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(AddStudentDetails.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lbladdstudentdetails = new JLabel("Add Student Details");
		lbladdstudentdetails.setForeground(new Color(142, 69, 133));
		lbladdstudentdetails.setFont(new Font("Corbel", Font.PLAIN, 37));
		lbladdstudentdetails.setBackground(new Color(255, 128, 255));
		lbladdstudentdetails.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lbladdstudentdetails);
		
		txtsurname = new JTextField();
		txtsurname.setColumns(10);
		txtsurname.setBounds(27, 86, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtsurname);
		
		txtdateofbirth = new JTextField();
		txtdateofbirth.setColumns(10);
		txtdateofbirth.setBounds(26, 166, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtdateofbirth);
		
		txtforename = new JTextField();
		txtforename.setColumns(10);
		txtforename.setBounds(27, 126, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtforename);
		
		txtnationalinsurance = new JTextField();
		txtnationalinsurance.setColumns(10);
		txtnationalinsurance.setBounds(26, 202, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnationalinsurance);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffHomePage.main(null);
				StaffHomePage.StaffID = StaffID;
			}
		});
		btnback.setBounds(359, 423, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		btnsave = new JButton("Save");
		btnsave.setBackground(new Color(255, 255, 255));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentDetails();
			}
			
		});
		btnsave.setBounds(283, 423, 69, 21);
		frmEnrolmentSystem.getContentPane().add(btnsave);
		
		txtidseen = new JTextField();
		txtidseen.setColumns(10);
		txtidseen.setBounds(27, 272, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtidseen);
		
		txtsex = new JTextField();
		txtsex.setColumns(10);
		txtsex.setBounds(27, 238, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtsex);
		
		lblsurname = new JLabel("Surname");
		lblsurname.setBackground(new Color(255, 255, 255));
		lblsurname.setForeground(new Color(255, 255, 255));
		lblsurname.setBounds(26, 70, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblsurname);
		
		JLabel lblforename = new JLabel("Forename");
		lblforename.setBackground(new Color(255, 255, 255));
		lblforename.setForeground(new Color(255, 255, 255));
		lblforename.setBounds(26, 103, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblforename);
		
		JLabel lbldob = new JLabel("Date_Of_Birth");
		lbldob.setBackground(new Color(255, 255, 255));
		lbldob.setForeground(new Color(255, 255, 255));
		lbldob.setBounds(26, 143, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lbldob);
		
		JLabel lblnationalinsurance = new JLabel("National Insurance");
		lblnationalinsurance.setBackground(new Color(255, 255, 255));
		lblnationalinsurance.setForeground(new Color(255, 255, 255));
		lblnationalinsurance.setBounds(26, 188, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnationalinsurance);
		
		JLabel lblsex = new JLabel("Sex");
		lblsex.setBackground(new Color(255, 255, 255));
		lblsex.setForeground(new Color(255, 255, 255));
		lblsex.setBounds(27, 223, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblsex);
		
		JLabel lblidseen = new JLabel("ID_Seen");
		lblidseen.setBackground(new Color(255, 255, 255));
		lblidseen.setForeground(new Color(255, 255, 255));
		lblidseen.setBounds(27, 259, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblidseen); 
		
		txtnationality = new JTextField();
		txtnationality.setColumns(10);
		txtnationality.setBounds(27, 314, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnationality);
		
		lblnationality = new JLabel("Nationality");
		lblnationality.setBackground(new Color(255, 255, 255));
		lblnationality.setForeground(new Color(255, 255, 255));
		lblnationality.setBounds(27, 299, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnationality);
		
		txtemergencycontactinformation = new JTextField();
		txtemergencycontactinformation.setColumns(10);
		txtemergencycontactinformation.setBounds(27, 352, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtemergencycontactinformation);
		
		lblemergencycontactinformation = new JLabel("Emergency_Contact_Information");
		lblemergencycontactinformation.setBackground(new Color(255, 255, 255));
		lblemergencycontactinformation.setForeground(new Color(255, 255, 255));
		lblemergencycontactinformation.setBounds(27, 337, 192, 13);
		frmEnrolmentSystem.getContentPane().add(lblemergencycontactinformation);
		
		txtethnicity = new JTextField();
		txtethnicity.setColumns(10);
		txtethnicity.setBounds(27, 388, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtethnicity);
		
		lblethnicity = new JLabel("Ethnicity");
		lblethnicity.setBackground(new Color(255, 255, 255));
		lblethnicity.setForeground(new Color(255, 255, 255));
		lblethnicity.setBounds(27, 373, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblethnicity);
		
		txtemailaddress = new JTextField();
		txtemailaddress.setColumns(10);
		txtemailaddress.setBounds(27, 424, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtemailaddress);
		
		lblemailaddress = new JLabel("Email_Address");
		lblemailaddress.setBackground(new Color(255, 255, 255));
		lblemailaddress.setForeground(new Color(255, 255, 255));
		lblemailaddress.setBounds(27, 409, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblemailaddress);
		
		txtnextofkin = new JTextField();
		txtnextofkin.setColumns(10);
		txtnextofkin.setBounds(229, 86, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkin);
		
		lblnextofkin = new JLabel("Next_Of_Kin");
		lblnextofkin.setBackground(new Color(255, 255, 255));
		lblnextofkin.setForeground(new Color(255, 255, 255));
		lblnextofkin.setBounds(229, 73, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkin);
		
		lblnextofkinaddress = new JLabel("Next_Of_Kin_Address");
		lblnextofkinaddress.setBackground(new Color(255, 255, 255));
		lblnextofkinaddress.setForeground(new Color(255, 255, 255));
		lblnextofkinaddress.setBounds(229, 113, 166, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinaddress);
		
		txtnextofkinaddress = new JTextField();
		txtnextofkinaddress.setColumns(10);
		txtnextofkinaddress.setBounds(229, 128, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinaddress);
		
		txtnextofkinphonenumber = new JTextField();
		txtnextofkinphonenumber.setColumns(10);
		txtnextofkinphonenumber.setBounds(229, 166, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinphonenumber);
		
		lblnextofkinphonenumber = new JLabel("Next_Of_Kin_Phone_Number");
		lblnextofkinphonenumber.setBackground(new Color(255, 255, 255));
		lblnextofkinphonenumber.setForeground(new Color(255, 255, 255));
		lblnextofkinphonenumber.setBounds(229, 151, 210, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinphonenumber);
		
		txtnextofkinrelationship = new JTextField();
		txtnextofkinrelationship.setColumns(10);
		txtnextofkinrelationship.setBounds(229, 202, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinrelationship);
		
		lblnextofkinrelationship = new JLabel("Next_Of_Kin_Relationship");
		lblnextofkinrelationship.setBackground(new Color(255, 255, 255));
		lblnextofkinrelationship.setForeground(new Color(255, 255, 255));
		lblnextofkinrelationship.setBounds(229, 187, 210, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinrelationship);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddStudentDetails.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, 0, 790, 476);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);}
	
		public void AddStudentDetails() { 
			java.sql.Connection conn = null;
			try {
	//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

	if(conn !=null)

	//if connected print connected to database System.out.println("Connected to database");
	System.out.println("Connected to Student Add Page");
	
	String SQLinsert;
	if		(txtsurname.getText().trim().isEmpty()
			|| txtforename.getText().trim().isEmpty()
		    || txtdateofbirth.getText().trim().isEmpty()
		    || txtnationalinsurance.getText().trim().isEmpty()
		    || txtsex.getText().trim().isEmpty()
		    || txtidseen.getText().trim().isEmpty()
		    || txtnationality.getText().trim().isEmpty()
			|| txtemergencycontactinformation.getText().trim().isEmpty()
			|| txtethnicity.getText().trim().isEmpty()
			|| txtemailaddress.getText().trim().isEmpty()
			|| txtnextofkin.getText().trim().isEmpty()
	    	|| txtnextofkinaddress.getText().trim().isEmpty()
	    	|| txtnextofkinphonenumber.getText().trim().isEmpty()
	    	|| txtnextofkinrelationship.getText().trim().isEmpty())
	{
	//This code opens a dialog box that says Please include all required fields!!!.
		JOptionPane.showMessageDialog(null, "Please include all required fields!!!");
	}
		else
			Emailvalidation();
		//This piece of code inputs the information into the database.
  try {		SQLinsert = "INSERT into tbl_applications values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement s = conn.prepareStatement(SQLinsert);
			s.setString(1, txtsurname.getText());
			s.setString(2, txtforename.getText());
			s.setString(3, txtdateofbirth.getText());
			s.setString(4, txtnationalinsurance.getText());
			s.setString(5, txtsex.getText());
			s.setString(6, txtidseen.getText());
			s.setString(7, txtnationality.getText());
			s.setString(8, txtemergencycontactinformation.getText());
			s.setString(9, txtethnicity.getText());
			s.setString(10, txtemailaddress.getText());
			s.setString(11, txtnextofkin.getText());
			s.setString(12, txtnextofkinaddress.getText());
			s.setString(13, txtnextofkinphonenumber.getText());
			s.setString(14, txtnextofkinrelationship.getText());
			s.execute();
		
			//This code opens a dialog box that says that the information is "saved".
			JOptionPane.showMessageDialog(null, "saved");
			
			String SQLFindID = "SELECT * FROM tbl_applications WHERE Email_Address='" +txtemailaddress.getText() +"'";
			PreparedStatement ps=conn.prepareStatement(SQLFindID);
			//This piece of code executes it
			ResultSet rs=ps.executeQuery();
			
			//This piece of code displays information from the database
		while(rs.next()){
			//String ID = ;
			JOptionPane.showMessageDialog(null, "Application for " + rs.getString("Forename") + " is "+ rs.getString("ApplicationsID"));
		}
			
			
			//This code takes the user to the home page.
			StaffHomePage.main(null);
			
			s.close();
			
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Not saved to database: error:" +e);
			}

} 
catch (Exception ex)
{
	
System.out.println("Not connected to Add Student Page");

	ex.printStackTrace();}
}

		public void Emailvalidation() {
			
		//check email address format
			
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\. "+
				"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		
		
		Pattern pattern = Pattern.compile(emailRegex);
		if(pattern.matcher(txtemailaddress.getText()). matches ()) { 
			
		System.out.print("Valid email address");

		} else {
		
		//if save has not been successful, display a pop up box saying "Invalid e-mail"
		
		JOptionPane.showMessageDialog(null, "Invalid e-mail"); }	
 }
}