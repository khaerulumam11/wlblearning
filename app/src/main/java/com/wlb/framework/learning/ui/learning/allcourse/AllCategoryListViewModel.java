package com.wlb.framework.learning.ui.learning.allcourse;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.remote.ApiEndPoint;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.learning.model.CategoryModel;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import org.json.JSONObject;

public class AllCategoryListViewModel extends BaseViewModel<AllCategoryNavigator> {
//    private final MutableLiveData<List<BlogResponse.Blog>> blogListLiveData;

    private Gson gson;
    public AllCategoryListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
//        blogListLiveData = new MutableLiveData<>();
//        fetchBlogs();
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
    }

    public void getCategory(){
        AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVERWLB_CATEGORY)
                .addHeaders("Authorization", "Bearer " + getDataManager().getoAuthUsertoken())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        setIsLoading(false);

                        CategoryModel categoryModel = gson.fromJson(String.valueOf(response), CategoryModel.class);
                        if (categoryModel.getData().size() != 0 && categoryModel.getData() != null){
                            getNavigator().updateUI(categoryModel);
                        }else{
                            Log.e("login", "onResponse: " + "no category found");
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
