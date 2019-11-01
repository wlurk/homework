package ujs.hw.main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import ujs.hw.entity.*;
import ujs.hw.listener.ProListener;
import ujs.hw.thread.ProduceT;

public class MainFrame {
	public static void main(String[] args) {
		JFrame frame=new JFrame("生产消费问题");
		Label label=new Label();
		label.setText("篮子中的面包面包数量为： "+Data.BACKETNUM);
		frame.add(label,BorderLayout.NORTH);
		
		TextArea textArea=new TextArea();
		frame.add(textArea,BorderLayout.CENTER);
		
		Panel buttonPanel=new Panel();
		
		Basket basket=new Basket();
		Thread proThread=new Thread(new ProduceT("生产者1", textArea, label, basket));
		
		
		
		
		Panel proPanel=new Panel();		
		Button proButton=new Button("生产者 开/关");
		
		proButton.addActionListener(new ProListener(proThread,textArea));
		//proThread.start();
		
		
		JCheckBox[] proCheckBox=new JCheckBox[Data.ProNum];
		Panel probuttonPanel=new Panel();
		for(int i=0;i<Data.ProNum;i++) {
			String string="生产者"+(i+1);
			proCheckBox[i]=new JCheckBox(string);
			probuttonPanel.add(proCheckBox[i]);
		}

		proPanel.add(proButton);
		proPanel.add(probuttonPanel);
		
		Panel comPanel=new Panel();		
		Button comButton=new Button("消费者 开/关");
		JCheckBox[] comCheckBox=new JCheckBox[Data.ComNum];
		Panel combuttonPanel=new Panel();
		for(int i=0;i<Data.ComNum;i++) {
			String string="消费者"+(i+1);
			comCheckBox[i]=new JCheckBox(string);
			combuttonPanel.add(comCheckBox[i]);
		}

		comPanel.add(comButton);
		comPanel.add(combuttonPanel);
		
		
		buttonPanel.add(proPanel);
		buttonPanel.add(comPanel);
		
		frame.add(buttonPanel,BorderLayout.SOUTH);

		
		
		
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		proThread.start();
	}
}
