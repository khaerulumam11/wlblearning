package com.wlb.framework.learning;

import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.ui.about.AboutViewModel;
import com.wlb.framework.learning.ui.feed.FeedViewModel;
import com.wlb.framework.learning.ui.feed.blogs.BlogViewModel;
import com.wlb.framework.learning.ui.feed.opensource.OpenSourceViewModel;
import com.wlb.framework.learning.ui.learning.LearningViewModel;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllItemListViewLoadModel;
import com.wlb.framework.learning.ui.learning.allList.viewModel.AllTrendingListViewModel;
import com.wlb.framework.learning.ui.learning.allcourse.AllCategoryListViewModel;
import com.wlb.framework.learning.ui.learning.detail.detail_viewmodel.DetailLearningViewModel;
import com.wlb.framework.learning.ui.learning.detail.timeline.TimelinePagerViewModel;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.CommentsViewModel;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.InstructorViewModel;
import com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.ReviewViewModel;
import com.wlb.framework.learning.ui.learning.viewmodel.LHomeViewModel;
import com.wlb.framework.learning.ui.learning.viewmodel.LWishListViewModel;
import com.wlb.framework.learning.ui.login.LoginViewModel;
import com.wlb.framework.learning.ui.main.MainViewModel;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.EditProfileViewModel;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.FriendsViewModel;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.NotificationViewModel;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.ProfileViewModel;
import com.wlb.framework.learning.ui.main.bottommenu.viewmodel.TimelineViewModel;
import com.wlb.framework.learning.ui.main.contacts.contactviewmodel.MyContacsViewModel;
import com.wlb.framework.learning.ui.main.rating.RateUsViewModel;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.ArticleViewModel;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.CompaniesViewModel;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.JobsViewModel;
import com.wlb.framework.learning.ui.main.timeline.viewmodel.PostingViewModel;
import com.wlb.framework.learning.ui.register.RegisterViewModel;
import com.wlb.framework.learning.ui.shopcart.ShopCartViewModel;
import com.wlb.framework.learning.ui.splash.SplashViewModel;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by jyotidubey on 22/02/19.
 */
@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AboutViewModel.class)) {
            //noinspection unchecked
            return (T) new AboutViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(FeedViewModel.class)) {
            //noinspection unchecked
            return (T) new FeedViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(BlogViewModel.class)) {
            //noinspection unchecked
            return (T) new BlogViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(RateUsViewModel.class)) {
            //noinspection unchecked
            return (T) new RateUsViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(OpenSourceViewModel.class)) {
            //noinspection unchecked
            return (T) new OpenSourceViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(RegisterViewModel.class)) {
            return (T) new RegisterViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(TimelineViewModel.class)) {
            return (T) new TimelineViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ProfileViewModel.class)) {
            return (T) new ProfileViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(FriendsViewModel.class)) {
            return (T) new FriendsViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(NotificationViewModel.class)) {
            return (T) new NotificationViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ArticleViewModel.class)) {
            return (T) new ArticleViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(PostingViewModel.class)) {
            return (T) new PostingViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(JobsViewModel.class)) {
            return (T) new JobsViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(CompaniesViewModel.class)) {
            return (T) new CompaniesViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(EditProfileViewModel.class)) {
            return (T) new EditProfileViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(LearningViewModel.class)) {
            return (T) new LearningViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(LHomeViewModel.class)) {
            return (T) new LHomeViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(LWishListViewModel.class)) {
            return (T) new LWishListViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(MyContacsViewModel.class)) {
            return (T) new MyContacsViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ShopCartViewModel.class)) {
            return (T) new ShopCartViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(AboutViewModel.class)) {
            return (T) new AboutViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(CommentsViewModel.class)) {
            return (T) new CommentsViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(InstructorViewModel.class)) {
            return (T) new InstructorViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ReviewViewModel.class)) {
            return (T) new ReviewViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(TimelinePagerViewModel.class)) {
            return (T) new TimelinePagerViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(DetailLearningViewModel.class)) {
            return (T) new DetailLearningViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.AboutViewModel.class)) {
            return (T) new com.wlb.framework.learning.ui.learning.detail.timeline.viewmodel.AboutViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(AllTrendingListViewModel.class)) {
            return (T) new AllTrendingListViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(AllItemListViewLoadModel.class)) {
            return (T) new AllTrendingListViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(AllCategoryListViewModel.class)) {
            return (T) new AllCategoryListViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}