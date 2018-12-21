package jp.gr.java_conf.mitchibu.navsample.ui.sub;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import jp.gr.java_conf.mitchibu.navsample.R;
import jp.gr.java_conf.mitchibu.navsample.databinding.SubFragmentBinding;
import jp.gr.java_conf.mitchibu.navsample.ui.base.BindLayout;
import jp.gr.java_conf.mitchibu.navsample.ui.base.DataBindingFragment;

@BindLayout(R.layout.sub_fragment)
public class SubFragment extends DataBindingFragment<SubFragmentBinding> {
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getBinding().setModel(ViewModelProviders.of(this).get(SubViewModel.class));
	}
}
