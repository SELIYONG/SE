package com.se.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;


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
public class MainFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JButton btnStuInfoManage;
	private JButton jButton4;
	private JButton btnStuScoreManage;
	private JButton btnCourseManage;
	private static MainFrame main = null;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				MainFrame inst = new MainFrame();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public static MainFrame getMainFrame(int type){
		if(main == null){
			main = new MainFrame(type);
		}
		return main;
	}
	
	private MainFrame(int type) {
		super();
		initGUI(type);
	}
	
	private void initGUI(int type) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u6b22\u8fce\u8fdb\u5165\u5b66\u751f\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
				jLabel1.setBounds(12, 12, 460, 69);
				jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI",0,36));
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(11, 119, 461, 199);
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					btnStuInfoManage = new JButton();
					jPanel1.add(btnStuInfoManage);
					btnStuInfoManage.setText("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
					btnStuInfoManage.setBounds(8, 46, 92, 92);
					btnStuInfoManage.setMargin(new java.awt.Insets(4, 4, 4, 4));
					btnStuInfoManage.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnStuInfoManageActionPerformed(evt);
						}
					});
				}
				{
					btnStuScoreManage = new JButton();
					jPanel1.add(btnStuScoreManage);
					btnStuScoreManage.setText("\u6210\u7ee9\u7ba1\u7406");
					btnStuScoreManage.setBounds(123, 46, 90, 90);
					btnStuScoreManage.setMargin(new java.awt.Insets(4, 4, 4, 4));
					btnStuScoreManage.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnStuScoreManageActionPerformed(evt);
						}
					});
				}
				{
					btnCourseManage = new JButton();
					jPanel1.add(btnCourseManage);
					btnCourseManage.setText("\u589e\u52a0\u8bfe\u7a0b");
					btnCourseManage.setBounds(238, 46, 92, 92);
					btnCourseManage.setMargin(new java.awt.Insets(4, 4, 4, 4));
					btnCourseManage.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							AddCourse addCourse = AddCourse.getAddCourse();
							addCourse.setVisible(true);
							addCourse.setResizable(true);
							addCourse.setLocationRelativeTo(null);
						}
					});
				}
				
				{
					jButton4 = new JButton();
					jPanel1.add(jButton4);
					jButton4.setText("\u7cfb\u7edf\u8bbe\u7f6e");
					jButton4.setBounds(354, 46, 92, 83);
					jButton4.setMargin(new java.awt.Insets(4, 4, 4, 4));
					jButton4.setSize(92, 92);
					if(type == 0){
						jButton4.setEnabled(true);
					}else{
						jButton4.setEnabled(false);
					}
					jButton4.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							SystemManagement sm = SystemManagement.getSystemManagement();
							sm.setVisible(true);
							sm.setLocationRelativeTo(null);
						}
					});
				}
			}
			pack();
			this.setSize(500, 450);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	//学生信息管理监听器
	private void btnStuInfoManageActionPerformed(ActionEvent evt) {
		StudentInfoManage inst = StudentInfoManage.getStudentInfoManage();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
			
	//学生成绩管理监听器
	private void btnStuScoreManageActionPerformed(ActionEvent evt) {
		ScoreManage inst = ScoreManage.getScoreManage();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

}
