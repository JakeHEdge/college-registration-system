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
import javax.swing.JScrollPane;

public class ViewAllQualifications {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JButton btnBack;
	private JTable tbl_courses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllQualifications window = new ViewAllQualifications();
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
	public ViewAllQualifications() {
		initialize();
		System.out.println("ViewCourses");
		ViewCourses();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllQualifications.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 838, 535);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, -16, 113, 102);
		lblNewLabel_2.setIcon(new ImageIcon(ViewAllQualifications.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.getContentPane().add(lblNewLabel_2);
		
		JLabel lblviewallqualifications = new JLabel("View All Qualifications");
		lblviewallqualifications.setBounds(77, 6, 423, 44);
		lblviewallqualifications.setForeground(new Color(142, 69, 133));
		lblviewallqualifications.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblviewallqualifications.setBackground(new Color(255, 128, 255));
		frmEnrolmentSystem.getContentPane().add(lblviewallqualifications);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setBounds(570, 449, 62, 21);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(null);
				AdminHomePage.StaffID =StaffID;
			}
		});
		frmEnrolmentSystem.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 82, 525, 357);
		frmEnrolmentSystem.getContentPane().add(scrollPane);
		
		tbl_courses = new JTable();
		scrollPane.setViewportView(tbl_courses);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewAllQualifications.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel_1.setBounds(0, 0, 824, 498);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel_1);
	}
	
	public void ViewCourses() { 
		java.sql.Connection conn = null;
		try {
			
			//Get connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

			if(conn !=null)

			//if connected print connected to database System.out.println("Connected to database");
			System.out.println("Connected to View Courses Page");
		
			//get individual details from database
			String SQLselect = "SELECT * FROM tbl_courses";
			PreparedStatement s=conn.prepareStatement(SQLselect);
			ResultSet rs=s.executeQuery();
					
			//this code displays every result in this section of the database into the table on the view all courses screen
			tbl_courses.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception ex)
		{
			
		System.out.println("Not connected to View Courses Page");
		
		
		
			ex.printStackTrace();
	
}
		
}
}