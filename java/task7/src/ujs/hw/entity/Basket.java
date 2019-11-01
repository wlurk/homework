package ujs.hw.entity;

public class Basket {
	public synchronized int put() {
			int ori=Data.BACKETNUM;		
		try {
			
			if(Data.BACKETNUM>=Data.BACKETCAP) {
				this.wait();
			}

			Thread.sleep((int)(Math.random()*1000));
			Data.BACKETNUM=Data.BACKETNUM+(int)(Math.random()*Data.ProLimit+1);
			Data.BACKETNUM=Data.BACKETNUM>Data.BACKETCAP?Data.BACKETCAP:Data.BACKETNUM;
			
			this.notify();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Data.BACKETNUM-ori;
	}
	
	public synchronized void get() {
		
		try {
			if(Data.BACKETNUM<=0) {
				this.wait();
			}
			Thread.sleep((int)(Math.random()*1000));
			Data.BACKETNUM=Data.BACKETNUM-(int)(Math.random()*Data.ComLimit+1);
			Data.BACKETNUM=Data.BACKETNUM<0?0:Data.BACKETNUM;
			this.notify();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
