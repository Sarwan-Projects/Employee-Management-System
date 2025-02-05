package employee_management_system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
	JTextField tfusername; 
	JPasswordField tfpassword; 
	Login()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(40, 20, 100, 30);
		add(lblusername);
		
		tfusername = new JTextField();
		tfusername.setBounds(150, 20, 150, 30);
		add(tfusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(40, 70, 100, 30);
		add(lblpassword);
		
		tfpassword = new JPasswordField();
		tfpassword.setBounds(150, 70, 150, 30);
		add(tfpassword);
		
		JButton login = new JButton("LOGIN");
		login.setBounds(150, 140, 150, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		setSize(580, 280);
		setLocation(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String username = tfusername.getText();
		String password = tfpassword.getText();
		
		Conn c = new Conn();
		String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
		
		try {
			ResultSet rs = c.s.executeQuery(query);
			if(rs.next())
			{
				setVisible(false);
				new Home();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid username or password");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}}