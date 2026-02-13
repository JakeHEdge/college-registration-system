package Enrolment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Login {
	public static String StaffID = null;
	private JFrame frame;
	private JTextField txtstaffusername;
	private JLabel lblbackgroundpicture;
	private JLabel lbllogintitle;
	private JButton btnstafflogin;
	private JLabel lblstafflogin;
	private JTextField txtadminusername;
	private JPasswordField txtstaffpassword;
	private JPasswordField txtadminpassword;

	//This piece of code displays the date and time.
		SimpleDateFormat  formatter = new SimpleDateFormat ("dd/MM/yyyy");
		Date date = new Date(0);
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		System.out.println("LoginPage");
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtstaffusername = new JTextField();
		txtstaffusername.setColumns(10);
		txtstaffusername.setBounds(10, 137, 96, 19);
		frame.getContentPane().add(txtstaffusername);
		
		lbllogintitle = new JLabel("Login");
		lbllogintitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogintitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbllogintitle.setBounds(127, 10, 156, 63);
		frame.getContentPane().add(lbllogintitle);
		
		btnstafflogin = new JButton("Submit");
		btnstafflogin.setBackground(new Color(255, 255, 255));
		btnstafflogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LoginStaff();
			}
		});
		btnstafflogin.setBounds(10, 195, 96, 21);
		frame.getContentPane().add(btnstafflogin);
		
		lblstafflogin = new JLabel("Staff Login");
		lblstafflogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblstafflogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblstafflogin.setBounds(-20, 83, 156, 63);
		frame.getContentPane().add(lblstafflogin);
		
		JButton btnadminlogin = new JButton("Submit");
		btnadminlogin.setBackground(new Color(255, 255, 255));
		btnadminlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin();
			}
		});
		btnadminlogin.setBounds(330, 195, 96, 21);
		frame.getContentPane().add(btnadminlogin);
		
		txtadminusername = new JTextField();
		txtadminusername.setColumns(10);
		txtadminusername.setBounds(330, 137, 96, 19);
		frame.getContentPane().add(txtadminusername);
		
		JLabel lbladminlogin = new JLabel("Admin Login");
		lbladminlogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbladminlogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbladminlogin.setBounds(298, 83, 156, 63);
		frame.getContentPane().add(lbladminlogin);
		
		txtstaffpassword = new JPasswordField();
		txtstaffpassword.setBounds(10, 166, 96, 19);
		frame.getContentPane().add(txtstaffpassword);
		
		txtadminpassword = new JPasswordField();
		txtadminpassword.setBounds(330, 166, 96, 19);
		frame.getContentPane().add(txtadminpassword);
		
		lblbackgroundpicture = new JLabel("New label");
		lblbackgroundpicture.setIcon(new ImageIcon(Login.class.getResource("/Images/riverside  background.png")));
		lblbackgroundpicture.setBounds(-90, -55, 626, 369);
		frame.getContentPane().add(lblbackgroundpicture);
	}
	
		public void LoginAdmin() {
			Connection conn = null;
			try {
				//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
				conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");
				
				//This code displays the message connected if the code gets this far.
				System.out.println("Connected to the Login Page");
				
				//This bit of code selects StaffID and Password Matches this is so they can check for a valid login for the system.
				String SQLselect = "SELECT * FROM tbl_staff WHERE (staffID='" + txtadminusername.getText() + "' AND Password = '" + txtadminpassword.getText() + "' AND Staff_Or_Admin = 'Admin')";
				PreparedStatement s=conn.prepareStatement(SQLselect);
				ResultSet rs=s.executeQuery();
				
				if (rs.next()) {
					String name = rs.getString("Forename");
					String StaffID = rs.getString("StaffID");
					
					//This piece of code shows a pop up box when admin enter their valid login information the pop up  box says "Hello  followed by their name in the data base".
					JOptionPane.showMessageDialog(null, "Hello " + name +"!");
					
					//This piece of code redirects the admin to the admin Home page.
					AdminHomePage.StaffID = StaffID;
					AdminLoginTracker();
					
					//This piece of code sends the user to the home page.
					AdminHomePage.main(null);
					frame.dispose();
				}
				else {
					//This will show a message saying that the details entered were wrong.
					JOptionPane.showMessageDialog(null,"Wrong details try again.");
					Login.main(null);
					frame.dispose();
				}
				s.close();
			} catch(Exception ex)
			{
			//This displays a message saying not connected to the database.
			System.out.println("Admin Login isnt connected to the databases");
			
			ex.printStackTrace();
			}
		}
			
			public void LoginStaff() {
				Connection conn = null;
				try {
					//This line of code links the mysql database to the java workspace so it can retrieve and send information when needed.
					conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");
					
					//Displays the message connected if the code gets this far.
					System.out.println("Connected to the Login Page");
					
					//This bit of code selects StaffID and Password Matches this is so they can check for a valid login for the system.
					String SQLselect = "SELECT * FROM tbl_staff WHERE (staffID='" + txtstaffusername.getText() + "' AND Password = '" + txtstaffpassword.getText() + "' AND Staff_Or_Admin = 'Staff')";
					PreparedStatement s=conn.prepareStatement(SQLselect);
					ResultSet rs=s.executeQuery();
					
					if (rs.next()) {
						String name = rs.getString("Forename");
						String StaffID = rs.getString("StaffID");
						
						//This code shows a pop up box when admin enter their valid login information the pop up  box says "Hello  followed by their name in the data base".
						JOptionPane.showMessageDialog(null, "Hello " + name +"!");
						
						//This piece of code redirects the staff to the staff Home page
						StaffHomePage.StaffID = StaffID;
						StaffLoginTracker();
						
						//This piece of code sends the user to the home page.
						StaffHomePage.main(null);
						frame.dispose();
					}
					else {
						//This will show a message saying that the details entered were wrong.
						JOptionPane.showMessageDialog(null,"Wrong details try again.");
						Login.main(null);
						frame.dispose();
					}
					s.close();
				} catch(Exception ex)
				{
				//This displays a message saying not connected to the database.	
				System.out.println("Staff Login isnt connected to the databases");
				
				ex.printStackTrace();
		}
	}
			
			public void AdminLoginTracker() {
				Connection conn = null;
				try {
					//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
					conn = (Connection)DriverManager.getConnection ("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");
					//This peace  of code says that it is connected to the database.
					System.out.println("Login tracker connected to database");
					//This statement checks the the AdminID and Password information provided the information required.
					String insert = "INSERT into tbl_logintracker VALUES (null, '"+txtadminusername.getText() + "','" + formatter.format(date) +"')";
					PreparedStatement  ps = conn.prepareStatement(insert);
					ps.execute();
					
				} catch(Exception ex)
				{
					ex.printStackTrace();
				}	
			}
			public void StaffLoginTracker() {
				Connection conn = null;
				try {
					//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
					conn = (Connection)DriverManager.getConnection ("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");
					//This peace  of code says that it is connected to the database
					System.out.println("Login tracker connected to database");
					//This statement checks the the AdminID and Password information provided the information required.
					String insert = "INSERT into tbl_logintracker VALUES (null, '"+txtstaffusername.getText() + "','" + formatter.format(date) +"')";
					PreparedStatement  ps = conn.prepareStatement(insert);
					ps.execute();
					
				} catch(Exception ex)
				{
					ex.printStackTrace();
				}	
			}		
}