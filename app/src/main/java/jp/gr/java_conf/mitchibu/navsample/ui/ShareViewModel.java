package jp.gr.java_conf.mitchibu.navsample.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.Objects;

import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import jp.gr.java_conf.mitchibu.navsample.ui.util.OnChangedObserver;

public class ShareViewModel extends ViewModel {
	public static ShareViewModel get(FragmentActivity activity) {
		return ViewModelProviders.of(Objects.requireNonNull(activity)).get(ShareViewModel.class);
	}

	public static ShareViewModel get(Fragment fragment) {
		return get(fragment.getActivity());
	}

	private final MutableLiveData<Long> showSubFragment = new MutableLiveData<>();

	public void showSubFragment() {
		showSubFragment.postValue(System.currentTimeMillis());
	}

	public void setOnShowSubFragment(LifecycleOwner owner, final NavController controller, final NavDirections directions) {
		final Observer<Long> observer = new OnChangedObserver<Long>(showSubFragment.getValue()) {
			@Override
			public void onChangedValue(@Nullable Long value) {
				controller.navigate(directions);
			}
		};
		owner.getLifecycle().addObserver(new LifecycleObserver() {
			@OnLifecycleEvent(Lifecycle.Event.ON_STOP)
			void onStop() {
				showSubFragment.removeObserver(observer);
			}
		});
		showSubFragment.observe(owner, observer);
	}
}
