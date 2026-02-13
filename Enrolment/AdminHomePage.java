package Enrolment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class AdminHomePage {
	public static String StaffID = null;
	private JFrame frame;
	private JButton btnviewcourses;
	private JButton btnaddcourses;
	private JButton btnviewstaffdetails;
	private JButton btnaddstaffdetails;
	private JLabel lbllogo;
	private JButton btnviewallchangestracker;
	private JButton btnviewalllogintracker;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePage window = new AdminHomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminHomePage() {
		initialize();
		System.out.println("AdminHomePage");
		ConnectToDatabase();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 684, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbladminhomepage = new JLabel("Admin Dashboard");
		lbladminhomepage.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		lbladminhomepage.setForeground(new Color(142, 69, 133));
		lbladminhomepage.setBackground(new Color(255, 128, 255));
		lbladminhomepage.setBounds(89, 5, 276, 28);
		frame.getContentPane().add(lbladminhomepage);
		
		btnviewcourses = new JButton("View courses");
		btnviewcourses.setBackground(new Color(255, 255, 255));
		btnviewcourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCourses.main(null);
				ViewCourses.StaffID = StaffID;
			}
		});
		btnviewcourses.setForeground(new Color(128, 0, 128));
		btnviewcourses.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnviewcourses.setBounds(8, 85, 119, 92);
		frame.getContentPane().add(btnviewcourses);
		
		btnaddcourses = new JButton("Add courses");
		btnaddcourses.setBackground(new Color(255, 255, 255));
		btnaddcourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourses.main(null);
				AddCourses.StaffID = StaffID;
			}
		});
		btnaddcourses.setForeground(new Color(128, 0, 128));
		btnaddcourses.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnaddcourses.setBounds(48, 187, 119, 92);
		frame.getContentPane().add(btnaddcourses);
		
		btnviewstaffdetails = new JButton("View staff details");
		btnviewstaffdetails.setBackground(new Color(255, 255, 255));
		btnviewstaffdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStaffDetails.main(null);
				AddCourses.StaffID = StaffID;
			}
		});
		btnviewstaffdetails.setForeground(new Color(128, 0, 128));
		btnviewstaffdetails.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnviewstaffdetails.setBounds(137, 85, 119, 92);
		frame.getContentPane().add(btnviewstaffdetails);
			
		btnaddstaffdetails = new JButton("Add staff details");
		btnaddstaffdetails.setBackground(new Color(255, 255, 255));
		btnaddstaffdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaffDetails.main(null);
			}
		});
		btnaddstaffdetails.setForeground(new Color(128, 0, 128));
		btnaddstaffdetails.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnaddstaffdetails.setBounds(193, 187, 119, 92);
		frame.getContentPane().add(btnaddstaffdetails);
		
		lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(AdminHomePage.class.getResource("/Images/riverside college done now.png")));
		lbllogo.setBounds(-2, -60, 113, 190);
		frame.getContentPane().add(lbllogo);
		
		JButton btnviewstudent = new JButton("View student details");
		btnviewstudent.setBackground(new Color(255, 255, 255));
		btnviewstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentDetailsReal.main(null);
				ViewStudentDetailsReal.StaffID = StaffID;
			
			}
		});
		btnviewstudent.setForeground(new Color(128, 0, 128));
		btnviewstudent.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnviewstudent.setBounds(395, 85, 119, 92);
		frame.getContentPane().add(btnviewstudent);
		
		JButton btnviewallstaff = new JButton("View all staff");
		btnviewallstaff.setBackground(new Color(255, 255, 255));
		btnviewallstaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllStaffDetails.main(null);
				ViewAllStaffDetails.StaffID = StaffID;
			}
		});
		btnviewallstaff.setForeground(new Color(128, 0, 128));
		btnviewallstaff.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnviewallstaff.setBounds(266, 85, 119, 92);
		frame.getContentPane().add(btnviewallstaff);
		
		JButton btnviewallcourses = new JButton("View all courses");
		btnviewallcourses.setBackground(new Color(255, 255, 255));
		btnviewallcourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllCourses.main(null);
				ViewAllCourses.StaffID = StaffID;
			}
		});
		btnviewallcourses.setForeground(new Color(128, 0, 128));
		btnviewallcourses.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnviewallcourses.setBounds(326, 187, 119, 92);
		frame.getContentPane().add(btnviewallcourses);
		
		btnviewallchangestracker = new JButton("View All Changes Tracker");
		btnviewallchangestracker.setBackground(new Color(255, 255, 255));
		btnviewallchangestracker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllChangesTracker.main(null);
				ViewAllChangesTracker.StaffID = StaffID;
			}
		});
		btnviewallchangestracker.setForeground(new Color(128, 0, 128));
		btnviewallchangestracker.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnviewallchangestracker.setBounds(483, 187, 143, 92);
		frame.getContentPane().add(btnviewallchangestracker);
		
		btnviewalllogintracker = new JButton("View All Login Tracker");
		btnviewalllogintracker.setBackground(new Color(255, 255, 255));
		btnviewalllogintracker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllLoginTracker.main(null);
				ViewAllLoginTracker.StaffID = StaffID;
			}
		});
		btnviewalllogintracker.setForeground(new Color(128, 0, 128));
		btnviewalllogintracker.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnviewalllogintracker.setBounds(524, 85, 143, 92);
		frame.getContentPane().add(btnviewalllogintracker);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AdminHomePage.class.getResource("/Images/riverside  background.png")));
		lblNewLabel.setBounds(0, 0, 686, 361);
		frame.getContentPane().add(lblNewLabel);
	}

		public void ConnectToDatabase() { 
			java.sql.Connection conn = null;
			try {
				//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

				if(conn !=null)

				//This code displays the message connected if the code gets this far.
				System.out.println("Connected to Admin Home Page");
			
			} catch (Exception ex)
			{
				//The code displays the message not connected if it hasnt worked properly.
			System.out.println("Not connected to Admin Home Page");
			
				ex.printStackTrace();
}
}


}

