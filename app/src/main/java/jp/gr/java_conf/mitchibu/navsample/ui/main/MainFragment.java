package jp.gr.java_conf.mitchibu.navsample.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Objects;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import jp.gr.java_conf.mitchibu.navsample.R;
import jp.gr.java_conf.mitchibu.navsample.databinding.MainFragmentBinding;
import jp.gr.java_conf.mitchibu.navsample.ui.ShareViewModel;
import jp.gr.java_conf.mitchibu.navsample.ui.base.BindLayout;
import jp.gr.java_conf.mitchibu.navsample.ui.base.DataBindingFragment;

@BindLayout(R.layout.main_fragment)
public class MainFragment extends DataBindingFragment<MainFragmentBinding> {
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		NavHostFragment host = (NavHostFragment)getChildFragmentManager().findFragmentById(R.id.nav_host);
		NavController controller = NavHostFragment.findNavController(Objects.requireNonNull(host));
		NavigationUI.setupWithNavController(getBinding().bottomNavigation, controller);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getBinding().setModel(ViewModelProviders.of(this).get(MainViewModel.class));

		ShareViewModel.get(this).setOnShowSubFragment(this, Navigation.findNavController(Objects.requireNonNull(getView())), MainFragmentDirections.actionMainFragmentToSubFragment());
	}
}
