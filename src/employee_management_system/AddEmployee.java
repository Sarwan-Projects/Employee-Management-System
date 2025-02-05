package employee_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener
{
	Random rd = new Random();
	int number = rd.nextInt(999999);
	JButton add1,back;
	JComboBox cbedu;
	JLabel lblempId;
	JTextField tfname,tffname,tfaddress,tfsalary,tfphone,tfemail,tfaadhar,tfdes;
	JDateChooser dcdob;
	public AddEmployee() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Employee Details");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 150, 150, 30);
		labelname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 150, 150, 30);
		add(tfname);
		
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
		
		dcdob = new JDateChooser();
		dcdob.setBounds(200, 200, 150, 30);
		add(dcdob);
		
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
		
		String course[] = {"BBA","BCA","BA","B.COM","BTECH","BSC","MBA","MCA","MA","M.COM","MTECH","MSC"};
		cbedu = new JComboBox(course);
		cbedu.setBounds(600,300,150,30);
		cbedu.setBackground(Color.white);
		add(cbedu);
		
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
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(600, 350, 150, 30);
		add(tfaadhar);
		
		JLabel labelempid = new JLabel("Employee Id");
		labelempid.setBounds(50, 400, 150, 30);
		labelempid.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelempid);
		
		lblempId = new JLabel("" + number);
		lblempId.setBounds(200, 400, 150, 30);
		lblempId.setFont(new Font("serif", Font.PLAIN, 20));
		add(lblempId);
		
		add1 = new JButton("Add Details");
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
		new AddEmployee();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==add1)
		{
			String name = tfname.getText();
			String fname = tffname.getText();
			String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
			String salary = tfsalary.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String education = (String)cbedu.getSelectedItem();
			String designation = tfdes.getText();
			String aadhar = tfaadhar.getText();
			String empId = lblempId.getText();
			
			Conn c = new Conn();
			String query = "insert into employee values('"+name+"', '"+fname+"','"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
			try {
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Added Successfully ");
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