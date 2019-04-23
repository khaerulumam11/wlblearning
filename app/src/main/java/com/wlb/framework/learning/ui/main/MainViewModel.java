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

package com.wlb.framework.learning.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;

import android.text.TextUtils;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.model.others.QuestionCardData;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import java.util.List;

/**
 *
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;

    private final ObservableField<String> appVersion = new ObservableField<>();

    private final MutableLiveData<List<QuestionCardData>> questionCardData;

    private final ObservableList<QuestionCardData> questionDataList = new ObservableArrayList<>();

    private final ObservableField<String> userEmail = new ObservableField<>();

    private final ObservableField<String> userName = new ObservableField<>();

    private final ObservableField<String> userProfilePicUrl = new ObservableField<>();

    private int action = NO_ACTION;

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        questionCardData = new MutableLiveData<>();
        loadQuestionCards();
    }

    public int getAction() {
        return action;
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public LiveData<List<QuestionCardData>> getQuestionCardData() {
        return questionCardData;
    }

    public ObservableList<QuestionCardData> getQuestionDataList() {
        return questionDataList;
    }

    public void setQuestionDataList(List<QuestionCardData> questionCardDatas) {
        action = ACTION_ADD_ALL;
        questionDataList.clear();
        questionDataList.addAll(questionCardDatas);
    }

    public ObservableField<String> getUserEmail() {
        return userEmail;
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public ObservableField<String> getUserProfilePicUrl() {
        return userProfilePicUrl;
    }

    public void loadQuestionCards() {
        getCompositeDisposable().add(getDataManager()
                .getQuestionCardData()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(questionList -> {
                    if (questionList != null) {
                        action = ACTION_ADD_ALL;
                        questionCardData.setValue(questionList);
                    }
                }, throwable -> {

                }));
    }

    public String getNameProfile() {
        return getDataManager().getCurrentUserName();
    }

    public void logout() {
        getDataManager().setUserAsLoggedOut();
        getNavigator().openLoginActivity();
    }

    public void onNavMenuCreated() {
        final String currentUserName = getDataManager().getCurrentUserName();
        if (!TextUtils.isEmpty(currentUserName)) {
            userName.set(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (!TextUtils.isEmpty(currentUserEmail)) {
            userEmail.set(currentUserEmail);
        }

        final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
        if (!TextUtils.isEmpty(profilePicUrl)) {
            userProfilePicUrl.set(profilePicUrl);
        }
    }

    public void removeQuestionCard() {
        action = ACTION_DELETE_SINGLE;
        questionCardData.getValue().remove(0);
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }

    public void actionLogout() {
        logout();
    }
    public void actionLearning() {
        getNavigator().openLearningNav();
    }

    public void actionProfile() {
        getNavigator().openProfileFragment();
    }
}
