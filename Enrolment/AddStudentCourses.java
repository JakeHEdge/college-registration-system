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

public class AddStudentCourses {
	public static String StaffID = null;
	public static String ApplicationID = null;
	private JFrame frmEnrolmentSystem;
	private JTextField txtcourseid;
	private JLabel lblcourses;
	private JButton btnback;
	private JButton btnsave;
	private JTextField txtapplication_id;
	private JLabel lblapplication_id;
	private JLabel lblcourse_id;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentCourses window = new AddStudentCourses();
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
	public AddStudentCourses() {
		initialize();
		System.out.println("AddCourses");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(AddStudentCourses.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 525, 227);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(AddStudentCourses.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lbladdcourses = new JLabel("Add Student Courses");
		lbladdcourses.setForeground(new Color(142, 69, 133));
		lbladdcourses.setFont(new Font("Corbel", Font.PLAIN, 37));
		lbladdcourses.setBackground(new Color(255, 128, 255));
		lbladdcourses.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lbladdcourses);
		
		txtcourseid = new JTextField();
		txtcourseid.setColumns(10);
		txtcourseid.setBounds(172, 140, 176, 49);
		frmEnrolmentSystem.getContentPane().add(txtcourseid);
		
		lblcourses = new JLabel("Courses");
		lblcourses.setBackground(new Color(255, 255, 255));
		lblcourses.setForeground(new Color(255, 255, 255));
		lblcourses.setBounds(172, 67, 192, 13);
		frmEnrolmentSystem.getContentPane().add(lblcourses);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentDetails.main(null);
				ViewStudentDetails.StaffID =StaffID;
			}
		});
		btnback.setBounds(438, 168, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		btnsave = new JButton("Save");
		btnsave.setBackground(new Color(255, 255, 255));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse();
			}
		});
		btnsave.setBounds(360, 168, 69, 21);
		frmEnrolmentSystem.getContentPane().add(btnsave);
		
		txtapplication_id = new JTextField();
		txtapplication_id.setColumns(10);
		txtapplication_id.setBounds(172, 81, 176, 49);
		frmEnrolmentSystem.getContentPane().add(txtapplication_id);
		
		lblapplication_id = new JLabel("Application_ID");
		lblapplication_id.setForeground(new Color(255, 255, 255));
		lblapplication_id.setBackground(new Color(255, 255, 255));
		lblapplication_id.setBounds(10, 87, 130, 13);
		frmEnrolmentSystem.getContentPane().add(lblapplication_id);
		txtapplication_id.setText(ApplicationID);
		
		lblcourse_id = new JLabel("Course_ID");
		lblcourse_id.setForeground(new Color(255, 255, 255));
		lblcourse_id.setBackground(new Color(255, 255, 255));
		lblcourse_id.setBounds(10, 142, 130, 13);
		frmEnrolmentSystem.getContentPane().add(lblcourse_id);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddStudentCourses.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, 0, 511, 189);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);
		
	}
		
		public void AddCourse() { 
			java.sql.Connection conn = null;
			try {
				//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

				if(conn !=null)

				//if connected print connected to database System.out.println("Connected to database");
				System.out.println("Connected to Add Student Courses");
				
				String SQLinsert;
				if		(txtapplication_id.getText().trim().isEmpty()
						|| txtcourseid.getText().trim().isEmpty())
				{
				//This code opens a dialog box that says Please include all required fields!!!.
					JOptionPane.showMessageDialog(null, "Please include all required fields!!!");
				}
					else
					
					//This piece of code inputs the information into the database.
		      try {		SQLinsert = "INSERT into tbl_studentcourses values (?,?)";
						PreparedStatement s = conn.prepareStatement(SQLinsert);
						s.setString(1, txtapplication_id.getText());
						s.setString(2, txtcourseid.getText());
						s.execute();
					
						//This code opens a dialog box that says that the information is "saved".
						JOptionPane.showMessageDialog(null, "saved");
						
						//This code takes the user to the home page.
						AddStudentCourses.main(null);
						
						s.close();
						
						} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Not saved to database: error:" +e);
						}
			
			} 
			catch (Exception ex)
			{
				
			System.out.println("Not connected to Add Course Page");
			
				ex.printStackTrace();
			}
		}
}

