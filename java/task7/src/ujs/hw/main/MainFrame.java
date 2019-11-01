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
		JFrame frame=new JFrame("������������");
		Label label=new Label();
		label.setText("�����е�����������Ϊ�� "+Data.BACKETNUM);
		frame.add(label,BorderLayout.NORTH);
		
		TextArea textArea=new TextArea();
		frame.add(textArea,BorderLayout.CENTER);
		
		Panel buttonPanel=new Panel();
		
		Basket basket=new Basket();
		Thread proThread=new Thread(new ProduceT("������1", textArea, label, basket));
		
		
		
		
		Panel proPanel=new Panel();		
		Button proButton=new Button("������ ��/��");
		
		proButton.addActionListener(new ProListener(proThread,textArea));
		//proThread.start();
		
		
		JCheckBox[] proCheckBox=new JCheckBox[Data.ProNum];
		Panel probuttonPanel=new Panel();
		for(int i=0;i<Data.ProNum;i++) {
			String string="������"+(i+1);
			proCheckBox[i]=new JCheckBox(string);
			probuttonPanel.add(proCheckBox[i]);
		}

		proPanel.add(proButton);
		proPanel.add(probuttonPanel);
		
		Panel comPanel=new Panel();		
		Button comButton=new Button("������ ��/��");
		JCheckBox[] comCheckBox=new JCheckBox[Data.ComNum];
		Panel combuttonPanel=new Panel();
		for(int i=0;i<Data.ComNum;i++) {
			String string="������"+(i+1);
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
