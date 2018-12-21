package jp.gr.java_conf.mitchibu.navsample.ui.main.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import jp.gr.java_conf.mitchibu.navsample.R;
import jp.gr.java_conf.mitchibu.navsample.databinding.HomeFragmentBinding;
import jp.gr.java_conf.mitchibu.navsample.ui.ShareViewModel;
import jp.gr.java_conf.mitchibu.navsample.ui.base.BindLayout;
import jp.gr.java_conf.mitchibu.navsample.ui.base.DataBindingFragment;

@BindLayout(R.layout.home_fragment)
public class HomeFragment extends DataBindingFragment<HomeFragmentBinding> {
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getBinding().setModel(ViewModelProviders.of(this).get(HomeViewModel.class));
		getBinding().test.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ShareViewModel.get(HomeFragment.this).showSubFragment();
			}
		});
	}
}
