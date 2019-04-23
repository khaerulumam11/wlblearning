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

package com.wlb.framework.learning.di.module;

import android.app.Application;
import androidx.room.Room;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wlb.framework.learning.BuildConfig;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.data.AppDataManager;
import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.local.db.AppDatabase;
import com.wlb.framework.learning.data.local.db.AppDbHelper;
import com.wlb.framework.learning.data.local.db.DbHelper;
import com.wlb.framework.learning.data.local.prefs.AppPreferencesHelper;
import com.wlb.framework.learning.data.local.prefs.PreferencesHelper;
import com.wlb.framework.learning.data.remote.ApiHeader;
import com.wlb.framework.learning.data.remote.ApiHelper;
import com.wlb.framework.learning.data.remote.AppApiHelper;
import com.wlb.framework.learning.di.ApiInfo;
import com.wlb.framework.learning.di.DatabaseInfo;
import com.wlb.framework.learning.di.PreferenceInfo;
import com.wlb.framework.learning.utils.AppConstants;
import com.wlb.framework.learning.utils.rx.AppSchedulerProvider;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }@Provides
    ApiHeader.WlbApiHeader provideWlbHeader(PreferencesHelper preferencesHelper) {
        return new ApiHeader.WlbApiHeader(
                preferencesHelper.getoAuthUsertoken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
