package Enrolment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class ViewAllStaffDetails {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JLabel lblNewLabel_4;
	private JTable tblviewallstaffdetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllStaffDetails window = new ViewAllStaffDetails();
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
	public ViewAllStaffDetails() {
		initialize();
		System.out.println("ViewEnrolmentDetails");
		ViewAllStaffDetails();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.getContentPane().setBackground(new Color(0, 255, 0));
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllStaffDetails.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 838, 535);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(ViewAllStaffDetails.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -15, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lblviewallstaffdetails = new JLabel("View All Staff Details");
		lblviewallstaffdetails.setForeground(new Color(142, 69, 133));
		lblviewallstaffdetails.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblviewallstaffdetails.setBackground(new Color(255, 128, 255));
		lblviewallstaffdetails.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lblviewallstaffdetails);
		
		tblviewallstaffdetails = new JTable();
		tblviewallstaffdetails.setBounds(106, 88, 525, 357);
		frmEnrolmentSystem.getContentPane().add(tblviewallstaffdetails);
		
		JButton btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(null);
				AdminHomePage.StaffID = StaffID;
			}
		});
		btnback.setBounds(570, 449, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewAllStaffDetails.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel_1.setBounds(0, 0, 824, 498);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel_1);
	}
	
	public void ViewAllStaffDetails() { 
		java.sql.Connection conn = null;
		try {
			
			//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			if(conn !=null)

			//This piece of code if executed prints connected to database.
			System.out.println("Connected to View All Staff Details");
		
			//This piece of code collects individual details from the database.
			String SQLselect = "SELECT * FROM tbl_staff";
			PreparedStatement s=conn.prepareStatement(SQLselect);
			ResultSet rs=s.executeQuery();
					
			//this code displays every result in this section of the database into the table on the view all courses screen.
			tblviewallstaffdetails.setModel(DbUtils.resultSetToTableModel(rs));
			//tbl_table2 is the name of the j table
		} catch (Exception ex)
		{
			
		System.out.println("Not connected to View All Staff Details Page");
		
		
		
			ex.printStackTrace();
	
}
		
}
	
}


