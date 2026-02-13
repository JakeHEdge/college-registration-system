package Enrolment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;



public class StaffHomePage {
	public static String StaffID = null;
	private JFrame frame;
	private JLabel lblstaffhomepage;
	private JButton btnaddstudentdetails;
	private JLabel lbllogo;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffHomePage window = new StaffHomePage();
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
	public StaffHomePage() {
		initialize();
		System.out.println("StaffHomePage");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblstaffhomepage = new JLabel("Staff HomePage");
		lblstaffhomepage.setForeground(new Color(142, 69, 133));
		lblstaffhomepage.setFont(new Font("Corbel", Font.PLAIN, 37));
		lblstaffhomepage.setBackground(new Color(255, 128, 255));
		lblstaffhomepage.setBounds(84, 1, 276, 44);
		frame.getContentPane().add(lblstaffhomepage);
		
		JButton btnviewstudentdetails = new JButton("View student details");
		btnviewstudentdetails.setBackground(new Color(255, 255, 255));
		btnviewstudentdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentDetails.main(null);
				ViewStudentDetails.StaffID = StaffID;
			}
		});
		btnviewstudentdetails.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnviewstudentdetails.setForeground(new Color(128, 0, 128));
		btnviewstudentdetails.setBounds(98, 97, 119, 92);
		frame.getContentPane().add(btnviewstudentdetails);
		
		btnaddstudentdetails = new JButton("Add student details");
		btnaddstudentdetails.setBackground(new Color(255, 255, 255));
		btnaddstudentdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentDetails.main(null);
				AddStudentDetails.StaffID = StaffID;
			}
		});
		btnaddstudentdetails.setForeground(new Color(128, 0, 128));
		btnaddstudentdetails.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnaddstudentdetails.setBounds(227, 97, 119, 92);
		frame.getContentPane().add(btnaddstudentdetails);
		
		lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(StaffHomePage.class.getResource("/Images/riverside college done now.png")));
		lbllogo.setBounds(3, -63, 113, 190);
		frame.getContentPane().add(lbllogo);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(StaffHomePage.class.getResource("/Images/riverside  background.png")));
		lblNewLabel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel);
	}
}
