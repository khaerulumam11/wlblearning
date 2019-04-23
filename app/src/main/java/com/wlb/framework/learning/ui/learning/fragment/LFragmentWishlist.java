package com.wlb.framework.learning.ui.learning.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.error.ANError;
import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.ViewModelProviderFactory;
import com.wlb.framework.learning.databinding.FragmentLearningWishlistBinding;
import com.wlb.framework.learning.databinding.FragmentMainFriendsBinding;
import com.wlb.framework.learning.ui.base.BaseFragment;
import com.wlb.framework.learning.ui.learning.adapter.WishlistAdapter;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.model.WishlistModel;
import com.wlb.framework.learning.ui.learning.navigator.FragmentWishlistNavigator;
import com.wlb.framework.learning.ui.learning.viewmodel.LHomeViewModel;
import com.wlb.framework.learning.ui.learning.viewmodel.LWishListViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.DispatchingAndroidInjector;

public class LFragmentWishlist extends BaseFragment<FragmentLearningWishlistBinding, LWishListViewModel>
        implements FragmentWishlistNavigator, WishlistAdapter.AllTrendingListListener{

    public static LFragmentWishlist newInstance() {
        Bundle args = new Bundle();
        LFragmentWishlist fragment = new LFragmentWishlist();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    WishlistAdapter wishlistAdapter;
    private LWishListViewModel friendsViewModel;
    FragmentLearningWishlistBinding mFragmentMainBinding;

    ArrayList<WishlistModel.Course> courses = new ArrayList<WishlistModel.Course>();

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_learning_wishlist;
    }

    @Override
    public LWishListViewModel getViewModel() {
        friendsViewModel = ViewModelProviders.of(this, factory).get(LWishListViewModel.class);
        return friendsViewModel;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentMainBinding = getViewDataBinding();
        friendsViewModel.setNavigator(this);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(),2);
        RecyclerView recyclerView = view.findViewById(R.id.rv_wishlist);
        recyclerView.setLayoutManager(gridLayoutManager);
//        mFragmentMainBinding.rvWishlist.setItemAnimator(new DefaultItemAnimator());
        wishlistAdapter = new WishlistAdapter(courses,getBaseActivity());
        recyclerView.setAdapter(wishlistAdapter);
        recyclerView.setHasFixedSize(false);

        wishlistAdapter.notifyDataSetChanged();
        updateRecommendationCourse();

        return view;
    }

    private void setUp(View view) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(),2);
        mFragmentMainBinding.rvWishlist.setLayoutManager(gridLayoutManager);
//        mFragmentMainBinding.rvWishlist.setItemAnimator(new DefaultItemAnimator());
        wishlistAdapter = new WishlistAdapter(courses,getBaseActivity());
        mFragmentMainBinding.rvWishlist.setAdapter(wishlistAdapter);
        mFragmentMainBinding.rvWishlist.setHasFixedSize(false);

        wishlistAdapter.notifyDataSetChanged();
        updateRecommendationCourse();

    }

    @Override
    public void handleError(Throwable throwable) {

    }


    private void updateRecommendationCourse(){
        if (isNetworkConnected()){
            friendsViewModel.loadWishlist();
        }else{

        }
    }

    @Override
    public void updateWishlist(ArrayList<WishlistModel.Course> courseModelTrending) {
//        WishlistModel.Course academyCourseCategory;
////
//        for (int i = 0; i < courseModelTrending.size(); i++){
//            academyCourseCategory = courseModelTrending.get(i);
//            courses.add(academyCourseCategory);
//        }
//        wishlistAdapter.notifyDataSetChanged();

    }

    @Override
    public void handleErrorNetwork(ANError error) {

    }
}
