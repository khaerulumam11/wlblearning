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

package com.wlb.framework.learning.ui.main.bottommenu;

import com.wlb.framework.learning.ui.main.timeline.tfragmentMenu.MArticleFragment;
import com.wlb.framework.learning.ui.main.timeline.tfragmentMenu.MCompaniesFragment;
import com.wlb.framework.learning.ui.main.timeline.tfragmentMenu.MJobsFragment;
import com.wlb.framework.learning.ui.main.timeline.tfragmentMenu.MPostingFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by MHBX
 */

public class TimelinesPagerAdapter extends FragmentStatePagerAdapter {
    private int mTabCount;
    public TimelinesPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MPostingFragment.newInstance();
            case 1:
                return MArticleFragment.newInstance();
            case 2:
                return MCompaniesFragment.newInstance();
            case 3:
                return MJobsFragment.newInstance();
            default:
                return null;
        }
    }
}
