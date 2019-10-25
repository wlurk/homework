package edu.ujs.listener;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ujs.beans.DBS;

public class QueryListener implements ActionListener{
	TextField t1;
	TextField t2;
	TextField t3;
	TextField t4;
	TextArea t5;
	TextField t6;
	
	public QueryListener(TextField t1, TextField t2, TextField t3, TextField t4, TextArea t5,TextField t6) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6=t6;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameString=t6.getText();
		for(int i=0;i<DBS.dbs.size();i++) {
			if(DBS.dbs.get(i).getName().equals(nameString)) {
				t1.setText(DBS.dbs.get(i).getId()+"");
				t2.setText(DBS.dbs.get(i).getName());
				t3.setText(DBS.dbs.get(i).getScore()+"");
				t4.setText(DBS.dbs.get(i).getTele());
				t5.setText("成功查询到 name="+nameString+" 的学生");
				return;
			}
		}
		t5.setText("未查询到name="+nameString+" 的学生");
	}
}
