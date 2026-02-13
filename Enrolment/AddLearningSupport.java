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

public class AddLearningSupport {
	public static String StaffID = null;
	public static String ApplicationID = null;
	private JFrame frmEnrolmentSystem;
	private JButton btnback;
	private JButton btnsave;
	private JLabel lblsupporttype;
	private JTextField txtsupporttype;
	private JLabel lbldescriptionofsupporttype;
	private JTextField txtdescriptionofsupporttype;
	private JLabel lblsupportstartdate;
	private JTextField txtsupportstartdate;
	private JLabel lblsupportenddate;
	private JTextField txtsupportenddate;
	private JTextField txtcontactinformation;
	private JLabel lblcontactinformation;
	private JTextField txtehcp;
	private JLabel lblehcp;
	private JTextField txtapplicationid;
	private JLabel lblapplicationid;
	private JTextField txtstaffid;
	private JLabel lblstaffid;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLearningSupport window = new AddLearningSupport();
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
	public AddLearningSupport() {
		initialize();
		System.out.println("AddEnrolmentDetails");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrolmentSystem = new JFrame();
		frmEnrolmentSystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmEnrolmentSystem.setTitle("Enrolment System");
		frmEnrolmentSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(AddLearningSupport.class.getResource("/Images/riverside college done now.png")));
		frmEnrolmentSystem.setBounds(100, 100, 513, 354);
		frmEnrolmentSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrolmentSystem.getContentPane().setLayout(null);
		
		JLabel lblcollegelogo = new JLabel("");
		lblcollegelogo.setIcon(new ImageIcon(AddLearningSupport.class.getResource("/Images/riverside college done now.png")));
		lblcollegelogo.setBounds(0, -16, 113, 102);
		frmEnrolmentSystem.getContentPane().add(lblcollegelogo);
		
		JLabel lbllearningsupport = new JLabel("Learning Support");
		lbllearningsupport.setForeground(new Color(142, 69, 133));
		lbllearningsupport.setFont(new Font("Corbel", Font.PLAIN, 37));
		lbllearningsupport.setBackground(new Color(255, 128, 255));
		lbllearningsupport.setBounds(77, 6, 423, 44);
		frmEnrolmentSystem.getContentPane().add(lbllearningsupport);
		
		btnback = new JButton("Back");
		btnback.setBackground(new Color(255, 255, 255));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentDetails.main(null);
				ViewStudentDetails.StaffID = StaffID;
			}
		});
		btnback.setBounds(437, 293, 62, 21);
		frmEnrolmentSystem.getContentPane().add(btnback);
		
		btnsave = new JButton("Save");
		btnsave.setBackground(new Color(255, 255, 255));
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLearningSupport();
			}
		});
		btnsave.setBounds(359, 292, 69, 21);
		frmEnrolmentSystem.getContentPane().add(btnsave);
		
		lblsupporttype = new JLabel("Support_Type");
		lblsupporttype.setForeground(SystemColor.text);
		lblsupporttype.setBounds(107, 98, 172, 13);
		frmEnrolmentSystem.getContentPane().add(lblsupporttype);
		
		txtsupporttype = new JTextField();
		txtsupporttype.setColumns(10);
		txtsupporttype.setBounds(107, 107, 172, 19);
		frmEnrolmentSystem.getContentPane().add(txtsupporttype);
		
		lbldescriptionofsupporttype = new JLabel("Description_Of_Support_Type");
		lbldescriptionofsupporttype.setForeground(SystemColor.text);
		lbldescriptionofsupporttype.setBounds(107, 122, 172, 13);
		frmEnrolmentSystem.getContentPane().add(lbldescriptionofsupporttype);
		
		txtdescriptionofsupporttype = new JTextField();
		txtdescriptionofsupporttype.setColumns(10);
		txtdescriptionofsupporttype.setBounds(107, 136, 172, 19);
		frmEnrolmentSystem.getContentPane().add(txtdescriptionofsupporttype);
		
		lblsupportstartdate = new JLabel("Support_Start_Date");
		lblsupportstartdate.setForeground(SystemColor.text);
		lblsupportstartdate.setBounds(107, 158, 172, 13);
		frmEnrolmentSystem.getContentPane().add(lblsupportstartdate);
		
		txtsupportstartdate = new JTextField();
		txtsupportstartdate.setColumns(10);
		txtsupportstartdate.setBounds(107, 167, 172, 19);
		frmEnrolmentSystem.getContentPane().add(txtsupportstartdate);
		
		lblsupportenddate = new JLabel("Support_End_Date");
		lblsupportenddate.setForeground(SystemColor.text);
		lblsupportenddate.setBounds(318, 56, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblsupportenddate);
		
		txtsupportenddate = new JTextField();
		txtsupportenddate.setColumns(10);
		txtsupportenddate.setBounds(318, 65, 172, 19);
		frmEnrolmentSystem.getContentPane().add(txtsupportenddate);
		
		txtcontactinformation = new JTextField();
		txtcontactinformation.setColumns(10);
		txtcontactinformation.setBounds(318, 167, 172, 19);
		frmEnrolmentSystem.getContentPane().add(txtcontactinformation);
		
		lblcontactinformation = new JLabel("Contact_Information");
		lblcontactinformation.setForeground(SystemColor.text);
		lblcontactinformation.setBounds(318, 157, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblcontactinformation);
		
		txtehcp = new JTextField();
		txtehcp.setColumns(10);
		txtehcp.setBounds(318, 131, 172, 19);
		frmEnrolmentSystem.getContentPane().add(txtehcp);
		
		lblehcp = new JLabel("EHCP");
		lblehcp.setForeground(SystemColor.text);
		lblehcp.setBounds(318, 122, 45, 13);
		frmEnrolmentSystem.getContentPane().add(lblehcp);
		
		txtapplicationid = new JTextField();
		txtapplicationid.setColumns(10);
		txtapplicationid.setBounds(318, 102, 172, 19);
		frmEnrolmentSystem.getContentPane().add(txtapplicationid);
		txtapplicationid.setText(ApplicationID);
		
		lblapplicationid = new JLabel("Application_ID");
		lblapplicationid.setForeground(SystemColor.text);
		lblapplicationid.setBounds(318, 89, 122, 13);
		frmEnrolmentSystem.getContentPane().add(lblapplicationid);
		
		txtstaffid = new JTextField();
		txtstaffid.setColumns(10);
		txtstaffid.setBounds(107, 69, 172, 19);
		frmEnrolmentSystem.getContentPane().add(txtstaffid);
		txtstaffid.setText(StaffID);
		
		lblstaffid = new JLabel("Staff_ID");
		lblstaffid.setForeground(SystemColor.text);
		lblstaffid.setBounds(107, 60, 172, 13);
		frmEnrolmentSystem.getContentPane().add(lblstaffid);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddLearningSupport.class.getResource("/Images/enrolment system backdrop.png")));
		lblNewLabel.setBounds(0, -4, 586, 317);
		frmEnrolmentSystem.getContentPane().add(lblNewLabel);
	}
	
	public void AddLearningSupport() { 
		java.sql.Connection conn = null;
		try {
//This line of code links the MySQL database to the java workspace so it can retrieve and send information when needed.
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment", "root", "Student2024");

if(conn !=null)

//if connected print connected to database System.out.println("Connected to database");
System.out.println("Connected to Add Learning Support Page");

String SQLinsert;
if		( txtstaffid.getText().trim().isEmpty()
		|| txtsupporttype.getText().trim().isEmpty()
	    || txtdescriptionofsupporttype.getText().trim().isEmpty()
	    || txtsupportstartdate.getText().trim().isEmpty()
	    || txtsupportenddate.getText().trim().isEmpty()
	    || txtapplicationid.getText().trim().isEmpty()
		|| txtehcp.getText().trim().isEmpty()
		|| txtcontactinformation.getText().trim().isEmpty())
		
{
//This code opens a dialog box that says Please include all required fields!!!.
	JOptionPane.showMessageDialog(null, "Please include all required fields!!!");
}
	else
	
	//This piece of code inputs the information into the database.
try {		SQLinsert = "INSERT into tbl_learningsupport values (null,?,?,?,?,?,?,?,?)";
		PreparedStatement s = conn.prepareStatement(SQLinsert);
		s.setString(1, txtstaffid.getText());
		s.setString(2, txtsupporttype.getText());
		s.setString(3, txtdescriptionofsupporttype.getText());
		s.setString(4, txtsupportstartdate.getText());
		s.setString(5, txtsupportenddate.getText());
		s.setString(6, txtapplicationid.getText());
		s.setString(7, txtehcp.getText());
		s.setString(8, txtcontactinformation.getText());
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

System.out.println("Not connected to Add Learning Support Page");

ex.printStackTrace();
}
}
	
}

