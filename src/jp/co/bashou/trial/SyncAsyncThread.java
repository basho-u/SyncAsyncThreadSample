package jp.co.bashou.trial;

import java.util.ArrayList;


public class SyncAsyncThread {
	
	private ArrayList<Runnable> runnables = new ArrayList<Runnable>();
	private Runnable mCallback;

	public SyncAsyncThread( Runnable callback ) {
		mCallback = callback;
	}

	public void start() {
		for (int cnt = 0; cnt < runnables.size(); cnt++) {
			new Thread( runnables.get(cnt) ).start();
		}
	}

	public void add( final BashouRunnable br ){
		runnables.add(new Runnable() {
			@Override
			public void run() {
				br.run();
				runnables.remove(this);
				check();
			}
		});
		
	}

	private void check() {
		if ( runnables.size() == 0 ) {
			if ( mCallback instanceof Runnable ) {
				mCallback.run();
			}
			runnables = null;
			mCallback = null;
		}
	}
	
	public interface BashouRunnable {
		public void run();
	}
}