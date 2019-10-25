package edu.ujs.listener;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import edu.ujs.beans.DBS;
import edu.ujs.beans.Student;

public class OpenListener implements ActionListener{
	TextField t1;
	TextField t2;
	TextField t3;
	TextField t4;
	TextArea t5;
	public OpenListener(TextField t1, TextField t2, TextField t3, TextField t4, TextArea t5) {
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
		try {
			InputStream inputStream=new FileInputStream("database.dat");
			ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
			
			Object bean;
			while((bean=objectInputStream.readObject())!=null){
				DBS.dbs.add((Student)bean);
			}
			DBS.i=0;
			t5.setText("已打开文件");
			t1.setText(DBS.dbs.get(DBS.i).getId()+"");
			t2.setText(DBS.dbs.get(DBS.i).getName());
			t3.setText(DBS.dbs.get(DBS.i).getScore()+"");
			t4.setText(DBS.dbs.get(DBS.i).getTele());
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
