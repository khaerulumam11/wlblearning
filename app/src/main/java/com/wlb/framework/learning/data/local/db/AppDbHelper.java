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

package com.wlb.framework.learning.data.local.db;

import com.wlb.framework.learning.data.model.db.Course;
import com.wlb.framework.learning.data.model.db.Option;
import com.wlb.framework.learning.data.model.db.Question;
import com.wlb.framework.learning.data.model.db.User;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by amitshekhar on 07/07/17.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return Observable.fromCallable(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return mAppDatabase.questionDao().loadAll();
            }
        });
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return mAppDatabase.userDao().loadAll();
            }
        });
    }

    @Override
    public Observable<List<Option>> getOptionsForQuestionId(final Long questionId) {
        return Observable.fromCallable(new Callable<List<Option>>() {
            @Override
            public List<Option> call() throws Exception {
                return mAppDatabase.optionDao().loadAllByQuestionId(questionId);
            }
        });
    }

    @Override
    public Observable<Boolean> insertUser(final User user) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.userDao().insert(user);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> isOptionEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mAppDatabase.optionDao().loadAll().isEmpty();
            }
        });
    }

    @Override
    public Observable<Boolean> isQuestionEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mAppDatabase.questionDao().loadAll().isEmpty();
            }
        });
    }

    @Override
    public Observable<Boolean> saveOption(final Option option) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.optionDao().insert(option);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveOptionList(final List<Option> optionList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.optionDao().insertAll(optionList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveQuestion(final Question question) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.questionDao().insert(question);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveQuestionList(final List<Question> questionList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.questionDao().insertAll(questionList);
                return true;
            }
        });
    }

    @Override
    public Observable<List<Course>> getAllCourse() {
        return Observable.fromCallable(new Callable<List<Course>>() {
            @Override
            public List<Course> call() throws Exception {
                return mAppDatabase.courseDao().loadAll();
            }
        });
    }

    @Override
    public Observable<List<Course>> getAllCourseById(final Long courseId) {
        return Observable.fromCallable(new Callable<List<Course>>() {
            @Override
            public List<Course> call() throws Exception {
                return mAppDatabase.courseDao().loadAllByIds(courseId);
            }
        });
    }

    @Override
    public Observable<Boolean> saveCourseList(List<Course> courseList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.courseDao().insertAll(courseList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> isCourseEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mAppDatabase.courseDao().loadAll().isEmpty();
            }
        });
    }
}
