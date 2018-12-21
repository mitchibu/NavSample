package jp.gr.java_conf.mitchibu.navsample.ui.util;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

public abstract class OnChangedObserver<T> implements Observer<T> {
	private T value;

	public OnChangedObserver(T initialValue) {
		value = initialValue;
	}

	@Override
	public void onChanged(@Nullable T value) {
		if(this.value != null && this.value.equals(value)) return;
		this.value = value;
		onChangedValue(value);
	}

	public abstract void onChangedValue(@Nullable T value);
}
