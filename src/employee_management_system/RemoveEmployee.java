package employee_management_system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener
{
	Choice cEmpId;
	JButton back, delete;
	public RemoveEmployee() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel labelempId = new JLabel("Employee Id");
		labelempId.setBounds(50, 50, 100, 30);
		add(labelempId);
		
		cEmpId = new Choice();
		cEmpId.setBounds(200, 50, 150, 30);
		add(cEmpId);
		
		Conn c = new Conn();
		String query = "select * from employee";
		try {
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next())
			{
				cEmpId.add(rs.getString("empId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 100, 100, 30);
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200, 100, 100, 30);
		add(lblname);
		
		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(50, 150, 100, 30);
		add(labelphone);
		
		JLabel lblphone = new JLabel();
		lblphone.setBounds(200, 150, 100, 30);
		add(lblphone);
		
		JLabel labelemail = new JLabel("Email");
		labelemail.setBounds(50, 200, 100, 30);
		add(labelemail);
		
		JLabel lblemail = new JLabel();
		lblemail.setBounds(200, 200, 132, 30);
		add(lblemail);
		
		Conn c1 = new Conn();
		String query1 = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
		try {
			ResultSet rs = c1.s.executeQuery(query1);
			while(rs.next())
			{
				lblname.setText(rs.getString("name"));
				lblphone.setText(rs.getString("phone"));
				lblemail.setText(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cEmpId.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				Conn c1 = new Conn();
				String query1 = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
				try {
					ResultSet rs = c1.s.executeQuery(query1);
					while(rs.next())
					{
						lblname.setText(rs.getString("name"));
						lblphone.setText(rs.getString("phone"));
						lblemail.setText(rs.getString("email"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} );
		
		delete = new JButton("Delete");
		delete.setBounds(80, 300, 100, 30);
		delete.setBackground(Color.black);
		delete.setForeground(Color.white);
		delete.addActionListener(this);
		add(delete);
		
		back = new JButton("Back");
		back.setBounds(220, 300, 100, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
		Image i2 = i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(370, 0, 600, 400);
		add(image);
		
		setSize(1000,430);
		setLocation(200, 150);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new RemoveEmployee();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==delete)
		{
			Conn c = new Conn();
			String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
			try {
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
				setVisible(false);
				new Home();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
			new Home();
		}
	}
}