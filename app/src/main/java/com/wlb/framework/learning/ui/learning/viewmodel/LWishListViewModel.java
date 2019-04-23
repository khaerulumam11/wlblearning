package com.wlb.framework.learning.ui.learning.viewmodel;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.model.api.wlb.account.LoginResponseWlb;
import com.wlb.framework.learning.data.remote.ApiEndPoint;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.learning.allList.model.CourseModelTrending;
import com.wlb.framework.learning.ui.learning.model.WishlistModel;
import com.wlb.framework.learning.ui.learning.navigator.FragmentWishlistNavigator;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LWishListViewModel extends BaseViewModel<FragmentWishlistNavigator>  {
    private Gson gson;
    public LWishListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
    }

    public void loadWishlist() {
        setIsLoading(true);
        AndroidNetworking.get(ApiEndPoint.ENDPOINT_SERVERWLB_WISHLIST)
                .addHeaders("Authorization","Bearer " + getDataManager().getoAuthUsertoken())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setIsLoading(false);
//                        LoginResponseWlb loginResponseWlb = gson.fromJson(String.valueOf(response),LoginResponseWlb.class);
//                        WishlistModel courseModelTrending = gson.fromJson(String.valueOf(response),WishlistModel.class);
//                        getDataManager().updateUserWlbInformation(
//                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
//                                loginResponseWlb.getId(),
//                                loginResponseWlb.getName(),
//                                loginResponseWlb.getEmail(),
//                                loginResponseWlb.getSocialLinks(),
//                                loginResponseWlb.getBiography(),
//                                loginResponseWlb.getRoles(),
//                                loginResponseWlb.getLatestBalance(),
//                                loginResponseWlb.getDateAdded(),
//                                loginResponseWlb.getLastModified(),
//                                loginResponseWlb.getSaltRounds(),
//                                loginResponseWlb.getToken(),
//                                loginResponseWlb.getOauth().getAccess_token()
//                        );
                        Type listType = new TypeToken<List<WishlistModel.Course>>(){}.getType();
                        List<WishlistModel.Course> listOfCountry = gson.fromJson(String.valueOf(response.length()), listType);
//

                        Log.i("wishlist", "onResponse: "+listOfCountry.size());
// if (courseModelTrending.getUserId() == loginResponseWlb.getId() ) {
//                            if (courseModelTrending.getCourse().size() != 0) {
//                                getNavigator().updateWishlist(listOfCountry);
//                            }
//                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        setIsLoading(false);
                        getNavigator().handleErrorNetwork(anError);
                    }
                });
    }

}
