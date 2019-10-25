package edu.ujs.listener;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ujs.beans.DBS;

public class DeleteListener implements ActionListener{
	TextField t1;
	TextField t2;
	TextField t3;
	TextField t4;
	TextArea t5;
	public DeleteListener(TextField t1, TextField t2, TextField t3, TextField t4, TextArea t5) {
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
		t5.setText("ÒÑÉ¾³ýÊý¾Ý£º"+DBS.dbs.get(DBS.i).toString());
		DBS.dbs.remove(DBS.i);
		if(DBS.i==DBS.dbs.size()) {
			DBS.i=DBS.dbs.size()-1;
		}
		t1.setText(DBS.dbs.get(DBS.i).getId()+"");
		t2.setText(DBS.dbs.get(DBS.i).getName());
		t3.setText(DBS.dbs.get(DBS.i).getScore()+"");
		t4.setText(DBS.dbs.get(DBS.i).getTele());
	}
}
