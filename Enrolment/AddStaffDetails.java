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
import java.awt.event.ActionEvent;

public class AddStaffDetails {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JTextField txtsurname;
	private JTextField txtemail_address;
	private JTextField txtforename;
	private JTextField txtphone_number;
	private JLabel lblsurname;
	private JButton btnback;
	private JButton btnsave;
	private JTextField txtstaff_or_admin;
	private JTextField txtpassword;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaffDetails window = new AddStaffDetails();
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
	public AddStaffDetails() {
		initialize();
		System.out.println("AddEnrolmentDetails");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.getContentPane().setBackground(new Color(0, 255, 0));
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(AddStaffDetails.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 358, 242);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(AddStaffDetails.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lbladdstaffdetails = new JLabel("Add Staff Details");
		lbladdstaffdetails.setForeground(new Color(142, 69, 133));
		lbladdstaffdetails.setFont(new Font("Corbel", Font.PLAIN, 37));
		lbladdstaffdetails.setBackground(new Color(255, 128, 255));
		lbladdstaffdetails.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lbladdstaffdetails);
		
		txtsurname = new JTextField();
		txtsurname.setColumns(10);
		txtsurname.setBounds(10, 81, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtsurname);
		
		txtemail_address = new JTextField();
		txtemail_address.setColumns(10);
		txtemail_address.setBounds(10, 148, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtemail_address);
		
		txtforename = new JTextField();
		txtforename.setColumns(10);
		txtforename.setBounds(10, 119, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtforename);
		
		txtphone_number = new JTextField();
		txtphone_number.setColumns(10);
		txtphone_number.setBounds(10, 179, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtphone_number);
		
		lblsurname = new JLabel("Surname");
		lblsurname.setForeground(SystemColor.text);
		lblsurname.setBounds(10, 71, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblsurname);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(null);
				AdminHomePage.StaffID = StaffID;
			}
		});
		btnback.setBounds(264, 178, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		btnsave = new JButton("Save");
		btnsave.setBackground(new Color(255, 255, 255));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaffDetails();
			}
		});
		btnsave.setBounds(184, 178, 69, 21);
		frmEnrolmentSystem.getContentPane().add(btnsave);
		
		JLabel lblforename = new JLabel("Forename");
		lblforename.setForeground(SystemColor.text);
		lblforename.setBounds(10, 110, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblforename);
		
		JLabel lblemailaddress = new JLabel("Email_Address");
		lblemailaddress.setForeground(SystemColor.text);
		lblemailaddress.setBounds(10, 134, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblemailaddress);
		
		JLabel lblphonenumber = new JLabel("Phone_Number");
		lblphonenumber.setForeground(SystemColor.text);
		lblphonenumber.setBounds(10, 170, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblphonenumber);
		
		JLabel lblstaff_or_admin = new JLabel("Staff_Or_Admin");
		lblstaff_or_admin.setForeground(SystemColor.text);
		lblstaff_or_admin.setBounds(142, 71, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblstaff_or_admin);
		
		txtstaff_or_admin = new JTextField();
		txtstaff_or_admin.setColumns(10);
		txtstaff_or_admin.setBounds(142, 80, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtstaff_or_admin);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setForeground(SystemColor.text);
		lblpassword.setBounds(142, 106, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblpassword);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(142, 116, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtpassword);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddStaffDetails.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, -4, 586, 321);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);
	}

	
		public void AddStaffDetails() { 
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
      try {		SQLinsert = "INSERT into tbl_staff values (null,?,?,?,?,?,?)";
				PreparedStatement s = conn.prepareStatement(SQLinsert);
				s.setString(1, txtsurname.getText());
				s.setString(2, txtforename.getText());
				s.setString(3, txtemail_address.getText());
				s.setString(4, txtphone_number.getText());
				s.setString(5, txtstaff_or_admin.getText());
				s.setString(6, txtpassword.getText());
				s.execute();
			
				//This code opens a dialog box that says that the information is "saved".
				JOptionPane.showMessageDialog(null, "saved");
				
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

