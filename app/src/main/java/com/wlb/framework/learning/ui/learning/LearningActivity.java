/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.wlb.framework.learning.ui.learning;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.BuildConfig;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.ActivityMainLearningBinding;
import com.wlb.framework.learning.databinding.NavHeaderLearningBinding;
import com.wlb.framework.learning.databinding.NavHeaderMainBinding;
import com.wlb.framework.learning.ui.about.AboutFragment;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.learning.fragment.LFragmentHome;
import com.wlb.framework.learning.ui.learning.fragment.LFragmentWishlist;
import com.wlb.framework.learning.ui.login.LoginActivity;
import com.wlb.framework.learning.ui.main.bottommenu.BFragmentFriends;
import com.wlb.framework.learning.ui.main.bottommenu.BFragmentNotification;
import com.wlb.framework.learning.ui.main.bottommenu.BFragmentProfile;
import com.wlb.framework.learning.ui.main.bottommenu.BFragmentTimeline;

import javax.inject.Inject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class LearningActivity extends BaseActivity<ActivityMainLearningBinding, LearningViewModel> implements LearningNavigator, HasSupportFragmentInjector {
    private static final String TAG = "LearningActivity";
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    private ActivityMainLearningBinding mActivityMainBinding;
    private SwipePlaceHolderView mCardsContainerView;
    private DrawerLayout mDrawer;
    private LearningViewModel mMainViewModel;
    private NavigationView mNavigationView;
    private BottomNavigationView mBottomNav;
    private Toolbar mToolbar;
    private Handler mHandler;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LearningActivity.class);
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_learning;
    }

    @Override
    public LearningViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, factory).get(LearningViewModel.class);
        return mMainViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG);
        if (fragment == null) {
            super.onBackPressed();
        } else {
            onFragmentDetached(AboutFragment.TAG);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_learning, menu);
        return true;
    }

    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
            unlockDrawer();
        }
    }

    private void onchangeSegmentFragment(Fragment fragment) {

        FragmentManager fragmentManager2 = getSupportFragmentManager();
        fragmentManager2.beginTransaction().
                disallowAddToBackStack().
                replace(R.id.main_content, fragment).
                setCustomAnimations(R.anim.fade_in, R.anim.fade_out).
                commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_search_learning:
                return true;
            case R.id.action_chart:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void LoadHomeFragment() {
        mToolbar.setTitle(null);
        mToolbar.setLogo(this.getResources().getDrawable(R.drawable.ic_logo_learning));
        // update the main content by replacing fragments
        Fragment fragment = new LFragmentHome();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.main_content, fragment, TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }

    @Override
    public void openProfileFragment() {
        mToolbar.setLogo(null);
        mToolbar.setTitle(mMainViewModel.getNameProfile());
        unselectBottomNav();
        Fragment fragment = new BFragmentProfile();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.main_content, fragment, TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void unselectBottomNav() {
        int menu = getSelectedItem(mActivityMainBinding.bottomnavMenu);
        mActivityMainBinding.bottomnavMenu.getMenu().findItem(menu).setCheckable(false);
    }

    private int getSelectedItem(BottomNavigationView bottomNavigationView) {
        Menu menu = bottomNavigationView.getMenu();
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.isChecked()) {
                menuItem.setChecked(false);
                return menuItem.getItemId();
            }
        }
        return 0;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);
        setUp();
        LoadHomeFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mDrawer != null) {
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    private void lockDrawer() {
        if (mDrawer != null) {
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }

    private void setUp() {
        mDrawer = mActivityMainBinding.drawerView;
        mToolbar = mActivityMainBinding.toolbar;
        mNavigationView = mActivityMainBinding.navigationView;
        mCardsContainerView = mActivityMainBinding.cardsContainer;
        mBottomNav = mActivityMainBinding.bottomnavMenu;

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }
        };

        mDrawerToggle.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_menu_icon));
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setupNavMenu();
        String version = getString(R.string.version) + " " + BuildConfig.VERSION_NAME;
        mMainViewModel.updateAppVersion(version);
        mMainViewModel.onNavMenuCreated();
//        setupCardContainerView();
//        subscribeToLiveData();

        mBottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open_drawer, R.string.close_drawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };
        actionBarDrawerToggle.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_menu_icon));
        //Setting the actionbarToggle to drawer layout
        mDrawer.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
//        actionBarDrawerToggle.syncState();
    }


    private void setupNavMenu() {
        NavHeaderLearningBinding navHeaderLearningBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_learning, mActivityMainBinding.navigationView, false);
        mActivityMainBinding.navigationView.addHeaderView(navHeaderLearningBinding.getRoot());
        navHeaderLearningBinding.setViewModel(mMainViewModel);
//        mNavigationView.setNavigationItemSelectedListener(
//                item -> {
//                    mDrawer.closeDrawer(GravityCompat.START);
//                    switch (item.getItemId()) {
//                        case R.id.navItemAbout:
//                            showAboutFragment();
//                            return true;
//                        case R.id.navItemRateUs:
//                            RateUsDialog.newInstance().show(getSupportFragmentManager());
//                            return true;
//                        case R.id.navItemFeed:
//                            startActivity(FeedActivity.newIntent(MainActivity.this));
//                            return true;
//                        case R.id.navItemLogout:
//                            mMainViewModel.logout();
//                            return true;
//                        default:
//                            return false;
//                    }
//                });
    }

    private void showAboutFragment() {
        lockDrawer();
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.clRootView, AboutFragment.newInstance(), AboutFragment.TAG)
                .commit();
    }


    private void unlockDrawer() {
        if (mDrawer != null) {
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener = menuItem -> {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navigation_home_learning:
//                mToolbar.setTitle(getResources().getString(R.string.app_name_title));
                mToolbar.setLogo(this.getResources().getDrawable(R.drawable.ic_logo_learning));
                mToolbar.setTitle(null);
                LFragmentHome f_home = new LFragmentHome();
                onchangeSegmentFragment(f_home);
                return true;
            case R.id.navigation_wlist_learning:
                mToolbar.setLogo(null);
                mToolbar.setTitle(getResources().getString(R.string.wishlist));
                LFragmentWishlist f_friends = new LFragmentWishlist();
                onchangeSegmentFragment(f_friends);
                return true;
            case R.id.navigation_notif_learning:
                mToolbar.setLogo(null);
                mToolbar.setTitle(getResources().getString(R.string.notification));
                BFragmentNotification f_notif = new BFragmentNotification();
                onchangeSegmentFragment(f_notif);
                return true;
        }
        return false;
    };



}

