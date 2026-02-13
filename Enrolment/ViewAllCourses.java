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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewAllCourses {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JButton btnback;
	private JTable tbl_courses;
	private JTable tblcourses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllCourses window = new ViewAllCourses();
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
	public ViewAllCourses() {
		initialize();
		System.out.println("ViewCourses");
		ViewAllCourses();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllCourses.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 838, 535);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setBounds(0, -16, 113, 102);
		lblcollegelogo.setIcon(new ImageIcon(ViewAllCourses.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lblviewallcourses = new JLabel("View All Courses");
		lblviewallcourses.setBounds(77, 6, 423, 44);
		lblviewallcourses.setForeground(new Color(142, 69, 133));
		lblviewallcourses.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblviewallcourses.setBackground(new Color(255, 128, 255));
		frmEnrolmentSystem.getContentPane().add(lblviewallcourses);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.setBounds(570, 449, 62, 21);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(null);
				AdminHomePage.StaffID =StaffID;
			}
		});
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 82, 525, 357);
		frmEnrolmentSystem.getContentPane().add(scrollPane);
		
		tblcourses = new JTable();
		scrollPane.setViewportView(tblcourses);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewAllCourses.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, 0, 824, 498);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);}
		
	public void ViewAllCourses() { 
		java.sql.Connection conn = null;
		try {
			
			//Get connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			if(conn !=null)

			//if connected print connected to database System.out.println("Connected to database");
			System.out.println("Connected to View All courses Details");
		
			//get individual details from database
			String SQLselect = "SELECT * FROM tbl_courses";
			PreparedStatement s=conn.prepareStatement(SQLselect);
			ResultSet rs=s.executeQuery();
					
			//this code displays every result in this section of the database into the table on the view all courses screen
			tblcourses.setModel(DbUtils.resultSetToTableModel(rs));
			//tbl_table2 is the name of the j table
		} catch (Exception ex)
		{
			
		System.out.println("Not connected to View All Staff Details Page");
		
		
		
			ex.printStackTrace();
				
				
	}
}}