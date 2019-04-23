/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.wlb.framework.learning.ui.login;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.model.api.ApiError;
import com.wlb.framework.learning.data.model.api.LoginRequest;
import com.wlb.framework.learning.data.model.api.wlb.account.LoginResponseWlb;
import com.wlb.framework.learning.data.remote.ApiEndPoint;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.ui.login.modelui.LoginFields;
import com.wlb.framework.learning.ui.login.modelui.LoginForm;
import com.wlb.framework.learning.utils.AppLogger;
import com.wlb.framework.learning.utils.CommonUtils;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Function;

/**
 * Created by MHBX
 */
public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    private LoginForm login;
    private Gson gson;
    private View.OnFocusChangeListener onFocusEmail;
    private View.OnFocusChangeListener onFocusPassword;

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gson = gsonBuilder.create();
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .doOnSuccess(response ->
                        getDataManager()
                                .updateUserInfo(
                                        response.getAccessToken(),
                                        response.getUserId(),
                                        DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                        response.getUserName(),
                                        response.getUserEmail(),
                                        response.getGoogleProfilePicUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);

                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }
    public void loginWlb(String email, String password) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doServerLoginWLBApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .doOnSuccess(loginResponseWlb -> getDataManager().
                        updateUserWlbInformation(
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                loginResponseWlb.getId(),
                                loginResponseWlb.getName(),
                                loginResponseWlb.getEmail(),
                                loginResponseWlb.getSocialLinks(),
                                loginResponseWlb.getBiography(),
                                loginResponseWlb.getRoles(),
                                loginResponseWlb.getLatestBalance(),
                                loginResponseWlb.getDateAdded(),
                                loginResponseWlb.getLastModified(),
                                loginResponseWlb.getSaltRounds(),
                                loginResponseWlb.getToken(),
                                loginResponseWlb.getToken()
                        )
                )
                .doOnError(ANError -> {
                    Log.i("Login Error", ANError.getMessage());
                })
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            setIsLoading(false);
                            if (!response.getStatus().equals("401")) {
                                AppLogger.d("Berhasil Masuk");
                                getNavigator().openMainActivity();
                            } else {
                                AppLogger.e("Gagal Masuk");
                            }

                        }, throwable -> {
                            AppLogger.e(throwable, "Error masuk");
                            setIsLoading(false);
                            getNavigator().handleError(throwable);
                        }
                ));
    }

    public void Loginv2(String email, String password) {
        setIsLoading(true);
        AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVERWLB_LOGIN_ACCOUNT)
                .addBodyParameter(new LoginRequest.ServerLoginRequest(email, password))
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        setIsLoading(false);
                        try {
                            if (response.get("status").equals("ACTIVE")){
                                LoginResponseWlb loginResponseWlb = gson.fromJson(String.valueOf(response),LoginResponseWlb.class);
                                getDataManager().updateUserWlbInformation(
                                        DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                        loginResponseWlb.getId(),
                                        loginResponseWlb.getName(),
                                        loginResponseWlb.getEmail(),
                                        loginResponseWlb.getSocialLinks(),
                                        loginResponseWlb.getBiography(),
                                        loginResponseWlb.getRoles(),
                                        loginResponseWlb.getLatestBalance(),
                                        loginResponseWlb.getDateAdded(),
                                        loginResponseWlb.getLastModified(),
                                        loginResponseWlb.getSaltRounds(),
                                        loginResponseWlb.getToken(),
                                        loginResponseWlb.getOauth().getAccess_token()
                                );
                                getNavigator().openMainActivity();
                            }
                        } catch (JSONException e) {
//                            e.printStackTrace();
                            Log.e("login", "onResponse: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        setIsLoading(false);
                        getNavigator().handleErrorNetwork(anError);
                    }
                });
    }

    public void onFbLoginClick() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doFacebookLoginApiCall(new LoginRequest.FacebookLoginRequest("test3", "test4"))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_FB,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public void onGoogleLoginClick() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doGoogleLoginApiCall(new LoginRequest.GoogleLoginRequest("test1", "test1"))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_GOOGLE,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public void onServerLoginClick() {
        getNavigator().login();
//        getNavigator().openMainActivity();
    }

    public void onClickRegister() {
        getNavigator().openRegister();
    }

    //validation
    public LoginForm getLogin() {
        return login;
    }

    public View.OnFocusChangeListener getEmailOnFocusChangeListener() {
        return onFocusEmail;
    }

    public View.OnFocusChangeListener getPasswordOnFocusChangeListener() {
        return onFocusPassword;
    }

    public void onButtonClick() {
        login.onClick();
    }

    public MutableLiveData<LoginFields> getLoginFields() {
        return login.getLoginFields();
    }

    public LoginForm getForm() {
        return login;
    }

    @BindingAdapter("error")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }
    }

    @BindingAdapter("onFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }
}
