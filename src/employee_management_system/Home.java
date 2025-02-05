package employee_management_system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener
{
	JButton add,view,update,remove;
	Home()
	{
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1050, 610,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1050, 610);
		add(image);
		
		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(580, 20, 400, 40);
		heading.setFont(new Font("Raleway",Font.BOLD,25));
		image.add(heading);
		
		add = new JButton("Add Employee");
		add.setBounds(600, 80, 150, 40);
		add.addActionListener(this);
		image.add(add);
		
		view = new JButton("View Employees");
		view.setBounds(780, 80, 150, 40);
		view.addActionListener(this);
		image.add(view);
		
		update = new JButton("Update Employee");
		update.setBounds(600, 150, 150, 40);
		update.addActionListener(this);
		image.add(update);
		
		remove = new JButton("Remove Employee");
		remove.setBounds(780, 150, 150, 40);
		remove.addActionListener(this);
		image.add(remove);
		
		
		setSize(1050, 610);
		setLocation(150,80);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Home();	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==add)
		{
			setVisible(false);
			new AddEmployee();
		}
		else if(e.getSource()==view)
		{
			setVisible(false);
			new ViewEmployee();
		}
		else if(e.getSource()==update)
		{
			setVisible(false);
			new ViewEmployee();
		}
		else
		{
			setVisible(false);
			new RemoveEmployee();
		}
	}
}