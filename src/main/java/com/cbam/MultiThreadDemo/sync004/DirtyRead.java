package com.cbam.MultiThreadDemo.sync004;
/**
 * 业务整体需要使用完整的synchronized，保持业务的原子性。
 * @author alienware
 *
 */
public class DirtyRead {

	private static String username = "bjsxt";
	private static String password = "123";
	
	public static synchronized void setValue(String usernam, String passwor){
		username = usernam;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		password = passwor;
		
		System.out.println("setValue最终结果：username = " + username + " , password = " + password);
	}
	
	public static synchronized   void getValue(){
		System.out.println("getValue方法得到：username = " + username + " , password = " + password);
	}
	
	
	public static void main(String[] args) throws Exception{
		
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("z3", "456");		
			}
		});
		t1.start();
		Thread.sleep(1000);
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.getValue();
			}
		});
		t2.start();
		//dr.getValue();

	}
	
	
	
}
