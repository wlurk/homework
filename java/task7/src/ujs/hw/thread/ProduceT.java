package ujs.hw.thread;

import java.awt.Label;
import java.awt.TextArea;

import ujs.hw.entity.*;

public class ProduceT implements Runnable{
	public static boolean flag1=true;
	public static boolean flag2=true;
	String nameString=null;
	TextArea ta=null;
	Label l1=null;
	Basket basket=null;
	
	public ProduceT(String nameString,TextArea ta, Label l1, Basket basket) {
		super();
		this.nameString=nameString;
		this.ta = ta;
		this.l1 = l1;
		this.basket = basket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag1) {
			if(flag2) {
				int num=basket.put();
				l1.setText("�����е�����������Ϊ�� "+Data.BACKETNUM);
				ta.append(nameString+" ������ "+num+" ������������л��� "+Data.BACKETNUM+" �����\n");
			}else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
