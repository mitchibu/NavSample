package jp.gr.java_conf.mitchibu.navsample.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class DataBindingFragment<T extends ViewDataBinding> extends Fragment {
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
}
