package com.se.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.se.control.AdminControl;
import com.se.model.AdminInfoTable;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SystemManagement extends javax.swing.JFrame implements ActionListener{
	private JLabel jLabel1;
	private JTextField tfAdminId;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPasswordField tfPassword;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox jComboBox1;
	private static SystemManagement sm = null;;
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static SystemManagement getSystemManagement(){
		if(sm == null){
			sm = new SystemManagement();
			sm.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					sm = null;
				}
			});
		}
		return sm;
	}
	
	private SystemManagement() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u589e\u52a0\u8d44\u6599\u7ba1\u7406\u5458");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7528\u6237\u540d\uff1a");
				jLabel1.setBounds(21, 20, 60, 17);
			}
			{
				tfAdminId = new JTextField();
				getContentPane().add(tfAdminId);
				tfAdminId.setBounds(100, 18, 128, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801\uff1a");
				jLabel2.setBounds(21, 74, 60, 17);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u7c7b\u522b\uff1a");
				jLabel3.setBounds(21, 129, 60, 17);
			}
			{
				ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(
								new String[] { "资料录入员工", "系统管理员" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(100, 125, 128, 24);
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("\u4fdd\u5b58");
				btnSave.setBounds(57, 210, 50, 30);
				btnSave.setMargin(new java.awt.Insets(4, 4, 4, 4));
				btnSave.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(tfAdminId.getText().length()==0||tfPassword.getText().length()==0){
							JOptionPane.showMessageDialog(null,"输入的信息不完整，请重新输入","警告", JOptionPane.OK_CANCEL_OPTION);
						}else{
						int flag = 0;
						List<AdminInfoTable> adminList = AdminControl.getAdminControl().getAllAdmin();
						for(int i = 0;i<adminList.size();i++){
							if(adminList.get(i).equals(tfAdminId.getText())){
								flag = -1;
							}
						}
						if(flag == -1){
							JOptionPane.showMessageDialog(null,"用户名重复，请重新输入","警告", JOptionPane.OK_CANCEL_OPTION);
							}else{
								if(JOptionPane.showConfirmDialog(null, "确定要增加课程?","消息提示",JOptionPane.YES_NO_OPTION)==0){
									if(jComboBox1.getSelectedItem().toString().equals("资料管理员")){
										AdminInfoTable admin = new AdminInfoTable(tfAdminId.getText(),
												tfPassword.getText(),
												"1");
										AdminControl.getAdminControl().saveAdmin(admin);
										JOptionPane.showMessageDialog(null,"增加成功","警告", JOptionPane.OK_CANCEL_OPTION);
									}else{
										AdminInfoTable admin = new AdminInfoTable(tfAdminId.getText(),
												tfPassword.getText(),
												"0");
										AdminControl.getAdminControl().saveAdmin(admin);
										JOptionPane.showMessageDialog(null,"增加成功","警告", JOptionPane.OK_CANCEL_OPTION);
									}
								}
							}
						}
					}
					
				});
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				getContentPane().add(getJPasswordField1());
				btnCancel.setText("\u53d6\u6d88");
				btnCancel.setBounds(158, 210, 50, 30);
				btnCancel.setMargin(new java.awt.Insets(4, 4, 4, 4));
				btnCancel.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						sm.dispose();
						sm=null;
					}
				});
			}
			pack();
			this.setSize(272, 301);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private JPasswordField getJPasswordField1() {
		if(tfPassword == null) {
			tfPassword = new JPasswordField();
			tfPassword.setBounds(99, 67, 126, 24);
		}
		return tfPassword;
	}
	 

}
