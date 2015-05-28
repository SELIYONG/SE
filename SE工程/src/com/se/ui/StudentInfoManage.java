package com.se.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.se.control.StudentInfoControl;
import com.se.model.StudentInfoTable;


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
public class StudentInfoManage extends javax.swing.JFrame implements ActionListener{
	private JButton btnSearchStu;
	private JButton btnUpdStuInfo;
	private JButton btnDelStuInfo;
	private JButton btnAddStuInfo;
	private JTextField tfTelePhone;
	private JLabel jLabel9;
	private JTextField tfNativePlace;
	private JLabel jLabel8;
	private JTextField tfClassNumber;
	private JTextField tfStudentNoChange;
	private JLabel jLabel5;
	private JLabel jLabel1;
	private JTextField tfStudentSearch;
	private JTextField tfDepartment;
	private JButton btnCancel;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JComboBox sexCombox;
	private JTextField tfStudentIdCard;
	private JLabel jLabel4;
	private JTextField tfStudentName;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private static StudentInfoManage siManage = null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StudentInfoManage inst = new StudentInfoManage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public static StudentInfoManage getStudentInfoManage(){
		if (siManage == null){
			siManage = new StudentInfoManage();
		}
		return siManage;
	}
	
	private StudentInfoManage() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
			
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 55, 305, 348);
				jPanel1.setBorder(BorderFactory.createTitledBorder("\u5b66\u751f\u4fe1\u606f"));
				jPanel1.setLayout(null);
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u5b66\u53f7\uff1a");
					jLabel2.setBounds(34, 39, 100, 25);
				}
				{
					tfStudentNoChange = new JTextField();
					jPanel1.add(tfStudentNoChange);
					tfStudentNoChange.setBounds(134, 36, 138, 25);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("\u59d3\u540d\uff1a");
					jLabel3.setBounds(34, 78, 100, 25);
				}
				{
					tfStudentName = new JTextField();
					jPanel1.add(tfStudentName);
					tfStudentName.setBounds(134, 75, 138, 25);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
					jLabel4.setBounds(34, 118, 100, 25);
				}
				{
					tfStudentIdCard = new JTextField();
					jPanel1.add(tfStudentIdCard);
					tfStudentIdCard.setBounds(134, 115, 138, 25);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("\u6027\u522b\uff1a");
					jLabel5.setBounds(34, 158, 100, 25);
				}
				{
					ComboBoxModel jComboBox1Model = 
							new DefaultComboBoxModel(
									new String[] { "男", "女" });
					sexCombox = new JComboBox();
					jPanel1.add(sexCombox);
					sexCombox.setModel(jComboBox1Model);
					sexCombox.setBounds(134, 155, 138, 25);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("\u5b66\u9662\uff1a");
					jLabel6.setBounds(34, 197, 100, 25);
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7);
					jLabel7.setText("\u73ed\u7ea7\u53f7\uff1a");
					jLabel7.setBounds(34, 237, 100, 25);
				}
				{
					tfClassNumber = new JTextField();
					jPanel1.add(tfClassNumber);
					tfClassNumber.setBounds(134, 235, 138, 25);
				}
				{
					jLabel8 = new JLabel();
					jPanel1.add(jLabel8);
					jLabel8.setText("\u5bb6\u5ead\u4f4f\u5740\uff1a");
					jLabel8.setBounds(34, 277, 100, 25);
				}
				{
					tfNativePlace = new JTextField();
					jPanel1.add(tfNativePlace);
					tfNativePlace.setBounds(134, 275, 138, 25);
				}
				{
					jLabel9 = new JLabel();
					jPanel1.add(jLabel9);
					jLabel9.setText("\u7535\u8bdd\uff1a");
					jLabel9.setBounds(34, 317, 62, 25);
				}
				{
					tfTelePhone = new JTextField();
					jPanel1.add(tfTelePhone);
					tfTelePhone.setBounds(134, 315, 138, 25);
				}
				{
					tfDepartment = new JTextField();
					jPanel1.add(tfDepartment);
					tfDepartment.setBounds(134, 195, 138, 25);
				}
			}
			{
				btnAddStuInfo = new JButton();
				getContentPane().add(btnAddStuInfo);
				btnAddStuInfo.setText("\u589e\u52a0");
				btnAddStuInfo.setBounds(379, 64, 68, 38);
				btnAddStuInfo.setMargin(new java.awt.Insets(4, 4, 4, 4));
				btnAddStuInfo.addActionListener(this);
			}
			{
				btnSearchStu = new JButton();
				getContentPane().add(btnSearchStu);
				btnSearchStu.setText("\u67e5\u8be2");
				btnSearchStu.setBounds(244, 10, 73, 40);
				btnSearchStu.setMargin(new java.awt.Insets(4, 4, 4, 4));
				btnSearchStu.addActionListener(this);
			}
			{
				btnDelStuInfo = new JButton();
				getContentPane().add(btnDelStuInfo);
				btnDelStuInfo.setText("\u5220\u9664");
				btnDelStuInfo.setBounds(379, 163, 70, 40);
				btnDelStuInfo.addActionListener(this);
			}
			{
				btnUpdStuInfo = new JButton();
				getContentPane().add(btnUpdStuInfo);
				btnUpdStuInfo.setText("\u66f4\u65b0");
				btnUpdStuInfo.setBounds(379, 263, 70, 40);
				btnUpdStuInfo.addActionListener(this);
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("\u9000\u51fa");
				btnCancel.setBounds(379, 363, 70, 40);
				btnCancel.addActionListener(this);
			}
			{
				tfStudentSearch = new JTextField();
				getContentPane().add(tfStudentSearch);
				tfStudentSearch.setBounds(126, 18, 100, 24);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8f93\u5165\u5b66\u751f\u5b66\u53f7\uff1a");
				jLabel1.setBounds(12, 21, 102, 17);
			}
			pack();
			this.setSize(500, 450);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		int flag = 0;
		if(e.getSource().equals(btnAddStuInfo)){
			if(tfStudentNoChange.getText().length()==0||
					tfStudentName.getText().length()==0||
					tfStudentIdCard.getText().length()==0||
					tfDepartment.getText().length()==0||
					tfClassNumber.getText().length()==0||
					tfNativePlace.getText().length()==0||
					tfTelePhone.getText().length()==0){
				JOptionPane.showMessageDialog(null,"输入的信息不完整，请重新输入","警告", JOptionPane.WARNING_MESSAGE);
			}else{
				List<StudentInfoTable> student = StudentInfoControl.getStudentInfoControl().getAllStudent();
				for(int i = 0;i<student.size();i++){
					if(student.get(i).getStuClassNo()==tfStudentNoChange.getText()){
						flag=-1;
					}
				}
				if(flag == -1){
					JOptionPane.showMessageDialog(null,"输入的学生学号重复，请重新输入","警告", JOptionPane.WARNING_MESSAGE);
				}else{
					if(JOptionPane.showConfirmDialog(null, "确定要增加学生?","消息提示",JOptionPane.YES_NO_OPTION)==0){
						String stuNo = tfStudentNoChange.getText();
						String stuName = tfStudentName.getText();
						String stuIDNo = tfStudentIdCard.getText();
						String stuSex = sexCombox.getSelectedItem().toString();
						String stuDepartment = tfDepartment.getText();
						String stuClassNo = tfClassNumber.getText();
						String stuNativePlace = tfNativePlace.getText();
						String stuTel = tfTelePhone.getText();
						
						StudentInfoTable studentInstance = new StudentInfoTable(stuNo,stuName,stuIDNo,stuSex
								,stuDepartment,stuClassNo,stuNativePlace,stuTel);
						StudentInfoControl.getStudentInfoControl().save(studentInstance);
						JOptionPane.showMessageDialog(null,stuNo+"学生增加成功","", JOptionPane.OK_CANCEL_OPTION);
						tfStudentNoChange.setText("");
						tfStudentName.setText("");
						tfStudentIdCard.setText("");
						tfDepartment.setText("");
						tfClassNumber.setText("");
						tfNativePlace.setText("");
						tfTelePhone.setText("");
					}
				}
			}
			
		}
		else if(e.getSource().equals(btnSearchStu)){
			StudentInfoTable student = null;
			student = StudentInfoControl.getStudentInfoControl().findStudent(tfStudentSearch.getText());
			if(student == null){
				JOptionPane.showMessageDialog(null,"该学生不存在","警告", JOptionPane.OK_CANCEL_OPTION);
			}else{
				tfStudentNoChange.setText(student.getStuNo());
				tfStudentName.setText(student.getStuName());
				tfStudentIdCard.setText(student.getStuIdnumber());
				tfDepartment.setText(student.getStuDepartment());
				tfClassNumber.setText(student.getStuClassNo());
				tfNativePlace.setText(student.getStuNativePlace());
				tfTelePhone.setText(student.getStuTelephone());
				sexCombox.setSelectedItem(student.getStuSex());
			}
		}
		else if(e.getSource().equals(btnDelStuInfo)){
			StudentInfoTable student = null;
			if(tfStudentSearch.getText().length()==0){
				JOptionPane.showMessageDialog(null,"请先查找一个学生","警告", JOptionPane.OK_CANCEL_OPTION);
			}else{
				student = StudentInfoControl.getStudentInfoControl().findStudent(tfStudentSearch.getText());
				if(JOptionPane.showConfirmDialog(null, "确定要删除学生?","消息提示",JOptionPane.YES_NO_OPTION)==0){
					StudentInfoControl.getStudentInfoControl().delete(student);
					JOptionPane.showMessageDialog(null,student.getStuNo()+"学生删除成功","", JOptionPane.OK_OPTION);
					tfStudentNoChange.setText("");
					tfStudentName.setText("");
					tfStudentIdCard.setText("");
					tfDepartment.setText("");
					tfClassNumber.setText("");
					tfNativePlace.setText("");
					tfTelePhone.setText("");
					tfStudentSearch.setText("");
				}
			}
		}
		else if(e.getSource().equals(btnUpdStuInfo)){
			if(tfStudentSearch.getText().length()==0){
				JOptionPane.showMessageDialog(null,"请先查找一个学生","警告", JOptionPane.OK_CANCEL_OPTION);
			}else{
				List<StudentInfoTable> student = StudentInfoControl.getStudentInfoControl().getAllStudent();
				for(int i = 0;i<student.size();i++){
					if(student.get(i).getStuClassNo()==tfStudentNoChange.getText()){
						flag=-1;
					}
				}
				if(flag == -1){
					JOptionPane.showMessageDialog(null,"输入的学生学号重复，请重新输入","警告", JOptionPane.WARNING_MESSAGE);
				}else{
					if(JOptionPane.showConfirmDialog(null, "确定要修改学生?","消息提示",JOptionPane.YES_NO_OPTION)==0){
						String stuNo = tfStudentNoChange.getText();
						String stuName = tfStudentName.getText();
						String stuIDNo = tfStudentIdCard.getText();
						String stuSex = sexCombox.getSelectedItem().toString();
						String stuDepartment = tfDepartment.getText();
						String stuClassNo = tfClassNumber.getText();
						String stuNativePlace = tfNativePlace.getText();
						String stuTel = tfTelePhone.getText();
						StudentInfoTable studentInst = null;
						studentInst = StudentInfoControl.getStudentInfoControl().findStudent(tfStudentSearch.getText());
						StudentInfoTable studentInstance = new StudentInfoTable(stuNo,stuName,stuIDNo,stuSex
								,stuDepartment,stuClassNo,stuNativePlace,stuTel);
						StudentInfoControl.getStudentInfoControl().updateStudent(studentInst);;
						JOptionPane.showMessageDialog(null,"学生修改成功","消息提示", JOptionPane.YES_NO_OPTION);
						tfStudentNoChange.setText("");
						tfStudentName.setText("");
						tfStudentIdCard.setText("");
						tfDepartment.setText("");
						tfClassNumber.setText("");
						tfNativePlace.setText("");
						tfTelePhone.setText("");
						tfStudentSearch.setText("");
					}
				}
			}
		}
		if(e.getSource().equals(btnCancel)){
			System.out.println("dfsdfs");
			siManage.dispose();
			siManage = null;
		}
		
	}

}
