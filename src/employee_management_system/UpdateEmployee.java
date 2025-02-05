package employee_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateEmployee extends JFrame implements ActionListener
{
	JButton add1,back;
	JLabel lblempId;
	String empId;
	JTextField tfeducation,tffname,tfaddress,tfsalary,tfphone,tfemail,tfdes;
	public UpdateEmployee(String empId) 
	{
		this.empId = empId;
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Update Employee Details");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 150, 150, 30);
		labelname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200, 150, 150, 30);
		add(lblname);
		
		JLabel labelfname = new JLabel("Father's Name");
		labelfname.setBounds(420, 150, 150, 30);
		labelfname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelfname);
		
		tffname = new JTextField();
		tffname.setBounds(600, 150, 150, 30);
		add(tffname);
		
		JLabel labelfdob = new JLabel("Date of Birth");
		labelfdob.setBounds(50, 200, 150, 30);
		labelfdob.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelfdob);
		
		JLabel lbldob = new JLabel();
		lbldob.setBounds(200, 200, 150, 30);
		add(lbldob);
		
		JLabel labelsalary = new JLabel("Salary");
		labelsalary.setBounds(420, 200, 150, 30);
		labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(600, 200, 150, 30);
		add(tfsalary);
		
		JLabel labeladdress = new JLabel("Address");
		labeladdress.setBounds(50, 250, 150, 30);
		labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200, 250, 150, 30);
		add(tfaddress);
		
		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(420, 250, 150, 30);
		labelphone.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600, 250, 150, 30);
		add(tfphone);
		
		JLabel labelemail = new JLabel("Email");
		labelemail.setBounds(50, 300, 150, 30);
		labelemail.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200, 300, 150, 30);
		add(tfemail);
		
		JLabel labeledu = new JLabel("Highest Education");
		labeledu.setBounds(420, 300, 150, 30);
		labeledu.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeledu);
		
		tfeducation = new JTextField();
		tfeducation.setBounds(600,300,150,30);
		tfeducation.setBackground(Color.white);
		add(tfeducation);
		
		JLabel labeldes = new JLabel("Deisgnation");
		labeldes.setBounds(50, 350, 150, 30);
		labeldes.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeldes);
		
		tfdes = new JTextField();
		tfdes.setBounds(200, 350, 150, 30);
		add(tfdes);
		
		JLabel labelaadhar = new JLabel("Aadhar Number");
		labelaadhar.setBounds(420, 350, 150, 30);
		labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelaadhar);
		
		JLabel lblaadhar = new JLabel();
		lblaadhar.setBounds(600, 350, 150, 30);
		add(lblaadhar);
		
		JLabel labelempid = new JLabel("Employee Id");
		labelempid.setBounds(50, 400, 150, 30);
		labelempid.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelempid);
		
		lblempId = new JLabel();
		lblempId.setBounds(200, 400, 150, 30);
		lblempId.setFont(new Font("serif", Font.PLAIN, 20));
		add(lblempId);
		
		Conn c = new Conn();
		String query = "select * from employee where empId = '"+empId+"'";
		try {
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next())
			{
				lblname.setText(rs.getString("name"));
				tffname.setText(rs.getString("fname"));
				lbldob.setText(rs.getString("dob"));
				tfaddress.setText(rs.getString("address"));
				tfsalary.setText(rs.getString("salary"));
				tfphone.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));
				tfeducation.setText(rs.getString("education"));
				lblaadhar.setText(rs.getString("aadhar"));
				lblempId.setText(rs.getString("empId"));
				tfdes.setText(rs.getString("designation"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		add1 = new JButton("Update Details");
		add1.setBounds(250, 530, 150, 40);
		add1.setBackground(Color.black);
		add1.setForeground(Color.white);
		add1.addActionListener(this);
		add(add1);
		
		back = new JButton("Back");
		back.setBounds(450, 530, 150, 40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		setSize(900,650);
		setLocation(280,50);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new UpdateEmployee("");
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==add1)
		{
			String fname = tffname.getText();
			String salary = tfsalary.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String education = tfeducation.getText();
			String designation = tfdes.getText();
			
			Conn c = new Conn();
			String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId =  '"+empId+"'";
			try {
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Updated Successfully ");
				setVisible(false);
				new Home();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==back)
		{
			setVisible(false);
			new Home();
		}
	}
}