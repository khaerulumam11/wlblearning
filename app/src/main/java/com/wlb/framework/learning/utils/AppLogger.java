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

package com.wlb.framework.learning.utils;

import com.crashlytics.android.Crashlytics;
import android.os.Build;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.CrashlyticsCore;
import com.wlb.framework.learning.BuildConfig;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * Adding Crashlytics
 */

public final class AppLogger {

    private AppLogger() {
        // This utility class is not publicly instantiable
    }

    public static void d(String s, Object... objects) {
        Timber.d(s, objects);
        //not worki
        if (Build.VERSION.SDK_INT > 20) {
            Crashlytics.log(s);
        }
    }

    public static void d(Throwable throwable, String s, Object... objects) {
        Timber.d(throwable, s, objects);
        if (Build.VERSION.SDK_INT > 20) {
            Crashlytics.logException(throwable);
        }
    }

    public static void e(String s, Object... objects) {
        Timber.e(s, objects);
        if (Build.VERSION.SDK_INT > 20) {
            Crashlytics.log(s);
        }

    }

    public static void e(Throwable throwable, String s, Object... objects) {
        Timber.e(throwable, s, objects);
        if (Build.VERSION.SDK_INT > 20) {
            Crashlytics.logException(throwable);
        }
    }

    public static void i(String s, Object... objects) {
        Timber.i(s, objects);
    }

    public static void i(Throwable throwable, String s, Object... objects) {
        Timber.i(throwable, s, objects);
    }

    public static void init() {
        if (BuildConfig.DEBUG) {

            Timber.plant(new Timber.DebugTree());
        }else{

        }
    }

    public static void w(String s, Object... objects) {
        Timber.w(s, objects);
    }

    public static void w(Throwable throwable, String s, Object... objects) {
        Timber.w(throwable, s, objects);
    }
}
