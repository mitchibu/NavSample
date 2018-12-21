package jp.gr.java_conf.mitchibu.navsample.ui.util;

import android.support.v7.app.AppCompatActivity;

public class SimpleSplash extends Splash {
	private final Runnable runnable = new Runnable() {
		@Override
		public void run() {
			doComplete();
		}
	};

	private final long timeout;

	public SimpleSplash(AppCompatActivity activity, int layoutResId, boolean finishIfPause, long timeout) {
		super(activity, layoutResId, finishIfPause);
		this.timeout = timeout;
	}

	@Override
	protected void doProcess() {
		getView().postDelayed(runnable, timeout);
	}

	@Override
	protected void doDestroy() {
		getView().removeCallbacks(runnable);
	}
}
