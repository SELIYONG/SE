package com.se.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.se.control.CourseInfoControl;
import com.se.control.ScoreInfoControl;
import com.se.control.StudentInfoControl;
import com.se.model.CourseInfoTable;
import com.se.model.ScoreInfoTable;
import com.se.model.ScoreInfoTableId;
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
public class InputStudentScore extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JLabel jLabel5;
	private JButton btnCancel;
	private JButton btnOK;
	private JTextField tfScore;
	private JTextField tfStuNo;
	private JTextField tfCourseNo;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				InputStudentScore inst = new InputStudentScore();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public InputStudentScore() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u8f93\u5165\u5b66\u751f\u5206\u6570");
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 237, 282);
				jPanel1.setBorder(BorderFactory.createTitledBorder("\u5b66\u751f\u5206\u6570"));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u8bfe\u7a0b\u53f7\uff1a");
					jLabel1.setBounds(12, 51, 76, 13);
				}
				{
					tfCourseNo = new JTextField();
					jPanel1.add(tfCourseNo);
					tfCourseNo.setBounds(93, 46, 122, 24);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("\u5b66\u751f\u5b66\u53f7\uff1a");
					jLabel3.setBounds(12, 103, 76, 13);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("\u8bfe\u7a0b\u5206\u6570\uff1a");
					jLabel5.setBounds(12, 163, 76, 13);
				}
				{
					tfStuNo = new JTextField();
					jPanel1.add(tfStuNo);
					tfStuNo.setBounds(93, 102, 122, 24);
				}
				{
					tfScore = new JTextField();
					jPanel1.add(tfScore);
					tfScore.setBounds(93, 158, 122, 24);
				}
				{
					btnOK = new JButton();
					jPanel1.add(btnOK);
					btnOK.setText("\u4fdd\u5b58");
					btnOK.setBounds(61, 235, 64, 30);
					btnOK.setMargin(new java.awt.Insets(4, 4, 4, 4));
					btnOK.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							int flag1 = -1;
							int flag2 = -1;
							List<CourseInfoTable> courseList = CourseInfoControl.getCourseControl().getAllCourse();
							List<StudentInfoTable> student = StudentInfoControl.getStudentInfoControl().getAllStudent();
							for(int i = 0;i<courseList.size();i++){
								System.out.println(courseList.get(i).getCourseNo());
								if(courseList.get(i).getCourseNo().equals(tfCourseNo.getText())){
									flag1 = 0;
								}
							}
							for(int i = 0;i<student.size();i++){
								if(student.get(i).getStuNo().equals(tfStuNo.getText())){
									flag2=0;
								}
							}
							if(flag1 == -1){
								JOptionPane.showMessageDialog(null,"课程号不存在","警告", JOptionPane.OK_CANCEL_OPTION);
							}else{
								if(flag2 == -1){
									JOptionPane.showMessageDialog(null,"学生不存在","警告", JOptionPane.OK_CANCEL_OPTION);
								}else{
									if(JOptionPane.showConfirmDialog(null, "确定要增加学生的成绩吗?","消息提示",JOptionPane.YES_NO_OPTION)==0){
										String courseNo = tfCourseNo.getText();
										String stuNo = tfStuNo.getText();
										double score = Double.valueOf(tfScore.getText());
										ScoreInfoTableId scoreId = new ScoreInfoTableId(courseNo,stuNo);
										ScoreInfoTable scoreInfo = new ScoreInfoTable(scoreId,score);
										ScoreInfoControl.getScoreInfoControl().saveScore(scoreInfo);
										JOptionPane.showMessageDialog(null,stuNo+"的成绩添加成功","", JOptionPane.WARNING_MESSAGE);
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
					btnCancel.setBounds(158, 235, 64, 30);
					btnCancel.setMargin(new java.awt.Insets(4, 4, 4, 4));
					btnCancel.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							InputStudentScore.this.dispose();
						}
						
					});
				}
			}
			pack();
			this.setSize(272, 338);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
