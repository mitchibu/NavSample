package jp.gr.java_conf.mitchibu.navsample.ui;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import java.util.Objects;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import jp.gr.java_conf.mitchibu.navsample.R;
import jp.gr.java_conf.mitchibu.navsample.databinding.MainActivityBinding;
import jp.gr.java_conf.mitchibu.navsample.ui.base.BindLayout;
import jp.gr.java_conf.mitchibu.navsample.ui.base.DataBindingActivity;
import jp.gr.java_conf.mitchibu.navsample.ui.util.SimpleSplash;
import jp.gr.java_conf.mitchibu.navsample.ui.util.Splash;

@BindLayout(R.layout.main_activity)
public class MainActivity extends DataBindingActivity<MainActivityBinding> {
	private static final long SPLASH_TIMEOUT = 2000L;

	private NavController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSupportActionBar(getBinding().toolBar);

		NavHostFragment host = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host);
		controller = NavHostFragment.findNavController(Objects.requireNonNull(host));
		NavigationUI.setupActionBarWithNavController(this, controller, getBinding().drawer);
		NavigationUI.setupWithNavController(getBinding().navigation, controller);

		if(savedInstanceState != null) return;

		new SimpleSplash(this, R.layout.splash, true, SPLASH_TIMEOUT).show();
	}

	@Override
	public void onBackPressed() {
		if(getBinding().drawer.isDrawerOpen(GravityCompat.START)) {
			getBinding().drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return NavigationUI.onNavDestinationSelected(item, controller) || super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onSupportNavigateUp() {
		return NavigationUI.navigateUp(controller, getBinding().drawer) || super.onSupportNavigateUp();
	}
}
