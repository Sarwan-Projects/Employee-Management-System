package employee_management_system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener
{
	JTable table;
	Choice cemployeeId;
	JButton search,print,update,back;
	public ViewEmployee() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel searchlbl = new JLabel("Search by Employee Id");
		searchlbl.setBounds(20, 20, 150, 20);
		add(searchlbl);
		
		cemployeeId = new Choice();
		cemployeeId.setBounds(180, 20, 150, 20);
		add(cemployeeId);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee");
					
			while(rs.next())
			{
				cemployeeId.add(rs.getString("empId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 100, 1150, 600);
		add(jsp);
		
		search = new JButton("Search");
		search.setBounds(20, 70, 80, 20);
		search.addActionListener(this);
		add(search);
		
		print = new JButton("Print");
		print.setBounds(120, 70, 80, 20);
		print.addActionListener(this);
		add(print);
		
		update = new JButton("Update");
		update.setBounds(220, 70, 80, 20);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(320, 70, 80, 20);
		back.addActionListener(this);
		add(back);
		
		setSize(1150,650);
		setLocation(100,40);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new ViewEmployee();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==search)
		{
			String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==print)
		{
			try {
				table.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==update)
		{
			setVisible(false);
			new UpdateEmployee(cemployeeId.getSelectedItem());
		}
		else if(e.getSource()==back)
		{
			setVisible(false);
			new Home();
		}
	}
}