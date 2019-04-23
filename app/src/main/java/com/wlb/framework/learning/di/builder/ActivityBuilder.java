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

package com.wlb.framework.learning.di.builder;

import com.wlb.framework.learning.ui.about.AboutFragmentProvider;
import com.wlb.framework.learning.ui.feed.FeedActivity;
import com.wlb.framework.learning.ui.feed.FeedActivityModule;
import com.wlb.framework.learning.ui.feed.blogs.BlogFragmentProvider;
import com.wlb.framework.learning.ui.feed.opensource.OpenSourceFragmentProvider;
import com.wlb.framework.learning.ui.learning.LearningActivity;
import com.wlb.framework.learning.ui.learning.allList.AllItemListModule;
import com.wlb.framework.learning.ui.learning.allList.AllItemListProvider;
import com.wlb.framework.learning.ui.learning.allList.AllTrendingList;
import com.wlb.framework.learning.ui.learning.allList.adapter.AllTrendingListAdapter;
import com.wlb.framework.learning.ui.learning.allcourse.AllCategoryActivity;
import com.wlb.framework.learning.ui.learning.allcourse.AllCategoryListModule;
import com.wlb.framework.learning.ui.learning.allcourse.AllCategoryListProvider;
import com.wlb.framework.learning.ui.learning.detail.DetailLearningAcitivity;
import com.wlb.framework.learning.ui.learning.detail.timeline.MFTimelineModule;
import com.wlb.framework.learning.ui.learning.detail.timeline.provider.MFPostingTimelineProvider;
import com.wlb.framework.learning.ui.learning.detail.timeline.provider.MFTimelineProvider;
import com.wlb.framework.learning.ui.login.LoginActivity;
import com.wlb.framework.learning.ui.main.MainActivity;
import com.wlb.framework.learning.ui.main.bottommenu.detail.EditProfile;
import com.wlb.framework.learning.ui.main.bottommenu.provider.BFriendsFragmentProvider;
import com.wlb.framework.learning.ui.main.bottommenu.provider.BNotificationFragmentProvider;
import com.wlb.framework.learning.ui.main.bottommenu.provider.BTimelineFragmentProvider;
import com.wlb.framework.learning.ui.main.bottommenu.provider.TimelineActivityModule;
import com.wlb.framework.learning.ui.main.contacts.MyContact;
import com.wlb.framework.learning.ui.main.rating.RateUsDialogProvider;
import com.wlb.framework.learning.ui.main.timeline.provider.MFPostingProvider;
import com.wlb.framework.learning.ui.register.RegisterActivity;
import com.wlb.framework.learning.ui.shopcart.ShoppingCart;
import com.wlb.framework.learning.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * MHBX
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            FeedActivityModule.class,
            BlogFragmentProvider.class,
            OpenSourceFragmentProvider.class
    }
    )
    abstract FeedActivity bindFeedActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {
            AboutFragmentProvider.class,
            RateUsDialogProvider.class,
            BTimelineFragmentProvider.class,
            BFriendsFragmentProvider.class,
            BNotificationFragmentProvider.class,
            MFPostingProvider.class,
            TimelineActivityModule.class
    })
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {
            AboutFragmentProvider.class,
            RateUsDialogProvider.class,
            BTimelineFragmentProvider.class,
            BFriendsFragmentProvider.class,
            BNotificationFragmentProvider.class,
            MFPostingProvider.class,
            TimelineActivityModule.class
    })
    abstract LearningActivity bindLearningActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract RegisterActivity bindRegisterActivity();

    @ContributesAndroidInjector
    abstract EditProfile bindEditProfileActivity();

    @ContributesAndroidInjector
    abstract MyContact bindMyContactActivity();

    @ContributesAndroidInjector
    abstract ShoppingCart bindShopCartActivity();

    @ContributesAndroidInjector(modules = {
            MFTimelineProvider.class,
            MFTimelineModule.class,
            MFPostingTimelineProvider.class,
    })

    abstract DetailLearningAcitivity bindDetailLearningAcitivity();

    @ContributesAndroidInjector(modules = {
            AllItemListModule.class,
            AllItemListProvider.class
    }
    )
    abstract AllTrendingList allTrendingList();

    @ContributesAndroidInjector(modules = {
            AllCategoryListModule.class,
            AllCategoryListProvider.class
    }
    )
    abstract AllCategoryActivity allCategoryActivity();
}
