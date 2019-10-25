package edu.ujs.listener;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ujs.beans.DBS;

public class NextListener implements ActionListener{
	TextField t1;
	TextField t2;
	TextField t3;
	TextField t4;
	TextArea t5;
	
	public NextListener(TextField t1, TextField t2, TextField t3, TextField t4, TextArea t5) {
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
		if(DBS.dbs.isEmpty()) {
			t5.setText("没有数据");
		}else if(DBS.i==DBS.dbs.size()-1){
			t5.setText("已经是最后一条数据了");			
		}else {
			DBS.i++;
			t5.setText(DBS.dbs.get(DBS.i).getId()+" next");

			t1.setText(DBS.dbs.get(DBS.i).getId()+"");
			t2.setText(DBS.dbs.get(DBS.i).getName());
			t3.setText(DBS.dbs.get(DBS.i).getScore()+"");
			t4.setText(DBS.dbs.get(DBS.i).getTele());
			
			
		}
		
	}

}
