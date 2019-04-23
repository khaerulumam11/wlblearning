package com.wlb.framework.learning.ui.learning.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.data.model.api.BlogResponse;
import com.wlb.framework.learning.data.model.api.wlb.course.CourseRespMdl;
import com.wlb.framework.learning.databinding.FragmentLearningHomeBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.custom.ItemDecorationHorizontal;
import com.wlb.framework.learning.ui.learning.adapter.LCategoryAdapter;
import com.wlb.framework.learning.ui.learning.adapter.LCategoryAdapter1;
import com.wlb.framework.learning.ui.learning.allList.AllTrendingList;
import com.wlb.framework.learning.ui.learning.allcourse.AllCategoryActivity;
import com.wlb.framework.learning.ui.learning.detail.DetailLearningAcitivity;
import com.wlb.framework.learning.ui.learning.model.CategoryModel;
import com.wlb.framework.learning.ui.learning.navigator.LearningFragmentNavigator;
import com.wlb.framework.learning.ui.learning.viewmodel.LHomeViewModel;
import com.wlb.framework.learning.ui.main.jajal.CourseAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.DispatchingAndroidInjector;

import static com.mindorks.placeholderview.Utils.dpToPx;

public class LFragmentHome extends BaseFragment<FragmentLearningHomeBinding, LHomeViewModel> implements LearningFragmentNavigator {

    public static LFragmentHome newInstance() {
        Bundle args = new Bundle();
        LFragmentHome fragment = new LFragmentHome();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    private LHomeViewModel lHomeViewModel;
    FragmentLearningHomeBinding mFragmentMainBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_learning_home;
    }

    @Override
    public LHomeViewModel getViewModel() {
        lHomeViewModel = ViewModelProviders.of(this, factory).get(LHomeViewModel.class);
        return lHomeViewModel;
    }

    @Override
    public void onPergi(CourseRespMdl.Data course) {
        Intent intent = DetailLearningAcitivity.newIntent(getActivity());
        intent.putExtra("id", course.getId());
        intent.putExtra("title", course.getTitle());
        startActivity(intent);
    }

    @Override
    public void handleErrorNetwork(ANError error) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentMainBinding = getViewDataBinding();
        lHomeViewModel.setNavigator(this);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        configCourseRv(view);

        return view;
    }

    @Override
    public void onAllTrending() {
        Intent intent = AllTrendingList.newIntent(getActivity());
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onAllCategory() {
        Intent intent = AllCategoryActivity.newIntent(getActivity());
        startActivity(intent);
        getActivity().finish();
    }

    ArrayList<CourseRespMdl.Data> courses = new ArrayList<CourseRespMdl.Data>();
    ArrayList<CategoryModel.Data> category = new ArrayList<CategoryModel.Data>();
    ArrayList<CategoryModel.Data> category1 = new ArrayList<CategoryModel.Data>();
    private CourseAdapter adapter;
    private LCategoryAdapter categoryAdapter;
    private LCategoryAdapter1 categoryAdapter1;

    private void configCourseRv(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(requireContext());
        ItemDecorationHorizontal itemDecoration = new ItemDecorationHorizontal(dpToPx(requireContext(), 8), dpToPx(requireContext(), 16));
        RecyclerView courseRv = view.findViewById(R.id.courseRv);
        RecyclerView categeoryRv = view.findViewById(R.id.rv_category);
        RecyclerView categeoryRv1 = view.findViewById(R.id.rv_category_1);
        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_fragment);
        courseRv.setLayoutManager(layoutManager);
        courseRv.addItemDecoration(itemDecoration);
        courseRv.setHasFixedSize(false);
        categeoryRv.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false));
//        categeoryRv1.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false));
//        categeoryRv.addItemDecoration(itemDecoration);
//        categeoryRv1.addItemDecoration(itemDecoration);
        categeoryRv.setHasFixedSize(false);
//        categeoryRv1.setHasFixedSize(false);
        categeoryRv.setNestedScrollingEnabled(false);
//        categeoryRv1.setNestedScrollingEnabled(false);

        adapter = new CourseAdapter(courses, getBaseActivity());
        categoryAdapter = new LCategoryAdapter(category, getBaseActivity());
//        categoryAdapter1 = new LCategoryAdapter1(category1, getBaseActivity());

        courseRv.setAdapter(adapter);
        categeoryRv.setAdapter(categoryAdapter);
//        categeoryRv1.setAdapter(categoryAdapter1);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        courses.clear();
                        category.clear();
                        // Berhenti berputar/refreshing
                        swipeRefreshLayout.setRefreshing(false);

                        // fungsi-fungsi lain yang dijalankan saat refresh berhenti
                        lHomeViewModel.getRecommendationCourse();
                        lHomeViewModel.getCategory();
                        adapter.notifyDataSetChanged();
                        categoryAdapter.notifyDataSetChanged();
                    }
                }, 5000);
            }
        });

        updateCategoryCourse();
        updateRecommendationCourse();

    }

    private void updateRecommendationCourse() {
        if (isNetworkConnected()) {
            lHomeViewModel.getRecommendationCourse();
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(requireContext(), "no Internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateCategoryCourse() {
        if (isNetworkConnected()) {
            lHomeViewModel.getCategory();
            categoryAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(requireContext(), "no Internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void updateCourse(CourseRespMdl courseRespMdl) {

        CourseRespMdl.Data course;
        for (int i = 0; i < 5; i++) {
            course = courseRespMdl.getData().get(i);
            courses.add(course);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateCategory(CategoryModel categoryModel) {
        CategoryModel.Data course;
        CategoryModel.Data course1;
        int k = (categoryModel.getData().size() / 2) + 1;
//        for (int i = 0; i < categoryModel.getData().size(); i++) {
            for (int h = 0; h < categoryModel.getData().size(); h++) {
                course = categoryModel.getData().get(h);
                category.add(course);
            }
        categoryAdapter.notifyDataSetChanged();

    }


//    }


    private void toLearningDetail() {

    }

}
