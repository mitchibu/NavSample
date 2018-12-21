package jp.gr.java_conf.mitchibu.navsample.ui.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class DataBindingDialogFragment<T extends ViewDataBinding> extends DialogFragment {
	private T binding = null;

	public final T getBinding() {
		return binding;
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		BindLayout layout = getClass().getAnnotation(BindLayout.class);
		binding = DataBindingUtil.inflate(inflater, Objects.requireNonNull(layout).value(), container, false);
		binding.setLifecycleOwner(this);
		return binding.getRoot();
	}

	public void sendResult(int resultCode, Intent data) {
		Fragment fragment = getTargetFragment();
		if(fragment == null) return;
		fragment.onActivityResult(getTargetRequestCode(), resultCode, data);
	}
}
