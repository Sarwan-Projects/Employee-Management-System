package employee_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements ActionListener
{
	Splash()
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		heading.setBounds(68,20, 1100, 50);
		heading.setFont(new Font("serif", Font.BOLD,56));
		heading.setForeground(Color.red);
		add(heading);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(50, 80, 1050, 500);
		add(image);
		
		JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
		clickhere.setBounds(400,400 ,300 , 70);
		clickhere.setBackground(Color.BLACK);
		clickhere.setForeground(Color.WHITE);
		clickhere.addActionListener(this);
		image.add(clickhere);
		
		
		setSize(1170,650);
		setLocation(100,50);
		setVisible(true);
		
		while(true)
		{
			heading.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			heading.setVisible(true);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		new Splash();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		setVisible(false);
		new Login();
	}
}
