package com.se.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.se.control.AdminControl;
import com.se.model.AdminInfoTable;

public class LogIn extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField passwordField;
	private ButtonGroup user_type;
	private JComboBox comboBox = null;
	private JRadioButton rbManager = null;
	private JRadioButton rbEmployee = null;
	private JButton btnOK = null;
	private JButton btnCancel = null;
	private int flag=1;
	private JComboBox username;
	private static LogIn frame = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LogIn();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(113, 102, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(113, 127, 54, 15);
		contentPane.add(label_1);
		
		btnOK = new JButton("\u767B\u5F55");
		btnOK.setBounds(111, 208, 80, 23);
		contentPane.add(btnOK);
		btnOK.addActionListener(this);
		
		btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setBounds(253, 208, 80, 23);
		contentPane.add(btnCancel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 124, 108, 21);
		contentPane.add(passwordField);
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		label_3.setFont(new Font("楷体", Font.PLAIN, 26));
		label_3.setBounds(111, 35, 220, 44);
		contentPane.add(label_3);
		
		rbManager = new JRadioButton("\u7CFB\u7EDF\u7BA1\u7406\u5458");
		rbManager.setBounds(113, 164, 121, 23);
		contentPane.add(rbManager);
		rbManager.addActionListener(this);

		

		rbEmployee = new JRadioButton("\u8D44\u6599\u7BA1\u7406\u5458");
		rbEmployee.setBounds(239, 164, 121, 23);
		contentPane.add(rbEmployee);
		rbEmployee.addActionListener(this);

	
		
		user_type = new ButtonGroup();
		user_type.add(rbManager);
		user_type.add(rbEmployee);
		
		username = new JComboBox();
		username.setBounds(225, 99, 108, 21);
		contentPane.add(username);
		
	}
	int flag1 = -1;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getSource().equals(rbManager)){
			Iterator<AdminInfoTable> it = AdminControl.getAdminControl().getAdmin("0").iterator();
			username.removeAllItems();
			while(it.hasNext()){
				username.addItem(it.next().getAdminId());
			}
			flag1 = 0;
		}
		if(e.getSource().equals(rbEmployee)){
			Iterator<AdminInfoTable> it = AdminControl.getAdminControl().getAdmin("1").iterator();
			username.removeAllItems();
			while(it.hasNext()){
				username.addItem(it.next().getAdminId());
			}
			flag1 = 1;
		}
		if(e.getSource().equals(btnOK)){
			String pw = String.valueOf(passwordField.getPassword());
			if(pw.length() == 0){
				JOptionPane.showMessageDialog(null,"密码不能为空","警告", JOptionPane.WARNING_MESSAGE);
			}
			else{
				if(pw.equals(AdminControl.getAdminControl().getPassword(username.getSelectedItem().toString()))){
					
					MainFrame main = MainFrame.getMainFrame(flag1);
					main.setVisible(true);
					main.setLocationRelativeTo(null);
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(null,"用户名和密码不匹配，请重新输入","警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
	}
	
	
}
