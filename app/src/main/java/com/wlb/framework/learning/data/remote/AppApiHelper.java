/*
 *  Copyright (C) 2019
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.wlb.framework.learning.data.remote;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.wlb.framework.learning.data.model.api.BlogResponse;
import com.wlb.framework.learning.data.model.api.LoginRequest;
import com.wlb.framework.learning.data.model.api.LoginResponse;
import com.wlb.framework.learning.data.model.api.LogoutResponse;
import com.wlb.framework.learning.data.model.api.OpenSourceResponse;
import com.wlb.framework.learning.data.model.api.wlb.account.LoginResponseWlb;
import com.wlb.framework.learning.data.model.api.wlb.register.RegisterRequest;
import com.wlb.framework.learning.data.model.api.wlb.register.RegisterResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {
    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);

    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponseWlb> doServerLoginWLBApiCall(LoginRequest.ServerLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVERWLB_LOGIN_ACCOUNT)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponseWlb.class);
//        User user = new User();
//        user.firstname = "Amit";
//        user.lastname = "Shekhar";

//        AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVERWLB_LOGIN_ACCOUNT)
//                .addBodyParameter(request) // posting java object
//                .setTag("test")
//                .setPriority(Priority.MEDIUM)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//                    }
//                });

    }

    @Override
    public Single<RegisterResponse> doServerRegisterWLBApiCall(RegisterRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVERWLB_REGISTER_ACCOUNT)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }



    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(BlogResponse.class);
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(OpenSourceResponse.class);
    }

}
