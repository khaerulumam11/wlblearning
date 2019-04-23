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

package com.wlb.framework.learning.ui.main;

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
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.BuildConfig;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.ActivityMainBinding;
import com.wlb.framework.learning.databinding.NavHeaderMainBinding;
import com.wlb.framework.learning.ui.about.AboutFragment;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.learning.LearningActivity;
import com.wlb.framework.learning.ui.login.LoginActivity;
import com.wlb.framework.learning.ui.main.bottommenu.BFragmentFriends;
import com.wlb.framework.learning.ui.main.bottommenu.BFragmentNotification;
import com.wlb.framework.learning.ui.main.bottommenu.BFragmentProfile;
import com.wlb.framework.learning.ui.main.bottommenu.BFragmentTimeline;
import com.wlb.framework.learning.utils.ScreenUtils;

import javax.inject.Inject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {
    private static final String TAG = "MainActivity";
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    private ActivityMainBinding mActivityMainBinding;
    private SwipePlaceHolderView mCardsContainerView;
    private DrawerLayout mDrawer;
    private MainViewModel mMainViewModel;
    private NavigationView mNavigationView;
    private BottomNavigationView mBottomNav;
    private Toolbar mToolbar;
    private Handler mHandler;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
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
        getMenuInflater().inflate(R.menu.main_dashboard, menu);
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
            case R.id.action_search:
                return true;
            case R.id.action_chat:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void LoadHomeFragment() {
        // update the main content by replacing fragments
        Fragment fragment = new BFragmentTimeline();
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
        mToolbar.setTitle(mMainViewModel.getNameProfile());
        unselectBottomNav();
        Fragment fragment = new BFragmentProfile();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.main_content, fragment,TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void openLearningNav() {
        startActivity(LearningActivity.newIntent(MainActivity.this));
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

    private void setupCardContainerView() {
        int screenWidth = ScreenUtils.getScreenWidth(this);
        int screenHeight = ScreenUtils.getScreenHeight(this);

        mCardsContainerView.getBuilder()
                .setDisplayViewCount(3)
                .setHeightSwipeDistFactor(10)
                .setWidthSwipeDistFactor(5)
                .setSwipeDecor(new SwipeDecor()
                        .setViewWidth((int) (0.90 * screenWidth))
                        .setViewHeight((int) (0.75 * screenHeight))
                        .setPaddingTop(20)
                        .setSwipeRotationAngle(10)
                        .setRelativeScale(0.01f));

        mCardsContainerView.addItemRemoveListener(count -> {
            if (count == 0) {
                // reload the contents again after 1 sec delay
                new Handler(getMainLooper()).postDelayed(() -> {
                    //Reload once all the cards are removed
                    mMainViewModel.loadQuestionCards();
                }, 800);
            } else {
                mMainViewModel.removeQuestionCard();
            }
        });
    }

    private void setupNavMenu() {
        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_main, mActivityMainBinding.navigationView, false);
        mActivityMainBinding.navigationView.addHeaderView(navHeaderMainBinding.getRoot());
        navHeaderMainBinding.setViewModel(mMainViewModel);
        mNavigationView.setNavigationItemSelectedListener(
                item -> {
                    mDrawer.closeDrawer(GravityCompat.START);
                    switch (item.getItemId()) {
//                        case R.id.navItemAbout:
//                            showAboutFragment();
//                            return true;
//                        case R.id.navItemRateUs:
//                            RateUsDialog.newInstance().show(getSupportFragmentManager());
//                            return true;
                        case R.id.nav_learning_menu:
                            startActivity(LearningActivity.newIntent(MainActivity.this));
                            return true;
                        case R.id.tv_learning_nav:
                            startActivity(LearningActivity.newIntent(MainActivity.this));
                            return true;
//                        case R.id.navItemLogout:
//                            mMainViewModel.logout();
//                            return true;
                        default:
                            return false;
                    }
                });
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

    private void subscribeToLiveData() {
        mMainViewModel.getQuestionCardData().observe(this, questionCardDatas -> mMainViewModel.setQuestionDataList(questionCardDatas));
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
            case R.id.navigation_home:
                mToolbar.setTitle(getResources().getString(R.string.app_name_title));
                BFragmentTimeline f_home = new BFragmentTimeline();
                onchangeSegmentFragment(f_home);
                return true;
            case R.id.navigation_friend:
                mToolbar.setTitle(getResources().getString(R.string.contacts));
                BFragmentFriends f_friends = new BFragmentFriends();
                onchangeSegmentFragment(f_friends);
                return true;
            case R.id.navigation_notif:
                mToolbar.setTitle(getResources().getString(R.string.notification));
                BFragmentNotification f_notif = new BFragmentNotification();
                onchangeSegmentFragment(f_notif);
                return true;
        }
        return false;
    };
}

