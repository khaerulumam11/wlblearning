package com.wlb.framework.learning.ui.learning.allList.viewModel;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.model.api.BlogResponse;
import com.wlb.framework.learning.data.model.api.LoginRequest;
import com.wlb.framework.learning.data.model.api.wlb.account.LoginResponseWlb;
import com.wlb.framework.learning.data.remote.ApiEndPoint;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.allList.navigator.AllTrendingNavigator;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AllTrendingListViewModel extends BaseViewModel<AllTrendingNavigator> {
//    private final MutableLiveData<List<BlogResponse.Blog>> blogListLiveData;

    private Gson gson;
    public AllTrendingListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
//        blogListLiveData = new MutableLiveData<>();
//        fetchBlogs();
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
    }

    public void fetchBlogs() {
        setIsLoading(true);
        AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVERWLB_ALL_COURSE_RECOMENDATION)
                .addHeaders("Authorization","Bearer" + getDataManager().getoAuthUsertoken())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        setIsLoading(false);

                                CourseModelTrending courseModelTrending = gson.fromJson(String.valueOf(response),CourseModelTrending.class);
                                if (courseModelTrending.getData().size() != 0) {
                                    getNavigator().updateUI(courseModelTrending);
                                }


                    }

                    @Override
                    public void onError(ANError anError) {
                        setIsLoading(false);
                        getNavigator().handleErrorNetwork(anError);
                    }
                });
    }


}
