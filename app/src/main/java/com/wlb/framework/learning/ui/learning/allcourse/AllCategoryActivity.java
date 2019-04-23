package com.wlb.framework.learning.ui.learning.allcourse;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.ActivityAllCourseBinding;
import com.wlb.framework.learning.ui.base.BaseActivity;
import com.wlb.framework.learning.ui.learning.model.CategoryModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class AllCategoryActivity extends BaseActivity<ActivityAllCourseBinding, AllCategoryListViewModel>
        implements AllCategoryNavigator,AllCategoryListAdapter.AllCategoryListener {

    private static final String TAG = "AllTrendingList";

    @Inject
    ViewModelProviderFactory factory;
    ActivityAllCourseBinding activityAllCourseBinding;
    private Toolbar mToolbar;
    private AllCategoryListAdapter categoryAdapter;
    private AllCategoryListViewModel allCategoryListViewModel;

    ArrayList<CategoryModel.Data> courses = new ArrayList<CategoryModel.Data>();
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, AllCategoryActivity.class);
        return intent;
    }
    @Override
    public int getBindingVariable() {
        return BR.model;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_course;
    }

    @Override
    public AllCategoryListViewModel getViewModel() {
        allCategoryListViewModel = ViewModelProviders.of(this, factory).get(AllCategoryListViewModel.class);
        return allCategoryListViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAllCourseBinding = getViewDataBinding();
        allCategoryListViewModel.setNavigator(this);
        setUp();
    }

    private void setUp() {
        mToolbar = activityAllCourseBinding.toolbar;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle("All Category");
        activityAllCourseBinding.rvLis.setLayoutManager(new GridLayoutManager(this,2));
        activityAllCourseBinding.rvLis.setItemAnimator(new DefaultItemAnimator());
        categoryAdapter = new AllCategoryListAdapter(courses,this);
        activityAllCourseBinding.rvLis.setAdapter(categoryAdapter);

        activityAllCourseBinding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        courses.clear();
                        // Berhenti berputar/refreshing
                        activityAllCourseBinding.swipeRefreshLayout.setRefreshing(false);

                        // fungsi-fungsi lain yang dijalankan saat refresh berhenti
                        allCategoryListViewModel.getCategory();
                        categoryAdapter.notifyDataSetChanged();
                    }
                }, 5000);
            }
        });

        updateRecommendationCourse();
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    private void updateRecommendationCourse() {
        if (isNetworkConnected()) {
            allCategoryListViewModel.getCategory();
            categoryAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "no Internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void updateUI(CategoryModel courseModelTrending) {
        CategoryModel.Data academyCourseCategory;
//
        for (int i = 0; i < courseModelTrending.getData().size(); i++){
            academyCourseCategory = courseModelTrending.getData().get(i);
            courses.add(academyCourseCategory);
        }
        categoryAdapter.notifyDataSetChanged();

    }

    @Override
    public void handleErrorNetwork(ANError error) {

    }
}
