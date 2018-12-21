package jp.gr.java_conf.mitchibu.navsample.ui.util;

import android.animation.Animator;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public abstract class Splash {
	private final FragmentActivity activity;
	private final boolean finishIfPause;
	private final View view;

	protected Splash(AppCompatActivity activity, int layoutResId, boolean finishIfPause) {
		this.activity = activity;
		this.finishIfPause = finishIfPause;
		view = View.inflate(activity, layoutResId, null);
		view.setClickable(true);
	}

	public final View getView() {
		return view;
	}

	public void show() {
		activity.addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		activity.getLifecycle().addObserver(new LifecycleObserver() {
			@OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
			void onPause() {
				if(finishIfPause) activity.finish();
			}

			@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
			void onDestroy() {
				doDestroy();
			}
		});
		doProcess();
	}

	protected void doComplete() {
		view.animate().alpha(0).setListener(new SimpleAnimatorListener() {
			@Override
			public void onAnimationEnd(Animator animation) {
				((ViewGroup)view.getParent()).removeView(view);
			}
		}).start();
	}

	protected abstract void doProcess();
	protected abstract void doDestroy();
}
