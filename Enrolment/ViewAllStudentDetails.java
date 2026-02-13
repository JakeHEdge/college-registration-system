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

public class ViewAllStudentDetails {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JButton btnBack;
	private JTable tblviewallstudentdetails;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllStudentDetails window = new ViewAllStudentDetails();
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
	public ViewAllStudentDetails() {
		initialize();
		System.out.println("ViewStudentDetails");
		ViewAllStudentDetails();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllStudentDetails.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 838, 535);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ViewAllStudentDetails.class.getResource("/Images/riverside college done now.png")));
		lblNewLabel_2.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("View Staff Details");
		lblNewLabel.setForeground(new Color(142, 69, 133));
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblNewLabel.setBackground(new Color(255, 128, 255));
		lblNewLabel.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffHomePage.main(null);
				StaffHomePage.StaffID = StaffID;
			}
		});
		btnBack.setBounds(570, 449, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnBack);
		
		tblviewallstudentdetails = new JTable();
		tblviewallstudentdetails.setBounds(106, 88, 525, 357);
		frmEnrolmentSystem.getContentPane().add(tblviewallstudentdetails);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewAllStudentDetails.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel_1.setBounds(0, 0, 824, 498);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel_1);
	}
	
	public void ViewAllStudentDetails() { 
		java.sql.Connection conn = null;
		try {
			
			//Get connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			if(conn !=null)

			//if connected print connected to database System.out.println("Connected to database");
			System.out.println("Connected to View All Staff Details");
		
			//get individual details from database
			String SQLselect = "SELECT * FROM tbl_student";
			PreparedStatement s=conn.prepareStatement(SQLselect);
			ResultSet rs=s.executeQuery();
					
			//this code displays every result in this section of the database into the table on the view all courses screen
			tblviewallstudentdetails.setModel(DbUtils.resultSetToTableModel(rs));
			//tbl_table2 is the name of the j table
		} catch (Exception ex)
		{
			
		System.out.println("Not connected to View All Staff Details Page");
		
		
		
			ex.printStackTrace();
	
}
		
}
	
}


