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


import com.wlb.framework.learning.BuildConfig;
import com.wlb.framework.learning.utils.AppConstants;

/**
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL + "/5926ce9d11000096006ccb30";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL + "/588d161c100000a9072d2946";

    public static final String ENDPOINT_OPEN_SOURCE = BuildConfig.BASE_URL + "/5926c34212000035026871cd";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL + "/588d15f5100000a8072d2945";
    /**
     * WLB
     */

    public static final String ENDPOINT_SERVERWLB_DETAIL_LEARNING = AppConstants.BASE_URL_WLB +"/academy/course/";
    public static final String ENDPOINT_SERVERWLB_COURSE_RECOMMENDATION = AppConstants.BASE_URL_WLB +"/academy/course/recommendation";
    public static final String ENDPOINT_SERVERWLB_CATEGORY = AppConstants.BASE_URL_WLB +"/academy/category/get";
    public static final String ENDPOINT_SERVERWLB_LOGIN_ACCOUNT = AppConstants.BASE_URL_WLB +"/global/accounts/login";
    public static final String ENDPOINT_SERVERWLB_REGISTER_ACCOUNT = AppConstants.BASE_URL_WLB +"/global/accounts/register";
    public static final String ENDPOINT_SERVERWLB_COURSE_DETAIL = AppConstants.BASE_URL_WLB +"/academy/course/1";

    public static final String ENDPOINT_SERVERWLB_GET_FILE_JWT = AppConstants.BASE_URL_JWT;

    public static final String ENDPOINT_SERVERWLB_ALL_COURSE_RECOMENDATION = AppConstants.BASE_URL_WLB +"/academy/course/recommendation";
    public static final String ENDPOINT_SERVERWLB_WISHLIST = AppConstants.BASE_URL_WLB +"/academy/wishlist/get";



    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
