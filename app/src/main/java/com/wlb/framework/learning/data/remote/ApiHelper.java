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

package com.wlb.framework.learning.data.remote;

import com.google.gson.JsonObject;
import com.wlb.framework.learning.data.model.api.ApiError;
import com.wlb.framework.learning.data.model.api.BlogResponse;
import com.wlb.framework.learning.data.model.api.LoginRequest;
import com.wlb.framework.learning.data.model.api.LoginResponse;
import com.wlb.framework.learning.data.model.api.LogoutResponse;
import com.wlb.framework.learning.data.model.api.OpenSourceResponse;
import com.wlb.framework.learning.data.model.api.wlb.account.LoginResponseWlb;
import com.wlb.framework.learning.data.model.api.wlb.register.RegisterRequest;
import com.wlb.framework.learning.data.model.api.wlb.register.RegisterResponse;

import io.reactivex.Single;
import io.reactivex.internal.operators.single.SingleMap;

/**
 * Created by amitshekhar on 07/07/17.
 */

public interface ApiHelper {

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();
    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    /**
     * WLB
     */
    //account register and login
    Single<LoginResponseWlb> doServerLoginWLBApiCall(LoginRequest.ServerLoginRequest request);
    Single<RegisterResponse> doServerRegisterWLBApiCall(RegisterRequest request);
    //

    ApiHeader getApiHeader();

    Single<BlogResponse> getBlogApiCall();
    Single<OpenSourceResponse> getOpenSourceApiCall();


    //WLB
    /**
     * Login
     */


}
