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
import javax.swing.JPanel;

public class AddCourses {
	public static String StaffID = null;
	private JFrame frmEnrolmentSystem;
	private JTextField txtcourselevel;
	private JTextField txtcoursedurationweeks;
	private JTextField txtcoursedetails;
	private JLabel lblcourses;
	private JButton btnback;
	private JButton btnsave;
	private JTextField txtcoursename;
	private JLabel lblcoursename;
	private JLabel lblcourselevel;
	private JLabel lblcoursedetails;
	private JLabel lblcoursedurationweeks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourses window = new AddCourses();
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
	public AddCourses() {
		initialize();
		System.out.println("AddCourses");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(AddCourses.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 600, 354);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(AddCourses.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lbladdcourses = new JLabel("Add Courses");
		lbladdcourses.setForeground(new Color(142, 69, 133));
		lbladdcourses.setFont(new Font("Corbel", Font.PLAIN, 37));
		lbladdcourses.setBackground(new Color(255, 128, 255));
		lbladdcourses.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lbladdcourses);
		
		txtcourselevel = new JTextField();
		txtcourselevel.setColumns(10);
		txtcourselevel.setBounds(172, 140, 176, 49);
		frmEnrolmentSystem.getContentPane().add(txtcourselevel);
		
		txtcoursedurationweeks = new JTextField();
		txtcoursedurationweeks.setColumns(10);
		txtcoursedurationweeks.setBounds(172, 199, 176, 49);
		frmEnrolmentSystem.getContentPane().add(txtcoursedurationweeks);
		
		txtcoursedetails = new JTextField();
		txtcoursedetails.setColumns(10);
		txtcoursedetails.setBounds(172, 258, 176, 49);
		frmEnrolmentSystem.getContentPane().add(txtcoursedetails);
		
		lblcourses = new JLabel("Courses");
		lblcourses.setForeground(new Color(255, 255, 255));
		lblcourses.setBounds(172, 67, 192, 13);
		frmEnrolmentSystem.getContentPane().add(lblcourses);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHomePage.main(null);
				AdminHomePage.StaffID =StaffID;
			}
		});
		btnback.setBounds(511, 292, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		btnsave = new JButton("Save");
		btnsave.setBackground(new Color(255, 255, 255));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse();
			}
		});
		btnsave.setBounds(440, 292, 69, 21);
		frmEnrolmentSystem.getContentPane().add(btnsave);
		
		txtcoursename = new JTextField();
		txtcoursename.setColumns(10);
		txtcoursename.setBounds(172, 81, 176, 49);
		frmEnrolmentSystem.getContentPane().add(txtcoursename);
		
		lblcoursename = new JLabel("Course_Name");
		lblcoursename.setForeground(new Color(255, 255, 255));
		lblcoursename.setBackground(new Color(255, 255, 255));
		lblcoursename.setBounds(10, 87, 130, 13);
		frmEnrolmentSystem.getContentPane().add(lblcoursename);
		
		lblcourselevel = new JLabel("Course_Level");
		lblcourselevel.setForeground(new Color(255, 255, 255));
		lblcourselevel.setBounds(10, 142, 130, 13);
		frmEnrolmentSystem.getContentPane().add(lblcourselevel);
		
		lblcoursedetails = new JLabel("Course_Details");
		lblcoursedetails.setForeground(new Color(255, 255, 255));
		lblcoursedetails.setBounds(10, 254, 130, 13);
		frmEnrolmentSystem.getContentPane().add(lblcoursedetails);
		
		lblcoursedurationweeks = new JLabel("Course_Duration_(Weeks)");
		lblcoursedurationweeks.setForeground(new Color(255, 255, 255));
		lblcoursedurationweeks.setBounds(10, 199, 154, 13);
		frmEnrolmentSystem.getContentPane().add(lblcoursedurationweeks);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddCourses.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, 0, 586, 317);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);
		
	}
		
		public void AddCourse() { 
			java.sql.Connection conn = null;
			try {
				//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

				if(conn !=null)

				//if connected print connected to database System.out.println("Connected to database");
				System.out.println("Connected to Admin Home Page");
				
				String SQLinsert;
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
		      try {		SQLinsert = "INSERT into tbl_courses values (null,?,?,?,?)";
						PreparedStatement s = conn.prepareStatement(SQLinsert);
						s.setString(1, txtcoursename.getText());
						s.setString(2, txtcoursedurationweeks.getText());
						s.setString(3, txtcoursedurationweeks.getText());
						s.setString(4, txtcoursedetails.getText());
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
				
			System.out.println("Not connected to Add Course Page");
			
				ex.printStackTrace();
			}
		}
}

