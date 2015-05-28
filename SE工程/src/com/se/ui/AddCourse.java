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
import javax.swing.WindowConstants;

import com.se.control.CourseInfoControl;
import com.se.model.CourseInfoTable;


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
public class AddCourse extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox jComboBox1;
	private JTextField tfCourseYear;
	private JTextField tfCourseCredit;
	private JTextField tfCourseName;
	private JTextField tfCourseNo;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private static AddCourse addCourse = null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public static AddCourse getAddCourse(){
		if(addCourse == null){
			addCourse = new AddCourse();
		}
		return addCourse;
	}
	
	private AddCourse() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u589e\u52a0\u8bfe\u7a0b\u4fe1\u606f");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 232, 324);
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder("\u589e\u52a0\u8bfe\u7a0b\u4fe1\u606f"));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u8bfe\u7a0b\u53f7\uff1a");
					jLabel1.setBounds(17, 26, 66, 17);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u8bfe\u7a0b\u540d\uff1a");
					jLabel2.setBounds(17, 66, 66, 17);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("\u5b66\u5206\uff1a");
					jLabel3.setBounds(17, 106, 66, 17);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("\u5f00\u8bfe\u5b66\u5e74\uff1a");
					jLabel4.setBounds(17, 146, 66, 17);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("\u5f00\u8bfe\u5b66\u671f\uff1a");
					jLabel5.setBounds(17, 186, 66, 17);
				}
				{
					tfCourseNo = new JTextField();
					jPanel1.add(tfCourseNo);
					tfCourseNo.setBounds(91, 23, 115, 24);
				}
				{
					tfCourseName = new JTextField();
					jPanel1.add(tfCourseName);
					tfCourseName.setBounds(91, 62, 115, 24);
				}
				{
					tfCourseCredit = new JTextField();
					jPanel1.add(tfCourseCredit);
					tfCourseCredit.setBounds(89, 102, 117, 24);
				}
				{
					tfCourseYear = new JTextField();
					jPanel1.add(tfCourseYear);
					tfCourseYear.setBounds(89, 141, 117, 24);
				}
				{
					ComboBoxModel jComboBox1Model = 
							new DefaultComboBoxModel(
									new String[] { "春季", "秋季" });
					jComboBox1 = new JComboBox();
					jPanel1.add(jComboBox1);
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1.setBounds(89, 181, 117, 24);
				}
				{
					btnAdd = new JButton();
					jPanel1.add(btnAdd);
					btnAdd.setText("\u589e\u52a0");
					btnAdd.setBounds(43, 243, 38, 24);
					btnAdd.setSize(50, 30);
					btnAdd.setMargin(new java.awt.Insets(4, 4, 4, 4));
					btnAdd.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							int flag = 0;
							if(tfCourseNo.getText().length()==0||
									tfCourseName.getText().length()==0||
									tfCourseCredit.getText().length()==0||
									tfCourseYear.getText().length()==0){
								JOptionPane.showMessageDialog(null,"输入的信息不完整，请重新输入","警告", JOptionPane.OK_CANCEL_OPTION);
							}else{
								List<CourseInfoTable> courseList = CourseInfoControl.getCourseControl().getAllCourse();
								for(int i = 0;i<courseList.size();i++){
									if(courseList.get(i).getCourseNo().equals(tfCourseNo.getText())){
										flag = -1;
									}
								}
								if(flag == -1){
									JOptionPane.showMessageDialog(null,"输入的课程名重复","警告", JOptionPane.OK_CANCEL_OPTION);
								}else{
									if(JOptionPane.showConfirmDialog(null, "确定要增加课程?","消息提示",JOptionPane.YES_NO_OPTION)==0){
										String courseNo = tfCourseNo.getText();
										String courseName = tfCourseName.getText();
										double courseCredit = Double.valueOf(tfCourseCredit.getText());
										String courseYear = tfCourseYear.getText();
										String courseSemester = jComboBox1.getSelectedItem().toString();
										CourseInfoTable course = new CourseInfoTable(courseNo,courseName,courseCredit,courseYear,courseSemester);
										CourseInfoControl.getCourseControl().saveCourse(course);
										JOptionPane.showMessageDialog(null,courseNo+"增加成功","", JOptionPane.WARNING_MESSAGE);
									}
								}
							}
							
						}
					});
				}
				{
					btnCancel = new JButton();
					jPanel1.add(btnCancel);
					btnCancel.setText("\u53d6\u6d88");
					btnCancel.setBounds(136, 243, 38, 24);
					btnCancel.setSize(50, 30);
					btnCancel.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							addCourse.dispose();
							addCourse = null;
						}
						
					});
				}
			}
			pack();
			this.setSize(272, 381);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
