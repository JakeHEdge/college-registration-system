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
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewCourses {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JTextField txtcoursename;
	private JTextField txtcourselevel;
	private JTextField txtcoursedurationweeks;
	private JButton btnback;
	private JTextField txtcoursedetails;
	private JLabel lblcoursename;
	private JLabel lblcourselevel;
	private JLabel lblcoursedurationweeks;
	private JLabel lblcoursedetails;
	private JTextField txtcourseid;
	private JLabel lblcourseid;

	//This piece of code displays the date and time.
			SimpleDateFormat  formatter = new SimpleDateFormat ("dd/MM/yyyy");
			Date date = new Date(0);
			private JButton btnupdate;
			private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCourses window = new ViewCourses();
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
	public ViewCourses() {
		initialize();
		System.out.println("ViewCourses");

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewCourses.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 421, 535);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setBounds(0, -16, 113, 102);
		lblcollegelogo.setIcon(new ImageIcon(ViewCourses.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lblviewcourses = new JLabel("View Courses");
		lblviewcourses.setBounds(77, 6, 423, 44);
		lblviewcourses.setForeground(new Color(142, 69, 133));
		lblviewcourses.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblviewcourses.setBackground(new Color(255, 128, 255));
		frmEnrolmentSystem.getContentPane().add(lblviewcourses);
		
		txtcoursename = new JTextField();
		txtcoursename.setBounds(172, 164, 176, 49);
		txtcoursename.setColumns(10);
		frmEnrolmentSystem.getContentPane().add(txtcoursename);
		
		txtcourselevel = new JTextField();
		txtcourselevel.setBounds(172, 223, 176, 49);
		txtcourselevel.setColumns(10);
		frmEnrolmentSystem.getContentPane().add(txtcourselevel);
		
		txtcoursedurationweeks = new JTextField();
		txtcoursedurationweeks.setBounds(172, 282, 176, 49);
		txtcoursedurationweeks.setColumns(10);
		frmEnrolmentSystem.getContentPane().add(txtcoursedurationweeks);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.setBounds(209, 455, 73, 21);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(null);
				AdminHomePage.StaffID =StaffID;
			}
		});
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		txtcoursedetails = new JTextField();
		txtcoursedetails.setColumns(10);
		txtcoursedetails.setBounds(171, 341, 176, 49);
		frmEnrolmentSystem.getContentPane().add(txtcoursedetails);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBackground(new Color(255, 255, 255));
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCourses();
			}
		});
		btnsearch.setBounds(26, 455, 90, 21);
		frmEnrolmentSystem.getContentPane().add(btnsearch);
		
		JButton btndelete = new JButton("Delete");
		btndelete.setBackground(new Color(255, 255, 255));
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCourse();
			}
		});
		btndelete.setBounds(126, 455, 73, 21);
		frmEnrolmentSystem.getContentPane().add(btndelete);
		
		lblcoursename = new JLabel("Course_Name");
		lblcoursename.setForeground(new Color(255, 255, 255));
		lblcoursename.setBounds(10, 179, 90, 13);
		frmEnrolmentSystem.getContentPane().add(lblcoursename);
		
		lblcourselevel = new JLabel("Course_Level");
		lblcourselevel.setForeground(new Color(255, 255, 255));
		lblcourselevel.setBounds(10, 238, 90, 13);
		frmEnrolmentSystem.getContentPane().add(lblcourselevel);
		
		lblcoursedurationweeks = new JLabel("Course_Duration_Weeks");
		lblcoursedurationweeks.setForeground(new Color(255, 255, 255));
		lblcoursedurationweeks.setBounds(10, 290, 229, 13);
		frmEnrolmentSystem.getContentPane().add(lblcoursedurationweeks);
		
		lblcoursedetails = new JLabel("Course_Details");
		lblcoursedetails.setForeground(new Color(255, 255, 255));
		lblcoursedetails.setBounds(10, 354, 100, 13);
		frmEnrolmentSystem.getContentPane().add(lblcoursedetails);
		
		lblcourseid = new JLabel("Course_ID");
		lblcourseid.setForeground(new Color(255, 255, 255));
		lblcourseid.setBounds(10, 112, 90, 13);
		frmEnrolmentSystem.getContentPane().add(lblcourseid);
		
		txtcourseid = new JTextField();
		txtcourseid.setColumns(10);
		txtcourseid.setBounds(172, 97, 176, 49);
		frmEnrolmentSystem.getContentPane().add(txtcourseid);
		
		btnupdate = new JButton("Update");
		btnupdate.setBackground(new Color(255, 255, 255));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCourse();
			}
		});
		btnupdate.setBounds(294, 455, 90, 21);
		frmEnrolmentSystem.getContentPane().add(btnupdate);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewCourses.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, 0, 407, 498);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);
	}
	
	public void ViewCourses() { 
		java.sql.Connection conn = null;
		try {
			//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			if(conn !=null)

			//If the system is connected this should print connected to database.
			System.out.println("Connected to View Courses Page");
			
			//This piece of code saves text from the text field as a variable.
			String courseID = txtcourseid.getText();
			//This piece of code selects CourseID from the Database.
			String SQLselect = "SELECT * FROM tbl_courses WHERE CourseID=" + courseID;
			PreparedStatement s=conn.prepareStatement(SQLselect); 

			//This line executes the code.
			ResultSet rs=s.executeQuery(); 
			
			//This piece of code displays information from the database. 
			while(rs.next()) 
			{
			txtcourseid.setText(rs.getString("CourseID")); 
			txtcoursename.setText(rs.getString("Course_Name")); 
			txtcourselevel.setText(rs.getString("Course_Level"));
			txtcoursedurationweeks.setText(rs.getString("Course_Duration_Weeks"));
			txtcoursedetails.setText(rs.getString("Course_Details")); 
			} 

			s.close(); 
			
		} catch (Exception ex)
		{
			
		System.out.println("Not connected to View Courses Page");
		ex.printStackTrace();
		}
	}
		
		
		public void DeleteCourse () {
			//This piece of code  Prompts if you want this to be deleted.
			JOptionPane.showConfirmDialog(null, "Do you really want to delete this??","Delete",JOptionPane.YES_NO_OPTION);
			
			Connection conn = null;
			try {
				//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
				conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");
				
				//If the code is connected it will show that it is connected to the database.
				System.out.println("Delete Course connected to database");
				
				String courseID = txtcourseid.getText();
				
				//This code make sure that it is deleted from the database.
				String SQLdelete = "DELETE FROM tbl_courses WHERE courseID=" + courseID;
				PreparedStatement s=conn.prepareStatement(SQLdelete);
				s.execute();
				
				//This next line of code closes the page and goes to the home page again.
				AdminHomePage.main(null);
				
			}catch(Exception ex)
			{
				
			System.out.println("Delete course not connected to the databse");
			
				
				
				
	
		
		
		
		
			ex.printStackTrace();
	
}
		
}
		public void ChangesTrackerUpdate() {
		    
		    Connection conn = null; 
		    try {
		    	//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
		        conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

		        System.out.println("Changes tracker Connected to data ");

		        String RecordID = txtcourseid.getText();

		        //This piece of code inserts data the into Database
		        String insert = "INSERT INTO tbl_changestracker VALUES (null,'" + RecordID + "', StaffID ,'" + formatter.format(date) + "','Update')";

		        PreparedStatement s = conn.prepareStatement(insert);
		        s.execute();

		    } catch(Exception ex) {
		        ex.printStackTrace();
		        }
		    }


		    
		    public void UpdateCourse() { 
		    	
		    	JOptionPane.showConfirmDialog(null, "Do you want to Update this Course??","Delete",JOptionPane.YES_NO_OPTION);
		    	
		    	Connection conn = null;
				try {
					//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

					if(conn !=null)
						//if connected print connected to database System.out.println("Connected to database");
					System.out.println("Connected to Admin Home Page");
					}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Not saved to database: error:" +e);
					}
					
					if		(txtcoursename.getText().trim().isEmpty()
							|| txtcourselevel.getText().trim().isEmpty()
							|| txtcoursedurationweeks.getText().trim().isEmpty()
							|| txtcoursedetails.getText().trim().isEmpty())
					{
					//This code opens a dialog box that says Please include all required fields!!!.
						JOptionPane.showMessageDialog(null, "Please include all required fields!!!");
					}
						else
						
						//This piece of code inputs the information into the database.
			      try {		String SQLinsert = "UPDATE tbl_courses SET Course_Name=?, Course_Level=?, Course_Duration_Weeks=?, Course_Details=? WHERE CourseID=?";
							PreparedStatement s = conn.prepareStatement(SQLinsert);
							s.setString(1, txtcoursename.getText());
							s.setString(2, txtcoursedurationweeks.getText());
							s.setString(3, txtcoursedurationweeks.getText());
							s.setString(4, txtcoursedetails.getText());
							s.setString(5, txtcourseid.getText());
							s.execute();
						
							//This code opens a dialog box that says that the information is "saved".
							JOptionPane.showMessageDialog(null, "saved");
							
							//This code takes the user to the home page.
							AdminHomePage.main(null);
							AdminHomePage.StaffID =StaffID;
							
							s.close();
							
							} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Not saved to database: error:" +e);
							}
				
				}
		    }	