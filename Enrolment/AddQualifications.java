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

public class AddQualifications {
	public static String StaffID = null;
	public static String ApplicationID = null;
	private JFrame frmEnrolmentSystem;
	private JTextField txtapplicationid;
	private JTextField txtexamboard;
	private JTextField txtqualificationname;
	private JLabel lblstudentID;
	private JButton btnback;
	private JButton btnsave;
	private JTextField txtqualificationdate;
	private JTextField txtstaffid;
	private JTextField txtgrade;
	private JTextField txtlevel;
	private JLabel lbllevel;
	private JLabel lblgrade;
	private JLabel lblstaffid;
	private JLabel lblqualificationdate;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQualifications window = new AddQualifications();
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
	public AddQualifications() {
		initialize();
		System.out.println("AddQualifications");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.getContentPane().setBackground(new Color(0, 255, 0));
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(AddQualifications.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 350, 372);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(AddQualifications.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lblqualifications = new JLabel("Qualifications");
		lblqualifications.setForeground(new Color(142, 69, 133));
		lblqualifications.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblqualifications.setBackground(new Color(255, 128, 255));
		lblqualifications.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lblqualifications);
		
		txtapplicationid = new JTextField();
		txtapplicationid.setColumns(10);
		txtapplicationid.setBounds(200, 114, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtapplicationid);
		txtapplicationid.setText(ApplicationID);
		
		txtexamboard = new JTextField();
		txtexamboard.setColumns(10);
		txtexamboard.setBounds(200, 166, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtexamboard);
		
		txtqualificationname = new JTextField();
		txtqualificationname.setColumns(10);
		txtqualificationname.setBounds(200, 140, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtqualificationname);
		
		lblstudentID = new JLabel("Student_ID");
		lblstudentID.setForeground(SystemColor.text);
		lblstudentID.setBounds(22, 114, 131, 13);
		frmEnrolmentSystem.getContentPane().add(lblstudentID);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentDetails.main(null);
				ViewStudentDetails.StaffID = StaffID;
			}
		});
		btnback.setBounds(210, 303, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		btnsave = new JButton("Save");
		btnsave.setBackground(new Color(255, 255, 255));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQualifications();
			}
		});
		btnsave.setBounds(58, 304, 69, 21);
		frmEnrolmentSystem.getContentPane().add(btnsave);
		
		JLabel lblqualificationname = new JLabel("Qualification_Name");
		lblqualificationname.setForeground(SystemColor.text);
		lblqualificationname.setBounds(22, 140, 141, 13);
		frmEnrolmentSystem.getContentPane().add(lblqualificationname);
		
		JLabel lblexamboard = new JLabel("Exam_Board");
		lblexamboard.setForeground(SystemColor.text);
		lblexamboard.setBounds(22, 166, 151, 13);
		frmEnrolmentSystem.getContentPane().add(lblexamboard);
		
		txtqualificationdate = new JTextField();
		txtqualificationdate.setColumns(10);
		txtqualificationdate.setBounds(200, 274, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtqualificationdate);
		
		txtstaffid = new JTextField();
		txtstaffid.setColumns(10);
		txtstaffid.setBounds(200, 248, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtstaffid);
		txtstaffid.setText(StaffID);
		
		txtgrade = new JTextField();
		txtgrade.setColumns(10);
		txtgrade.setBounds(200, 222, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtgrade);
		
		txtlevel = new JTextField();
		txtlevel.setColumns(10);
		txtlevel.setBounds(200, 196, 122, 19);
		frmEnrolmentSystem.getContentPane().add(txtlevel);
		
		lbllevel = new JLabel("Level");
		lbllevel.setForeground(SystemColor.text);
		lbllevel.setBounds(22, 196, 141, 13);
		frmEnrolmentSystem.getContentPane().add(lbllevel);
		
		lblgrade = new JLabel("Grade");
		lblgrade.setForeground(SystemColor.text);
		lblgrade.setBounds(22, 222, 131, 13);
		frmEnrolmentSystem.getContentPane().add(lblgrade);
		
		lblstaffid = new JLabel("Staff_ID");
		lblstaffid.setForeground(SystemColor.text);
		lblstaffid.setBounds(22, 248, 141, 13);
		frmEnrolmentSystem.getContentPane().add(lblstaffid);
		
		lblqualificationdate = new JLabel("Qualification_Date");
		lblqualificationdate.setForeground(SystemColor.text);
		lblqualificationdate.setBounds(22, 274, 151, 13);
		frmEnrolmentSystem.getContentPane().add(lblqualificationdate);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddQualifications.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, 0, 336, 335);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);
		
	}

	
	public void AddQualifications() { 
			java.sql.Connection conn = null;
			try {
	//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

	if(conn !=null)

	//if connected print connected to database System.out.println("Connected to database");
	System.out.println("Connected to Qualification Add Page");
	
	String SQLinsert;
	if		(txtapplicationid.getText().trim().isEmpty()
		    || txtqualificationname.getText().trim().isEmpty()
		    || txtexamboard.getText().trim().isEmpty()
		    || txtlevel.getText().trim().isEmpty()
		    || txtgrade.getText().trim().isEmpty()
		    || txtstaffid.getText().trim().isEmpty()
			|| txtqualificationdate.getText().trim().isEmpty())
	{
	//This code opens a dialog box that says Please include all required fields!!!.
		JOptionPane.showMessageDialog(null, "Please include all required fields!!!");
	}
		else
		
		//This piece of code inputs the information into the database.
  try {		SQLinsert = "INSERT into tbl_qualifications values (null,?,?,?,?,?,?,?)";
			PreparedStatement s = conn.prepareStatement(SQLinsert);
			s.setString(1, txtapplicationid.getText());
			s.setString(2, txtqualificationname.getText());
			s.setString(3, txtexamboard.getText());
			s.setString(4, txtlevel.getText());
			s.setString(5, txtgrade.getText());
			s.setString(6, txtstaffid.getText());
			s.setString(7, txtqualificationdate.getText());
			s.execute();
		
			//This code opens a dialog box that says that the information is "saved".
			JOptionPane.showMessageDialog(null, "saved");
			
			//This code takes the user to the home page.
			StaffHomePage.main(null);
			
			s.close();
			
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Not saved to database: error:" +e);
			}

} 
catch (Exception ex)
{
	
System.out.println("Not connected to Qualification Add Page");

	ex.printStackTrace();
}
}

}
