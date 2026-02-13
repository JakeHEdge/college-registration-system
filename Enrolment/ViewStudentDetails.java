package Enrolment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ViewStudentDetails {
	public static String StaffID = null;
	public static String ApplicationID = null;
	private JFrame frmEnrolmentSystem;
	private JButton btnback;
	private JButton btnsearch;
	private JTextField txtapplicationsid;
	private JTable tblstudentcourses;
	private JTable tblstudentqualifications;
	private JTable tblstudentlearningsupport;

	//This piece of code displays the date and time.
			SimpleDateFormat  formatter = new SimpleDateFormat ("dd/MM/yyyy");
			Date date = new Date(0);
			private JTextField txtemailaddress;
			private JTextField txtethnicity;
			private JTextField txtemergencycontactinformation;
			private JTextField txtnationality;
			private JTextField txtidseen;
			private JTextField txtsex;
			private JTextField txtnationalinsurance;
			private JTextField txtdateofbirth;
			private JTextField txtforename;
			private JTextField txtnextofkin;
			private JTextField txtnextofkinaddress;
			private JTextField txtnextofkinphonenumber;
			private JTextField txtnextofkinrelationship;
			private JTextField txtsurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudentDetails window = new ViewStudentDetails();
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
	
		
		public ViewStudentDetails() {
			initialize();
			System.out.println("ViewStudentDetails");
			
			

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewStudentDetails.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 933, 552);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(ViewStudentDetails.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lblstudentdetails = new JLabel("View Student Details");
		lblstudentdetails.setForeground(new Color(142, 69, 133));
		lblstudentdetails.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblstudentdetails.setBackground(new Color(255, 128, 255));
		lblstudentdetails.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lblstudentdetails);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffHomePage.main(null);
				StaffHomePage.StaffID = StaffID;
			}
		});
		btnback.setBounds(514, 80, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		new JTable();
		
		btnsearch = new JButton("Search");
		btnsearch.setBackground(new Color(255, 255, 255));
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentDetails();
				ViewStudentCourses();
				ViewStudentQualifications();
				ViewStudentLearningSupport();
			}
		});
		btnsearch.setBounds(514, 58, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btnsearch);
		
		JLabel lblstudentcourses = new JLabel("Student_Courses:");
		lblstudentcourses.setForeground(new Color(255, 255, 255));
		lblstudentcourses.setBounds(296, 274, 614, 13);
		frmEnrolmentSystem.getContentPane().add(lblstudentcourses);
		
		JLabel lblqualifications = new JLabel("Qualifications:");
		lblqualifications.setForeground(new Color(255, 255, 255));
		lblqualifications.setBounds(296, 354, 618, 13);
		frmEnrolmentSystem.getContentPane().add(lblqualifications);
		
		JLabel lblsupportneeds = new JLabel("Support Needs:");
		lblsupportneeds.setForeground(new Color(255, 255, 255));
		lblsupportneeds.setBounds(296, 437, 614, 13);
		frmEnrolmentSystem.getContentPane().add(lblsupportneeds);
		
		JButton btnaddstudentcourses = new JButton("Add");
		btnaddstudentcourses.setBackground(new Color(255, 255, 255));
		btnaddstudentcourses.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				AddStudentCourses.main(null);
				AddStudentCourses.StaffID = StaffID;
				AddStudentCourses.ApplicationID = ApplicationID;
			
			
			}
		});
		btnaddstudentcourses.setBounds(808, 276, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btnaddstudentcourses);
		
		JButton btnaddqualifications = new JButton("Add");
		btnaddqualifications.setBackground(new Color(255, 255, 255));
		btnaddqualifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQualifications.main(null);
				AddQualifications.StaffID = StaffID;
				AddQualifications.ApplicationID = ApplicationID;
			}
		});
		btnaddqualifications.setBounds(808, 350, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btnaddqualifications);
		
		JButton btnaddsupportneeds = new JButton("Add");
		btnaddsupportneeds.setBackground(new Color(255, 255, 255));
		btnaddsupportneeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLearningSupport.main(null);
				AddLearningSupport.StaffID = StaffID;
				AddLearningSupport.ApplicationID = ApplicationID;
			}
		});
		btnaddsupportneeds.setBounds(808, 432, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btnaddsupportneeds);
		
		txtapplicationsid = new JTextField();
		txtapplicationsid.setColumns(10);
		txtapplicationsid.setBounds(74, 75, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtapplicationsid);
		
		JLabel lblapplicationsid = new JLabel("Applications_ID");
		lblapplicationsid.setForeground(new Color(255, 255, 255));
		lblapplicationsid.setBounds(74, 59, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblapplicationsid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(296, 297, 614, 56);
		frmEnrolmentSystem.getContentPane().add(scrollPane);
		
		tblstudentcourses = new JTable();
		scrollPane.setViewportView(tblstudentcourses);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(297, 377, 613, 56);
		frmEnrolmentSystem.getContentPane().add(scrollPane_1);
		
		tblstudentqualifications = new JTable();
		scrollPane_1.setViewportView(tblstudentqualifications);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(296, 455, 614, 56);
		frmEnrolmentSystem.getContentPane().add(scrollPane_2);
		
		tblstudentlearningsupport = new JTable();
		scrollPane_2.setViewportView(tblstudentlearningsupport);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.setBackground(new Color(255, 255, 255));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudentDetails();
				
			}
		});
		btnupdate.setBounds(514, 101, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btnupdate);
		
		txtemailaddress = new JTextField();
		txtemailaddress.setColumns(10);
		txtemailaddress.setBounds(276, 75, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtemailaddress);
		
		JLabel lblemailaddress = new JLabel("Email_Address");
		lblemailaddress.setForeground(Color.WHITE);
		lblemailaddress.setBackground(Color.WHITE);
		lblemailaddress.setBounds(276, 60, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblemailaddress);
		
		txtethnicity = new JTextField();
		txtethnicity.setColumns(10);
		txtethnicity.setBounds(74, 414, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtethnicity);
		
		JLabel lblethnicity = new JLabel("Ethnicity");
		lblethnicity.setForeground(Color.WHITE);
		lblethnicity.setBackground(Color.WHITE);
		lblethnicity.setBounds(74, 399, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblethnicity);
		
		txtemergencycontactinformation = new JTextField();
		txtemergencycontactinformation.setColumns(10);
		txtemergencycontactinformation.setBounds(74, 378, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtemergencycontactinformation);
		
		JLabel lblemergencycontactinformation = new JLabel("Emergency_Contact_Information");
		lblemergencycontactinformation.setForeground(Color.WHITE);
		lblemergencycontactinformation.setBackground(Color.WHITE);
		lblemergencycontactinformation.setBounds(74, 363, 192, 13);
		frmEnrolmentSystem.getContentPane().add(lblemergencycontactinformation);
		
		txtnationality = new JTextField();
		txtnationality.setColumns(10);
		txtnationality.setBounds(74, 340, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnationality);
		
		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setForeground(Color.WHITE);
		lblnationality.setBackground(Color.WHITE);
		lblnationality.setBounds(74, 325, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnationality);
		
		txtidseen = new JTextField();
		txtidseen.setColumns(10);
		txtidseen.setBounds(74, 298, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtidseen);
		
		JLabel lblidseen = new JLabel("ID_Seen");
		lblidseen.setForeground(Color.WHITE);
		lblidseen.setBackground(Color.WHITE);
		lblidseen.setBounds(74, 285, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblidseen);
		
		txtsex = new JTextField();
		txtsex.setColumns(10);
		txtsex.setBounds(74, 264, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtsex);
		
		JLabel lblsex = new JLabel("Sex");
		lblsex.setForeground(Color.WHITE);
		lblsex.setBackground(Color.WHITE);
		lblsex.setBounds(74, 249, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblsex);
		
		txtnationalinsurance = new JTextField();
		txtnationalinsurance.setColumns(10);
		txtnationalinsurance.setBounds(74, 228, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnationalinsurance);
		
		JLabel lblnationalinsurance = new JLabel("National Insurance");
		lblnationalinsurance.setForeground(Color.WHITE);
		lblnationalinsurance.setBackground(Color.WHITE);
		lblnationalinsurance.setBounds(74, 214, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnationalinsurance);
		
		txtdateofbirth = new JTextField();
		txtdateofbirth.setColumns(10);
		txtdateofbirth.setBounds(74, 192, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtdateofbirth);
		
		JLabel lbldob = new JLabel("Date_Of_Birth");
		lbldob.setForeground(Color.WHITE);
		lbldob.setBackground(Color.WHITE);
		lbldob.setBounds(74, 169, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lbldob);
		
		txtforename = new JTextField();
		txtforename.setColumns(10);
		txtforename.setBounds(75, 152, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtforename);
		
		JLabel lblforename = new JLabel("Forename");
		lblforename.setForeground(Color.WHITE);
		lblforename.setBackground(Color.WHITE);
		lblforename.setBounds(74, 137, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblforename);
		
		JLabel lblnextofkin = new JLabel("Next_Of_Kin");
		lblnextofkin.setForeground(Color.WHITE);
		lblnextofkin.setBackground(Color.WHITE);
		lblnextofkin.setBounds(278, 96, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkin);
		
		txtnextofkin = new JTextField();
		txtnextofkin.setColumns(10);
		txtnextofkin.setBounds(278, 109, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkin);
		
		JLabel lblnextofkinaddress = new JLabel("Next_Of_Kin_Address");
		lblnextofkinaddress.setForeground(Color.WHITE);
		lblnextofkinaddress.setBackground(Color.WHITE);
		lblnextofkinaddress.setBounds(278, 136, 166, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinaddress);
		
		txtnextofkinaddress = new JTextField();
		txtnextofkinaddress.setColumns(10);
		txtnextofkinaddress.setBounds(278, 151, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinaddress);
		
		JLabel lblnextofkinphonenumber = new JLabel("Next_Of_Kin_Phone_Number");
		lblnextofkinphonenumber.setForeground(Color.WHITE);
		lblnextofkinphonenumber.setBackground(Color.WHITE);
		lblnextofkinphonenumber.setBounds(278, 174, 210, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinphonenumber);
		
		txtnextofkinphonenumber = new JTextField();
		txtnextofkinphonenumber.setColumns(10);
		txtnextofkinphonenumber.setBounds(278, 189, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinphonenumber);
		
		JLabel lblnextofkinrelationship = new JLabel("Next_Of_Kin_Relationship");
		lblnextofkinrelationship.setForeground(Color.WHITE);
		lblnextofkinrelationship.setBackground(Color.WHITE);
		lblnextofkinrelationship.setBounds(278, 210, 210, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinrelationship);
		
		txtnextofkinrelationship = new JTextField();
		txtnextofkinrelationship.setColumns(10);
		txtnextofkinrelationship.setBounds(278, 225, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinrelationship);
		
		txtsurname = new JTextField();
		txtsurname.setColumns(10);
		txtsurname.setBounds(74, 109, 192, 19);
		frmEnrolmentSystem.getContentPane().add(txtsurname);
		
		JLabel lblsurname = new JLabel("Surename");
		lblsurname.setForeground(Color.WHITE);
		lblsurname.setBackground(Color.WHITE);
		lblsurname.setBounds(74, 96, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblsurname);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewStudentDetails.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(1, -1, 917, 517);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);
		}
		
	public void ViewStudentDetails() { 
		java.sql.Connection conn = null;
		try {
			//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			if(conn !=null)

			//If the system is connected this should print connected to database.
			System.out.println("Connected to View Student Details Page");
			
			//This piece of code saves text from the text field as a variable.
			ApplicationID = txtapplicationsid.getText();
			//This piece of code selects ApplicationsID from the Database.
			String SQLselect = "SELECT * FROM tbl_applications WHERE ApplicationsID=" + ApplicationID;
			PreparedStatement s=conn.prepareStatement(SQLselect); 

			//This line executes the code.
			ResultSet rs=s.executeQuery(); 
			
			//This piece of code displays information from the database. 
			while(rs.next()) 
			{
				txtapplicationsid.setText(rs.getString("ApplicationsID"));
				txtsurname.setText(rs.getString("Surname")); 
				txtforename.setText(rs.getString("Forename"));
				txtdateofbirth.setText(rs.getString("DOB"));
				txtnationalinsurance.setText(rs.getString("NI")); 
				txtsex.setText(rs.getString("Sex")); 
				txtidseen.setText(rs.getString("ID_seen")); 
				txtnationality.setText(rs.getString("Nationality")); 
				txtemergencycontactinformation.setText(rs.getString("Emergency_Contact_Information"));
				txtethnicity.setText(rs.getString("Ethnicity"));
				txtemailaddress.setText(rs.getString("Email_Address")); 
				txtnextofkin.setText(rs.getString("Next_Of_Kin")); 
				txtnextofkinaddress.setText(rs.getString("Next_Of_Kin_Address")); 
				txtnextofkinphonenumber.setText(rs.getString("Next_Of_Kin_Phone_Number")); 
				txtnextofkinrelationship.setText(rs.getString("Next_Of_Kin_Relationship"));
			} 

			s.close(); 
			
		} catch (Exception ex)
		{
			
		System.out.println("Not connected to View Student Details Page");
		ex.printStackTrace(); 
		}
		}
	
	public void ViewStudentCourses() { 
		java.sql.Connection conn = null;
		try {
			
			//Get connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			if(conn !=null)

			//if connected print connected to database System.out.println("Connected to database");
			System.out.println("Connected to View All courses Details");
		
			//This piece of code saves text from the text field as a variable.
			String ApplicationID = txtapplicationsid.getText();
			//get individual details from database
			String SQLselect = "SELECT * FROM tbl_studentcourses WHERE StudentID=" + ApplicationID;
			PreparedStatement s=conn.prepareStatement(SQLselect);
			ResultSet rs=s.executeQuery();
					
			//this code displays every result in this section of the database into the table on the view all courses screen
			tblstudentcourses.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception ex)
		{
			
		System.out.println("Not connected to View Student Courses Page");
		
		
		
			ex.printStackTrace();
		}
	
	}
		
		public void ViewStudentQualifications() { 
			java.sql.Connection conn = null;
			try {
				
				//Get connection
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

				if(conn !=null)

				//if connected print connected to database System.out.println("Connected to database");
				System.out.println("Connected to View Qualifications");
			
				//This piece of code saves text from the text field as a variable.
				String ApplicationID = txtapplicationsid.getText();
				//get individual details from database
				String SQLselect = "SELECT Qualification_Name, Exam_Board, Level, Grade, Qualification_Date FROM tbl_qualifications WHERE StudentID=" + ApplicationID;
				PreparedStatement s=conn.prepareStatement(SQLselect);
				ResultSet rs=s.executeQuery();
						
				//this code displays every result in this section of the database into the table on the view all courses screen
				tblstudentqualifications.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (Exception ex)
			{
				
			System.out.println("Not connected to View Qualifications");
			
			
			
				ex.printStackTrace();
		
	}
}
		
		public void Emailvalidation() {
			
			//check email address format
				
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\. "+
					"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			
			
			Pattern pattern = Pattern.compile(emailRegex);
			if(pattern.matcher(txtemailaddress.getText()). matches ()) { 
				
			System.out.print("Valid email address");
			
			}  else {
			
			//if save has not been successful, display a pop up box saying "Invalid e-mail"
			
			JOptionPane.showMessageDialog(null, "Invalid e-mail"); }	
		}
		
		public void ViewStudentLearningSupport() { 
			java.sql.Connection conn = null;
			try {
				
				//Get connection
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

				if(conn !=null)

				//if connected print connected to database System.out.println("Connected to database");
				System.out.println("Connected to View Student Learning Support");
			
				//This piece of code saves text from the text field as a variable.
				String ApplicationID = txtapplicationsid.getText();
				//get individual details from database
				String SQLselect = "SELECT Support_Type, Description_Of_Support_Type, Support_Start_Date, Support_End_Date, EHCP, Contact_Information FROM tbl_learningsupport WHERE StudentID=" + ApplicationID;
				PreparedStatement s=conn.prepareStatement(SQLselect);
				ResultSet rs=s.executeQuery();
						
				//this code displays every result in this section of the database into the table on the view all courses screen
				tblstudentlearningsupport.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (Exception ex)
			{
				
			System.out.println("Not connected to View Student Learning Support");
			
			
			
				ex.printStackTrace(); }
		
		}
		
		
		public void UpdateStudentDetails() { 
			
			JOptionPane.showConfirmDialog(null, "Do you want to update this record?","Update",JOptionPane.YES_NO_OPTION);
			java.sql.Connection conn = null;
			try {
	//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

	if(conn !=null)

	//if connected print connected to database System.out.println("Connected to database");
	System.out.println("Connected to Student Update Page");
	
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
		
			
			
		//This piece of code inputs the information into the database.
  try {
	  Emailvalidation();
	  SQLinsert = "UPDATE tbl_applications SET Surname=?, Forename=?, DOB=?, NI=?, Sex=?, ID_seen=?, Nationality=?, Emergency_Contact_Information=?, Ethnicity=?, Email_Address=?, Next_Of_Kin=?, Next_Of_Kin_Address=?, Next_Of_Kin_Phone_Number=?, Next_Of_Kin_Relationship=? WHERE ApplicationsID=?";
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
			s.setString(15, txtapplicationsid.getText());
			s.execute();
		
			//This code opens a dialog box that says that the information is "saved".
			JOptionPane.showMessageDialog(null, "saved");
			
			ChangesTrackerUpdate();
			
			//This piece of code displays information from the database
		
			
			
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

		
	
		
			
			public void ChangesTrackerUpdate() {
			    
			    Connection conn = null; 
			    try {
			    	//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
			        conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			        System.out.println("Changes tracker Connected to data ");

			        String RecordID = txtapplicationsid.getText();

			        //This piece of code inserts data the into Database
			        String insert = "INSERT INTO tbl_changestracker VALUES (null,'" + RecordID + "','"+ StaffID +"' ,'" + formatter.format(date) + "','Update')";

			        PreparedStatement s = conn.prepareStatement(insert);
			        s.execute();

			    } catch(Exception ex) {
			        ex.printStackTrace();
			    }
			
			}
	}


