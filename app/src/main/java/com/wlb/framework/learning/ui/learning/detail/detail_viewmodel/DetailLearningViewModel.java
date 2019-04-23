package com.wlb.framework.learning.ui.learning.detail.detail_viewmodel;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.model.api.wlb.course.AboutRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.CommentRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.course.ReviewRespMdl;
import com.wlb.framework.learning.data.model.api.wlb.jw.VideoDetail;
import com.wlb.framework.learning.data.remote.ApiEndPoint;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.learning.detail.DetailLearningNavigator;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailLearningViewModel extends BaseViewModel<DetailLearningNavigator> {
    private Gson gson;
    private String url_video = "", default_video = "";

    public DetailLearningViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
    }

    public void getFileVideoJw(String media) {
        AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVERWLB_GET_FILE_JWT + media)
                .addHeaders("Authorization", "Bearer " + getDataManager().getoAuthUsertoken())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.get("url") != null) {
                                if (!url_video.isEmpty()) {
                                    url_video = response.get("url").toString();
                                    Log.i("result link", url_video);
                                    getDetailVideoJw(url_video);
                                } else {
                                    url_video = "";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            url_video = "";
                            Log.e("login", "onResponse: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        if (getNavigator() != null) {
                            getNavigator().handleErrorNetwork(anError);
                        }
                    }
                });
    }

    public void getDetailVideoJw(String url) {
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("detail Video", response.toString());
                        VideoDetail videoJwResolution = gson.fromJson(String.valueOf(response), VideoDetail.class);
                        //default_video = videoJwResolution.getPlaylist().get(0).getSources().get(0).getFile();
                        //Log.i("link ", "video:"+default_video);
                        getNavigator().onUpdateVideo(videoJwResolution);
                    }

                    @Override
                    public void onError(ANError anError) {
                        if (getNavigator() != null) {
                            getNavigator().handleErrorNetwork(anError);
                        }
                    }
                });
    }


    public void getAbout(String id) {
        AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVERWLB_DETAIL_LEARNING + id)
                .addHeaders("Authorization", "Bearer " + getDataManager().getoAuthUsertoken())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        setIsLoading(false);

                        AboutRespMdl aboutRespMdl = gson.fromJson(String.valueOf(response), AboutRespMdl.class);
                        if (aboutRespMdl != null && getNavigator() != null) {
                            getNavigator().updateAbout(aboutRespMdl);
                        } else {
                            Log.e("login", "onResponse: " + "no courses found");
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        setIsLoading(false);
                        if (getNavigator() != null) {
                            getNavigator().handleErrorNetwork(anError);
                        }
                    }
                });
    }


    public void getReview(String id) {
        AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVERWLB_DETAIL_LEARNING + id + "/review")
                .addHeaders("Authorization", "Bearer " + getDataManager().getoAuthUsertoken())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        setIsLoading(false);

                        ReviewRespMdl aboutRespMdl = gson.fromJson(String.valueOf(response), ReviewRespMdl.class);
                        if (aboutRespMdl != null && getNavigator() != null) {
                            getNavigator().updateReview(aboutRespMdl);
                        } else {
                            Log.e("login", "onResponse: " + "no courses found");
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        setIsLoading(false);
                        if (getNavigator() != null) {
                            getNavigator().handleErrorNetwork(anError);
                        }
                    }
                });
    }

    public void getComments(String id) {
        AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVERWLB_DETAIL_LEARNING + id + "/discussion")
                .addHeaders("Authorization", "Bearer " + getDataManager().getoAuthUsertoken())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        setIsLoading(false);

                        CommentRespMdl aboutRespMdl = gson.fromJson(String.valueOf(response), CommentRespMdl.class);
                        if (aboutRespMdl != null && getNavigator() != null) {
                            getNavigator().updateComment(aboutRespMdl);
                        } else {
                            Log.e("login", "onResponse: " + "no courses found");
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        setIsLoading(false);
                        if (getNavigator() != null) {
                            getNavigator().handleErrorNetwork(anError);

                        }
                    }
                });
    }
}
