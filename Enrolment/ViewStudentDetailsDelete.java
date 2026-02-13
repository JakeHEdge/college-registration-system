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
import java.awt.event.ActionEvent;

public class ViewStudentDetailsDelete {
	public static String StaffID = null;
	public static String ApplicationID = null;
	private JFrame frmEnrolmentSystem;
	private JButton btnback;
	private JButton btnsearch;
	private JTextField txtsex;
	private JTextField txtemailaddress;
	private JTextField txtnextofkin;
	private JTextField txtidseen;
	private JTextField txtsurname;
	private JTextField txtforename;
	private JTextField txtnationality;
	private JTextField txtnextofkinaddress;
	private JTextField txtnextofkinphonenumber;
	private JTextField txtemergencycontactinformation;
	private JTextField txtdateofbirth;
	private JTextField txtnationalinsurance;
	private JTextField txtnextofkinrelationship;
	private JTextField txtethnicity;
	private JTextField txtapplicationsid;
	private JTable tblstudentcourses;
	private JTable tblstudentqualifications;
	private JTable tblstudentlearningsupport;

	//This piece of code displays the date and time.
			SimpleDateFormat  formatter = new SimpleDateFormat ("dd/MM/yyyy");
			Date date = new Date(0);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudentDetailsDelete window = new ViewStudentDetailsDelete();
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
	
		
		public ViewStudentDetailsDelete() {
			initialize();
			System.out.println("ViewStudentDetails");
			
			

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewStudentDetailsDelete.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 993, 552);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(ViewStudentDetailsDelete.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lblstudentdetails = new JLabel("View Student Details Delete");
		lblstudentdetails.setForeground(new Color(142, 69, 133));
		lblstudentdetails.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblstudentdetails.setBackground(new Color(255, 128, 255));
		lblstudentdetails.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lblstudentdetails);
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(null);
				AdminHomePage.StaffID = StaffID;
			}
		});
		btnback.setBounds(514, 80, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		new JTable();
		
		btnsearch = new JButton("Search");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentDetails();
				ViewStudentCourses();
				ViewStudentQualifications();
				ViewStudentLearningSupport();
			}
		});
		btnsearch.setBounds(515, 58, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btnsearch);
		
		JLabel lblstudentcourses = new JLabel("Student_Courses:");
		lblstudentcourses.setBounds(296, 274, 91, 13);
		frmEnrolmentSystem.getContentPane().add(lblstudentcourses);
		
		JLabel lblqualifications = new JLabel("Qualifications:");
		lblqualifications.setBounds(27, 277, 95, 13);
		frmEnrolmentSystem.getContentPane().add(lblqualifications);
		
		JLabel lblsupportneeds = new JLabel("Support Needs:");
		lblsupportneeds.setBounds(31, 360, 91, 13);
		frmEnrolmentSystem.getContentPane().add(lblsupportneeds);
		
		JButton btnaddstudentcourses = new JButton("Add");
		btnaddstudentcourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentCourses.main(null);
				AddStudentCourses.StaffID = StaffID;
				AddStudentCourses.ApplicationID = ApplicationID;
			
			
			}
		});
		btnaddstudentcourses.setBounds(120, 200, 85, 21);
		frmEnrolmentSystem.getContentPane().add(btnaddstudentcourses);
		
		JButton btnaddqualifications = new JButton("Add");
		btnaddqualifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQualifications.main(null);
				AddQualifications.StaffID = StaffID;
				AddQualifications.ApplicationID = ApplicationID;
			}
		});
		btnaddqualifications.setBounds(126, 274, 85, 21);
		frmEnrolmentSystem.getContentPane().add(btnaddqualifications);
		
		JButton btnaddsupportneeds = new JButton("Add");
		btnaddsupportneeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLearningSupport.main(null);
				AddLearningSupport.StaffID = StaffID;
				AddLearningSupport.ApplicationID = ApplicationID;
			}
		});
		btnaddsupportneeds.setBounds(136, 356, 85, 21);
		frmEnrolmentSystem.getContentPane().add(btnaddsupportneeds);
		
		JLabel lblsex = new JLabel("Sex");
		lblsex.setForeground(Color.BLACK);
		lblsex.setBounds(205, 39, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblsex);
		
		txtsex = new JTextField();
		txtsex.setColumns(10);
		txtsex.setBounds(205, 54, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtsex);
		
		JLabel lblemailaddress = new JLabel("Email_Address");
		lblemailaddress.setForeground(Color.BLACK);
		lblemailaddress.setBounds(355, 39, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblemailaddress);
		
		txtemailaddress = new JTextField();
		txtemailaddress.setColumns(10);
		txtemailaddress.setBounds(355, 54, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtemailaddress);
		
		JLabel lblnextofkin = new JLabel("Next_Of_Kin");
		lblnextofkin.setForeground(Color.BLACK);
		lblnextofkin.setBounds(355, 70, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkin);
		
		txtnextofkin = new JTextField();
		txtnextofkin.setColumns(10);
		txtnextofkin.setBounds(354, 82, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkin);
		
		JLabel lblidseen = new JLabel("ID_Seen");
		lblidseen.setForeground(Color.BLACK);
		lblidseen.setBounds(207, 71, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblidseen);
		
		txtidseen = new JTextField();
		txtidseen.setColumns(10);
		txtidseen.setBounds(205, 87, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtidseen);
		
		JLabel lblsurname = new JLabel("Surname");
		lblsurname.setForeground(Color.BLACK);
		lblsurname.setBounds(73, 78, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblsurname);
		
		txtsurname = new JTextField();
		txtsurname.setColumns(10);
		txtsurname.setBounds(71, 89, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtsurname);
		
		JLabel lblforename = new JLabel("Forename");
		lblforename.setForeground(Color.BLACK);
		lblforename.setBounds(73, 105, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblforename);
		
		txtforename = new JTextField();
		txtforename.setColumns(10);
		txtforename.setBounds(73, 117, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtforename);
		
		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setForeground(Color.BLACK);
		lblnationality.setBounds(205, 106, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnationality);
		
		txtnationality = new JTextField();
		txtnationality.setColumns(10);
		txtnationality.setBounds(205, 119, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtnationality);
		
		JLabel lblnextofkinaddress = new JLabel("Next_Of_Kin_Address");
		lblnextofkinaddress.setForeground(Color.BLACK);
		lblnextofkinaddress.setBounds(353, 100, 104, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinaddress);
		
		txtnextofkinaddress = new JTextField();
		txtnextofkinaddress.setColumns(10);
		txtnextofkinaddress.setBounds(353, 112, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinaddress);
		
		JLabel lblnextofkinphonenumber = new JLabel("Next_Of_Kin_Phone_Number");
		lblnextofkinphonenumber.setForeground(Color.BLACK);
		lblnextofkinphonenumber.setBounds(354, 132, 152, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinphonenumber);
		
		txtnextofkinphonenumber = new JTextField();
		txtnextofkinphonenumber.setColumns(10);
		txtnextofkinphonenumber.setBounds(355, 146, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinphonenumber);
		
		JLabel lblemergencycontactinformation = new JLabel("Emergency_Contact_Information");
		lblemergencycontactinformation.setForeground(Color.BLACK);
		lblemergencycontactinformation.setBounds(204, 138, 165, 13);
		frmEnrolmentSystem.getContentPane().add(lblemergencycontactinformation);
		
		txtemergencycontactinformation = new JTextField();
		txtemergencycontactinformation.setColumns(10);
		txtemergencycontactinformation.setBounds(204, 152, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtemergencycontactinformation);
		
		JLabel lbldob = new JLabel("Date_Of_Birth");
		lbldob.setForeground(Color.BLACK);
		lbldob.setBounds(73, 134, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lbldob);
		
		txtdateofbirth = new JTextField();
		txtdateofbirth.setColumns(10);
		txtdateofbirth.setBounds(71, 146, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtdateofbirth);
		
		JLabel lblnationalinsurance = new JLabel("National Insurance");
		lblnationalinsurance.setForeground(Color.BLACK);
		lblnationalinsurance.setBounds(72, 163, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblnationalinsurance);
		
		txtnationalinsurance = new JTextField();
		txtnationalinsurance.setColumns(10);
		txtnationalinsurance.setBounds(73, 175, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtnationalinsurance);
		
		JLabel lblethnicity = new JLabel("Ethnicity");
		lblethnicity.setForeground(Color.BLACK);
		lblethnicity.setBounds(203, 170, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblethnicity);
		
		txtethnicity = new JTextField();
		txtethnicity.setColumns(10);
		txtethnicity.setBounds(205, 184, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtethnicity);
		
		JLabel lblnextofkinrelationship = new JLabel("Next_Of_Kin_Relationship");
		lblnextofkinrelationship.setForeground(Color.BLACK);
		lblnextofkinrelationship.setBounds(354, 166, 138, 13);
		frmEnrolmentSystem.getContentPane().add(lblnextofkinrelationship);
		
		txtnextofkinrelationship = new JTextField();
		txtnextofkinrelationship.setColumns(10);
		txtnextofkinrelationship.setBounds(353, 179, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtnextofkinrelationship);
		
		txtapplicationsid = new JTextField();
		txtapplicationsid.setColumns(10);
		txtapplicationsid.setBounds(74, 59, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtapplicationsid);
		
		JLabel lblapplicationsid = new JLabel("Applications_ID");
		lblapplicationsid.setForeground(Color.BLACK);
		lblapplicationsid.setBounds(73, 43, 86, 13);
		frmEnrolmentSystem.getContentPane().add(lblapplicationsid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(296, 297, 614, 56);
		frmEnrolmentSystem.getContentPane().add(scrollPane);
		
		tblstudentcourses = new JTable();
		scrollPane.setViewportView(tblstudentcourses);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(297, 377, 614, 56);
		frmEnrolmentSystem.getContentPane().add(scrollPane_1);
		
		tblstudentqualifications = new JTable();
		scrollPane_1.setViewportView(tblstudentqualifications);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(296, 455, 614, 56);
		frmEnrolmentSystem.getContentPane().add(scrollPane_2);
		
		tblstudentlearningsupport = new JTable();
		scrollPane_2.setViewportView(tblstudentlearningsupport);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent();
			}
		});
		btndelete.setBounds(514, 101, 102, 21);
		frmEnrolmentSystem.getContentPane().add(btndelete);
		
		}
		
	public void ViewStudentDetails() { 
		java.sql.Connection conn = null;
		try {
			//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			if(conn !=null)

			//If the system is connected this should print connected to database.
			System.out.println("Connected to View Student Details Page");
			System.out.println(StaffID);
			
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
				txtnextofkinrelationship.setText(rs.getString("Next_Of_ Kin_Relationship"));
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
			//tbl_table2 is the name of the j table
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
			
			
			
				ex.printStackTrace();
				
			}
		}
			
				
				
				public void DeleteStudent () {
					//This piece of code  Prompts if you want this to be deleted.
					JOptionPane.showConfirmDialog(null, "Do you really want to delete this??","Delete",JOptionPane.YES_NO_OPTION);
					
					Connection conn = null;
					try {
						//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
						conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");
						
						//If the code is connected it will show that it is connected to the database.
						System.out.println("Delete Course connected to database");
						
						String ApplicationID = txtapplicationsid.getText();
						
						//This code make sure that it is deleted from the qualifications database.
						String SQLdeletequalifications = "DELETE FROM tbl_qualifications WHERE studentID=" + ApplicationID;
						PreparedStatement s=conn.prepareStatement(SQLdeletequalifications);
						s.execute();
						
						//This code make sure that it is deleted from the studentcourses database.
						String SQLdeletestudentcourses = "DELETE FROM tbl_studentcourses WHERE studentID=" + ApplicationID;
						PreparedStatement s2=conn.prepareStatement(SQLdeletestudentcourses);
						s2.execute();

						//This code make sure that it is deleted from the learningsupport database.
						String SQLdeletelearningsupport = "DELETE FROM tbl_learningsupport WHERE studentID=" + ApplicationID;
						PreparedStatement s3=conn.prepareStatement(SQLdeletelearningsupport);
						s3.execute();
						
						//This code make sure that it is deleted from the courses database.
						String SQLdeleteapplications = "DELETE FROM tbl_applications WHERE ApplicationsID=" + ApplicationID;
						PreparedStatement s4=conn.prepareStatement(SQLdeleteapplications);
						s4.execute();
						
						ChangesTrackerDelete();
						
						//This next line of code closes the page and goes to the home page again.
						AdminHomePage.main(null);
						
					}catch(Exception ex)
					{
			
						ex.printStackTrace();
						
	}
	}
				
				public void ChangesTrackerDelete() {
				    
				    Connection conn = null; 
				    try {
				    	//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
				        conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

				        System.out.println("Changes tracker Connected to data ");

				        String RecordID = txtapplicationsid.getText();

				        //This piece of code inserts data the into Database
				        String insert = "INSERT INTO tbl_changestracker VALUES (null,'"+RecordID+"' ,' "+ StaffID + "','" + formatter.format(date) + "','Delete')";

				        PreparedStatement s = conn.prepareStatement(insert);
				        s.execute();

				    } catch(Exception ex) {
				        ex.printStackTrace();
				    }
				
}
}

