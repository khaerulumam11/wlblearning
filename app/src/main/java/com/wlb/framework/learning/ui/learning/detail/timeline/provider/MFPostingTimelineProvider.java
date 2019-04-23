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

package com.wlb.framework.learning.ui.learning.detail.timeline.provider;

import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.InstructorFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.MAboutFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.MCommentsFragment;
import com.wlb.framework.learning.ui.learning.detail.timeline.fragment.MReviewFragment;
import com.wlb.framework.learning.ui.learning.fragment.LFragmentHome;
import com.wlb.framework.learning.ui.learning.fragment.LFragmentWishlist;
import com.wlb.framework.learning.ui.main.timeline.tfragmentMenu.MArticleFragment;
import com.wlb.framework.learning.ui.main.timeline.tfragmentMenu.MCompaniesFragment;
import com.wlb.framework.learning.ui.main.timeline.tfragmentMenu.MJobsFragment;
import com.wlb.framework.learning.ui.main.timeline.tfragmentMenu.MPostingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
public abstract class MFPostingTimelineProvider {
    @ContributesAndroidInjector
    abstract MAboutFragment providepostingFragmentFactory();

    @ContributesAndroidInjector
    abstract MReviewFragment provideReviewFragmentFactory();

    @ContributesAndroidInjector
    abstract MCommentsFragment provideCommentsFragmentFactory();
//
    @ContributesAndroidInjector
    abstract InstructorFragment provideCompaniesFragmentFactory();

//    @ContributesAndroidInjector
//    abstract LFragmentHome provideFhomeFragmentFactory();
//
//    @ContributesAndroidInjector
//    abstract LFragmentWishlist provideFWlistFragmentFactory();
}
