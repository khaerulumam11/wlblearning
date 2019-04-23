package com.wlb.framework.learning.ui.main.bottommenu;

import android.os.Bundle;
import android.view.View;

//import com.crashlytics.android.Crashlytics;
import com.google.android.material.tabs.TabLayout;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.FragmentMainTimelineBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.feed.FeedPagerAdapter;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.TimelineViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class BFragmentTimeline extends BaseFragment<FragmentMainTimelineBinding, TimelineViewModel> implements HasSupportFragmentInjector {
    public static final String TAG = BFragmentTimeline.class.getSimpleName();

    public static BFragmentTimeline newInstance() {
        Bundle args = new Bundle();
        BFragmentTimeline fragment = new BFragmentTimeline();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    @Inject
    TimelinesPagerAdapter mPagerAdapter;

    private TimelineViewModel timelineViewModel;
    private FragmentMainTimelineBinding mainTimelineBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_timeline;
    }

    @Override
    public TimelineViewModel getViewModel() {
        timelineViewModel = ViewModelProviders.of(this, factory).get(TimelineViewModel.class);
        return timelineViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainTimelineBinding = getViewDataBinding();
        setUp();
//        Crashlytics.setString("Timeline","Error ");
    }

    //    @Override
//    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return fragmentDispatchingAndroidInjector;
//    }

    private void setUp() {
        mPagerAdapter.setCount(4);
        mainTimelineBinding.TimelineViewPager.setAdapter(mPagerAdapter);
        mainTimelineBinding.tabLayoutTimeline.addTab(mainTimelineBinding.tabLayoutTimeline.newTab().setText(getString(R.string.posting)));
        mainTimelineBinding.tabLayoutTimeline.addTab(mainTimelineBinding.tabLayoutTimeline.newTab().setText(getString(R.string.article)));
        mainTimelineBinding.tabLayoutTimeline.addTab(mainTimelineBinding.tabLayoutTimeline.newTab().setText(getString(R.string.commpanies)));
        mainTimelineBinding.tabLayoutTimeline.addTab(mainTimelineBinding.tabLayoutTimeline.newTab().setText(getString(R.string.job)));
        mainTimelineBinding.TimelineViewPager.setOffscreenPageLimit(mainTimelineBinding.tabLayoutTimeline.getTabCount());
        mainTimelineBinding.TimelineViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTimelineBinding.tabLayoutTimeline));
        mainTimelineBinding.tabLayoutTimeline.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainTimelineBinding.TimelineViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
