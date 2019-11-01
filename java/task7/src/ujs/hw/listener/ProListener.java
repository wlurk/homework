package ujs.hw.listener;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ujs.hw.thread.ProduceT;

public class ProListener implements ActionListener{
	Thread t=null;
	TextArea tArea=null;
	
	public ProListener(Thread t,TextArea tArea) {
		super();
		this.t = t;
		this.tArea=tArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ProduceT.flag2=!ProduceT.flag2;		
		if(ProduceT.flag2==false) {
			tArea.append("关闭生产者\n");
		}else {
			tArea.append("打开生产者\n");
		}

	}

}
