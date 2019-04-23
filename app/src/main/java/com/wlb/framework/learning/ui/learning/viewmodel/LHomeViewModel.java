package com.wlb.framework.learning.ui.learning.viewmodel;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.model.api.wlb.course.CourseRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.jw.VideoDetail;
import com.wlb.framework.learning.data.remote.ApiEndPoint;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.learning.model.CategoryModel;
import com.wlb.framework.learning.ui.learning.navigator.LearningFragmentNavigator;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import org.json.JSONException;
import org.json.JSONObject;

public class LHomeViewModel extends BaseViewModel<LearningFragmentNavigator> {

    private Gson gson;

    public LHomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
    }


   public void onAll(){
        getNavigator().onAllTrending();
    }

    public void onAllC(){
        getNavigator().onAllCategory();
    }


    public void getRecommendationCourse(){
        AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVERWLB_COURSE_RECOMMENDATION)
                .addHeaders("Authorization", "Bearer " + getDataManager().getoAuthUsertoken())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        setIsLoading(false);

                        CourseRespMdl courseRespMdl = gson.fromJson(String.valueOf(response), CourseRespMdl.class);
                        if (courseRespMdl.getData().size() != 0 && courseRespMdl.getData() != null){
                            getNavigator().updateCourse(courseRespMdl);
                        }else{
                            Log.e("login", "onResponse: " + "no courses found");
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        setIsLoading(false);
                        getNavigator().handleErrorNetwork(anError);
                    }
                });
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
                            getNavigator().updateCategory(categoryModel);
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
