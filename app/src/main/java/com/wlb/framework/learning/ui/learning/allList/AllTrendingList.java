package com.wlb.framework.learning.ui.learning.allList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.ActivityAllTrendingListBinding;
import com.wlb.framework.learning.databinding.ItemBlogEmptyViewBinding;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.learning.allList.adapter.AllTrendingListAdapter;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.allList.navigator.AllTrendingNavigator;
import com.wlb.framework.learning.ui.learning.allList.util.DemoConfiguration;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllTrendingListViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class AllTrendingList extends BaseActivity<ActivityAllTrendingListBinding, AllTrendingListViewModel>
        implements AllTrendingNavigator, AllTrendingListAdapter.AllTrendingListListener {

    private static final String TAG = "AllTrendingList";

    @Inject
    ViewModelProviderFactory factory;
    AllTrendingListAdapter allTrendingListAdapter;
    ActivityAllTrendingListBinding mActivityAllTrendingBinding;
    private Toolbar mToolbar;
    private AllTrendingListViewModel allTrendingListViewModel;

    RecyclerView.LayoutManager layoutManager;

    ArrayList<CourseModelTrending.Data> courses = new ArrayList<CourseModelTrending.Data>();

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, AllTrendingList.class);
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.model;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_trending_list;
    }

    @Override
    public AllTrendingListViewModel getViewModel() {
        allTrendingListViewModel = ViewModelProviders.of(this, factory).get(AllTrendingListViewModel.class);
        return allTrendingListViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityAllTrendingBinding = getViewDataBinding();
        allTrendingListViewModel.setNavigator(this);
//        allTrendingListAdapter.setListener(this);
        setUp();
//
    }

    private void setUp() {
        mToolbar = mActivityAllTrendingBinding.toolbar;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle("All Trending Learning");
        mActivityAllTrendingBinding.rvLis.setLayoutManager(new GridLayoutManager(this,2));
        mActivityAllTrendingBinding.rvLis.setItemAnimator(new DefaultItemAnimator());
        allTrendingListAdapter = new AllTrendingListAdapter(courses,this);
        mActivityAllTrendingBinding.rvLis.setAdapter(allTrendingListAdapter);
//        mActivityAllTrendingBinding.rvLis.showShimmerAdapter();
//         mActivityAllTrendingBinding.shimmerLayout.startShimmerAnimation();
//        mActivityAllTrendingBinding.shimmerLayout.setVisibility(View.GONE);

//        mActivityAllTrendingBinding.rvList.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mActivityAllTrendingBinding.rvList.showShimmerAdapter();
//            }
//        },3000);



        updateRecommendationCourse();

        mActivityAllTrendingBinding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        courses.clear();
                        // Berhenti berputar/refreshing
                        mActivityAllTrendingBinding.swipeRefreshLayout.setRefreshing(false);

                        // fungsi-fungsi lain yang dijalankan saat refresh berhenti
                        allTrendingListViewModel.fetchBlogs();
                        allTrendingListAdapter.notifyDataSetChanged();
                    }
                }, 5000);
            }
        });
    }

//    @Override
//    public void onRetryClick() {
//        allTrendingListViewModel.fetchBlogs();
//    }

    @Override
    public void handleError(Throwable throwable) {

    }

    private void updateRecommendationCourse(){
        if (isNetworkConnected()){
            allTrendingListViewModel.fetchBlogs();
            allTrendingListAdapter.notifyDataSetChanged();
//            mActivityAllTrendingBinding.shimmerLayout.stopShimmerAnimation();
//        mActivityAllTrendingBinding.shimmerLayout.setVisibility(View.GONE);
        }else{

        }
    }

    @Override
    public void updateUI(CourseModelTrending courseModelTrending) {

        CourseModelTrending.Data academyCourseCategory;
//
        for (int i = 0; i < courseModelTrending.getData().size(); i++){
            academyCourseCategory = courseModelTrending.getData().get(i);
            courses.add(academyCourseCategory);
        }
        allTrendingListAdapter.notifyDataSetChanged();
    }

    @Override
    public void handleErrorNetwork(ANError error) {

    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        mActivityAllTrendingBinding.shimmerLayout.startShimmerAnimation();
//    }
//
//    @Override
//    protected void onPause() {
//        mActivityAllTrendingBinding.shimmerLayout.stopShimmerAnimation();
//        super.onPause();
//    }

}
