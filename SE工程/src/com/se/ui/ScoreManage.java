package com.se.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.se.control.ScoreInfoControl;
import com.se.control.StudentInfoControl;
import com.se.model.StudentCourseScore;
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
public class ScoreManage extends javax.swing.JFrame {
	private JButton btnInputScore;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JButton btnStuAve;
	private JButton btnSearch;
	private JTextField tfScoreSearch;
	private static ScoreManage scoreManage = null;
	private double allScore = 0;
	private double avgScore = 0;
	private int count = 0;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				ScoreManage inst = new ScoreManage();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public static ScoreManage getScoreManage(){
		if(scoreManage == null){
			scoreManage = new ScoreManage();
		}
		return scoreManage;
	}
	
	public ScoreManage() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5b66\u751f\u6210\u7ee9\u7ba1\u7406");
			{
				btnInputScore = new JButton();
				getContentPane().add(btnInputScore);
				btnInputScore.setText("\u5f55\u5165\u5b66\u751f\u6210\u7ee9");
				btnInputScore.setBounds(204, 19, 129, 29);
				btnInputScore.setMargin(new java.awt.Insets(4, 4, 4, 4));
				btnInputScore.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						btnInputScoreActionPerformed(evt);
					}
				});
			}
			{
				btnSearch = new JButton();
				getContentPane().add(btnSearch);
				btnSearch.setText("\u67e5\u8be2");
				btnSearch.setBounds(136, 19, 63, 29);
				btnSearch.setMargin(new java.awt.Insets(4, 4, 4, 4));
				btnSearch.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						int flag = -1;
						if(tfScoreSearch.getText().length()==0){
							JOptionPane.showMessageDialog(null,"请输入要查询的学生的学号","警告", JOptionPane.OK_CANCEL_OPTION);
						}else{
							List<StudentInfoTable> student = StudentInfoControl.getStudentInfoControl().getAllStudent();
							for(int i = 0;i<student.size();i++){
								if(student.get(i).getStuNo().equals(tfScoreSearch.getText())){
									flag=0;
								}
							}
							if(flag == -1){
								JOptionPane.showMessageDialog(null,"查询的学号不存在","警告", JOptionPane.OK_CANCEL_OPTION);
							}else{
								ArrayList<StudentCourseScore> arrayList = ScoreInfoControl.getScoreInfoControl().findStudentScore(tfScoreSearch.getText());
								for(int i = 0;i<arrayList.size();i++){
									allScore += arrayList.get(i).getScore();
									count++;
									String [] rowdata = {arrayList.get(i).getStuNo(),
											arrayList.get(i).getStuName(),
											arrayList.get(i).getCourseNo(),
											arrayList.get(i).getCourseName(),
											String.valueOf(arrayList.get(i).getScore())};
									((DefaultTableModel) jTable1.getModel()).addRow(rowdata);
								}
							}
						
						}
					}
				});
			}
			{
				btnStuAve = new JButton();
				getContentPane().add(btnStuAve);
				btnStuAve.setText("\u5b66\u751f\u5e73\u5747\u5206");
				btnStuAve.setBounds(344, 19, 129, 29);
				btnStuAve.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						if(tfScoreSearch.getText().length()==0){
							JOptionPane.showMessageDialog(null,"请输入要计算平均分的学生的学号","警告", JOptionPane.OK_CANCEL_OPTION);
						}else{
							avgScore = allScore/count;
							JOptionPane.showMessageDialog(null,tfScoreSearch.getText()+"学生的平均成绩为"+avgScore,"", JOptionPane.WARNING_MESSAGE);
						}
					}
					
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				getContentPane().add(getTfScoreSearch());
				jScrollPane1.setBounds(12, 59, 460, 340);
				{
					
					String[] header = {"学号","姓名","课程号","课程名","分数",};
					Object [][]celldata = null;
					TableModel jTable1Model = new DefaultTableModel(celldata,header);
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					
				}
			}
			pack();
			this.setSize(500, 450);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void btnInputScoreActionPerformed(ActionEvent evt){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InputStudentScore inst = new InputStudentScore();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private JTextField getTfScoreSearch() {
		if(tfScoreSearch == null) {
			tfScoreSearch = new JTextField();
			tfScoreSearch.setBounds(12, 22, 112, 24);
		}
		return tfScoreSearch;
	}

}
