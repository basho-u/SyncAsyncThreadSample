package jp.co.bashou.test;

import jp.co.bashou.trial.SyncAsyncThread;
import jp.co.bashou.trial.SyncAsyncThread.BashouRunnable;


class test {
	
	public static void main (String[] args) {

		SyncAsyncThread sat = new SyncAsyncThread(new Runnable() {
			@Override
			public void run() {
				System.out.println("all task finished");
			}
		});

		sat.add(new BashouRunnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("1 secound sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		sat.add(new BashouRunnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1500);
					System.out.println("1.5 secound sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		sat.add(new BashouRunnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
					System.out.println("0.5 secound sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		sat.add(new BashouRunnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(6000);
					System.out.println("6 secound sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		sat.add(new BashouRunnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3500);
					System.out.println("3.5 secound sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		sat.add(new BashouRunnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("2 secound sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		sat.start();
	}
	
}