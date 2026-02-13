package Enrolment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewStaffDetails {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JTextField txtsurname;
	private JTextField txtforename;
	private JTextField txtemail_address;
	private JTextField txtstaffid;
	private JTextField txtphone_number;
	private JLabel lblstaffid;
	private JLabel lblsurname;
	private JButton btnback;
	private JTextField txtstaff_or_admin;
	private JButton btnsearch;
	private JLabel lblforename;
	private JLabel lblemail_address;
	private JLabel lblphone_number;
	private JLabel lblstaff_or_admin;
	private JLabel lblpassword;
	private JTextField txtpassword;

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
					ViewStaffDetails window = new ViewStaffDetails();
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
	public ViewStaffDetails() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.getContentPane().setForeground(new Color(0, 255, 0));
		frmEnrolmentSystem.getContentPane().setBackground(new Color(0, 255, 0));
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewStaffDetails.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 440, 285);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(ViewStaffDetails.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lblviewstaffdetails = new JLabel("View Staff Details");
		lblviewstaffdetails.setForeground(new Color(142, 69, 133));
		lblviewstaffdetails.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblviewstaffdetails.setBackground(new Color(255, 128, 255));
		lblviewstaffdetails.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lblviewstaffdetails);
		
		txtsurname = new JTextField();
		txtsurname.setBounds(70, 105, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtsurname);
		txtsurname.setColumns(10);
		
		txtforename = new JTextField();
		txtforename.setColumns(10);
		txtforename.setBounds(70, 134, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtforename);
		
		txtemail_address = new JTextField();
		txtemail_address.setColumns(10);
		txtemail_address.setBounds(70, 163, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtemail_address);
		
		txtstaffid = new JTextField();
		txtstaffid.setColumns(10);
		txtstaffid.setBounds(70, 76, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtstaffid);
		
		txtphone_number = new JTextField();
		txtphone_number.setColumns(10);
		txtphone_number.setBounds(70, 189, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtphone_number);
		
		lblstaffid = new JLabel("StaffID");
		lblstaffid.setForeground(SystemColor.text);
		lblstaffid.setBounds(70, 60, 45, 13);
		frmEnrolmentSystem.getContentPane().add(lblstaffid);
		
		lblsurname = new JLabel("Surname");
		lblsurname.setForeground(SystemColor.text);
		lblsurname.setBounds(68, 96, 45, 13);
		frmEnrolmentSystem.getContentPane().add(lblsurname);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(null);
				AdminHomePage.StaffID = StaffID;
			}
		});
		btnback.setBounds(170, 227, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		txtstaff_or_admin = new JTextField();
		txtstaff_or_admin.setColumns(10);
		txtstaff_or_admin.setBounds(285, 76, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtstaff_or_admin);
		
		btnsearch = new JButton("Search");
		btnsearch.setBackground(new Color(255, 255, 255));
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStaffDetails();
			}
		});
		btnsearch.setBounds(242, 227, 90, 21);
		frmEnrolmentSystem.getContentPane().add(btnsearch);
		
		lblforename = new JLabel("Forename");
		lblforename.setForeground(SystemColor.text);
		lblforename.setBounds(68, 124, 60, 13);
		frmEnrolmentSystem.getContentPane().add(lblforename);
		
		lblemail_address = new JLabel("Email_Address");
		lblemail_address.setForeground(SystemColor.text);
		lblemail_address.setBounds(68, 151, 124, 13);
		frmEnrolmentSystem.getContentPane().add(lblemail_address);
		
		lblphone_number = new JLabel("Phone_Number");
		lblphone_number.setForeground(SystemColor.text);
		lblphone_number.setBounds(70, 181, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblphone_number);
		
		lblstaff_or_admin = new JLabel("Staff_Or_Admin");
		lblstaff_or_admin.setForeground(SystemColor.text);
		lblstaff_or_admin.setBounds(286, 60, 121, 13);
		frmEnrolmentSystem.getContentPane().add(lblstaff_or_admin);
		
		lblpassword = new JLabel("Password");
		lblpassword.setForeground(SystemColor.text);
		lblpassword.setBounds(286, 96, 73, 13);
		frmEnrolmentSystem.getContentPane().add(lblpassword);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(285, 105, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtpassword);
		
		btnupdate = new JButton("Update");
		btnupdate.setBackground(new Color(255, 255, 255));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStaffDetails();
			}
		});
		btnupdate.setBounds(70, 227, 90, 21);
		frmEnrolmentSystem.getContentPane().add(btnupdate);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewStaffDetails.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, 0, 426, 498);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);}
		
		public void ViewStaffDetails() { 
			java.sql.Connection conn = null;
			try {
				//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

				if(conn !=null)

				//This piece of code if connected prints connected to database.
				System.out.println("Connected to View Staff Details Page");
			//This selects CourseID from Database
				String SQLselect = "SELECT * FROM tbl_staff WHERE StaffID='3001'";
				PreparedStatement s=conn.prepareStatement (SQLselect); 

				//This piece of code Executes the command. 
				ResultSet rs=s.executeQuery(); 

				//This piece of code displays information from the database onto the user interface.
				while(rs.next()) 
				{
				txtstaffid.setText(rs.getString("StaffID")); 
				txtsurname.setText(rs.getString("Surname")); 
				txtforename.setText(rs.getString("Forename"));
				txtemail_address.setText(rs.getString("Email_Address"));
				txtphone_number.setText(rs.getString("Phone_Number")); 
				txtstaff_or_admin.setText(rs.getString("Staff_Or_Admin")); 
				txtpassword.setText(rs.getString("Password"));
				
				} 

				s.close(); 
				
			} catch (Exception ex)
			{
				
			System.out.println("Not connected to View Staff Details Page");
			ex.printStackTrace();
			}
			
		}
		
		
	
				public void ChangesTrackerUpdate() {
		    
		    Connection conn = null; 
		    try {
		    	//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
		        conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

		        System.out.println("Changes tracker Connected to data ");

		        String RecordID = txtstaffid.getText();

		        //This piece of code inserts data the into Database
		        String insert = "INSERT INTO tbl_changestracker VALUES (null,'" + RecordID + "', StaffID ,'" + formatter.format(date) + "','Update')";

		        PreparedStatement s = conn.prepareStatement(insert);
		        s.execute();

		    } catch(Exception ex) {
		        ex.printStackTrace();
		        
		    }
} 
		
		public void UpdateStaffDetails() { 
			JOptionPane.showConfirmDialog(null, "Do you want to update this record?","Update",JOptionPane.YES_NO_OPTION);
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
		    || txtemail_address.getText().trim().isEmpty()
		    || txtphone_number.getText().trim().isEmpty()
		    || txtstaff_or_admin.getText().trim().isEmpty()
		    || txtpassword.getText().trim().isEmpty())
	{
	//This code opens a dialog box that says Please include all required fields!!!.
		JOptionPane.showMessageDialog(null, "Please include all required fields!!!");
	}
		else
		
		//This piece of code inputs the information into the database.
  try {		SQLinsert = "UPDATE tbl_staff SET Surname=?, Forename=?, Email_Address=?, Phone_Number=?, Staff_or_Admin=?, Password=? WHERE StaffID=?";
			PreparedStatement s = conn.prepareStatement(SQLinsert);
			s.setString(1, txtsurname.getText());
			s.setString(2, txtforename.getText());
			s.setString(3, txtemail_address.getText());
			s.setString(4, txtphone_number.getText());
			s.setString(5, txtstaff_or_admin.getText());
			s.setString(6, txtpassword.getText());
			s.setString(7, txtstaffid.getText());
			s.execute();
		
			//This code opens a dialog box that says that the information is "saved".
			JOptionPane.showMessageDialog(null, "saved");
			
			ChangesTrackerUpdate();
			
			//This code takes the user to the home page.
			AdminHomePage.main(null);
			
			s.close();
			
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Not saved to database: error:" +e);
			}

} 
catch (Exception ex)
{
	
System.out.println("Not connected to Add Staff Page");

	ex.printStackTrace();
}
}
}