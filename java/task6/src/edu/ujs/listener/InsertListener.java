package edu.ujs.listener;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ujs.beans.DBS;
import edu.ujs.beans.Student;

public class InsertListener implements ActionListener{
	TextField t1;
	TextField t2;
	TextField t3;
	TextField t4;
	TextArea t5;
	public InsertListener(TextField t1, TextField t2, TextField t3, TextField t4, TextArea t5) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setId(Integer.valueOf(t1.getText()));
		student.setName(t2.getText());
		student.setScore(Integer.valueOf(t3.getText()));
		student.setTele(t4.getText());
		DBS.dbs.add(student);
		DBS.i=DBS.dbs.size()-1;
		/*加叙述*/
		t5.setText("id="+t1.getText()+"  已添加成功");
	}
	
}
